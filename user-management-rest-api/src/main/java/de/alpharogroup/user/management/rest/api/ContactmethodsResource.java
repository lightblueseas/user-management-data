package de.alpharogroup.user.management.rest.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.management.domain.Contactmethod;
import de.alpharogroup.user.management.domain.User;
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
	 * Check if a contact exist with given contact value and the given {@link ContactmethodType} encapsulated as a {@link KeyValuePair}.
	 *
	 * @param contactMethod
	 *            the contact method
	 * @return true, if successful
	 */
	@POST
	@Path("/exists/contact")
	boolean existsContact(KeyValuePair<String, ContactmethodType> contactMethod);
	
	/**
	 * Find all the {@link Contactmethod} objects from the given contact value and the given {@link ContactmethodType} encapsulated as a {@link KeyValuePair}.
	 * 
	 * @param contactMethod
	 *            the contact method
	 * @return the list of the found {@link Contactmethod} objects.
	 */
	@POST
	@Path("/find/contact")
	List<Contactmethod> findContact(KeyValuePair<String, ContactmethodType> contactMethod);

	/**
	 * Find all the {@link Contactmethod} objects from the given contact value and the given {@link ContactmethodType}.
	 *
	 * @param contactmethod the contact method
	 * @return the list of the found {@link Contactmethod} objects.
	 */
	@POST
	@Path("/find")
	List<Contactmethod> find(KeyValuePair<String, ContactmethodType> contactMethod);
		
	/**
	 * Find all the {@link Contactmethod} objects from the given user and the given {@link ContactmethodType} encapsulated as a {@link KeyValuePair}.
	 *
	 * @param contactmethod the contact method
	 * @return the list of the found {@link Contactmethod} objects.
	 */
	@POST
	@Path("/find/contactmethods/from/user/")
	List<Contactmethod> findContactmethod(final KeyValuePair<ContactmethodType, User> contactMethodsFromUser);
}
