package de.alpharogroup.user.management.factories;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.resource.system.entities.Resources;
import de.alpharogroup.user.entities.Permissions;
import de.alpharogroup.user.entities.RelationPermissions;
import de.alpharogroup.user.entities.ResetPasswords;
import de.alpharogroup.user.entities.Roles;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.management.entities.Recommendations;
import de.alpharogroup.user.management.entities.Robinsons;
import de.alpharogroup.user.management.entities.RuleViolations;
import de.alpharogroup.user.management.entities.UserDatas;
import de.alpharogroup.user.management.enums.ContactmethodType;
import de.alpharogroup.user.management.enums.GenderType;
import de.alpharogroup.user.management.enums.RuleViolationReason;

/**
 * A factory for creating Domain objects for the user management.
 */
public class UserManagementFactory implements Serializable {

	/** The Constant instance. */
	private static final UserManagementFactory instance = new UserManagementFactory();

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Gets the single instance of UserManagementFactory.
	 *
	 * @return single instance of UserManagementFactory
	 */
	public static UserManagementFactory getInstance() {
		return instance;
	}

	/**
	 * Instantiates a new UserManagementFactory object.
	 */
	private UserManagementFactory() {
		super();
	}

	/**
	 * Gets the recommendation.
	 *
	 * @param id
	 *            the id
	 * @param user
	 *            the user
	 * @param recommended
	 *            the recommended
	 * @param email
	 *            the email
	 * @param invitationText
	 *            the invitationText
	 * @param sent
	 *            the sent
	 * @return the recommendation
	 */
	public Recommendations newRecommendations(final Integer id, final Users user, final Users recommended, final String email,
			final String invitationText, final Boolean sent) {
		final Recommendations recommendation = new Recommendations();
		recommendation.setId(id);
		recommendation.setUser(user);
		recommendation.setRecommended(recommended);
		recommendation.setEmail(email);
		recommendation.setInvitationText(invitationText);
		recommendation.setSent(sent);
		return recommendation;
	}

	/**
	 * Gets the recommendation.
	 *
	 * @param user
	 *            the user
	 * @param recommended
	 *            the recommended
	 * @param email
	 *            the email
	 * @param invitationText
	 *            the invitationText
	 * @param sent
	 *            the sent
	 * @return the recommendation
	 */
	public Recommendations newRecommendations(final Users user, final Users recommended, final String email, final String invitationText,
			final Boolean sent) {
		return newRecommendations(null, user, recommended, email, invitationText, sent);
	}

	/**
	 * Gets the recommendation.
	 *
	 * @param user
	 *            the user
	 * @param recommended
	 *            the recommended
	 * @param email
	 *            the email
	 * @param invitationText
	 *            the invitationText
	 * @return the recommendation
	 */
	public Recommendations newRecommendations(final Users user, final Users recommended, final String email, final String invitationText) {
		return newRecommendations(user, recommended, email, invitationText, Boolean.FALSE);
	}

	/**
	 * Data pool factory for ResetPasswords.
	 *
	 * @param id
	 *            the id
	 * @param expiryDate
	 *            the expiry date
	 * @param generatedPassword
	 *            the generated password
	 * @param starttime
	 *            the starttime
	 * @param user
	 *            the user
	 * @return the reset passwords
	 */
	public ResetPasswords newResetPasswords(final Integer id, final Date expiryDate, final String generatedPassword, final Date starttime,
			final Users user) {
		final ResetPasswords resetPasswords = new ResetPasswords();
		resetPasswords.setExpiryDate(expiryDate);
		resetPasswords.setGeneratedPassword(generatedPassword);
		resetPasswords.setId(id);
		resetPasswords.setStarttime(starttime);
		resetPasswords.setUser(user);

		return resetPasswords;
	}

	/**
	 * New robinsons.
	 *
	 * @param id
	 *            the id
	 * @param robinson
	 *            the robinson
	 * @return the robinsons
	 */
	public Robinsons newRobinsons(final Integer id, final Users robinson) {
		final Robinsons robinsons = new Robinsons();
		robinsons.setId(id);
		robinsons.setRobinson(robinson);
		return robinsons;
	}

