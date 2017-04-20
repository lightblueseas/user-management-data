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
package de.alpharogroup.user.management.rest.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.service.rs.Securable;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.management.domain.Contactmethod;
import de.alpharogroup.user.management.enums.ContactmethodType;

/**
 * The interface {@link ContactmethodsResource} provides methods for resolving contact methods.
 */
@Path("/contactmethod/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ContactmethodsResource extends RestfulResource<Integer, Contactmethod>
{
	/**
	 * Compare the given {@link Contactmethod} objects.
	 *
	 * @param comparison
	 *            the object to compare
	 * @return true, if successful
	 */
	@POST
	@Path("/compare/contactmethod/")
	boolean compare(KeyValuePair<Contactmethod, Contactmethod> comparison);

	/**
	 * Check if a contact exist with given contact value and the given {@link ContactmethodType}
	 * encapsulated as a {@link KeyValuePair}.
	 *
	 * @param contactMethod
	 *            the {@link KeyValuePair} object that encapsulate the contact method and contact
	 *            value
	 * @return true, if successful
	 */
	@POST
	@Securable
	@Path("/exists/contact")
	boolean existsContact(KeyValuePair<String, ContactmethodType> contactMethod);

	/**
	 * Find all the {@link Contactmethod} objects from the given contact value and the given
	 * {@link ContactmethodType}.
	 *
	 * @param contactMethod
	 *            the {@link KeyValuePair} object that encapsulate the contact method and contact
	 *            value
	 * @return the list of the found {@link Contactmethod} objects.
	 */
	@POST
	@Path("/find")
	List<Contactmethod> find(KeyValuePair<String, ContactmethodType> contactMethod);

	/**
	 * Find all the {@link Contactmethod} objects from the given contact value and the given
	 * {@link ContactmethodType} encapsulated as a {@link KeyValuePair}.
	 * 
	 * @param contactMethod
	 *            the {@link KeyValuePair} object that encapsulate the contact method and contact
	 *            value
	 * @return the list of the found {@link Contactmethod} objects.
	 */
	@POST
	@Path("/find/contact")
	List<Contactmethod> findContact(KeyValuePair<String, ContactmethodType> contactMethod);

	/**
	 * Find all the {@link Contactmethod} objects from the given {@link User} object and the given
	 * {@link ContactmethodType} encapsulated as a {@link KeyValuePair}.
	 *
	 * @param contactMethodsFromUser
	 *            the contact method
	 * @return the list of the found {@link Contactmethod} objects.
	 */
	@POST
	@Path("/find/contactmethods/from/user/")
	List<Contactmethod> findContactmethod(
		final KeyValuePair<ContactmethodType, User> contactMethodsFromUser);
}
