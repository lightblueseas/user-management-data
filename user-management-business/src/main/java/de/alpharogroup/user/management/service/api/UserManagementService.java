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
import de.alpharogroup.resource.system.application.model.ResourcesModel;
import de.alpharogroup.resource.system.entities.Resources;
import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.management.entities.Roles;
import de.alpharogroup.user.management.entities.UserData;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.enums.Contactmethod;
import de.alpharogroup.user.management.sign.up.SignUpUserResult;
import de.alpharogroup.user.management.sign.up.UserModel;

/**
 * The Interface UserManagementBusinessService.
 * 
 * @author Asterios Raptis
 */
public interface UserManagementService extends de.alpharogroup.auth.usermanagement.UserManagementService {
	
	/**
	 * Checks if is in role.
	 *
	 * @param rolename the rolename
	 * @param roles the roles
	 * @return true, if is in role
	 */
	boolean isInRole(final String rolename, final List<Roles> roles);
	
	/**
	 * Exists user with email.
	 *
	 * @param emailContact the email contact
	 * @return true, if successful
	 */
	boolean existsUserWithEmail(final Contactmethods emailContact);
	
	/**
	 * Existsfind user with email or username.
	 *
	 * @param emailOrUsername the email or username
	 * @return true, if successful
	 */
	boolean existsfindUserWithEmailOrUsername(
			final String emailOrUsername);

	/**
	 * Find addesses from user.
	 * 
	 * @param user
	 *            the user
	 * @return the list
	 */
	List<Addresses> findAddessesFromUser(final Users user);

	/**
	 * Find address from user.
	 * 
	 * @param user
	 *            the user
	 * @return the addresses
	 */
	Addresses findAddressFromUser(final Users user);

	/**
	 * Find all email contacts from user.
	 * 
	 * @param user
	 *            the user
	 * @return the list
	 */
	List<Contactmethods> findAllEmailContactmethodsFromUser(final Users user);

	/**
	 * Find all fax contacts from user.
	 * 
	 * @param user
	 *            the user
	 * @return the list
	 */
	List<Contactmethods> findAllFaxContactmethodsFromUser(final Users user);

	/**
	 * Find all internet contacts from user.
	 * 
	 * @param user
	 *            the user
	 * @return the list
	 */
	List<Contactmethods> findAllInternetContactmethodsFromUser(final Users user);

	/**
	 * Find all mobile contacts from user.
	 * 
	 * @param user
	 *            the user
	 * @return the list
	 */
	List<Contactmethods> findAllMobileContactmethodsFromUser(final Users user);

	/**
	 * Find all telefon contacts from user.
	 * 
	 * @param user
	 *            the user
	 * @return the list
	 */
	List<Contactmethods> findAllTelefonContactmethodsFromUser(final Users user);

	/**
	 * Find email contact from user.
	 * 
	 * @param user
	 *            the user
	 * @return the contacts
	 */
	Contactmethods findEmailContactFromUser(final Users user);

	/**
	 * Find fax contact from user.
	 * 
	 * @param user
	 *            the user
	 * @return the contacts
	 */
	Contactmethods findFaxContactFromUser(final Users user);

	/**
	 * Find internet contact from user.
	 * 
	 * @param user
	 *            the user
	 * @return the contacts
	 */
	Contactmethods findInternetContactFromUser(final Users user);

	/**
	 * Find mobile contact from user.
	 * 
	 * @param user
	 *            the user
	 * @return the contacts
	 */
	Contactmethods findMobileContactFromUser(final Users user);

	/**
	 * Find roles from user.
	 * 
	 * @param user
	 *            the user
	 * @return the list
	 */
	List<Roles> findRolesFromUser(final Users user);

	/**
	 * Find telefon contact from user.
	 * 
	 * @param user
	 *            the user
	 * @return the contacts
	 */
	Contactmethods findTelefonContactFromUser(final Users user);

	/**
	 * Find user with email.
	 * 
	 * @param email
	 *            the email
	 * @return the users
	 */
	Users findUserWithEmail(final String email);

	/**
	 * Find user with email or username.
	 * 
	 * @param emailOrUsername
	 *            the email or username
	 * @return the users
	 */
	Users findUserWithEmailOrUsername(final String emailOrUsername);

	/**
	 * Find user with username.
	 * 
	 * @param username
	 *            the username
	 * @return the users
	 */
	Users findUserWithUsername(final String username);

	/**
	 * Checks if is user in role.
	 * 
	 * @param user
	 *            the user
	 * @param rolename
	 *            the rolename
	 * @return true, if is user in role
	 */
	boolean isUserInRole(final Users user, String rolename);

	/**
	 * Save addresses from user.
	 * 
	 * @param user
	 *            the user
	 * @param addresses
	 *            the addresses
	 */
	void saveAddressesFromUser(final Users user,
			final Collection<Addresses> addresses);

	/**
	 * Save a single address from user.
	 *
	 * @param user            the user
	 * @param address the address
	 */
	void saveAddressFromUser(final Users user,
			Addresses address);

