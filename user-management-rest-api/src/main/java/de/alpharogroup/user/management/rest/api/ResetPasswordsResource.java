package de.alpharogroup.user.management.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.management.domain.ResetPassword;

/**
 * The interface {@link ResetPasswordsResource} provides methods for reset passwords from user
 * objects.
 */
@Path("/reset/passwords/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ResetPasswordsResource extends RestfulResource<Integer, ResetPassword>
{

}
