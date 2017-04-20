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
import de.alpharogroup.user.management.daos.RobinsonsDao;
import de.alpharogroup.user.management.domain.Robinson;
import de.alpharogroup.user.management.entities.Robinsons;
import de.alpharogroup.user.management.mapper.RobinsonsMapper;
import de.alpharogroup.user.management.service.api.RobinsonService;
import de.alpharogroup.user.management.service.api.RobinsonsService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link RobinsonDomainService}.
 */
@Transactional
@Service("robinsonDomainService")
public class RobinsonDomainService
	extends
		AbstractDomainService<Integer, Robinson, Robinsons, RobinsonsDao, RobinsonsMapper>
	implements
		RobinsonService
{

	/** The {@link RobinsonsService}. */
	@Autowired
	@Getter
	@Setter
	private RobinsonsService robinsonsService;

	/**
	 * Sets the specific {@link RobinsonsDao}.
	 *
	 * @param robinsonsDao
	 *            the new {@link RobinsonsDao}.
	 */
	@Autowired
	public void setRobinsonsDao(final RobinsonsDao robinsonsDao)
	{
		setDao(robinsonsDao);
	}

	/**
	 * Sets the specific {@link RobinsonsMapper}.
	 *
	 * @param mapper
	 *            the new {@link RobinsonsMapper}.
	 */
	@Autowired
	public void setRobinsonsMapper(RobinsonsMapper mapper)
	{
		setMapper(mapper);
	}

}
