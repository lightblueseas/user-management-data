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
package de.alpharogroup.user.management.service;

import java.sql.BatchUpdateException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.address.book.service.api.AddressesService;
import de.alpharogroup.auth.enums.InsertUserState;
import de.alpharogroup.auth.exceptions.EmailAlreadyExistsException;
import de.alpharogroup.auth.exceptions.UserAlreadyExistsException;
import de.alpharogroup.auth.models.UsernameSignUpModel;
import de.alpharogroup.auth.models.ValidationErrors;
import de.alpharogroup.crypto.pw.PasswordEncryptor;
import de.alpharogroup.random.RandomExtensions;
import de.alpharogroup.resource.system.application.model.ModelSynchronizer;
import de.alpharogroup.resource.system.application.model.ResourcesModel;
import de.alpharogroup.resource.system.entities.Resources;
import de.alpharogroup.resource.system.service.api.ResourcesService;
import de.alpharogroup.user.entities.Roles;
import de.alpharogroup.user.entities.UserTokens;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.management.entities.UserDatas;
import de.alpharogroup.user.management.enums.ContactmethodType;
import de.alpharogroup.user.management.factories.UserManagementFactory;
import de.alpharogroup.user.management.service.api.ContactmethodsService;
import de.alpharogroup.user.management.service.api.UserDatasService;
import de.alpharogroup.user.management.service.api.UsersManagementService;
import de.alpharogroup.user.management.service.api.UsersService;
import de.alpharogroup.user.management.sign.up.SignUpUserResult;
import de.alpharogroup.user.management.sign.up.UserModel;
import de.alpharogroup.user.service.api.RolesService;
import de.alpharogroup.user.service.api.UserTokensService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link UsersManagementBusinessService}.
 *
 * @author Asterios Raptis
 */
@Transactional
@Service("usersManagementService")
public class UsersManagementBusinessService implements UsersManagementService {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	/** The Constant logger. */
	private static final Logger LOGGER = Logger.getLogger(UsersManagementBusinessService.class.getName());

	/** The Addresses business service. */
	@Autowired
	private AddressesService addressesService;

	/** The contactmethods business service. */
	@Autowired
	@Getter
	@Setter
	private ContactmethodsService contactmethodsService;

	/** The roles business service. */
	@Autowired
	@Getter
	@Setter
	private RolesService rolesService;

	/** The users business service. */
	@Autowired
	@Getter
	@Setter
	private UsersService usersService;

	/** The users business service. */
	@Autowired
	@Getter
	@Setter
	private UserDatasService userDatasService;

	/** The user tokens business service. */
	@Autowired
	@Getter
	@Setter
	private UserTokensService userTokensService;

