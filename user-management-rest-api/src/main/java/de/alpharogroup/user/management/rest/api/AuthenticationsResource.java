package de.alpharogroup.user.management.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.alpharogroup.auth.Credentials;
import de.alpharogroup.auth.models.AuthenticationErrors;
import de.alpharogroup.auth.models.AuthenticationResult;
import de.alpharogroup.user.management.domain.User;


/**
 * The interface {@link AuthenticationsResource} provides methods for authenticate users of a given application.
 */
@Path("/auth/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AuthenticationsResource {

	/**
	 * Checks if the given email and returns a result of the authentication.
	 *
	 * @param emailOrUsername the email or username
	 * @param password the password
	 * @return the {@link AuthenticationResult} object
	 */
	@GET
	@Path("/find/{emailOrUsername}/{password}")
	AuthenticationResult<User, AuthenticationErrors> authenticate(@PathParam("emailOrUsername")String emailOrUsername, @PathParam("password")String password);
	
	/**
	 * Authenticate a user with the given {@link Credentials}.
	 *
	 * @param credentials the credentials
	 * @return the response
	 */
	@POST
	@Path("/credentials")
	Response authenticate(Credentials credentials);	
	
	/**
	 * Authenticate a user with the given {@link Credentials}.
	 *
	 * @param credentials the credentials
	 * @return the response
	 */
	@POST
	@Path("/formauth")
	Response formAuthentication(@FormParam("username") String username, @FormParam("password") String password);
}
