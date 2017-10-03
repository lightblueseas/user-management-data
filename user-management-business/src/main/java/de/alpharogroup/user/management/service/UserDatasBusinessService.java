/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *  *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *  *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.user.management.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.address.book.service.util.HqlStringCreator;
import de.alpharogroup.collections.list.ListExtensions;
import de.alpharogroup.date.CalculateDateExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.jgeohash.GeoHashExtensions;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.daos.UserDatasDao;
import de.alpharogroup.user.management.entities.UserDatas;
import de.alpharogroup.user.management.enums.GenderType;
import de.alpharogroup.user.management.service.api.UserDatasService;

@Transactional
@Service("userDatasService")
public class UserDatasBusinessService
	extends
		AbstractBusinessService<UserDatas, Integer, UserDatasDao>
	implements
		UserDatasService
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger(UserDatasBusinessService.class.getName());

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public UserDatas findBy(final Integer userid)
	{
		final String hqlString = "select ud from UserDatas ud " + "where ud.owner.id=:userid";
		final Query query = getQuery(hqlString);
		query.setParameter("userid", userid);
		final List<UserDatas> userDatas = query.getResultList();
		return ListExtensions.getFirst(userDatas);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public UserDatas findBy(final Users user)
	{
		final String hqlString = "select ud from UserDatas ud " + "where ud.owner=:user";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		final List<UserDatas> userDatas = query.getResultList();
		return ListExtensions.getFirst(userDatas);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<UserDatas> findUserDatas(final Integer from, final GenderType searchGender,
		final Integer until)
	{
		final Date now = new Date(System.currentTimeMillis());
		final Date start = CalculateDateExtensions.substractYearsFromDate(now, until);
		final Date end = CalculateDateExtensions.substractYearsFromDate(now, from);
		final String hqlString = "select ud from UserDatas ud " + "where ud.gender=:gender "
			+ "and ud.dateofbirth >= :start " + "and ud.dateofbirth <= :end";
		final Query query = getQuery(hqlString);
		query.setParameter("gender", searchGender);
		query.setParameter("start", start);
		query.setParameter("end", end);
		final List<UserDatas> userDatas = query.getResultList();
		return userDatas;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<UserDatas> findUserDatas(final Integer from, final GenderType searchGender,
		final Integer until, final String geohash)
	{
		final Date now = new Date(System.currentTimeMillis());
		final Date start = CalculateDateExtensions.substractYearsFromDate(now, until);
		final Date end = CalculateDateExtensions.substractYearsFromDate(now, from);

		final StringBuilder hqlString = new StringBuilder();
		hqlString.append("select ud from UserDatas ud " + "where ud.gender=:gender "
			+ "and ud.dateofbirth >= :start " + "and ud.dateofbirth <= :end ");

		Map<String, String> adjacentAreas = null;
		if (geohash != null && !geohash.trim().isEmpty())
		{
			adjacentAreas = GeoHashExtensions.getTwentyFiveAreasMap(geohash);
		}
		if (adjacentAreas != null)
		{
			final String firstAndSecondRingSubQuery = HqlStringCreator
				.getGeohashFirstAndSecondRingSubQuery();
			hqlString.append("and ud.primaryAddress.geohash in " + firstAndSecondRingSubQuery);
		}

		final String queryString = hqlString.toString();
		LOGGER.info("Query String from method findUsers:" + queryString);
		final Query query = getQuery(queryString);
		// Set parameters...
		query.setParameter("gender", searchGender);
		query.setParameter("start", start);
		query.setParameter("end", end);
		if (adjacentAreas != null)
		{
			for (final Entry<String, String> entry : adjacentAreas.entrySet())
			{
				query.setParameter(entry.getKey(), entry.getValue() + "%");
			}
		}
		final List<UserDatas> userDatas = query.getResultList();
		return userDatas;
	}

	/**
	 * {@inheritDoc}
	 */
	@Autowired
	public void setUserDataDao(final UserDatasDao userDataDao)
	{
		setDao(userDataDao);
	}

}