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
import de.alpharogroup.user.management.daos.UserCreditsDao;
import de.alpharogroup.user.management.domain.UserCredit;
import de.alpharogroup.user.management.entities.UserCredits;
import de.alpharogroup.user.management.mapper.UserCreditsMapper;
import de.alpharogroup.user.management.service.api.UserCreditService;
import de.alpharogroup.user.management.service.api.UserCreditsService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link UserCreditDomainService}.
 */
@Transactional
@Service("userCreditDomainService")
public class UserCreditDomainService
		extends AbstractDomainService<Integer, UserCredit, UserCredits, UserCreditsDao, UserCreditsMapper>
		implements UserCreditService {

	/** The {@link UserCreditsService}. */
	@Autowired
	@Getter
	@Setter
	private UserCreditsService userCreditsService;

	/**
	 * Sets the specific {@link UserCreditsDao}.
	 *
	 * @param userCreditsDao
	 *            the new {@link UserCreditsDao}.
	 */
	@Autowired
	public void setUserCreditsDao(final UserCreditsDao userCreditsDao) {
		setDao(userCreditsDao);
	}

	/**
	 * Sets the specific {@link UserCreditsMapper}.
	 *
	 * @param mapper
	 *            the new {@link UserCreditsMapper}.
	 */
	@Autowired
	public void setUserCreditsMapper(UserCreditsMapper mapper) {
		setMapper(mapper);
	}
	
}
