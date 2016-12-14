package de.alpharogroup.user.management.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.alpharogroup.auth.Credentials;


/**
 * The interface {@link AuthenticationsResource} provides methods for authenticate users of a given application.
 */
@Path("/auth/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AuthenticationsResource {

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
	 * Authenticate a user with the given email or username and the given password.
	 *
	 * @param username the email or username
	 * @param password the password
	 * @return the {@link Response} object
	 */
	@POST
	@Path("/form")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	Response authenticate(@FormParam("username") String username, @FormParam("password") String password);
}
