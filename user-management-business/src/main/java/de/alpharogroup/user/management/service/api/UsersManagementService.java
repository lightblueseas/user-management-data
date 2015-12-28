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
import de.alpharogroup.resource.system.entities.Resources;
import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.management.entities.Roles;
import de.alpharogroup.user.management.entities.UserDatas;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.enums.ContactmethodType;
import de.alpharogroup.user.management.sign.up.SignUpUserResult;
import de.alpharogroup.user.management.sign.up.UserModel;

/**
 * The interface {@link UsersManagementService}.
 *
 * @author Asterios Raptis
 */
public interface UsersManagementService extends UserExistenceService {

	/**
	 * Checks if a {@link Roles} object exist in the given list with the given
	 * role name.
	 *
	 * @param rolename
	 *            the role name
	 * @param roles
	 *            the roles
	 * @return true, if the {@link Roles} object exist in the list otherwise
	 *         false.
	 */
	boolean isInRole(final String rolename, final List<Roles> roles);

	/**
	 * Checks if a user exists with the given email.
	 *
	 * @param emailContact
	 *            the email contact
	 * @return true, if successful
	 */
	boolean existsUserWithEmail(final Contactmethods emailContact);

	/**
	 * Find all {@link Addresses} from the given {@link Users}.
	 *
	 * @param user
	 *            the user
	 * @return the list of found {@link Addresses} from the given {@link Users}.
	 */
	List<Addresses> findAddessesFromUser(final Users user);

	/**
	 * Find the main {@link Addresses} from the given {@link Users}.
	 *
	 * @param user
	 *            the user
	 * @return the main {@link Addresses} from the given {@link Users}.
	 */
	Addresses findAddressFromUser(final Users user);

	/**
	 * Find all email contacts from the given {@link Users}.
	 *
	 * @param user
	 *            the user
	 * @return the list of found {@link Contactmethods} from the given
	 *         {@link Users}.
	 */
	List<Contactmethods> findAllEmailContactmethodsFromUser(final Users user);

	/**
	 * Find all fax contacts from the given {@link Users}.
	 *
	 * @param user
	 *            the user
	 * @return the list of found {@link Contactmethods} from the given
	 *         {@link Users}.
	 */
	List<Contactmethods> findAllFaxContactmethodsFromUser(final Users user);

	/**
	 * Find all internet contacts from the given {@link Users}.
	 *
	 * @param user
	 *            the user
	 * @return the list of found {@link Contactmethods} from the given
	 *         {@link Users}.
	 */
	List<Contactmethods> findAllInternetContactmethodsFromUser(final Users user);

	/**
	 * Find all mobile contacts from user.
	 *
	 * @param user
	 *            the user
	 * @return the list of found {@link Contactmethods} from the given
	 *         {@link Users}.
	 */
	List<Contactmethods> findAllMobileContactmethodsFromUser(final Users user);

	/**
	 * Find all telefon contacts from the given {@link Users}.
	 *
	 * @param user
	 *            the user
	 * @return the list of found {@link Contactmethods} from the given
	 *         {@link Users}.
	 */
	List<Contactmethods> findAllTelefonContactmethodsFromUser(final Users user);

	/**
	 * Find email contact from the given {@link Users}.
	 *
	 * @param user
	 *            the user
	 * @return the found {@link Contactmethods} from the given {@link Users}.
	 */
	Contactmethods findEmailContactFromUser(final Users user);

	/**
	 * Find fax contact from the given {@link Users}.
	 *
	 * @param user
	 *            the user
	 * @return the found {@link Contactmethods} from the given {@link Users}.
	 */
	Contactmethods findFaxContactFromUser(final Users user);

	/**
	 * Find internet contact from the given {@link Users}.
	 *
	 * @param user
	 *            the user
	 * @return the found {@link Contactmethods} from the given {@link Users}.
	 */
	Contactmethods findInternetContactFromUser(final Users user);

	/**
	 * Find mobile contact from the given {@link Users}.
	 *
	 * @param user
	 *            the user
	 * @return the found {@link Contactmethods} from the given {@link Users}.
	 */
	Contactmethods findMobileContactFromUser(final Users user);

	/**
	 * Find roles from the given {@link Users}.
	 *
	 * @param user
	 *            the user
	 * @return the list of found {@link Roles} from the given {@link Users}.
	 */
	List<Roles> findRolesFromUser(final Users user);

	/**
	 * Find telefon contact from the given {@link Users}.
	 *
	 * @param user
	 *            the user
	 * @return the found {@link Contactmethods} from the given {@link Users}.
	 */
	Contactmethods findTelefonContactFromUser(final Users user);

	/**
	 * Find the {@link Users} object with the given email.
	 *
	 * @param email
	 *            the email
	 * @return the found {@link Users} object
	 */
	Users findUserWithEmail(final String email);

	/**
	 * Find {@link Users} object from the given email or user name.
	 *
	 * @param emailOrUsername
	 *            the email or user name
	 * @return the found {@link Users} object
	 */
	Users findUserWithEmailOrUsername(final String emailOrUsername);

	/**
	 * Find {@link Users} object from the given user name.
	 *
	 * @param username
	 *            the user name
	 * @return the found {@link Users} object
	 */
	Users findUserWithUsername(final String username);

	/**
	 * Checks if the given {@link Users} object is in the given role from the
	 * given role name.
	 *
	 * @param user
	 *            the user
	 * @param rolename
	 *            the role name
	 * @return true, if the given {@link Users} object is in role otherwise
	 *         false.
	 */
	boolean isUserInRole(final Users user, String rolename);