	/**
	 * New robinsons.
	 *
	 * @param robinson
	 *            the robinson
	 * @return the robinsons
	 */
	public Robinsons newRobinsons(final Users robinson) {
		return newRobinsons(null, robinson);
	}

	/**
	 * Gets the relation permissions.
	 *
	 * @param provider
	 *            the provider
	 * @param subscriber
	 *            the subscriber
	 * @return the relation permissions
	 */
	public RelationPermissions newRelationPermissions(final Users provider, final Users subscriber) {
		return newRelationPermissions(provider, subscriber, new HashSet<Permissions>());
	}

	/**
	 * Gets the relation permissions.
	 *
	 * @param provider
	 *            the provider
	 * @param subscriber
	 *            the subscriber
	 * @param permissions
	 *            the permissions
	 * @return the relation permissions
	 */
	public RelationPermissions newRelationPermissions(final Users provider, final Users subscriber, final Set<Permissions> permissions) {
		return newRelationPermissions(null, provider, subscriber, permissions);
	}

	/**
	 * Gets the relation permissions.
	 *
	 * @param id
	 *            the id
	 * @param provider
	 *            the provider
	 * @param subscriber
	 *            the subscriber
	 * @param permissions
	 *            the permissions
	 * @return the relation permissions
	 */
	public RelationPermissions newRelationPermissions(final Integer id, final Users provider, final Users subscriber,
			final Set<Permissions> permissions) {
		final RelationPermissions relationPermissions = new RelationPermissions();
		relationPermissions.setId(id);
		relationPermissions.setProvider(provider);
		relationPermissions.setSubscriber(subscriber);
		relationPermissions.setPermissions(permissions);
		return relationPermissions;
	}

	/**
	 * Data pool factory for ResetPasswords.
	 *
	 * @param expiryDate
	 *            the expiry date
	 * @param generatedPassword
	 *            the generated password
	 * @param starttime
	 *            the starttime
	 * @param user
	 *            the user
	 * @return the reset passwords
	 */
	public ResetPasswords newResetPasswords(final Date expiryDate, final String generatedPassword, final Date starttime, final Users user) {
		return newResetPasswords(null, expiryDate, generatedPassword, starttime, user);
	}

	/**
	 * Factory method for create an Contactmethods object.
	 *
	 * @param contactmethod
	 *            the contactmethod
	 * @param contactvalue
	 *            the contactvalue
	 * @param id
	 *            the id
	 * @return Contactmethods A Contactmethods object
	 */
	public Contactmethods newContactmethods(final ContactmethodType contactmethod, final String contactvalue, final Integer id) {
		final Contactmethods contactmethods = new Contactmethods();

		contactmethods.setContactmethod(contactmethod);
		contactmethods.setContactvalue(contactvalue);
		contactmethods.setId(id);

		return contactmethods;
	}

	/**
	 * Factory method for create an Contactmethods object.
	 *
	 * @param contactmethod
	 *            the contactmethod
	 * @param contactvalue
	 *            the contactvalue
	 * @return Contactmethods A Contactmethods object
	 */
	public Contactmethods newContactmethods(final ContactmethodType contactmethod, final String contactvalue) {
		return newContactmethods(contactmethod, contactvalue, null);
	}

	/**
	 * Factory method for create an Permissions object.
	 *
	 * @param id
	 *            the id
	 * @param permission
	 *            the permission
	 * @param description
	 *            the description
	 * @param shortcut
	 *            the shortcut
	 * @return Permissions A Permissions object
	 */
	public Permissions newPermissions(final Integer id, final String permission, final String description, final String shortcut) {
		final Permissions permissions = new Permissions();

		permissions.setDescription(description);
		permissions.setId(id);
		permissions.setPermissionName(permission);
		permissions.setShortcut(shortcut);

		return permissions;
	}

	/**
	 * Gets the permissions.
	 *
	 * @param permission
	 *            the permission
	 * @param description
	 *            the description
	 * @param shortcut
	 *            the shortcut
	 * @return the permissions
	 */
	public Permissions newPermissions(final String permission, final String description, final String shortcut) {
		return newPermissions(null, permission, description, shortcut);
	}

