package de.alpharogroup.user.management.rest;

import javax.ws.rs.core.Response;

import org.apache.commons.collections4.CollectionUtils;

import de.alpharogroup.auth.Credentials;
import de.alpharogroup.auth.models.AuthenticationErrors;
import de.alpharogroup.auth.models.AuthenticationResult;
import de.alpharogroup.auth.token.AuthToken;
import de.alpharogroup.user.domain.User;
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
	public Response authenticate(Credentials credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();
        return authenticate(username, password);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Response authenticate(String username, String password) {
		AuthenticationResult<User, AuthenticationErrors> result = authenticationService.authenticate(username, password);        
        if (CollectionUtils.isNotEmpty(result.getValidationErrors())) {
            return Response.status(Response.Status.UNAUTHORIZED)
            		.header("Access-Control-Allow-Origin", "*")// allow cors...
            		.build();			
		}
        String authenticationToken = authenticationService.newAuthenticationToken(username);
        AuthToken authToken = AuthToken.builder().value(authenticationToken).build();
        // Set the auth token in the response
		return Response.ok(authToken.getValue())
				.header("Access-Control-Allow-Origin", "*")// allow cors...
				.build();
	}

}
