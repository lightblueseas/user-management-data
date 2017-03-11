package de.alpharogroup.user.management.service.api;

import de.alpharogroup.db.service.api.BusinessService;
import de.alpharogroup.user.management.entities.UserDatas;
import de.alpharogroup.user.entities.Users;

/**
 * The interface {@link UserDatasService}.
 */
public interface UserDatasService extends BusinessService<UserDatas, Integer> {

	/**
	 * Find the {@link UserDatas} object by the given {@link Users} object.
	 *
	 * @param user the user
	 * @return the found {@link UserDatas} object or null if does not exist.
	 */
	UserDatas findBy(Users user);


	/**
	 * Find the {@link UserDatas} object by the given {@link Integer} user id.
	 *
	 * @param userid the user id
	 * @return the found {@link UserDatas} object or null if does not exist.
	 */
	UserDatas findBy(final Integer userid);

}