package de.alpharogroup.user.management.service.api;

import java.io.Serializable;
import java.sql.BatchUpdateException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.auth.exceptions.EmailAlreadyExistsException;
import de.alpharogroup.auth.exceptions.UserAlreadyExistsException;
import de.alpharogroup.auth.models.UsernameSignUpModel;
import de.alpharogroup.auth.models.ValidationErrors;
import de.alpharogroup.auth.usermanagement.UserExistenceService;
import de.alpharogroup.resource.system.application.model.ResourcesModel;
import de.alpharogroup.resource.system.domain.Resource;
import de.alpharogroup.user.management.domain.Contactmethod;
import de.alpharogroup.user.management.domain.Role;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.domain.UserData;
import de.alpharogroup.user.management.enums.ContactmethodType;
import de.alpharogroup.user.management.sign.up.SignUpUserResult;
import de.alpharogroup.user.management.sign.up.UserModel;

/**
 * The interface {@link UserManagementService}.
 */
public interface UserManagementService extends UserExistenceService {

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
	boolean isInRole(final String rolename, final List<Role> roles);

	/**
	 * Checks if a user exists with the given email.
	 *
	 * @param emailContact
	 *            the email contact
	 * @return true, if successful
	 */
	boolean existsUserWithEmail(final Contactmethod emailContact);

	/**
	 * Checks if a user exists with the given email or user name.
	 *
	 * @param emailOrUsername
	 *            the email or user name
	 * @return true, if successful
	 */
	boolean existsUserWithEmailOrUsername(final String emailOrUsername);

	/**
	 * Find all {@link Addresses} from the given {@link User}.
	 * 
	 * @param user
	 *            the user
	 * @return the list of found {@link Addresses} from the given {@link User}.
	 */
	List<Addresses> findAddessesFromUser(final User user);

	/**
	 * Find the main {@link Addresses} from the given {@link User}.
	 * 
	 * @param user
	 *            the user
	 * @return the main {@link Addresses} from the given {@link User}.
	 */
	Addresses findAddressFromUser(final User user);

	/**
	 * Find all email contacts from the given {@link User}.
	 * 
	 * @param user
	 *            the user
	 * @return the list of found {@link Contactmethod} from the given
	 *         {@link User}.
	 */
	List<Contactmethod> findAllEmailContactmethodsFromUser(final User user);

	/**
	 * Find all fax contacts from the given {@link User}.
	 * 
	 * @param user
	 *            the user
	 * @return the list of found {@link Contactmethod} from the given
	 *         {@link User}.
	 */
	List<Contactmethod> findAllFaxContactmethodsFromUser(final User user);

	/**
	 * Find all internet contacts from the given {@link User}.
	 * 
	 * @param user
	 *            the user
	 * @return the list of found {@link Contactmethod} from the given
	 *         {@link User}.
	 */
	List<Contactmethod> findAllInternetContactmethodsFromUser(final User user);

	/**
	 * Find all mobile contacts from user.
	 * 
	 * @param user
	 *            the user
	 * @return the list of found {@link Contactmethod} from the given
	 *         {@link User}.
	 */
	List<Contactmethod> findAllMobileContactmethodsFromUser(final User user);

	/**
	 * Find all telefon contacts from the given {@link User}.
	 * 
	 * @param user
	 *            the user
	 * @return the list of found {@link Contactmethod} from the given
	 *         {@link User}.
	 */
	List<Contactmethod> findAllTelefonContactmethodsFromUser(final User user);

	/**
	 * Find email contact from the given {@link User}.
	 * 
	 * @param user
	 *            the user
	 * @return the found {@link Contactmethod} from the given {@link User}.
	 */
	Contactmethod findEmailContactFromUser(final User user);

	/**
	 * Find fax contact from the given {@link User}.
	 * 
	 * @param user
	 *            the user
	 * @return the found {@link Contactmethod} from the given {@link User}.
	 */
	Contactmethod findFaxContactFromUser(final User user);

	/**
	 * Find internet contact from the given {@link User}.
	 * 
	 * @param user
	 *            the user
	 * @return the found {@link Contactmethod} from the given {@link User}.
	 */
	Contactmethod findInternetContactFromUser(final User user);

	/**
	 * Find mobile contact from the given {@link User}.
	 * 
	 * @param user
	 *            the user
	 * @return the found {@link Contactmethod} from the given {@link User}.
	 */
	Contactmethod findMobileContactFromUser(final User user);

