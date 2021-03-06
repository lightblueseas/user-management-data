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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.daos.ContactmethodsDao;
import de.alpharogroup.user.management.domain.Contactmethod;
import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.management.enums.ContactmethodType;
import de.alpharogroup.user.management.mapper.ContactmethodsMapper;
import de.alpharogroup.user.management.service.api.ContactmethodService;
import de.alpharogroup.user.management.service.api.ContactmethodsService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link ContactmethodDomainService}.
 */
@Transactional
@Service("contactmethodDomainService")
public class ContactmethodDomainService
	extends
		AbstractDomainService<Integer, Contactmethod, Contactmethods, ContactmethodsDao, ContactmethodsMapper>
	implements
		ContactmethodService
{

	/** The {@link ContactmethodsService}. */
	@Autowired
	@Getter
	@Setter
	private ContactmethodsService contactmethodsService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean compare(final Contactmethod contact, final Contactmethod compare)
	{
		return contactmethodsService.compare(getMapper().toEntity(contact),
			getMapper().toEntity(compare));
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsContact(final Contactmethod contact)
	{
		return contactmethodsService.existsContact(getMapper().toEntity(contact));
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsContact(final String contactValue, final ContactmethodType contactMethod)
	{
		return contactmethodsService.existsContact(contactValue, contactMethod);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> find(final ContactmethodType contactmethod,
		final String contactvalue)
	{
		return getMapper().toDomainObjects(contactmethodsService.find(contactmethod, contactvalue));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> findContact(final String contactValue,
		final ContactmethodType contactMethod)
	{
		return getMapper()
			.toDomainObjects(contactmethodsService.findContact(contactValue, contactMethod));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> findContactmethod(final ContactmethodType contactmethod,
		final User user)
	{
		final Users users = getMapper().map(user, Users.class);
		return getMapper()
			.toDomainObjects(contactmethodsService.findContactmethod(contactmethod, users));
	}

	/**
	 * Sets the specific {@link ContactmethodsDao}.
	 *
	 * @param contactmethodsDao
	 *            the new {@link ContactmethodsDao}.
	 */
	@Autowired
	public void setContactmethodsDao(final ContactmethodsDao contactmethodsDao)
	{
		setDao(contactmethodsDao);
	}

	/**
	 * Sets the specific {@link ContactmethodsMapper}.
	 *
	 * @param mapper
	 *            the new {@link ContactmethodsMapper}.
	 */
	@Autowired
	public void setContactmethodsMapper(ContactmethodsMapper mapper)
	{
		setMapper(mapper);
	}

}
