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
package de.alpharogroup.user.management.rest;


import java.util.List;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.service.rs.Securable;
import de.alpharogroup.user.management.domain.Contactmethod;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.management.enums.ContactmethodType;
import de.alpharogroup.user.management.rest.api.ContactmethodsResource;
import de.alpharogroup.user.management.service.api.ContactmethodService;

/**
 * The class {@link ContactmethodsRestResource} .
 */
public class ContactmethodsRestResource
	extends
		AbstractRestfulResource<Integer, Contactmethod, ContactmethodService>
	implements
		ContactmethodsResource
{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean compare(final KeyValuePair<Contactmethod, Contactmethod> comparison)
	{
		boolean result = getDomainService().compare(comparison.getKey(), comparison.getValue());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
    @Securable
	public boolean existsContact(KeyValuePair<String, ContactmethodType> contactMethod) {
		boolean result = getDomainService().existsContact(contactMethod.getKey(), contactMethod.getValue());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */

	@Override
	public List<Contactmethod> findContact(KeyValuePair<String, ContactmethodType> contactMethod) {	
		return getDomainService().findContact(contactMethod.getKey(), contactMethod.getValue());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> find(KeyValuePair<String, ContactmethodType> contactMethod) {
		return getDomainService().find(contactMethod.getValue(), contactMethod.getKey());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> findContactmethod(KeyValuePair<ContactmethodType, User> contactMethodsFromUser) {
		return getDomainService().findContactmethod(contactMethodsFromUser.getKey(), contactMethodsFromUser.getValue());
	}


}
