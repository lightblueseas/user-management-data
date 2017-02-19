package de.alpharogroup.user.management.service.api;

import java.util.List;

import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.enums.GenderType;
import de.alpharogroup.user.service.api.BaseUsersService;

/**
 * The interface {@link UsersService}.
 */
public interface UsersService extends BaseUsersService {

	/**
	 * Find all {@link Addresses} from the given {@link Users}.
	 *
	 * @param user
	 *            the user
	 * @return the list of found {@link Addresses} from the given {@link Users}.
	 */
	List<Addresses> findAddressesFromUser(final Users user);

	/**
	 * Find the main {@link Addresses} from the given {@link Users}.
	 *
	 * @param user
	 *            the user
	 * @return the main {@link Addresses} from the given {@link Users}.
	 */
	Addresses findAddressFromUser(final Users user);

	/**
	 * Find the {@link Users} object with the given email.
	 *
	 * @param email
	 *            the email
	 * @return the found {@link Users} object
	 */
	Users findUserWithEmail(final String email);

	/**
	 * Find users from the given {@link GenderType} object and the range from till until.
	 *
	 * @param from
	 *            the from
	 * @param searchGender
	 *            the search gender
	 * @param until
	 *            the until
	 * @return the found list of {@link Users} objects that matches the criteria.
	 */
	List<Users> findUsers(Integer from, GenderType searchGender, Integer until);

	/**
	 * Find users from the given {@link GenderType} object and the range from till until and the
	 * given geohash code.
	 *
	 * @param from
	 *            the from
	 * @param searchGender
	 *            the search gender
	 * @param until
	 *            the until
	 * @param geohash
	 *            the geohash
	 * @return the found list of {@link Users} objects that matches the criteria.
	 */
	List<Users> findUsers(Integer from, GenderType searchGender, Integer until,
			final String geohash);

}