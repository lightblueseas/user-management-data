package de.alpharogroup.user.management.service.api;

import java.util.List;

import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.db.service.jpa.BusinessService;
import de.alpharogroup.user.management.entities.Roles;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.enums.GenderType;

/**
 * The Interface UsersService.
 */
public interface UsersService extends BusinessService<Users, Integer> {

	/**
	 * Checks if the given username exists.
	 * 
	 * @param username
	 *            the username
	 * @return true, if successful
	 */
	boolean existsUserWithUsername(String username);

	/**
	 * Find addresses from the given user.
	 * 
	 * @param user
	 *            the user
	 * @return the list
	 */
	List<Addresses> findAddressesFromUser(final Users user);

	/**
	 * Find address from the given user.
	 * 
	 * @param user
	 *            the user
	 * @return the addresses
	 */
	Addresses findAddressFromUser(final Users user);

	/**
	 * Find roles from the given user.
	 * 
	 * @param user
	 *            the user
	 * @return the list
	 */
	List<Roles> findRolesFromUser(final Users user);

	/**
	 * Find user with the given email.
	 * 
	 * @param email
	 *            the email
	 * @return the users
	 */
	Users findUserWithEmail(final String email);

	/**
	 * Find user with the given username.
	 * 
	 * @param username
	 *            the username
	 * @return the users
	 */
	Users findUserWithUsername(final String username);

	/**
	 * Checks if the given user is in the given role.
	 * 
	 * @param user
	 *            the user
	 * @param role
	 *            the role
	 * @return true, if successful
	 */
	boolean userIsInRole(final Users user, final Roles role);

	/**
	 * Find users from the given gender and the range from till until.
	 * 
	 * @param from
	 *            the from
	 * @param searchGender
	 *            the search gender
	 * @param until
	 *            the until
	 * @return the list
	 */
	List<Users> findUsers(Integer from, GenderType searchGender, Integer until);

	/**
	 * Find users from the given gender and the range from till until and the
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
	 * @return the list
	 */
	List<Users> findUsers(Integer from, GenderType searchGender, Integer until,
			final String geohash);

}