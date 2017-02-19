package de.alpharogroup.user.management.rest.api;

import java.io.Serializable;
import java.sql.BatchUpdateException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.address.book.domain.Address;
import de.alpharogroup.auth.enums.InsertUserState;
import de.alpharogroup.auth.exceptions.EmailAlreadyExistsException;
import de.alpharogroup.auth.exceptions.UserAlreadyExistsException;
import de.alpharogroup.auth.models.UsernameSignUpModel;
import de.alpharogroup.auth.models.ValidationErrors;
import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.collections.pairs.Triple;
import de.alpharogroup.resource.system.application.model.ResourcesModel;
import de.alpharogroup.resource.system.domain.Resource;
import de.alpharogroup.user.management.domain.Contactmethod;
import de.alpharogroup.user.domain.Role;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.management.domain.UserData;
import de.alpharogroup.user.management.enums.ContactmethodType;
import de.alpharogroup.user.management.sign.up.SignUpUserResult;
import de.alpharogroup.user.management.sign.up.UserModel;

/**
 * The interface {@link UserManagementResource} provides methods for authenticate users of a given application.
 */
@Path("/usermanagement/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UserManagementResource {
	
	/**
	 * Checks if a {@link Role} object exist in the given list with the given
	 * role name.
	 *
	 * @param rolename
	 *            the role name
	 * @param roles
	 *            the roles
	 * @return true, if the {@link Role} object exist in the list otherwise
	 *         false.
	 */
	@POST
	@Path("/isin/role")
	boolean isInRole(final KeyValuePair<String, List<Role>> roleSearchModel);

	/**
	 * Checks if a user exists with the given email.
	 *
	 * @param emailContact
	 *            the email contact
	 * @return true, if successful
	 */
	@POST
	@Path("/exists/user/by/email")
	boolean existsUserWithEmail(final Contactmethod emailContact);

	/**
	 * Find all {@link Address} from the given {@link User}.
	 *
	 * @param user
	 *            the user
	 * @return the list of found {@link Address} from the given {@link User}.
	 */
	@POST
	@Path("/find/addresses")
	List<Address> findAddessesFromUser(final User user);

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

	/**
	 * Find all email contacts from the given {@link User}.
	 *
	 * @param user
	 *            the user
	 * @return the list of found {@link Contactmethod} from the given
	 *         {@link User}.
	 */
	@POST
	@Path("/find/all/emails")
	List<Contactmethod> findAllEmailContactmethodsFromUser(final User user);

	/**
	 * Find all fax contacts from the given {@link User}.
	 *
	 * @param user
	 *            the user
	 * @return the list of found {@link Contactmethod} from the given
	 *         {@link User}.
	 */
	@POST
	@Path("/find/all/faxes")
	List<Contactmethod> findAllFaxContactmethodsFromUser(final User user);

	/**
	 * Find all internet contacts from the given {@link User}.
	 *
	 * @param user
	 *            the user
	 * @return the list of found {@link Contactmethod} from the given
	 *         {@link User}.
	 */
	@POST
	@Path("/find/all/internets")
	List<Contactmethod> findAllInternetContactmethodsFromUser(final User user);

	/**
	 * Find all mobile contacts from user.
	 *
	 * @param user
	 *            the user
	 * @return the list of found {@link Contactmethod} from the given
	 *         {@link User}.
	 */
	@POST
	@Path("/find/all/mobiles")
	List<Contactmethod> findAllMobileContactmethodsFromUser(final User user);

	/**
	 * Find all telefon contacts from the given {@link User}.
	 *
	 * @param user
	 *            the user
	 * @return the list of found {@link Contactmethod} from the given
	 *         {@link User}.
	 */
	@POST
	@Path("/find/all/tel")
	List<Contactmethod> findAllTelefonContactmethodsFromUser(final User user);

	/**
	 * Find email contact from the given {@link User}.
	 *
	 * @param user
	 *            the user
	 * @return the found {@link Contactmethod} from the given {@link User}.
	 */
	@POST
	@Path("/find/email")
	Contactmethod findEmailContactFromUser(final User user);

	/**
	 * Find fax contact from the given {@link User}.
	 *
	 * @param user
	 *            the user
	 * @return the found {@link Contactmethod} from the given {@link User}.
	 */
	@POST
	@Path("/find/fax")
	Contactmethod findFaxContactFromUser(final User user);

	/**
	 * Find internet contact from the given {@link User}.
	 *
	 * @param user
	 *            the user
	 * @return the found {@link Contactmethod} from the given {@link User}.
	 */
	@POST
	@Path("/find/internet")
	Contactmethod findInternetContactFromUser(final User user);

	/**
	 * Find mobile contact from the given {@link User}.
	 *
	 * @param user
	 *            the user
	 * @return the found {@link Contactmethod} from the given {@link User}.
	 */
	@POST
	@Path("/find/mobile")
	Contactmethod findMobileContactFromUser(final User user);

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
	 * Find telefon contact from the given {@link User}.
	 *
	 * @param user
	 *            the user
	 * @return the found {@link Contactmethod} from the given {@link User}.
	 */
	@POST
	@Path("/find/tel")
	Contactmethod findTelefonContactFromUser(final User user);

	/**
	 * Find the {@link User} object with the given email.
	 *
	 * @param email
	 *            the email
	 * @return the found {@link User} object
	 */
	@GET
	@Path("/find/by/email/{email}")
	User findUserWithEmail(@PathParam("email")final String email);

	/**
	 * Find {@link User} object from the given email or user name.
	 *
	 * @param emailOrUsername
	 *            the email or user name
	 * @return the found {@link User} object
	 */
	@GET
	@Path("/find/by/email/or/username/{emailOrUsername}")
	User findUserWithEmailOrUsername(@PathParam("emailOrUsername")final String emailOrUsername);

	/**
	 * Find {@link User} object from the given user name.
	 *
	 * @param username
	 *            the user name
	 * @return the found {@link User} object
	 */
	@GET
	@Path("/find/by/username/{username}")
	User findUserWithUsername(@PathParam("username")final String username);

	/**
	 * Checks if the given {@link User} object is in the given role from the
	 * given role name.
	 *
	 * @param user
	 *            the user
	 * @param rolename
	 *            the role name
	 * @return true, if the given {@link User} object is in role otherwise
	 *         false.
	 */
	@POST
	@Path("/is/user/in/role")
	boolean isUserInRole(final KeyValuePair<User, String> userSearchModel);

	/**
	 * Persist the given collection of {@link Address} objects from the given
	 * {@link User} object.
	 *
	 * @param user
	 *            the user
	 * @param addresses
	 *            the addresses
	 */
	@POST
	@Path("/save/addresses")
	void saveAddressesFromUser(final KeyValuePair<User, Collection<Address>> userSaveModel);

	/**
	 * Persist the given {@link Address} object from the given {@link User}
	 * object.
	 *
	 * @param user
	 *            the user
	 * @param address
	 *            the address
	 */
	@POST
	@Path("/save/address")
	void saveAddressFromUser(final KeyValuePair<User, Address> userSaveModel);

	/**
	 * Persist the given {@link User} object.
	 *
	 * @param user
	 *            The {@link User} object to persist.
	 * @return the id of the persisted {@link User} object.
	 * @throws UserAlreadyExistsException
	 *             Thrown if the given {@link User} object already exists in
	 *             the database.
	 */
	@POST
	@Path("/new/user")
	Serializable saveNewUser(User user) throws UserAlreadyExistsException;

	/**
	 * Persist the given {@link User} object without checking the user name.
	 *
	 * @param user
	 *            The {@link User} object to persist.
	 * @return the id of the persisted {@link User} object.
	 * @throws UserAlreadyExistsException
	 *             Thrown if the given {@link User} object already exists in
	 *             the database.
	 */
	@POST
	@Path("/new/user/onlywith/email")
	Serializable saveUserOnlyWithEmail(User user) throws UserAlreadyExistsException;

	/**
	 * Persist the given {@link Contactmethod} object to the given
	 * {@link User} object contacts.
	 *
	 * @param user
	 *            the user
	 * @param contact
	 *            the contact
	 * @return the persisted {@link Contactmethod} object.
	 * @throws BatchUpdateException
	 *             the batch update exception
	 */
	@POST
	@Path("/save/user/with/contactmethod")
	Contactmethod saveUserWithContactmethod(KeyValuePair<User, Contactmethod> userSaveModel) throws BatchUpdateException;

	/**
	 * Persist the given list of {@link Contactmethod} objects to the given
	 * {@link User} object contacts.
	 *
	 * @param user
	 *            the user
	 * @param contacts
	 *            the contacts
	 * @return the persisted list of {@link Contactmethod} objects.
	 * @throws BatchUpdateException
	 *             the batch update exception
	 */
	@POST
	@Path("/save/user/with/contactmethods")
	List<Contactmethod> saveUserWithContactmethods(final KeyValuePair<User, List<Contactmethod>> userSaveModel)
			throws BatchUpdateException;
	
	/**
	 * Persist the given {@link User} object with the given collection of
	 * {@link Role} objects.
	 *
	 * @param user
	 *            the user
	 * @param roles
	 *            the roles
	 */
	@POST
	@Path("/save/user/with/roles")
	void saveUserWithRoles(final KeyValuePair<User, Collection<Role>> userSaveModel);

	/**
	 * Update email from the given {@link User} object if the email has changed
	 * and return the new contactMethod object or the contactMethod that is
	 * persist in database. Consider to check if the email already exists before
	 * you call this method otherwise an exception is thrown.
	 *
	 * @param email
	 *            the email
	 * @param user
	 *            the user
	 * @return the {@link Contactmethod} object
	 * @throws EmailAlreadyExistsException
	 *             the email already exists exception
	 */
	@POST
	@Path("/set/email")
	Contactmethod setEmail(final KeyValuePair<String, User> userSaveModel) throws EmailAlreadyExistsException;
	
	/**
	 * Sets a new user name to the the given {@link User} object.
	 *
	 * @param username
	 *            the username
	 * @param user
	 *            the user
	 * @return true, if successful
	 * @throws UserAlreadyExistsException
	 *             is thrown if the user already exists with the given user
	 *             name.
	 */
	@POST
	@Path("/set/username")
	boolean setUsername(final KeyValuePair<String, User> userSaveModel) throws UserAlreadyExistsException;

	/**
	 * Update an existing {@link Contactmethod} object. If the contact method
	 * has changed the new {@link Contactmethod} object will be returned or
	 * null if nothing changed.
	 *
	 * @param contactmethodValue
	 *            the contact method value
	 * @param contactmethodType
	 *            the contact method type
	 * @param contactmethod
	 *            the contact method
	 * @return the {@link Contactmethod} object
	 */
	@POST
	@Path("/update/contactmethod")
	Contactmethod updateContactmethod(final Triple<String, ContactmethodType, Contactmethod> updateModel);
	
	/**
	 * Update user name from the given {@link User} object if the user name has
	 * changed. Returns true if the user name has changed otherwise false.
	 *
	 * @param username
	 *            the user name
	 * @param user
	 *            the user
	 * @return Returns true if the user name has changed otherwise false.
	 * @throws UserAlreadyExistsException
	 *             is thrown if the user already exists with the given user
	 *             name.
	 */
	@POST
	@Path("/update/username")
	boolean updateUsername(final KeyValuePair<String, User> updateModel) throws UserAlreadyExistsException;

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
	@POST
	@Path("/user/is/in/role")
	boolean userIsInRole(final KeyValuePair<User, Role> searchModel);

	/**
	 * Validate the given {@link UsernameSignUpModel} object.
	 *
	 * @param model
	 *            the {@link UsernameSignUpModel} object.
	 * @return A {@link ValidationErrors} object if validation fail otherwise
	 *         null if the validation is successful.
	 */
	@POST
	@Path("/validate")
	ValidationErrors validate(UsernameSignUpModel model);

	/**
	 * Sign up process for insert a new user in the database.
	 *
	 * @param model
	 *            the model
	 * @param roles
	 *            the roles
	 * @param userModel
	 *            the user model
	 * @return the {@link SignUpUserResult} object with the result of the sign
	 *         up process
	 */
	@POST
	@Path("/signup/user")
	SignUpUserResult signUpUser(Triple<UsernameSignUpModel, Set<Role>, UserModel> saveModel);

	/**
	 * Persist the given resource model object with the given user id.
	 *
	 * @param resourceModel
	 *            the resource model
	 * @param userId
	 *            the user id
	 * @return the persisted {@link Resource} object
	 */
	@POST
	@Path("/persist/resource")
	Resource persistResource(KeyValuePair<ResourcesModel, Integer> saveModel);

	/**
	 * Deletes the {@link Resource} object from the given resource model
	 * object with the given user data id.
	 *
	 * @param resource
	 *            the resource
	 * @param userDataId
	 *            the user data id
	 */
	@POST
	@Path("/delete/resource")
	void deleteResource(final KeyValuePair<ResourcesModel, Integer> deleteModel);

	/**
	 * Deletes the given black listed {@link User} object from the given user data id.
	 *
	 * @param blacklisted
	 *            the black listed user
	 * @param userDataId
	 *            the user data id
	 * @return the {@link UserData} object.
	 */
	@POST
	@Path("/delete/blacklisted")
	UserData deleteBlacklisted(final KeyValuePair<User, Integer> deleteModel);

	/**
	 * Deletes the given {@link Address} object from the given {@link UserData} object.
	 *
	 * @param address
	 *            the {@link Address} object
	 * @param ud
	 *            the {@link UserData} object
	 * @return the {@link UserData} object.
	 */
	@POST
	@Path("/delete/address")
	UserData deleteAddress(final KeyValuePair<Address, UserData> deleteModel);

	/**
	 * Adds the given contact {@link User} object to the contacts of the given {@link User} object.
	 *
	 * @param user the user
	 * @param contact the contact to add
	 * @return the {@link User} object with the new contacts.
	 */
	@POST
	@Path("/add/user/contact")
	User addUserContact(final KeyValuePair<User, User> saveModel);
	
	// ****************************************
	// methods from the interface UserExistenceService
	// ****************************************
	
	/**
	 * Checks if a user exists with the given email.
	 * 
	 * @param email
	 *            the email
	 * @return true, if successful
	 */
	@GET
	@Path("/exists/user/with/email/{email}")
	boolean existsUserWithEmail(@PathParam("email")final String email);

	/**
	 * Checks if a user exists with the given user name.
	 * 
	 * @param username
	 *            the user name
	 * @return true, if successful
	 */
	@GET
	@Path("/exists/user/with/username/{username}")
	boolean existsUserWithUsername(@PathParam("username")final String username);
	
	/**
	 * Checks if a user exists with the given email or user name.
	 *
	 * @param emailOrUsername the email or user name
	 * @return true, if successful
	 */
	@GET
	@Path("/exists/user/with/emailOrUsername/{emailOrUsername}")
	boolean existsUserWithEmailOrUsername(@PathParam("emailOrUsername")final String emailOrUsername);

	/**
	 * Checks if a user exists with the given email or user name.
	 * 
	 * @param email
	 *            the email
	 * @param username
	 *            the user name
	 * @return the resulted {@link InsertUserState} object.
	 */
	@POST
	@Path("/exists/user/with/email/or/username")
	InsertUserState existsUserWithEmailOrUsername(final KeyValuePair<String, String> searchModel);

}
