package de.alpharogroup.user.management.rest;

import de.alpharogroup.auth.models.AuthenticationErrors;
import de.alpharogroup.auth.models.AuthenticationResult;
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

}
