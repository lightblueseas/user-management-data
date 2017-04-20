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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.daos.UserDatasDao;
import de.alpharogroup.user.management.domain.UserData;
import de.alpharogroup.user.management.entities.UserDatas;
import de.alpharogroup.user.management.mapper.UserDatasMapper;
import de.alpharogroup.user.management.service.api.UserDataService;
import de.alpharogroup.user.management.service.api.UserDatasService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link UserDataDomainService}.
 */
@Transactional
@Service("userDataDomainService")
public class UserDataDomainService
	extends
		AbstractDomainService<Integer, UserData, UserDatas, UserDatasDao, UserDatasMapper>
	implements
		UserDataService
{

	/** The {@link UserDatasService}. */
	@Autowired
	@Getter
	@Setter
	private UserDatasService userDatasService;

	@Override
	public UserData findBy(final Integer userid)
	{
		final UserData userData = getMapper().toDomainObject(userDatasService.findBy(userid));
		return userData;
	}

	@Override
	public UserData findBy(final User user)
	{
		final Users userEntity = getMapper().map(user, Users.class);
		final UserData userData = getMapper().toDomainObject(userDatasService.findBy(userEntity));
		return userData;
	}

	/**
	 * Sets the specific {@link UserDatasDao}.
	 *
	 * @param userDatasDao
	 *            the new {@link UserDatasDao}.
	 */
	@Autowired
	public void setUserDatasDao(final UserDatasDao userDatasDao)
	{
		setDao(userDatasDao);
	}

	/**
	 * Sets the specific {@link UserDatasMapper}.
	 *
	 * @param mapper
	 *            the new {@link UserDatasMapper}.
	 */
	@Autowired
	public void setUserDatasMapper(final UserDatasMapper mapper)
	{
		setMapper(mapper);
	}


}
