package de.alpharogroup.user.management.rest.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	 * @param contact
	 *            the contact
	 * @param compare
	 *            the compare
	 * @return true, if successful
	 */
	@POST
	@Path("/compare/contactmethod/")
	boolean compare(Contactmethod contact, Contactmethod compare);

	/**
	 * Check if a contact exist with given {@link Contactmethod}.
	 *
	 * @param contact
	 *            the contact
	 * @return true, if successful
	 */
	@GET
	@Path("/exists/{contact}/")
	boolean existsContact(@PathParam("contact")String contact);

	/**
	 * Check if a contact exist with given contact value and the given {@link ContactmethodType}.
	 *
	 * @param contactValue
	 *            the contact value
	 * @param contactMethod
	 *            the contact method
	 * @return true, if successful
	 */
	@GET
	@Path("/exists/contact/{contactValue}/{contactMethod}/")
	boolean existsContact(@PathParam("contactValue")String contactValue,
							@PathParam("contactMethod")ContactmethodType contactMethod);
	
	/**
	 * Find all the {@link Contactmethod} objects from the given contact value and the given {@link ContactmethodType}.
	 * 
	 * @param contactValue
	 *            the contact value
	 * @param contactMethod
	 *            the contact method
	 * @return the list of the found {@link Contactmethod} objects.
	 */
	@GET
	@Path("/find/contact/{contactValue}/{contactMethod}/")
	List<Contactmethod> findContact(@PathParam("contactValue")String contactValue,
									@PathParam("contactMethod")ContactmethodType contactMethod);

	/**
	 * Find all the {@link Contactmethod} objects from the given contact value and the given {@link ContactmethodType}.
	 *
	 * @param contactmethod the contact method
	 * @param contactvalue the contact value
	 * @return the list of the found {@link Contactmethod} objects.
	 */
	@GET
	@Path("/find/{contactmethod}/{contactvalue}/")
	List<Contactmethod> find(@PathParam("contactmethod")final ContactmethodType contactmethod, 
								@PathParam("contactvalue")final String contactvalue);
	
	/**
	 * Find all the {@link Contactmethod} objects from the given user and the given {@link ContactmethodType}.
	 *
	 * @param contactmethod the contact method
	 * @param user the user
	 * @return the list of the found {@link Contactmethod} objects.
	 */
	@GET
	@Path("/find/all/contactmethods/{contactmethod}/{user}/")
	List<Contactmethod> findContactmethod(final ContactmethodType contactmethod, final User user);
}
