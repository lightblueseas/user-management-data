package de.alpharogroup.user.management.application.utils;

import de.alpharogroup.user.management.entities.UserData;
import de.alpharogroup.user.management.entities.Users;

/**
 * The Class UserUtils.
 */
public class UserUtils {

	/**
	 * Gets the full name from the given Users object.
	 *
	 * @param user the user
	 * @return the full name
	 */
	public static String getFullName(Users user) {
		String fullName = getFullName(user.getUserData());
		if(fullName.isEmpty()) {
			return user.getUsername();
		}
		return fullName;		
	}

	/**
	 * Gets the full name from the given UserData object.
	 *
	 * @param userData the user data
	 * @return the full name
	 */
	public static String getFullName(UserData userData) {
		String firstname = userData.getFirstname();
		String lastname = userData.getLastname();
		StringBuilder sb = new StringBuilder();
		if(firstname != null && !firstname.isEmpty()){
			sb.append(firstname);
		}
		if(lastname != null && !lastname.isEmpty()){
			if(firstname != null && !firstname.isEmpty()){
				sb.append(" ");				
			}
			sb.append(lastname);
		}
		return sb.toString().trim();
	}
}
