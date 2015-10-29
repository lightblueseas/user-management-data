package de.alpharogroup.user.management.factories;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.resource.system.entities.Resources;
import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.management.entities.Permissions;
import de.alpharogroup.user.management.entities.Recommendations;
import de.alpharogroup.user.management.entities.RelationPermissions;
import de.alpharogroup.user.management.entities.ResetPasswords;
import de.alpharogroup.user.management.entities.Robinsons;
import de.alpharogroup.user.management.entities.Roles;
import de.alpharogroup.user.management.entities.RuleViolations;
import de.alpharogroup.user.management.entities.UserData;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.enums.Contactmethod;
import de.alpharogroup.user.management.enums.Gender;
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
	 * @param id the id
	 * @param user the user
	 * @param recommended the recommended
	 * @param email the email
	 * @param invitationText the invitationText
	 * @param sent the sent
	 * @return the recommendation
	 */
	public Recommendations newRecommendations(Integer id, Users user, Users recommended, String email, String invitationText, Boolean sent) {
		Recommendations recommendation = new Recommendations();
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
	 * @param user the user
	 * @param recommended the recommended
	 * @param email the email
	 * @param invitationText the invitationText
	 * @param sent the sent
	 * @return the recommendation
	 */
	public Recommendations newRecommendations(Users user, Users recommended, String email, String invitationText, Boolean sent) {
		return newRecommendations(null, user, recommended, email, invitationText, sent);
	}	
	
	/**
	 * Gets the recommendation.
	 *
	 * @param user the user
	 * @param recommended the recommended
	 * @param email the email
	 * @param invitationText the invitationText
	 * @return the recommendation
	 */
	public Recommendations newRecommendations(Users user, Users recommended, String email, String invitationText) {
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
	public ResetPasswords newResetPasswords(Integer id, Date expiryDate,
			String generatedPassword, Date starttime, Users user) {
		ResetPasswords resetPasswords = new ResetPasswords();
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
	 * @param id the id
	 * @param robinson the robinson
	 * @return the robinsons
	 */
	public Robinsons newRobinsons(Integer id, Users robinson) {
		Robinsons robinsons = new Robinsons();
		robinsons.setId(id);
		robinsons.setRobinson(robinson);
		return robinsons;
	}
	
	/**
	 * New robinsons.
	 *
	 * @param robinson the robinson
	 * @return the robinsons
	 */
	public Robinsons newRobinsons(Users robinson) {
		return newRobinsons(null, robinson);
	}
	
	/**
	 * Gets the relation permissions.
	 *
	 * @param provider the provider
	 * @param subscriber the subscriber
	 * @return the relation permissions
	 */
	public RelationPermissions newRelationPermissions(Users provider, Users subscriber) {
		return newRelationPermissions(provider, subscriber, new HashSet<Permissions>());
	}
	
	/**
	 * Gets the relation permissions.
	 *
	 * @param provider the provider
	 * @param subscriber the subscriber
	 * @param permissions the permissions
	 * @return the relation permissions
	 */
	public RelationPermissions newRelationPermissions(Users provider, Users subscriber, Set<Permissions> permissions) {
		return newRelationPermissions(null, provider, subscriber, permissions);
	}
	
	/**
	 * Gets the relation permissions.
	 *
	 * @param id the id
	 * @param provider the provider
	 * @param subscriber the subscriber
	 * @param permissions the permissions
	 * @return the relation permissions
	 */
	public RelationPermissions newRelationPermissions(Integer id, Users provider, Users subscriber, Set<Permissions> permissions) {
		RelationPermissions relationPermissions = new RelationPermissions();
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
	public ResetPasswords newResetPasswords(Date expiryDate,
			String generatedPassword, Date starttime, Users user) {
		return newResetPasswords(null, expiryDate, generatedPassword,
				starttime, user);
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
	public Contactmethods newContactmethods(Contactmethod contactmethod,
			String contactvalue, Integer id) {
		Contactmethods contactmethods = new Contactmethods();

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
	public Contactmethods newContactmethods(Contactmethod contactmethod,
			String contactvalue) {
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
	public Permissions newPermissions(Integer id, String permission,
			String description, String shortcut) {
		Permissions permissions = new Permissions();

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
	public Permissions newPermissions(String permission, String description,
			String shortcut) {
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
	public Permissions newPermissions(String permission, String description) {
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
	public Roles newRoles(Integer id, String rolename, String description,
			Set<Permissions> permissions) {
		Roles roles = new Roles();

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
	public Roles newRoles(String rolename, String description,
			Set<Permissions> permissions) {
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
	public Roles newRoles(String rolename, String description) {
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
	public UserData newUserData(String birthname, Date dateofbirth,
			String firstname, Gender gender, String ipAddress, String lastname,
			String locale) {
		return newUserData(null, birthname, dateofbirth, firstname, gender,
				ipAddress, lastname, locale);
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
	public UserData newUserData(Integer id, String birthname, Date dateofbirth,
			String firstname, Gender gender, String ipAddress, String lastname,
			String locale) {
		return newUserData(id, birthname, dateofbirth, firstname, gender,
				ipAddress, lastname, locale, null, null, null, null);
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
	public UserData newUserData(Integer id, String birthname, Date dateofbirth,
			String firstname, Gender gender, String ipAddress, String lastname,
			String locale, Set<Addresses> addresses,
			Set<Contactmethods> contactmethods, Set<Resources> resources,
			Set<Users> userContacts) {
		UserData userData = new UserData();
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
	 * @param userData
	 *            the user data
	 * @param roles
	 *            the roles
	 * @return the users
	 */
	public Users newUsers(Boolean active, String pw, String salt,
			String username, Boolean locked, UserData userData, Set<Roles> roles) {
		return newUsers(null, active, pw, salt, username, locked, userData,
				roles);
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
	 * @param userData
	 *            the user data
	 * @param roles
	 *            the roles
	 * @return Users A Users object
	 */
	public Users newUsers(Integer id, Boolean active, String pw, String salt,
			String username, Boolean locked, UserData userData, Set<Roles> roles) {
		Users users = new Users();
		users.setActive(active);
		users.setLocked(locked);
		users.setId(id);
		users.setPw(pw);
		users.setSalt(salt);
		users.setUsername(username);
		users.setUserData(userData);
		if (roles != null) {
			users.setRoles(roles);
		}
		return users;
	}

	/**
	 * Gets the rule violations.
	 *
	 * @param id the id
	 * @param detector the detector
	 * @param violator the violator
	 * @param description the description
	 * @param reason the reason
	 * @return the rule violations
	 */
	public RuleViolations newRuleViolations(Integer id, Users detector,
			Users violator, String description, RuleViolationReason reason) {
		RuleViolations ruleViolations = new RuleViolations();
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
	 * @param detector the detector
	 * @param violator the violator
	 * @param description the description
	 * @param reason the reason
	 * @return the rule violations
	 */
	public RuleViolations newRuleViolations(Users detector, Users violator,
			String description, RuleViolationReason reason) {
		return newRuleViolations(null, detector, violator, description, reason);
	}
}
