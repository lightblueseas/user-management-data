package de.alpharogroup.user.management.service.api;

import de.alpharogroup.db.service.jpa.BusinessService;
import de.alpharogroup.user.management.entities.ResetPasswords;
import de.alpharogroup.user.management.entities.Users;

public interface ResetPasswordsService extends BusinessService<ResetPasswords, Integer>{

	/**
	 * Find the entry from the given {@link Users} and the given generated password(hashed).
	 *
	 * @param user the user
	 * @param generatedPassword the generated password(hashed) is the confirmationCode from the url query string
	 * @return the entry of the found {@link ResetPasswords} or null if not found
	 */
	ResetPasswords findResetPassword(Users user, String generatedPassword);


	/**
	 * Finds the {@link ResetPasswords} object from the given {@link Users} object.
	 *
	 * @param user the user
	 * @return the entry of the found {@link ResetPasswords} or null if not found
	 */
	ResetPasswords findResetPassword(Users user);
}