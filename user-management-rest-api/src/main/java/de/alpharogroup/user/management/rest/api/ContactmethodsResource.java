package de.alpharogroup.user.management.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.service.rs.RestfulResource;
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
	boolean existsContact(String contactValue,
			ContactmethodType contactMethod);
}
