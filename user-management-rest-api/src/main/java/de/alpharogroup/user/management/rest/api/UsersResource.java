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
package de.alpharogroup.user.management.rest.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.address.book.domain.Address;
import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.collections.pairs.Triple;
import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.domain.Role;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.management.domain.model.UserSearchCriteria;
import de.alpharogroup.user.management.enums.GenderType;

/**
 * The interface {@link UsersResource} provides methods for resolve users.
 */
@Path("/user/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UsersResource extends RestfulResource<Integer, User>
{

	/**
	 * Checks if a user exists with the given user name.
	 * 
	 * @param username
	 *            the user name
	 * @return true, if successful
	 */
	@GET
	@Path("/exists/user/with/username/{username}")
	boolean existsUserWithUsername(@PathParam("username") String username);

	/**
	 * Find all {@link Address} from the given {@link User}.
	 * 
	 * @param user
	 *            the user
	 * @return the list of found {@link Address} from the given {@link User}.
	 */
	@POST
	@Path("/find/addresses")
	List<Address> findAddressesFromUser(final User user);

	/**
	 * Find the main {@link Address} from the given {@link User}.
	 * 
	 * @param user
	 *            the user
	 * @return the main {@link Address} from the given {@link User}.
	 */
	@POST
	@Path("/find/address")
	Address findAddressFromUser(final User user);

	@GET
	@Path("/findall/")
	List<User> findAll();

	/**
	 * Find roles from the given {@link User}.
	 * 
	 * @param user
	 *            the user
	 * @return the list of found {@link Role} from the given {@link User}.
	 */
	@POST
	@Path("/find/roles")
	List<Role> findRolesFromUser(final User user);

	/**
	 * Find users from the given {@link GenderType} object and the range from till until.
	 *
	 * @param searchCriteria
	 *            the {@link KeyValuePair} object that encapsulate the from age the gender and the
	 *            until age.
	 * @return the found list of {@link User} objects that matches the criteria.
	 */
	@POST
	@Path("/find/users")
	List<User> findUsers(final Triple<Integer, GenderType, Integer> searchCriteria);

	/**
	 * Find users from the given {@link GenderType} object and the range from till until and the
	 * given geohash code.
	 *
	 * @param userSearchCriteria
	 *            the {@link UserSearchCriteria} object that encapsulate the search criteria for
	 *            find users
	 * @return the found list of {@link User} objects that matches the criteria.
	 */
	@POST
	@Path("/find/users/by/geo")
	List<User> findUsers(UserSearchCriteria userSearchCriteria);

	/**
	 * Find the {@link User} object with the given email.
	 * 
	 * @param email
	 *            the email
	 * @return the found {@link User} object
	 */
	@GET
	@Path("/find/by/email/{email}")
	User findUserWithEmail(@PathParam("email") final String email);

	/**
	 * Find {@link User} object from the given user name.
	 * 
	 * @param username
	 *            the user name
	 * @return the found {@link User} object
	 */
	@GET
	@Path("/find/by/username/{username}")
	User findUserWithUsername(final String username);

	/**
	 * Checks if the given {@link User} object is in the given {@link Role} object.
	 *
	 * @param user
	 *            the {@link KeyValuePair} object that encapsulate the user and the role
	 * @return true, if successful
	 */
	@POST
	@Path("/user/is/in/role")
	boolean userIsInRole(final KeyValuePair<User, Role> user);

}
