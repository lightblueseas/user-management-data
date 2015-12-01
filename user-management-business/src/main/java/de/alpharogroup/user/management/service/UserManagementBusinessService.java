package de.alpharogroup.user.management.service;

import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import de.alpharogroup.crypto.PasswordEncryptor;
import de.alpharogroup.resource.system.application.model.ResourcesModel;
import de.alpharogroup.resource.system.entities.Resources;
import de.alpharogroup.resource.system.service.api.ResourcesService;
import de.alpharogroup.user.management.application.models.UserModelConverter;
import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.management.entities.Roles;
import de.alpharogroup.user.management.entities.UserData;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.enums.Contactmethod;
import de.alpharogroup.user.management.factories.UserManagementFactory;
import de.alpharogroup.user.management.service.api.ContactmethodsService;
import de.alpharogroup.user.management.service.api.RolesService;
import de.alpharogroup.user.management.service.api.UserDataService;
import de.alpharogroup.user.management.service.api.UserManagementService;
import de.alpharogroup.user.management.service.api.UsersService;
import de.alpharogroup.user.management.sign.up.SignUpUserResult;
import de.alpharogroup.user.management.sign.up.UserModel;

/**
 * The Class UserManagementBusinessService.
 * 
 * @author Asterios Raptis
 */
@Transactional
@Service("userManagementService")
public class UserManagementBusinessService implements UserManagementService {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	/** The Constant logger. */
	private static final Logger LOGGER = Logger
			.getLogger(UserManagementBusinessService.class.getName());

	/** The Addresses business service. */
	@Autowired
	private AddressesService addressesService;

	/** The contactmethods business service. */
	@Autowired
	private ContactmethodsService contactmethodsService;

	/** The roles business service. */
	@Autowired
	private RolesService rolesService;

	/** The users business service. */
	@Autowired
	private UsersService usersService;

	/** The users business service. */
	@Autowired
	private UserDataService userDataService;

	/** The resources business service. */
	@Autowired
	private ResourcesService resourcesService;

	/**
	 * Gets the user data service.
	 * 
	 * @return the user data service
	 */
	public UserDataService getUserDataService() {
		return userDataService;
	}

