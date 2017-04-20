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
package de.alpharogroup.user.management.service.api;

import java.util.List;

import de.alpharogroup.service.domain.DomainService;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.management.domain.Contactmethod;
import de.alpharogroup.user.management.enums.ContactmethodType;

/**
 * The interface {@link ContactmethodService}.
 */
public interface ContactmethodService extends DomainService<Integer, Contactmethod>
{

	/**
	 * Compare the given {@link Contactmethod} objects.
	 * 
	 * @param contact
	 *            the contact
	 * @param compare
	 *            the compare
	 * @return true, if successful
	 */
	boolean compare(Contactmethod contact, Contactmethod compare);

	/**
	 * Check if a contact exist with given {@link Contactmethod}.
	 * 
	 * @param contact
	 *            the contact
	 * @return true, if successful
	 */
	boolean existsContact(Contactmethod contact);

	/**
	 * Check if a contact exist with given contact value and the given {@link ContactmethodType}.
	 * 
	 * @param contactValue
	 *            the contact value
	 * @param contactMethod
	 *            the contact method
	 * @return true, if successful
	 */
	boolean existsContact(String contactValue, ContactmethodType contactMethod);

	/**
	 * Find all the {@link Contactmethod} objects from the given contact value and the given
	 * {@link ContactmethodType}.
	 *
	 * @param contactmethod
	 *            the contact method
	 * @param contactvalue
	 *            the contact value
	 * @return the list of the found {@link Contactmethod} objects.
	 */
	List<Contactmethod> find(final ContactmethodType contactmethod, final String contactvalue);

	/**
	 * Find all the {@link Contactmethod} objects from the given contact value and the given
	 * {@link ContactmethodType}.
	 * 
	 * @param contactValue
	 *            the contact value
	 * @param contactMethod
	 *            the contact method
	 * @return the list of the found {@link Contactmethod} objects.
	 */
	List<Contactmethod> findContact(String contactValue, ContactmethodType contactMethod);

	/**
	 * Find all the {@link Contactmethod} objects from the given user and the given
	 * {@link ContactmethodType}.
	 *
	 * @param contactmethod
	 *            the contact method
	 * @param user
	 *            the user
	 * @return the list of the found {@link Contactmethod} objects.
	 */
	List<Contactmethod> findContactmethod(final ContactmethodType contactmethod, final User user);
}
