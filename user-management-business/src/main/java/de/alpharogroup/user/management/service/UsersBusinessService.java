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

import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.address.book.service.util.HqlStringCreator;
import de.alpharogroup.collections.list.ListExtensions;
import de.alpharogroup.date.CalculateDateExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.jgeohash.GeoHashExtensions;
import de.alpharogroup.user.entities.Roles;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.enums.GenderType;
import de.alpharogroup.user.management.service.api.UsersService;
import de.alpharogroup.user.repositories.UsersDao;

@Transactional
@Service("usersService")
public class UsersBusinessService extends AbstractBusinessService<Users, Integer, UsersDao>
	implements
		UsersService
{

	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger(UsersBusinessService.class.getName());
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsUserWithUsername(final String username)
	{
		final Users users = findUserWithUsername(username);
		if (users != null)
		{
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Addresses> findAddressesFromUser(final Users user)
	{
		final String hqlString = "select ur.address from UserAddresses ur where ur.user=:user";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		final List<Addresses> addresses = query.getResultList();
		return addresses;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Addresses findAddressFromUser(final Users user)
	{
		final List<Addresses> addresses = findAddressesFromUser(user);
		return ListExtensions.getFirst(addresses);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Roles> findRolesFromUser(final Users user)
	{
		final String hqlString = "select u.roles from Users u " + "where u=:user";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		final List<Roles> roles = query.getResultList();
		return roles;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Users> findUsers(final Integer from, final GenderType searchGender,
		final Integer until)
	{
		final Date now = new Date(System.currentTimeMillis());
		final Date start = CalculateDateExtensions.substractYearsFromDate(now, until);
		final Date end = CalculateDateExtensions.substractYearsFromDate(now, from);
		final String hqlString = "select distinct ud.owner from UserDatas ud "
			+ "where ud.gender=:gender " + "and ud.dateofbirth >= :start "
			+ "and ud.dateofbirth <= :end";
		final Query query = getQuery(hqlString);
		query.setParameter("gender", searchGender);
		query.setParameter("start", start);
		query.setParameter("end", end);
		final List<Users> users = query.getResultList();
		return users;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Users> findUsers(final Integer from, final GenderType searchGender,
		final Integer until, final String geohash)
	{
		final Date now = new Date(System.currentTimeMillis());
		final Date start = CalculateDateExtensions.substractYearsFromDate(now, until);
		final Date end = CalculateDateExtensions.substractYearsFromDate(now, from);

		final StringBuilder hqlString = new StringBuilder();
		hqlString.append("select distinct ud.owner from UserDatas ud ")
			.append(" where ud.gender=:gender ").append(" and ud.dateofbirth >= :start ")
			.append(" and ud.dateofbirth <= :end ");

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
		final List<Users> users = query.getResultList();
		return users;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public Users findUserWithEmail(final String email)
	{
		final String hqlString = "select u from Users u, UserDatas ud inner join ud.contactmethods cc "
			+ "where cc.contactmethod='EMAIL' " + "and cc.contactmethod.contactvalue=:email";
		final Query query = getQuery(hqlString);
		query.setParameter("email", email);
		final List<Users> users = query.getResultList();
		return ListExtensions.getFirst(users);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Users findUserWithUsername(final String username)
	{
		final String hqlString = "select u from Users u " + "where u.username=:username";
		final Query query = getQuery(hqlString);
		query.setParameter("username", username);
		final List<Users> users = query.getResultList();
		return ListExtensions.getFirst(users);
	}

	@Autowired
	public void setUsersDao(final UsersDao usersDao)
	{
		setDao(usersDao);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean userIsInRole(final Users user, final Roles role)
	{
		final List<Roles> roles = findRolesFromUser(user);
		if (null != roles && (!roles.isEmpty()))
		{
			if (roles.contains(role))
			{
				return true;
			}
		}
		return false;
	}

}