package de.alpharogroup.user.management.rest.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.address.book.domain.Address;
import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.collections.pairs.Triple;
import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.management.domain.Role;
import de.alpharogroup.user.management.domain.User;
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

	@GET
	@Path("/findall/")
	List<User> findAll();
	

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
	boolean userIsInRole(final KeyValuePair<User, Role> user);

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
	List<User> findUsers(final Triple<Integer, GenderType, Integer> searchCriteria);

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
	List<User> findUsers(UserSearchCriteria userSearchCriteria);

}