	/**
	 * Saves a new Users object.
	 * 
	 * @param user
	 *            The new Users to save.
	 * @return the integer
	 * @throws UserAlreadyExistsException
	 *             Thrown when user allready exists.
	 */
	Serializable saveNewUser(Users user) throws UserAlreadyExistsException;
	

	/**
	 * Saves a new Users object without checking the username.
	 * 
	 * @param user
	 *            The new Users to save.
	 * @return the integer
	 * @throws UserAlreadyExistsException
	 *             Thrown when user allready exists.
	 */
	Serializable saveUserOnlyWithEmail(Users user) throws UserAlreadyExistsException;

	/**
	 * Save user with contact.
	 *
	 * @param user            the user
	 * @param contact            the contact
	 * @return the contactmethods
	 * @throws BatchUpdateException             the batch update exception
	 */
	Contactmethods saveUserWithContactmethod(Users user, Contactmethods contact)
			throws BatchUpdateException;

	/**
	 * Save user with contacts.
	 *
	 * @param user            the user
	 * @param contacts            the contacts
	 * @return the list
	 * @throws BatchUpdateException the batch update exception
	 */
	List<Contactmethods> saveUserWithContactmethods(final Users user,
			final List<Contactmethods> contacts) throws BatchUpdateException;

	/**
	 * Save user with roles.
	 * 
	 * @param user
	 *            the user
	 * @param roles
	 *            the roles
	 */
	void saveUserWithRoles(Users user, Collection<Roles> roles);

	/**
	 * Update email from the given user if the email has changed and return the
	 * new contactMethod object or the contactMethod that is persist in database. Consider to check if
	 * the email already exists before you call this method otherwise an
	 * exception is thrown.
	 * 
	 * @param email
	 *            the email
	 * @param user
	 *            the user
	 * @return the contactmethods
	 * @throws EmailAlreadyExistsException
	 *             the email already exists exception
	 */
	Contactmethods setEmail(final String email, final Users user)
			throws EmailAlreadyExistsException;

	/**
	 * Sets the username.
	 * 
	 * @param username
	 *            the username
	 * @param user
	 *            the user
	 * @return true, if successful
	 * @throws UserAlreadyExistsException
	 *             the user already exists exception
	 */
	boolean setUsername(final String username, final Users user)
			throws UserAlreadyExistsException;

	/**
	 * Update an existing contactmethod. If the contactmethod has changed the
	 * new contactMethod object will be returned or null if nothing changed.
	 * 
	 * @param contactmethodValue
	 *            the contactmethod value
	 * @param contactmethodType
	 *            the contactmethod type
	 * @param contactmethod
	 *            the contactmethod
	 * @return the contactmethods
	 */
	Contactmethods updateContactmethod(final String contactmethodValue,
			final Contactmethod contactmethodType,
			final Contactmethods contactmethod);

	/**
	 * Update username from the given user if the username has changed. Returns
	 * true if the username has changed otherwise false.
	 * 
	 * @param username
	 *            the username
	 * @param user
	 *            the user
	 * @return Returns true if the username has changed otherwise false.
	 * @throws UserAlreadyExistsException
	 *             occurs if the user already exists.
	 */
	boolean updateUsername(final String username, final Users user)
			throws UserAlreadyExistsException;

	/**
	 * User is in role.
	 * 
	 * @param user
	 *            the user
	 * @param role
	 *            the role
	 * @return true, if successful
	 */
	boolean userIsInRole(final Users user, final Roles role);
	

	/**
	 * Validate the given UsernameSignUpModel object.
	 *
	 * @param model the model
	 * @return A SignUpValidationErrors object if validation fail otherwise
	 * null if the validation is successful.
	 */
	ValidationErrors validate(UsernameSignUpModel model);
	
	/**
	 * Sign up process for insert a new user in the database.
	 *
	 * @param model the model
	 * @param roles the roles
	 * @param userModel the user model
	 * @return the sign up user result
	 */
	SignUpUserResult signUpUser(UsernameSignUpModel model, Set<Roles> roles, UserModel userModel);
	
	/**
	 * Persist the given ResourceModel with the given user id.
	 *
	 * @param resourceModel the resource model
	 * @param userId the user id
	 * @return the persisted resource
	 */
	Resources persistResource(ResourcesModel resourceModel, final Integer userId);
	
	/**
	 * Deletes the given Resources with the given user data id.
	 *
	 * @param resource the resource
	 * @param userDataId the user data id
	 */
	void deleteResource(final ResourcesModel resource, final Integer userDataId);

	/**
	 * Deletes the given black listed user from the given user data id.
	 *
	 * @param blacklisted the black listed user
	 * @param userDataId the user data id
	 * @return the UserData object.
	 */
	UserData deleteBlacklisted(Users blacklisted, final Integer userDataId);

	/**
	 * Deletes the given Addresses object from the given UserData object.
	 *
	 * @param address the Addresses object
	 * @param ud the user data id
	 * @return the UserData object.
	 */
	UserData deleteAddress(Addresses address, final UserData ud );
	
	Users addUserContact(Users user, Users contact);

}
