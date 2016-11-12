package de.alpharogroup.user.management.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.management.domain.ResetPassword;
import de.alpharogroup.user.management.domain.User;

/**
 * The interface {@link ResetPasswordsResource} provides methods for reset passwords from user
 * objects.
 */
@Path("/reset/passwords/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ResetPasswordsResource extends RestfulResource<Integer, ResetPassword>
{

	/**
	 * Find the entry from the given {@link User} and the given generated password(hashed).
	 *
	 * @param user the user
	 * @param generatedPassword the generated password(hashed) is the confirmationCode from the url query string
	 * @return the entry of the found {@link ResetPassword} or null if not found
	 */
	ResetPassword findResetPassword(User user, String generatedPassword);

	/**
	 * Finds the {@link ResetPassword} object from the given {@link User} object.
	 *
	 * @param user the user
	 * @return the entry of the found {@link ResetPassword} or null if not found
	 */
	ResetPassword findResetPassword(User user);
}