	/**
	 * Gets the permissions.
	 *
	 * @param permission
	 *            the permission
	 * @param description
	 *            the description
	 * @return the permissions
	 */
	public Permissions newPermissions(final String permission, final String description) {
		return newPermissions(null, permission, description, null);
	}

	/**
	 * Factory method for create an Roles object.
	 *
	 * @param id
	 *            the id
	 * @param rolename
	 *            the rolename
	 * @param description
	 *            the description
	 * @param permissions
	 *            the permissions
	 * @return Roles A Roles object
	 */
	public Roles newRoles(final Integer id, final String rolename, final String description, final Set<Permissions> permissions) {
		final Roles roles = new Roles();

		roles.setDescription(description);
		roles.setId(id);
		roles.setRolename(rolename);
		if (permissions != null) {
			roles.setPermissions(permissions);
		}
		return roles;
	}

	/**
	 * Gets the roles.
	 *
	 * @param rolename
	 *            the rolename
	 * @param description
	 *            the description
	 * @param permissions
	 *            the permissions
	 * @return the roles
	 */
	public Roles newRoles(final String rolename, final String description, final Set<Permissions> permissions) {
		return newRoles(null, rolename, description, permissions);
	}

	/**
	 * Gets the roles.
	 *
	 * @param rolename
	 *            the rolename
	 * @param description
	 *            the description
	 * @return the roles
	 */
	public Roles newRoles(final String rolename, final String description) {
		return newRoles(rolename, description, null);
	}

	/**
	 * Gets the user data.
	 *
	 * @param birthname
	 *            the birthname
	 * @param dateofbirth
	 *            the dateofbirth
	 * @param firstname
	 *            the firstname
	 * @param gender
	 *            the gender
	 * @param ipAddress
	 *            the ip address
	 * @param lastname
	 *            the lastname
	 * @param locale
	 *            the locale
	 * @return the user data
	 */
	public UserDatas newUserData(final String birthname, final Date dateofbirth, final String firstname, final GenderType gender,
			final String ipAddress, final String lastname, final String locale) {
		return newUserData(null, birthname, dateofbirth, firstname, gender, ipAddress, lastname, locale);
	}

	/**
	 * Factory method for create an UserData object.
	 *
	 * @param id
	 *            the id
	 * @param birthname
	 *            the birthname
	 * @param dateofbirth
	 *            the dateofbirth
	 * @param firstname
	 *            the firstname
	 * @param gender
	 *            the gender
	 * @param ipAddress
	 *            the ip address
	 * @param lastname
	 *            the lastname
	 * @param locale
	 *            the locale
	 * @return UserData A UserData object
	 */
	public UserDatas newUserData(final Integer id, final String birthname, final Date dateofbirth, final String firstname, final GenderType gender,
			final String ipAddress, final String lastname, final String locale) {
		return newUserData(id, birthname, dateofbirth, firstname, gender, ipAddress, lastname, locale, null, null, null,
				null);
	}

	/**
	 * Factory method for create an UserData object.
	 *
	 * @param id
	 *            the id
	 * @param birthname
	 *            the birthname
	 * @param dateofbirth
	 *            the dateofbirth
	 * @param firstname
	 *            the firstname
	 * @param gender
	 *            the gender
	 * @param ipAddress
	 *            the ip address
	 * @param lastname
	 *            the lastname
	 * @param locale
	 *            the locale
	 * @param addresses
	 *            the addresses
	 * @param contactmethods
	 *            the contactmethods
	 * @param resources
	 *            the resources
	 * @param userContacts
	 *            the user contacts
	 * @return UserData A UserData object
	 */
	public UserDatas newUserData(final Integer id, final String birthname, final Date dateofbirth, final String firstname, final GenderType gender,
			final String ipAddress, final String lastname, final String locale, final Set<Addresses> addresses,
			final Set<Contactmethods> contactmethods, final Set<Resources> resources, final Set<Users> userContacts) {
		return newUserData(id, null, birthname, dateofbirth, firstname, gender, ipAddress, lastname, locale, null, null,
				null, null);
	}

