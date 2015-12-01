package de.alpharogroup.user.management.sign.in;

import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.service.api.UsersManagementService;

/**
 * The Class AbstractAuthenticationService provides authentication methods.
 */
public abstract class AbstractAuthenticationService {
	
	
	/**
	 * Peform the authentication with the given email and password and return the result.
	 *
	 * @param email the email
	 * @param password the password
	 * @return the authentication result
	 */
	public AuthenticationResult<Users, AuthenticationErrors> authenticate(String email, String password) {
		AuthenticationResult<Users, AuthenticationErrors> authenticationResult = new AuthenticationResult<Users, AuthenticationErrors>();
		final UsersManagementService userManagementBusinessService = getUserManagementService();
		final boolean emailExists = userManagementBusinessService
				.existsUserWithEmail(email);

		if (emailExists) {
			final Users user = userManagementBusinessService
					.findUserWithEmail(email);
			return authorize(user, password, authenticationResult);

		} else { // ( emailExists )
			// Check if username exists.
			final boolean usernameExists = userManagementBusinessService
					.existsUserWithUsername(email);
			if (usernameExists) {
				final Users user = userManagementBusinessService
						.findUserWithUsername(email);
				return authorize(user, password, authenticationResult);
			} else { // ( usernameExists )
				authenticationResult.getValidationErrors().add(AuthenticationErrors.EMAIL_OR_USERNAME_DOES_NOT_EXIST);
				return authenticationResult;	
			}
		}	
	}
	
	/**
	 * Authorize given Users object.
	 *
	 * @param user the user
	 * @param password the password
	 * @param authenticationResult the authentication result
	 * @return the authentication result
	 */
	protected AuthenticationResult<Users, AuthenticationErrors> authorize(final Users user, final String password,			
			final AuthenticationResult<Users, AuthenticationErrors> authenticationResult) {
		if (user.isActive()) {
			final String pw = user.getPw();
			if (password.equals(pw)) {
				authenticationResult.setUser(user);
			} else { // ( password.equals( pw ) )
				authenticationResult.getValidationErrors().add(AuthenticationErrors.PASSWORD_INVALID);
			}
		} else {
			authenticationResult.getValidationErrors().add(AuthenticationErrors.UNREGISTERED);
		}
		return authenticationResult;
	}
	
	public abstract UsersManagementService getUserManagementService();

}
