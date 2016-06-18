package de.alpharogroup.user.management.service.api;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import de.alpharogroup.crypto.pw.PasswordEncryptor;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.sign.in.AuthenticationErrors;
import de.alpharogroup.user.management.sign.in.AuthenticationResult;

public interface AuthenticationsService extends Serializable {

	/**
	 * Perform the authentication with the given email and password and return the result.
	 *
	 * @param emailOrUsername the email or the user name of the {@link Users} object.
	 * @param password the password
	 * @return the resulted {@link AuthenticationResult} object 
	 */
	default public AuthenticationResult<Users, AuthenticationErrors> authenticate(String emailOrUsername, String password) {
		AuthenticationResult<Users, AuthenticationErrors> authenticationResult = new AuthenticationResult<Users, AuthenticationErrors>();
		final UsersManagementService userManagementBusinessService = getUsersManagementService();
		final boolean emailExists = userManagementBusinessService
				.existsUserWithEmail(emailOrUsername);
		// Check if email exists.
		if (emailExists) {
			final Users user = userManagementBusinessService
					.findUserWithEmail(emailOrUsername);
			return authorize(user, password, authenticationResult);
		} 
		// Check if username exists.
		final boolean usernameExists = userManagementBusinessService
				.existsUserWithUsername(emailOrUsername);
		if (usernameExists) {
			final Users user = userManagementBusinessService
					.findUserWithUsername(emailOrUsername);
			return authorize(user, password, authenticationResult);
		} 
		// set validation errors
		authenticationResult.getValidationErrors().add(AuthenticationErrors.EMAIL_OR_USERNAME_DOES_NOT_EXIST);
		
		return authenticationResult;	
	}
	
	
	/**
	 * Authorize given Users object.
	 *
	 * @param user the user
	 * @param password the password
	 * @param authenticationResult the authentication result
	 * @return the authentication result
	 */
	default public AuthenticationResult<Users, AuthenticationErrors> authorize(final Users user, final String password,			
			final AuthenticationResult<Users, AuthenticationErrors> authenticationResult) {
		if (user != null && user.isActive()) {
			String hashedPassword = "";
			// Get hashed pw from db
			final String dbHashedPassword = user.getPw();
			// Get salt from db
			final String salt = user.getSalt();			
			// get instance of PasswordEncryptor
			final PasswordEncryptor passwordService = PasswordEncryptor.getInstance();
			try {
	            hashedPassword = passwordService.hashAndHexPassword(password, salt);
	        } catch ( NoSuchAlgorithmException | 
	        		InvalidKeyException | 
	        		UnsupportedEncodingException | 
	        		NoSuchPaddingException | 
	        		IllegalBlockSizeException | 
	        		BadPaddingException e ) {
	        	authenticationResult.getValidationErrors().add(AuthenticationErrors.PASSWORD_INVALID);	
	    		return authenticationResult;        	
	        }
			if (passwordService.match(hashedPassword, dbHashedPassword)) {
				authenticationResult.setUser(user);				
			} else { 
				authenticationResult.getValidationErrors().add(AuthenticationErrors.PASSWORD_INVALID);
			}
		} else {
			authenticationResult.getValidationErrors().add(AuthenticationErrors.UNREGISTERED);
		}
		return authenticationResult;
	}

	UsersManagementService getUsersManagementService();

}