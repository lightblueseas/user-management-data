package de.alpharogroup.user.management.service.api;

import de.alpharogroup.auth.models.AuthenticationErrors;
import de.alpharogroup.auth.models.AuthenticationResult;
import de.alpharogroup.user.domain.User;

public interface AuthenticationService {

	AuthenticationResult<User, AuthenticationErrors> authenticate(String emailOrUsername, String password);	

	/**
	 * Factory method that creates a new authentication token or gets the existing one from the given user name.
	 *
	 * @param username the username
	 * @return the new authentication token
	 */
	String newAuthenticationToken(String username);
}
