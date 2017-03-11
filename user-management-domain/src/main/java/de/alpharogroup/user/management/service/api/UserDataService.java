package de.alpharogroup.user.management.service.api;

import de.alpharogroup.service.domain.DomainService;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.management.domain.UserData;

/**
 * The interface {@link UserDataService}.
 */
public interface UserDataService extends DomainService<Integer, UserData> {

	/**
	 * Find the {@link UserData} object by the given {@link User} object.
	 *
	 * @param user the user
	 * @return the found {@link UserData} object or null if does not exist.
	 */
	UserData findBy(User user);


	/**
	 * Find the {@link UserData} object by the given {@link Integer} user id.
	 *
	 * @param userid the user id
	 * @return the found {@link UserData} object or null if does not exist.
	 */
	UserData findBy(final Integer userid);
}