	/**
	 * Persist the given collection of {@link Addresses} objects from the given
	 * {@link Users} object.
	 *
	 * @param user
	 *            the user
	 * @param addresses
	 *            the addresses
	 */
	void saveAddressesFromUser(final Users user, final Collection<Addresses> addresses);

	/**
	 * Persist the given {@link Addresses} object from the given {@link Users}
	 * object.
	 *
	 * @param user
	 *            the user
	 * @param address
	 *            the address
	 */
	void saveAddressFromUser(final Users user, Addresses address);

	/**
	 * Persist the given {@link Users} object.
	 *
	 * @param user
	 *            The {@link Users} object to persist.
	 * @return the id of the persisted {@link Users} object.
	 * @throws UserAlreadyExistsException
	 *             Thrown if the given {@link Users} object already exists in
	 *             the database.
	 */
	Serializable saveNewUser(Users user) throws UserAlreadyExistsException;

	/**
	 * Persist the given {@link Users} object without checking the user name.
	 *
	 * @param user
	 *            The {@link Users} object to persist.
	 * @return the id of the persisted {@link Users} object.
	 * @throws UserAlreadyExistsException
	 *             Thrown if the given {@link Users} object already exists in
	 *             the database.
	 */
	Serializable saveUserOnlyWithEmail(Users user) throws UserAlreadyExistsException;

	/**
	 * Persist the given {@link Contactmethods} object to the given
	 * {@link Users} object contacts.
	 *
	 * @param user
	 *            the user
	 * @param contact
	 *            the contact
	 * @return the persisted {@link Contactmethods} object.
	 * @throws BatchUpdateException
	 *             the batch update exception
	 */
	Contactmethods saveUserWithContactmethod(Users user, Contactmethods contact) throws BatchUpdateException;

	/**
	 * Persist the given list of {@link Contactmethods} objects to the given
	 * {@link Users} object contacts.
	 *
	 * @param user
	 *            the user
	 * @param contacts
	 *            the contacts
	 * @return the persisted list of {@link Contactmethods} objects.
	 * @throws BatchUpdateException
	 *             the batch update exception
	 */
	List<Contactmethods> saveUserWithContactmethods(final Users user, final List<Contactmethods> contacts)
			throws BatchUpdateException;

	/**
	 * Persist the given {@link Users} object with the given collection of
	 * {@link Roles} objects.
	 *
	 * @param user
	 *            the user
	 * @param roles
	 *            the roles
	 */
	void saveUserWithRoles(Users user, Collection<Roles> roles);

	/**
	 * Update email from the given {@link Users} object if the email has changed
	 * and return the new contactMethod object or the contactMethod that is
	 * persist in database. Consider to check if the email already exists before
	 * you call this method otherwise an exception is thrown.
	 *
	 * @param email
	 *            the email
	 * @param user
	 *            the user
	 * @return the {@link Contactmethods} object
	 * @throws EmailAlreadyExistsException
	 *             the email already exists exception
	 */
	Contactmethods setEmail(final String email, final Users user) throws EmailAlreadyExistsException;

	/**
	 * Sets a new user name to the the given {@link Users} object.
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
	boolean setUsername(final String username, final Users user) throws UserAlreadyExistsException;

	/**
	 * Update an existing {@link Contactmethods} object. If the contact method
	 * has changed the new {@link Contactmethods} object will be returned or
	 * null if nothing changed.
	 *
	 * @param contactmethodValue
	 *            the contact method value
	 * @param contactmethodType
	 *            the contact method type
	 * @param contactmethod
	 *            the contact method
	 * @return the {@link Contactmethods} object
	 */
	Contactmethods updateContactmethod(final String contactmethodValue, final ContactmethodType contactmethodType,
			final Contactmethods contactmethod);

	/**
	 * Update user name from the given {@link Users} object if the user name has
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
	boolean updateUsername(final String username, final Users user) throws UserAlreadyExistsException;

	/**
	 * Checks if the given {@link Users} object is in the given {@link Roles}
	 * object.
	 *
	 * @param user
	 *            the user
	 * @param role
	 *            the role
	 * @return true, if successful
	 */
	boolean userIsInRole(final Users user, final Roles role);

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
	SignUpUserResult signUpUser(UsernameSignUpModel model, Set<Roles> roles, UserModel userModel);

	/**
	 * Persist the given resource model object with the given user id.
	 *
	 * @param resourceModel
	 *            the resource model
	 * @param userId
	 *            the user id
	 * @return the persisted {@link Resources} object
	 */
	Resources persistResource(ResourcesModel resourceModel, final Integer userId);

	/**
	 * Deletes the {@link Resources} object from the given resource model
	 * object with the given user data id.
	 *
	 * @param resource
	 *            the resource
	 * @param userDataId
	 *            the user data id
	 */
	void deleteResource(final ResourcesModel resource, final Integer userDataId);

	/**
	 * Deletes the given black listed {@link Users} object from the given user data id.
	 *
	 * @param blacklisted
	 *            the black listed user
	 * @param userDataId
	 *            the user data id
	 * @return the {@link UserDatas} object.
	 */
	UserDatas deleteBlacklisted(Users blacklisted, final Integer userDataId);

	/**
	 * Deletes the given {@link Addresses} object from the given {@link UserDatas} object.
	 *
	 * @param address
	 *            the {@link Addresses} object
	 * @param ud
	 *            the {@link UserDatas} object
	 * @return the {@link UserDatas} object.
	 */
	UserDatas deleteAddress(Addresses address, final UserDatas ud);

	/**
	 * Adds the given contact {@link Users} object to the contacts of the given {@link Users} object.
	 *
	 * @param user the user
	 * @param contact the contact to add
	 * @return the {@link Users} object with the new contacts.
	 */
	Users addUserContact(Users user, Users contact);

}
