package de.alpharogroup.user.management.service.api;

import de.alpharogroup.service.domain.DomainService;
import de.alpharogroup.user.management.domain.ResetPassword;
import de.alpharogroup.user.management.domain.User;

/**
 * The interface {@link ResetPasswordService}.
 */
public interface ResetPasswordService extends DomainService<Integer, ResetPassword> {

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
