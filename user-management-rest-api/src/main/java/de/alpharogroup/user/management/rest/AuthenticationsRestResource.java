package de.alpharogroup.user.management.rest;

import javax.ws.rs.core.Response;

import org.apache.commons.collections4.CollectionUtils;

import de.alpharogroup.auth.Credentials;
import de.alpharogroup.auth.models.AuthenticationErrors;
import de.alpharogroup.auth.models.AuthenticationResult;
import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.rest.api.AuthenticationsResource;
import de.alpharogroup.user.management.service.api.AuthenticationService;
import lombok.Getter;
import lombok.Setter;


/**
 * The class {@link AuthenticationsRestResource} provides an implementation of the inteface {@link AuthenticationsResource}.
 */
public class AuthenticationsRestResource implements AuthenticationsResource {

	/** The authentication service. */
	@Getter
	@Setter
	private AuthenticationService authenticationService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AuthenticationResult<User, AuthenticationErrors> authenticate(String emailOrUsername, String password) {
		return authenticationService.authenticate(emailOrUsername, password);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Response authenticate(Credentials credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();
        return formAuthentication(username, password);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Response formAuthentication(String username, String password) {
		AuthenticationResult<User, AuthenticationErrors> result = authenticationService.authenticate(username, password);        
        if (CollectionUtils.isNotEmpty(result.getValidationErrors())) {
            return Response.status(Response.Status.UNAUTHORIZED).build();			
		}
        String authenticationToken = authenticationService.newAuthenticationToken(username);
        // Set the auth token in the response
		return Response.ok(authenticationToken).build();
	}

}
