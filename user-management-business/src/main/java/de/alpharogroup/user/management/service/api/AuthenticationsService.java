/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *  *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *  *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.user.management.service.api;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import de.alpharogroup.auth.models.AuthenticationErrors;
import de.alpharogroup.auth.models.AuthenticationResult;
import de.alpharogroup.crypto.pw.PasswordEncryptor;
import de.alpharogroup.user.entities.Users;

public interface AuthenticationsService extends Serializable
{

	/**
	 * Perform the authentication with the given email and password and return the result.
	 *
	 * @param emailOrUsername
	 *            the email or the user name of the {@link Users} object.
	 * @param password
	 *            the password
	 * @return the resulted {@link AuthenticationResult} object
	 */
	default public AuthenticationResult<Users, AuthenticationErrors> authenticate(
		final String emailOrUsername, final String password)
	{
		final AuthenticationResult<Users, AuthenticationErrors> authenticationResult = new AuthenticationResult<>();
		final UsersManagementService userManagementBusinessService = getUsersManagementService();
		final boolean emailExists = userManagementBusinessService
			.existsUserWithEmail(emailOrUsername);
		// Check if email exists.
		if (emailExists)
		{
			final Users user = userManagementBusinessService.findUserWithEmail(emailOrUsername);
			return authorize(user, password, authenticationResult);
		}
		// Check if username exists.
		final boolean usernameExists = userManagementBusinessService
			.existsUserWithUsername(emailOrUsername);
		if (usernameExists)
		{
			final Users user = userManagementBusinessService.findUserWithUsername(emailOrUsername);
			return authorize(user, password, authenticationResult);
		}
		// set validation errors
		authenticationResult.getValidationErrors()
			.add(AuthenticationErrors.EMAIL_OR_USERNAME_DOES_NOT_EXIST);

		return authenticationResult;
	}


	/**
	 * Authorize given Users object.
	 *
	 * @param user
	 *            the user
	 * @param password
	 *            the password
	 * @param authenticationResult
	 *            the authentication result
	 * @return the authentication result
	 */
	default public AuthenticationResult<Users, AuthenticationErrors> authorize(final Users user,
		final String password,
		final AuthenticationResult<Users, AuthenticationErrors> authenticationResult)
	{
		if (user != null && user.isActive())
		{
			String hashedPassword = "";
			// Get hashed pw from db
			final String dbHashedPassword = user.getPw();
			// Get salt from db
			final String salt = user.getSalt();
			// get instance of PasswordEncryptor
			final PasswordEncryptor passwordService = PasswordEncryptor.getInstance();
			try
			{
				hashedPassword = passwordService.hashAndHexPassword(password, salt);
			}
			catch (NoSuchAlgorithmException | InvalidKeyException | UnsupportedEncodingException
				| NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException
				| InvalidKeySpecException | InvalidAlgorithmParameterException e)
			{
				authenticationResult.getValidationErrors()
					.add(AuthenticationErrors.PASSWORD_INVALID);
				return authenticationResult;
			}
			if (passwordService.match(hashedPassword, dbHashedPassword))
			{
				authenticationResult.setUser(user);
			}
			else
			{
				authenticationResult.getValidationErrors()
					.add(AuthenticationErrors.PASSWORD_INVALID);
			}
		}
		else
		{
			authenticationResult.getValidationErrors().add(AuthenticationErrors.UNREGISTERED);
		}
		return authenticationResult;
	}

	UsersManagementService getUsersManagementService();

	String newAuthenticationToken(String username);

}