	/**
	 * Sets the user data service.
	 * 
	 * @param userDataService
	 *            the new user data service
	 */
	public void setUserDataService(UserDataService userDataService) {
		this.userDataService = userDataService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsfindUserWithEmailOrUsername(
			final String emailOrUsername) {
		boolean emailExists = usersService.findUserWithEmail(emailOrUsername) != null;
		return emailExists || existsUserWithUsername(emailOrUsername);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsUserWithEmail(final String email) {
		final Contactmethods emailContact = UserManagementFactory.getInstance()
				.newContactmethods(Contactmethod.EMAIL, email);
		return existsUserWithEmail(emailContact);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsUserWithEmail(final Contactmethods emailContact) {
		// Check if email exists.
		final boolean emailExists = contactmethodsService
				.existsContact(emailContact);
		return emailExists;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public InsertUserState existsUserWithEmailOrUsername(final String email,
			final String username) {
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
	public List<Contactmethods> findAllEmailContactmethodsFromUser(
			final Users user) {
		List<Contactmethods> cms = new ArrayList<Contactmethods>();
		Set<Contactmethods> userContactMethods = user.getUserData().getContactmethods();
		for (Contactmethods cm : userContactMethods) {
			if (Contactmethod.EMAIL.equals(cm.getContactmethod())) {
				cms.add(cm);
			}
		}
		return cms;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethods> findAllFaxContactmethodsFromUser(
			final Users user) {
		List<Contactmethods> cms = new ArrayList<Contactmethods>();
		Set<Contactmethods> userContactMethods = user.getUserData().getContactmethods();
		for (Contactmethods cm : userContactMethods) {
			if (Contactmethod.FAX.equals(cm.getContactmethod())) {
				cms.add(cm);
			}
		}
		return cms;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethods> findAllInternetContactmethodsFromUser(
			final Users user) {		
		List<Contactmethods> cms = new ArrayList<Contactmethods>();
		Set<Contactmethods> userContactMethods = user.getUserData().getContactmethods();
		for (Contactmethods cm : userContactMethods) {
			if (Contactmethod.INTERNET.equals(cm.getContactmethod())) {
				cms.add(cm);
			}
		}
		return cms;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethods> findAllMobileContactmethodsFromUser(
			final Users user) {
		List<Contactmethods> cms = new ArrayList<Contactmethods>();
		Set<Contactmethods> userContactMethods = user.getUserData().getContactmethods();
		for (Contactmethods cm : userContactMethods) {
			if (Contactmethod.MOBILE.equals(cm.getContactmethod())) {
				cms.add(cm);
			}
		}
		return cms;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethods> findAllTelefonContactmethodsFromUser(
			final Users user) {
		List<Contactmethods> cms = new ArrayList<Contactmethods>();
		Set<Contactmethods> userContactMethods = user.getUserData().getContactmethods();
		for (Contactmethods cm : userContactMethods) {
			if (Contactmethod.TELEFON.equals(cm.getContactmethod())) {
				cms.add(cm);
			}
		}return cms;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethods findEmailContactFromUser(final Users user) {
		Set<Contactmethods> userContactMethods = user.getUserData().getContactmethods();
		for (Contactmethods cm : userContactMethods) {
			if (Contactmethod.EMAIL.equals(cm.getContactmethod())) {
				return cm;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethods findFaxContactFromUser(final Users user) {
		Set<Contactmethods> userContactMethods = user.getUserData().getContactmethods();
		for (Contactmethods cm : userContactMethods) {
			if (Contactmethod.FAX.equals(cm.getContactmethod())) {
				return cm;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethods findInternetContactFromUser(final Users user) {
		Set<Contactmethods> userContactMethods = user.getUserData().getContactmethods();
		for (Contactmethods cm : userContactMethods) {
			if (Contactmethod.INTERNET.equals(cm.getContactmethod())) {
				return cm;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethods findMobileContactFromUser(final Users user) {
		Set<Contactmethods> userContactMethods = user.getUserData().getContactmethods();
		for (Contactmethods cm : userContactMethods) {
			if (Contactmethod.MOBILE.equals(cm.getContactmethod())) {
				return cm;
			}
		}
		return null;
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
		for (Contactmethods cm : user.getUserData().getContactmethods()) {
			if (Contactmethod.TELEFON.equals(cm.getContactmethod())) {
				return cm;
			}
		}
		return null;
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
		Users user = findUserWithEmail(emailOrUsername);
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
	public void saveAddressesFromUser(final Users user,
			final Collection<Addresses> addresses) {
		List<Addresses> mergedAddresses = new ArrayList<Addresses>();
		for (Addresses address : addresses) {
			if (!addressesService.exists(address.getId())) {
				address = addressesService.merge(address);
			}
			mergedAddresses.add(address);
		}
		UserData userData = user.getUserData();
		userData.getAddresses().addAll(mergedAddresses);
		userData = userDataService.merge(userData);
	}

	/**
	 * {@inheritDoc}
	 */
	public void saveAddressFromUser(final Users user, Addresses address) {
		if (!addressesService.exists(address.getId())) {
			address = addressesService.merge(address);
		}
		UserData userData = user.getUserData();
		userData.getAddresses().add(address);
		userData = userDataService.merge(userData);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer saveNewUser(final Users user)
			throws UserAlreadyExistsException {
		final String username = user.getUsername();
		if (username == null || username.isEmpty()) {
			throw new IllegalArgumentException(
					"Username cannot be null or empty");
		}
		final boolean exists = existsUserWithUsername(username);
		if (!exists) {
			user.setUserData(userDataService.merge(user.getUserData()));
			final Users mergedUser = usersService.merge(user);
			return mergedUser.getId();
		} else {
			throw new UserAlreadyExistsException("User with username "
					+ username + " allready exists.");
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
	public Contactmethods saveUserWithContactmethod(final Users user,
			final Contactmethods contact) throws BatchUpdateException {
		final Contactmethods saved = contactmethodsService.merge(contact);
		UserData ud = userDataService.get(user.getUserData().getId());
		ud.getContactmethods().add(saved);
		ud = userDataService.merge(ud);
		return saved;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Contactmethods> saveUserWithContactmethods(final Users user,
			final List<Contactmethods> contacts) throws BatchUpdateException {
		List<Contactmethods> saved = contactmethodsService.merge(contacts);
		UserData ud = userDataService.get(user.getUserData().getId());
		ud.getContactmethods().addAll(saved);
		ud = userDataService.merge(ud);
		return saved;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveUserWithRoles(Users user,
			final Collection<Roles> roles) {
		List<Roles> mergedRoles = new ArrayList<Roles>();
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
	 * Sets the contactmethods business service.
	 * 
	 * @param contactmethodsService
	 *            the new contactmethods business service
	 */
	public void setContactmethodsService(
			final ContactmethodsService contactmethodsService) {
		this.contactmethodsService = contactmethodsService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethods setEmail(final String email, final Users user)
			throws EmailAlreadyExistsException {

		final Contactmethods emailContact = UserManagementFactory.getInstance()
				.newContactmethods(Contactmethod.EMAIL, email);
		final Contactmethods emailContactInDB = findEmailContactFromUser(user);
		if(emailContactInDB == null) {
			return emailContact;
		}
		if (!contactmethodsService.compare(emailContact, emailContactInDB)) {
			if (existsUserWithEmail(email)) {
				throw new EmailAlreadyExistsException("User with email "
						+ email + " already exists");
			}
			emailContactInDB.setContactvalue(emailContact.getContactvalue());
			return emailContactInDB;
		}
		return emailContactInDB;
	}

	/**
	 * Sets the roles business service.
	 * 
	 * @param rolesService
	 *            the new roles business service
	 */
	public void setRolesService(final RolesService rolesService) {
		this.rolesService = rolesService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setUsername(final String username, final Users user)
			throws UserAlreadyExistsException {
		if (existsUserWithUsername(username)) {
			throw new UserAlreadyExistsException("User with username "
					+ username + " already exists");
		}
		user.setUsername(username);
		return true;
	}

	/**
	 * Sets the users business service.
	 * 
	 * @param usersService
	 *            the new users business service
	 */
	public void setUsersService(final UsersService usersService) {
		this.usersService = usersService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethods updateContactmethod(final String contactmethodValue,
			final Contactmethod contactmethodType,
			final Contactmethods contactmethod) {
		final Contactmethods newContactMethod = UserManagementFactory
				.getInstance().newContactmethods(contactmethodType,
						contactmethodValue);
		if(contactmethod != null) {
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
	public boolean updateUsername(final String username, final Users user)
			throws UserAlreadyExistsException {
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
	public ValidationErrors validate(UsernameSignUpModel model) {

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
	public SignUpUserResult signUpUser(UsernameSignUpModel model,
			Set<Roles> roles, UserModel userModel) {

		SignUpUserResult result = new SignUpUserResult();

		final String username = model.getUsername();
		final String email = model.getEmail();
		final String password = model.getPassword();

		ValidationErrors validationErrors = validate(model);
		if (validationErrors != null) {
			result.setValidationErrors(validationErrors);
			return result;
		}
		final Set<Contactmethods> contacts = new HashSet<Contactmethods>();
		final Contactmethods emailContact = UserManagementFactory.getInstance()
				.newContactmethods(Contactmethod.EMAIL, email);
		contacts.add(emailContact);
		if(userModel.getFax()!=null && !userModel.getFax().isEmpty()) {
			final Contactmethods faxContact = UserManagementFactory.getInstance()
					.newContactmethods(
					Contactmethod.FAX, userModel.getFax());
			contacts.add(faxContact);
		}
		if(userModel.getTelefon()!=null && !userModel.getTelefon().isEmpty()) {
			final Contactmethods telefonContact = UserManagementFactory.getInstance()
					.newContactmethods(Contactmethod.TELEFON,
							userModel.getTelefon());
			contacts.add(telefonContact);
		}
		if(userModel.getMobile()!=null && !userModel.getMobile().isEmpty()) {
			final Contactmethods mobileContact = UserManagementFactory.getInstance()
					.newContactmethods(Contactmethod.MOBILE,
							userModel.getMobile());
			contacts.add(mobileContact);
		}

		Users newUser = null;

		PasswordEncryptor passwordService = PasswordEncryptor.getInstance();

		String salt = passwordService.getRandomSalt(8);
		String hashedPassword;
		try {
			hashedPassword = passwordService.hashAndHexPassword(password, salt);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		} 
		String locale = null;
		if (userModel.getLocale() != null) {
			locale = userModel.getLocale().toString();
			if (5 < locale.length()) {
				locale = locale.substring(0, 5);
			}
		}
		UserData userData = UserManagementFactory.getInstance().newUserData(
				userModel.getBirthname(), userModel.getDateofbirth(),
				userModel.getFirstname(), userModel.getGender(),
				userModel.getIpAddress(), userModel.getLastname(), locale);

		final Set<Contactmethods> mergedContacts = new HashSet<Contactmethods>();
		for (Contactmethods contactmethod : contacts) {
			contactmethod = contactmethodsService.merge(contactmethod);
			mergedContacts.add(contactmethod);
		}
		userData.setContactmethods(mergedContacts);
		userData = userDataService.merge(userData);

		if(userModel.getAddress() != null) {
			Addresses address = addressesService.merge(userModel.getAddress());
			if (address != null) {
				userData.setPrimaryAddress(address);
			}
		}

		userData = userDataService.merge(userData);
		newUser = UserManagementFactory.getInstance().newUsers(Boolean.TRUE,
				hashedPassword, salt, username, Boolean.FALSE, userData, roles);

		// save user
		newUser = usersService.merge(newUser);
		result.setUser(newUser);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public Resources persistResource(final ResourcesModel resourceModel,
			final Integer userId) {
		Users user = usersService.get(userId);
		Resources resource = UserModelConverter.convert(resourceModel);
		resource = resourcesService.merge(resource);
		resourceModel.setId(resource.getId());
		UserData userData = userDataService.get(user.getUserData().getId());
		userData.getResources().add(resource);
		userData = userDataService.merge(userData);
		try {
			user = usersService.merge(user);
		} catch (HibernateException e) {
			LOGGER.error("Error by flushing...", e);
		}
		return resource;
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteResource(ResourcesModel resourceModel, final Integer userDataId) {		
		UserData userData = userDataService.get(userDataId);
		Resources resource = resourcesService.get(resourceModel.getId());
		if(userData.getResources().contains(resource)) {
			if(userData.getResources().remove(resource)) {
				userData = userDataService.merge(userData);
			}
			try {
				if (resourcesService.exists(resource.getId())) {
					resource.setDeletedFlag(Boolean.TRUE);
					resource = resourcesService.merge(resource);
				}
			} catch (HibernateException e) {
				LOGGER.error("Error by flushing...", e);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public UserData deleteBlacklisted(Users blacklisted, final Integer userDataId) {
		UserData userData = userDataService.get(userDataId);
		if(userData.getBlacklistedContacts().contains(blacklisted)) {			
			try {
				userData.getBlacklistedContacts().remove(blacklisted);
				userData = userDataService.merge(userData);
			} catch (HibernateException e) {
				LOGGER.error("HibernateException on flush...", e);
			}
		}
		return userData;
	}
	
	public UserData deleteAddress(Addresses address, final UserData ud ) {
		UserData userData = userDataService.get(ud.getId());
		if(userData.getAddresses().contains(address)) {
			userData.getAddresses().remove(address);
			userData = userDataService.merge(userData);
		}
		return userData;
	}
	
	public Users addUserContact(Users user, Users contact) {
		UserData userData = getUserDataService().get(user.getUserData().getId());
		userData.getUserContacts().add(contact);
		userData = getUserDataService().merge(userData);
		user.setUserData(userData);
		user = usersService.merge(user);
		return user;
	}
}
