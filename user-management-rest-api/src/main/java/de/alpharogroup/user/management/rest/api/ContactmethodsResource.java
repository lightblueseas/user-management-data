package de.alpharogroup.user.management.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.management.domain.Contactmethod;

/**
 * The interface {@link ContactmethodsResource} provides methods for resolving contact methods.
 */
@Path("/contactmethod/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ContactmethodsResource extends RestfulResource<Integer, Contactmethod>
{

}