	/**
	 * Factory method for create an UserData object.
	 *
	 * @param id
	 *            the id
	 * @param owner
	 *            the owner
	 * @param birthname
	 *            the birthname
	 * @param dateofbirth
	 *            the dateofbirth
	 * @param firstname
	 *            the firstname
	 * @param gender
	 *            the gender
	 * @param ipAddress
	 *            the ip address
	 * @param lastname
	 *            the lastname
	 * @param locale
	 *            the locale
	 * @param addresses
	 *            the addresses
	 * @param contactmethods
	 *            the contactmethods
	 * @param resources
	 *            the resources
	 * @param userContacts
	 *            the user contacts
	 * @return UserData A UserData object
	 */
	public UserDatas newUserData(final Integer id, final Users owner, final String birthname, final Date dateofbirth, final String firstname,
			final GenderType gender, final String ipAddress, final String lastname, final String locale, final Set<Addresses> addresses,
			final Set<Contactmethods> contactmethods, final Set<Resources> resources, final Set<Users> userContacts) {
		final UserDatas userData = new UserDatas();
		userData.setOwner(owner);
		userData.setBirthname(birthname);
		userData.setContactmethods(contactmethods);
		userData.setDateofbirth(dateofbirth);
		userData.setFirstname(firstname);
		userData.setGender(gender);
		userData.setId(id);
		userData.setIpAddress(ipAddress);
		userData.setLastname(lastname);
		userData.setLocale(locale);
		if (addresses != null) {
			userData.setAddresses(addresses);
		}
		if (contactmethods != null) {
			userData.setContactmethods(contactmethods);
		}
		if (resources != null) {
			userData.setResources(resources);
		}
		if (userContacts != null) {
			userData.setUserContacts(userContacts);
		}
		return userData;
	}

	/**
	 * Gets the users.
	 *
	 * @param active
	 *            the active
	 * @param pw
	 *            the pw
	 * @param salt
	 *            the salt
	 * @param username
	 *            the username
	 * @param locked
	 *            the locked
	 * @param roles
	 *            the roles
	 * @return the users
	 */
	public Users newUsers(final Boolean active, final String pw, final String salt, final String username, final Boolean locked, final Set<Roles> roles) {
		return newUsers(null, active, pw, salt, username, locked, roles);
	}

	/**
	 * Factory method for create an Users object.
	 *
	 * @param id
	 *            the id
	 * @param active
	 *            the active
	 * @param pw
	 *            the pw
	 * @param salt
	 *            the salt
	 * @param username
	 *            the username
	 * @param locked
	 *            the locked
	 * @param roles
	 *            the roles
	 * @return Users A Users object
	 */
	public Users newUsers(final Integer id, final Boolean active, final String pw, final String salt, final String username, final Boolean locked,
			final Set<Roles> roles) {
		final Users users = new Users();
		users.setActive(active);
		users.setLocked(locked);
		users.setId(id);
		users.setPw(pw);
		users.setSalt(salt);
		users.setUsername(username);
		if (roles != null) {
			users.setRoles(roles);
		}
		return users;
	}

	/**
	 * Gets the rule violations.
	 *
	 * @param id
	 *            the id
	 * @param detector
	 *            the detector
	 * @param violator
	 *            the violator
	 * @param description
	 *            the description
	 * @param reason
	 *            the reason
	 * @return the rule violations
	 */
	public RuleViolations newRuleViolations(final Integer id, final Users detector, final Users violator, final String description,
			final RuleViolationReason reason) {
		final RuleViolations ruleViolations = new RuleViolations();
		ruleViolations.setId(id);
		ruleViolations.setDetector(detector);
		ruleViolations.setViolator(violator);
		ruleViolations.setDescription(description);
		ruleViolations.setReason(reason);
		return ruleViolations;
	}

	/**
	 * Gets the rule violations.
	 *
	 * @param detector
	 *            the detector
	 * @param violator
	 *            the violator
	 * @param description
	 *            the description
	 * @param reason
	 *            the reason
	 * @return the rule violations
	 */
	public RuleViolations newRuleViolations(final Users detector, final Users violator, final String description,
			final RuleViolationReason reason) {
		return newRuleViolations(null, detector, violator, description, reason);
	}
}