	/**
	 * Find roles from the given {@link User}.
	 * 
	 * @param user
	 *            the user
	 * @return the list of found {@link Role} from the given {@link User}.
	 */
	List<Role> findRolesFromUser(final User user);

	/**
	 * Find telefon contact from the given {@link User}.
	 * 
	 * @param user
	 *            the user
	 * @return the found {@link Contactmethod} from the given {@link User}.
	 */
	Contactmethod findTelefonContactFromUser(final User user);

	/**
	 * Find the {@link User} object with the given email.
	 * 
	 * @param email
	 *            the email
	 * @return the found {@link User} object
	 */
	User findUserWithEmail(final String email);

	/**
	 * Find {@link User} object from the given email or user name.
	 * 
	 * @param emailOrUsername
	 *            the email or user name
	 * @return the found {@link User} object
	 */
	User findUserWithEmailOrUsername(final String emailOrUsername);

	/**
	 * Find {@link User} object from the given user name.
	 * 
	 * @param username
	 *            the user name
	 * @return the found {@link User} object
	 */
	User findUserWithUsername(final String username);

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
	boolean isUserInRole(final User user, String rolename);

	/**
	 * Persist the given collection of {@link Addresses} objects from the given
	 * {@link User} object.
	 * 
	 * @param user
	 *            the user
	 * @param addresses
	 *            the addresses
	 */
	void saveAddressesFromUser(final User user, final Collection<Addresses> addresses);

	/**
	 * Persist the given {@link Addresses} object from the given {@link User}
	 * object.
	 *
	 * @param user
	 *            the user
	 * @param address
	 *            the address
	 */
	void saveAddressFromUser(final User user, Addresses address);

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
	Contactmethod saveUserWithContactmethod(User user, Contactmethod contact) throws BatchUpdateException;

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
	List<Contactmethod> saveUserWithContactmethods(final User user, final List<Contactmethod> contacts)
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
	void saveUserWithRoles(User user, Collection<Role> roles);

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
	Contactmethod setEmail(final String email, final User user) throws EmailAlreadyExistsException;

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
	boolean setUsername(final String username, final User user) throws UserAlreadyExistsException;

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
	Contactmethod updateContactmethod(final String contactmethodValue, final ContactmethodType contactmethodType,
			final Contactmethod contactmethod);

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
	boolean updateUsername(final String username, final User user) throws UserAlreadyExistsException;

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
	 * Validate the given {@link UsernameSignUpModel} object.
	 *
	 * @param model
	 *            the {@link UsernameSignUpModel} object.
	 * @return A {@link ValidationErrors} object if validation fail otherwise
	 *         null if the validation is successful.
	 */
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
	SignUpUserResult signUpUser(UsernameSignUpModel model, Set<Role> roles, UserModel userModel);

	/**
	 * Persist the given {@link ResourceModel} object with the given user id.
	 *
	 * @param resourceModel
	 *            the resource model
	 * @param userId
	 *            the user id
	 * @return the persisted {@link Resources} object
	 */
	Resource persistResource(ResourcesModel resourceModel, final Integer userId);

	/**
	 * Deletes the {@link Resources} object from the given {@link ResourceModel}
	 * object with the given user data id.
	 *
	 * @param resource
	 *            the resource
	 * @param userDataId
	 *            the user data id
	 */
	void deleteResource(final ResourcesModel resource, final Integer userDataId);

	/**
	 * Deletes the given black listed {@link User} object from the given user data id.
	 *
	 * @param blacklisted
	 *            the black listed user
	 * @param userDataId
	 *            the user data id
	 * @return the {@link UserDatas} object.
	 */
	UserData deleteBlacklisted(User blacklisted, final Integer userDataId);

	/**
	 * Deletes the given {@link Addresses} object from the given {@link UserDatas} object.
	 *
	 * @param address
	 *            the {@link Addresses} object
	 * @param ud
	 *            the {@link UserDatas} object
	 * @return the {@link UserDatas} object.
	 */
	UserData deleteAddress(Addresses address, final UserData ud);

	/**
	 * Adds the given contact {@link User} object to the contacts of the given {@link User} object.
	 *
	 * @param user the user
	 * @param contact the contact to add
	 * @return the {@link User} object with the new contacts.
	 */
	User addUserContact(User user, User contact);

}
