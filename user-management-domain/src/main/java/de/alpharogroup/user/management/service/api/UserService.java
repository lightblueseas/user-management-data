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

import java.util.List;

import de.alpharogroup.address.book.domain.Address;
import de.alpharogroup.service.domain.DomainService;
import de.alpharogroup.user.domain.Role;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.management.enums.GenderType;

/**
 * The interface {@link UserService}.
 */
public interface UserService extends DomainService<Integer, User> {

	/**
	 * Checks if a user exists with the given user name.
	 *
	 * @param username
	 *            the user name
	 * @return true, if successful
	 */
	boolean existsUserWithUsername(String username);

	/**
	 * Find all {@link Address} from the given {@link User}.
	 *
	 * @param user
	 *            the user
	 * @return the list of found {@link Address} from the given {@link User}.
	 */
	List<Address> findAddressesFromUser(final User user);

	/**
	 * Find the main {@link Address} from the given {@link User}.
	 *
	 * @param user
	 *            the user
	 * @return the main {@link Address} from the given {@link User}.
	 */
	Address findAddressFromUser(final User user);

	/**
	 * Find roles from the given {@link User}.
	 *
	 * @param user
	 *            the user
	 * @return the list of found {@link Role} from the given {@link User}.
	 */
	List<Role> findRolesFromUser(final User user);

	/**
	 * Find the {@link User} object with the given email.
	 *
	 * @param email
	 *            the email
	 * @return the found {@link User} object
	 */
	User findUserWithEmail(final String email);

	/**
	 * Find {@link User} object from the given user name.
	 *
	 * @param username
	 *            the user name
	 * @return the found {@link User} object
	 */
	User findUserWithUsername(final String username);

	/**
	 * Checks if the given {@link User} object is in the given {@link Role}
	 * object.
	 *
	 * @param user
	 *            the user
	 * @param role
	 *            the role
	 * @return true, if successful
	 */
	boolean userIsInRole(final User user, final Role role);

	/**
	 * Find users from the given {@link GenderType} object and the range from till until.
	 *
	 * @param from
	 *            the from
	 * @param searchGender
	 *            the search gender
	 * @param until
	 *            the until
	 * @return the found list of {@link User} objects that matches the criteria.
	 */
	List<User> findUsers(Integer from, GenderType searchGender, Integer until);

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
	 * @return the found list of {@link User} objects that matches the criteria.
	 */
	List<User> findUsers(Integer from, GenderType searchGender, Integer until,
			final String geohash);

}