	/** The resources business service. */
	@Autowired
	private ResourcesService resourcesService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsUserWithEmailOrUsername(final String emailOrUsername) {
		final boolean emailExists = usersService.findUserWithEmail(emailOrUsername) != null;
		return emailExists || existsUserWithUsername(emailOrUsername);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsUserWithEmail(final String email) {
		final Contactmethods emailContact = UserManagementFactory.getInstance()
				.newContactmethods(ContactmethodType.EMAIL, email);
		return existsUserWithEmail(emailContact);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsUserWithEmail(final Contactmethods emailContact) {
		// Check if email exists.
		final boolean emailExists = contactmethodsService.existsContact(emailContact);
		return emailExists;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public InsertUserState existsUserWithEmailOrUsername(final String email, final String username) {
		if (existsUserWithEmail(email)) {
			return InsertUserState.EMAIL_EXISTS;
		}
		if (existsUserWithUsername(username)) {
			return InsertUserState.USERNAME_EXISTS;
		}
		return InsertUserState.INSERT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsUserWithUsername(final String username) {
		return usersService.existsUserWithUsername(username);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Addresses> findAddessesFromUser(final Users user) {
		return usersService.findAddressesFromUser(user);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Addresses findAddressFromUser(final Users user) {
		return usersService.findAddressFromUser(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethods> findAllEmailContactmethodsFromUser(final Users user) {
		return findAllContactmethodsByType(user, ContactmethodType.EMAIL);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethods> findAllFaxContactmethodsFromUser(final Users user) {
		return findAllContactmethodsByType(user, ContactmethodType.FAX);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethods> findAllInternetContactmethodsFromUser(final Users user) {
		return findAllContactmethodsByType(user, ContactmethodType.INTERNET);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethods> findAllMobileContactmethodsFromUser(final Users user) {
		return findAllContactmethodsByType(user, ContactmethodType.MOBILE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethods> findAllTelefonContactmethodsFromUser(final Users user) {
		return findAllContactmethodsByType(user, ContactmethodType.TELEFON);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethods> findAllContactmethodsByType(final @Nonnull Users user, final @Nonnull ContactmethodType contactmethodType) {
		final List<Contactmethods> cms = new ArrayList<>();
		final UserDatas userData = userDatasService.findBy(user);
		final Set<Contactmethods> userContactMethods = userData.getContactmethods();
		for (final Contactmethods cm : userContactMethods) {
			if (contactmethodType.equals(cm.getContactmethod())) {
				cms.add(cm);
			}
		}
		return cms;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethods findContactmethodByType(final @Nonnull Users user, final @Nonnull ContactmethodType contactmethodType) {
		final UserDatas userData = userDatasService.findBy(user);
		final Set<Contactmethods> userContactMethods = userData.getContactmethods();
		for (final Contactmethods cm : userContactMethods) {
			ContactmethodType currentContactmethodType = cm.getContactmethod();			
			if (contactmethodType.equals(currentContactmethodType)) {
				return cm;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethods findEmailContactFromUser(final Users user) {
		return findContactmethodByType(user, ContactmethodType.EMAIL);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethods findFaxContactFromUser(final Users user) {
		return findContactmethodByType(user, ContactmethodType.FAX);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethods findInternetContactFromUser(final Users user) {
		return findContactmethodByType(user, ContactmethodType.INTERNET);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethods findMobileContactFromUser(final Users user) {
		return findContactmethodByType(user, ContactmethodType.MOBILE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Roles> findRolesFromUser(final Users user) {
		return usersService.findRolesFromUser(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethods findTelefonContactFromUser(final Users user) {
		return findContactmethodByType(user, ContactmethodType.TELEFON);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Users findUserWithEmail(final String email) {
		return usersService.findUserWithEmail(email);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Users findUserWithEmailOrUsername(final String emailOrUsername) {
		final Users user = findUserWithEmail(emailOrUsername);
		if (user != null) {
			return user;
		}
		return findUserWithUsername(emailOrUsername);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Users findUserWithUsername(final String username) {
		return usersService.findUserWithUsername(username);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isInRole(final String rolename, final List<Roles> roles) {
		if (null != roles && (!roles.isEmpty())) {
			for (final Roles role : roles) {
				if (role.getRolename().equals(rolename)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isUserInRole(final Users user, final String rolename) {
		return isInRole(rolename, findRolesFromUser(user));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveAddressesFromUser(final Users user, final Collection<Addresses> addresses) {
		final List<Addresses> mergedAddresses = new ArrayList<>();
		for (Addresses address : addresses) {
			if (!addressesService.exists(address.getId())) {
				address = addressesService.merge(address);
			}
			mergedAddresses.add(address);
		}
		UserDatas userData = userDatasService.findBy(user);
		userData.getAddresses().addAll(mergedAddresses);
		userData = userDatasService.merge(userData);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveAddressFromUser(final Users user, Addresses address) {
		if (!addressesService.exists(address.getId())) {
			address = addressesService.merge(address);
		}
		UserDatas userData = userDatasService.findBy(user);
		userData.getAddresses().add(address);
		userData = userDatasService.merge(userData);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer saveNewUser(final Users user) throws UserAlreadyExistsException {
		final String username = user.getUsername();
		if (username == null || username.isEmpty()) {
			throw new IllegalArgumentException("Username cannot be null or empty");
		}
		final boolean exists = existsUserWithUsername(username);
		if (!exists) {
			// TODO FIXME set UserDatas object with this user object
			//user.setUserData(userDatasService.merge(user.getUserData()));
			final Users mergedUser = usersService.merge(user);

			return mergedUser.getId();
		} else {
			throw new UserAlreadyExistsException("User with username " + username + " allready exists.");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer saveUserOnlyWithEmail(final Users user) {
		final Users mergedUser = usersService.merge(user);
		return mergedUser.getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethods saveUserWithContactmethod(final Users user, final Contactmethods contact)
			throws BatchUpdateException {
		final Contactmethods saved = contactmethodsService.merge(contact);
		UserDatas ud = userDatasService.findBy(user);
		ud.getContactmethods().add(saved);
		ud = userDatasService.merge(ud);
		return saved;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethods> saveUserWithContactmethods(final Users user, final List<Contactmethods> contacts)
			throws BatchUpdateException {
		final List<Contactmethods> saved = contactmethodsService.merge(contacts);
		UserDatas ud = userDatasService.findBy(user);
		ud.getContactmethods().addAll(saved);
		ud = userDatasService.merge(ud);
		return saved;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveUserWithRoles(Users user, final Collection<Roles> roles) {
		final List<Roles> mergedRoles = new ArrayList<>();
		for (Roles role : roles) {
			if (!rolesService.exists(role.getId())) {
				role = rolesService.merge(role);
			}
			mergedRoles.add(role);
		}
		user.getRoles().addAll(roles);
		user = usersService.merge(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethods setEmail(final String email, final Users user) throws EmailAlreadyExistsException {

		final Contactmethods emailContact = UserManagementFactory.getInstance()
				.newContactmethods(ContactmethodType.EMAIL, email);
		final Contactmethods emailContactInDB = findEmailContactFromUser(user);
		if (emailContactInDB == null) {
			return emailContact;
		}
		if (!contactmethodsService.compare(emailContact, emailContactInDB)) {
			if (existsUserWithEmail(email)) {
				throw new EmailAlreadyExistsException("User with email " + email + " already exists");
			}
			emailContactInDB.setContactvalue(emailContact.getContactvalue());
			return emailContactInDB;
		}
		return emailContactInDB;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setUsername(final String username, final Users user) throws UserAlreadyExistsException {
		if (existsUserWithUsername(username)) {
			throw new UserAlreadyExistsException("User with username " + username + " already exists");
		}
		user.setUsername(username);
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethods updateContactmethod(final String contactmethodValue,
			final ContactmethodType contactmethodType, final Contactmethods contactmethod) {
		final Contactmethods newContactMethod = UserManagementFactory.getInstance().newContactmethods(contactmethodType,
				contactmethodValue);
		if (contactmethod != null) {
			if (!contactmethodsService.compare(newContactMethod, contactmethod)) {
				contactmethod.setContactvalue(contactmethodValue);
				return contactmethod;
			}
		}
		return newContactMethod;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateUsername(final String username, final Users user) throws UserAlreadyExistsException {
		// If the username has changed...
		boolean result = false;
		if (!user.getUsername().equals(username.trim())) {
			result = setUsername(username, user);
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean userIsInRole(final Users user, final Roles role) {
		return usersService.userIsInRole(user, role);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ValidationErrors validate(final UsernameSignUpModel model) {

		final String password = model.getPassword();
		final String repeatPassword = model.getRepeatPassword();

		if (!model.getTermOfUseAccepted()) {
			return ValidationErrors.TERM_OF_USE_ERROR;
		}
		if (existsUserWithEmail(model.getEmail())) {
			return ValidationErrors.EMAIL_EXISTS_ERROR;
		}
		if (existsUserWithUsername(model.getUsername())) {
			return ValidationErrors.USERNAME_EXISTS_ERROR;
		}
		if (!password.trim().equals(repeatPassword.trim())) {
			return ValidationErrors.UNEQAUL_PASSWORDS_ERROR;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public SignUpUserResult signUpUser(final UsernameSignUpModel model, final Set<Roles> roles,
			final UserModel userModel) {

		final SignUpUserResult result = new SignUpUserResult();

		final String username = model.getUsername();
		final String email = model.getEmail();
		final String password = model.getPassword();

		final ValidationErrors validationErrors = validate(model);
		if (validationErrors != null) {
			result.setValidationErrors(validationErrors);
			return result;
		}
		final Set<Contactmethods> contacts = new HashSet<>();
		final Contactmethods emailContact = UserManagementFactory.getInstance()
				.newContactmethods(ContactmethodType.EMAIL, email);
		contacts.add(emailContact);
		if (userModel.getFax() != null && !userModel.getFax().isEmpty()) {
			final Contactmethods faxContact = UserManagementFactory.getInstance()
					.newContactmethods(ContactmethodType.FAX, userModel.getFax());
			contacts.add(faxContact);
		}
		if (userModel.getTelefon() != null && !userModel.getTelefon().isEmpty()) {
			final Contactmethods telefonContact = UserManagementFactory.getInstance()
					.newContactmethods(ContactmethodType.TELEFON, userModel.getTelefon());
			contacts.add(telefonContact);
		}
		if (userModel.getMobile() != null && !userModel.getMobile().isEmpty()) {
			final Contactmethods mobileContact = UserManagementFactory.getInstance()
					.newContactmethods(ContactmethodType.MOBILE, userModel.getMobile());
			contacts.add(mobileContact);
		}

		Users newUser = null;

		final PasswordEncryptor passwordService = PasswordEncryptor.getInstance();

		final String salt = passwordService.getRandomSalt(8);
		String hashedPassword;
		try {
			hashedPassword = passwordService.hashAndHexPassword(password, salt);
		} catch (final Exception e) {
			throw new IllegalArgumentException(e);
		}
		String locale = null;
		if (userModel.getLocale() != null) {
			locale = userModel.getLocale().toString();
			if (5 < locale.length()) {
				locale = locale.substring(0, 5);
			}
		}

		newUser = UserManagementFactory.getInstance().newUsers(Boolean.TRUE, hashedPassword, salt, username,
				Boolean.FALSE, roles);

		// save user
		newUser = usersService.merge(newUser);

		UserDatas userData = UserManagementFactory.getInstance().newUserData(userModel.getBirthname(),
				userModel.getDateofbirth(), userModel.getFirstname(), userModel.getGender(), userModel.getIpAddress(),
				userModel.getLastname(), locale);

		userData.setOwner(newUser);

		final Set<Contactmethods> mergedContacts = new HashSet<>();
		for (Contactmethods contactmethod : contacts) {
			contactmethod = contactmethodsService.merge(contactmethod);
			mergedContacts.add(contactmethod);
		}
		userData.setContactmethods(mergedContacts);
		userData = userDatasService.merge(userData);

		if (userModel.getAddress() != null) {
			final Addresses address = addressesService.merge(userModel.getAddress());
			if (address != null) {
				userData.setPrimaryAddress(address);
			}
		}
		userData = userDatasService.merge(userData);

		result.setUser(newUser);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Resources persistResource(final ResourcesModel resourceModel, final Integer userId) {
		Users user = usersService.get(userId);
		Resources resource = ModelSynchronizer.convert(resourceModel);
		resource = resourcesService.merge(resource);
		resourceModel.setId(resource.getId());
		UserDatas userData = userDatasService.findBy(user);
		userData.getResources().add(resource);
		userData = userDatasService.merge(userData);
		try {
			user = usersService.merge(user);
		} catch (final HibernateException e) {
			LOGGER.error("Error by flushing...", e);
		}
		return resource;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteResource(final ResourcesModel resourceModel, final Integer userDataId) {
		UserDatas userData = userDatasService.get(userDataId);
		Resources resource = resourcesService.get(resourceModel.getId());
		if (userData.getResources().contains(resource)) {
			if (userData.getResources().remove(resource)) {
				userData = userDatasService.merge(userData);
			}
			try {
				if (resourcesService.exists(resource.getId())) {
					resource.setDeletedFlag(Boolean.TRUE);
					resource = resourcesService.merge(resource);
				}
			} catch (final HibernateException e) {
				LOGGER.error("Error by flushing...", e);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDatas deleteBlacklisted(final Users blacklisted, final Integer userDataId) {
		UserDatas userData = userDatasService.get(userDataId);
		if (userData.getBlacklistedContacts().contains(blacklisted)) {
			try {
				userData.getBlacklistedContacts().remove(blacklisted);
				userData = userDatasService.merge(userData);
			} catch (final HibernateException e) {
				LOGGER.error("HibernateException on flush...", e);
			}
		}
		return userData;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDatas deleteAddress(final Addresses address, final UserDatas ud) {
		UserDatas userData = userDatasService.get(ud.getId());
		if (userData.getAddresses().contains(address)) {
			userData.getAddresses().remove(address);
			userData = userDatasService.merge(userData);
		}
		return userData;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Users addUserContact(final Users user, final Users contact) {
		UserDatas userData = userDatasService.findBy(user);
		userData.getUserContacts().add(contact);
		userData = getUserDatasService().merge(userData);
		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String newAuthenticationToken(final String username) {
		UserTokens userTokens = userTokensService.find(username);
		if (userTokens == null) {
			userTokens = userTokensService.merge(newUserTokens(username));
		}
		// check if expired
		final Date now = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
		if (userTokens.getExpiry().before(now)) {
			// expires in one year
			final Date expiry = Date.from(LocalDateTime.now().plusMonths(12).atZone(ZoneId.systemDefault()).toInstant());
			// create a token
			final String token = RandomExtensions.randomToken();
			userTokens.setExpiry(expiry);
			userTokens.setToken(token);
			userTokens = userTokensService.merge(userTokens);
		}
		return userTokens.getToken();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isValid(final String token) {
		return userTokensService.isValid(token);
	}

	/**
	 * New user tokens.
	 *
	 * @param username the username
	 * @return the user tokens
	 */
	private UserTokens newUserTokens(final String username) {
		UserTokens userTokens;
		// expires in one year
		final Date expiry = Date.from(LocalDateTime.now().plusMonths(12).atZone(ZoneId.systemDefault()).toInstant());
		// create a token
		final String token = RandomExtensions.randomToken();
		userTokens = UserTokens.builder().expiry(expiry).username(username).token(token).build();
		return userTokens;
	}
}
