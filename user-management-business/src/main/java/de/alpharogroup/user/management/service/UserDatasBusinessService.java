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

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.daos.UserDatasDao;
import de.alpharogroup.user.management.entities.UserDatas;
import de.alpharogroup.user.management.service.api.UserDatasService;

@Transactional
@Service("userDatasService")
public class UserDatasBusinessService extends AbstractBusinessService<UserDatas, Integer, UserDatasDao> implements UserDatasService {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	@Autowired
	public void setUserDataDao(final UserDatasDao userDataDao) {
		setDao(userDataDao);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public UserDatas findBy(final Users user) {
		final String hqlString =
				  "select ud from UserDatas ud "
				+ "where ud.owner=:user";
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
	public UserDatas findBy(final Integer userid) {
		final String hqlString =
				  "select ud from UserDatas ud "
				+ "where ud.owner.id=:userid";
		final Query query = getQuery(hqlString);
		query.setParameter("userid", userid);
		final List<UserDatas> userDatas = query.getResultList();
		return ListExtensions.getFirst(userDatas);
	}

}