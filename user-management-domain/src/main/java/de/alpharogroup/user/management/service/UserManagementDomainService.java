package de.alpharogroup.user.management.service;

import java.io.Serializable;
import java.sql.BatchUpdateException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.address.book.domain.Address;
import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.auth.enums.InsertUserState;
import de.alpharogroup.auth.exceptions.EmailAlreadyExistsException;
import de.alpharogroup.auth.exceptions.UserAlreadyExistsException;
import de.alpharogroup.auth.models.UsernameSignUpModel;
import de.alpharogroup.auth.models.ValidationErrors;
import de.alpharogroup.db.entitymapper.MapperExtensions;
import de.alpharogroup.resource.system.application.model.ResourcesModel;
import de.alpharogroup.resource.system.domain.Resource;
import de.alpharogroup.resource.system.entities.Resources;
import de.alpharogroup.user.management.domain.Contactmethod;
import de.alpharogroup.user.management.domain.Role;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.domain.UserData;
import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.entities.Roles;
import de.alpharogroup.user.management.entities.UserDatas;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.enums.ContactmethodType;
import de.alpharogroup.user.management.service.api.UserManagementService;
import de.alpharogroup.user.management.service.api.UsersManagementService;
import de.alpharogroup.user.management.sign.up.SignUpUserResult;
import de.alpharogroup.user.management.sign.up.UserModel;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link UserManagementDomainService}.
 */
@Transactional
@Service("userManagementDomainService")
public class UserManagementDomainService implements UserManagementService {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The {@link UsersManagementService}. */
	@Autowired
	@Getter
	@Setter
	private UsersManagementService usersManagementService;

	private Mapper mapper;

	public Mapper getMapper() {
		if(mapper == null) {
			mapper = newMapper(Collections.<String> emptyList());
		}
		return mapper;
	}


	/**
	 * Factory method for creating the new {@link Mapper} for the mapping
	 * process with the given mapping files list. This method is invoked in the
	 * constructor and can be overridden so users can provide their own mapping
	 * process.
	 *
	 * @param mappingFiles
	 *            the mapping files
	 *
	 * @return the new {@link Mapper} for the mapping process.
	 */
	public Mapper newMapper(final List<String> mappingFiles) {
		return new DozerBeanMapper(mappingFiles);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsUserWithEmail(final String email) {
		return usersManagementService.existsUserWithEmail(email);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsUserWithUsername(final String username) {
		return usersManagementService.existsUserWithUsername(username);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public InsertUserState existsUserWithEmailOrUsername(final String email, final String username) {
		return usersManagementService.existsUserWithEmailOrUsername(email, username);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isInRole(final String rolename, final List<Role> roles) {
		return usersManagementService.isInRole(rolename, MapperExtensions.map(getMapper(), roles, Roles.class));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsUserWithEmail(final Contactmethod emailContact) {
		return usersManagementService.existsUserWithEmail(MapperExtensions.map(getMapper(), emailContact, Contactmethods.class));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsUserWithEmailOrUsername(final String emailOrUsername) {
		return usersManagementService.existsUserWithEmailOrUsername(emailOrUsername);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Address> findAddessesFromUser(final User user) {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		final List<Addresses> addresses = usersManagementService.findAddessesFromUser(users);
		final List<Address> addressDomainObjects = MapperExtensions.map(getMapper(), addresses, Address.class);
		return addressDomainObjects;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Address findAddressFromUser(final User user) {
		final Addresses addresses = usersManagementService.findAddressFromUser(MapperExtensions.map(getMapper(), user, Users.class));
		final Address address = MapperExtensions.map(getMapper(), addresses, Address.class);
		return address;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> findAllEmailContactmethodsFromUser(final User user) {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		final List<Contactmethods> contactmethods =usersManagementService.findAllEmailContactmethodsFromUser(users);
		final List<Contactmethod> contactmethodDomainObjects = MapperExtensions.map(getMapper(), contactmethods, Contactmethod.class);
		return contactmethodDomainObjects;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> findAllFaxContactmethodsFromUser(final User user) {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		final List<Contactmethods> contactmethods =usersManagementService.findAllFaxContactmethodsFromUser(users);
		final List<Contactmethod> contactmethodDomainObjects = MapperExtensions.map(getMapper(), contactmethods, Contactmethod.class);
		return contactmethodDomainObjects;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> findAllInternetContactmethodsFromUser(final User user) {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		final List<Contactmethods> contactmethods =usersManagementService.findAllInternetContactmethodsFromUser(users);
		final List<Contactmethod> contactmethodDomainObjects = MapperExtensions.map(getMapper(), contactmethods, Contactmethod.class);
		return contactmethodDomainObjects;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> findAllMobileContactmethodsFromUser(final User user) {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		final List<Contactmethods> contactmethods =usersManagementService.findAllMobileContactmethodsFromUser(users);
		final List<Contactmethod> contactmethodDomainObjects = MapperExtensions.map(getMapper(), contactmethods, Contactmethod.class);
		return contactmethodDomainObjects;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> findAllTelefonContactmethodsFromUser(final User user) {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		final List<Contactmethods> contactmethods =usersManagementService.findAllTelefonContactmethodsFromUser(users);
		final List<Contactmethod> contactmethodDomainObjects = MapperExtensions.map(getMapper(), contactmethods, Contactmethod.class);
		return contactmethodDomainObjects;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethod findEmailContactFromUser(final User user) {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		final Contactmethods contactmethods =usersManagementService.findEmailContactFromUser(users);
		final Contactmethod contactmethod = MapperExtensions.map(getMapper(), contactmethods, Contactmethod.class);
		return contactmethod;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethod findFaxContactFromUser(final User user) {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		final Contactmethods contactmethods =usersManagementService.findFaxContactFromUser(users);
		final Contactmethod contactmethod = MapperExtensions.map(getMapper(), contactmethods, Contactmethod.class);
		return contactmethod;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethod findInternetContactFromUser(final User user) {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		final Contactmethods contactmethods =usersManagementService.findInternetContactFromUser(users);
		final Contactmethod contactmethod = MapperExtensions.map(getMapper(), contactmethods, Contactmethod.class);
		return contactmethod;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethod findMobileContactFromUser(final User user) {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		final Contactmethods contactmethods =usersManagementService.findMobileContactFromUser(users);
		final Contactmethod contactmethod = MapperExtensions.map(getMapper(), contactmethods, Contactmethod.class);
		return contactmethod;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethod findTelefonContactFromUser(final User user) {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		final Contactmethods contactmethods =usersManagementService.findTelefonContactFromUser(users);
		final Contactmethod contactmethod = MapperExtensions.map(getMapper(), contactmethods, Contactmethod.class);
		return contactmethod;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Role> findRolesFromUser(final User user) {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		final List<Roles> roles = usersManagementService.findRolesFromUser(users);
		final List<Role> roleDomainObjects =  MapperExtensions.map(getMapper(), roles, Role.class);
		return roleDomainObjects;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findUserWithEmail(final String email) {
		final Users users = usersManagementService.findUserWithEmail(email);
		return MapperExtensions.map(getMapper(), users, User.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findUserWithEmailOrUsername(final String emailOrUsername) {
		final Users users = usersManagementService.findUserWithEmailOrUsername(emailOrUsername);
		return MapperExtensions.map(getMapper(), users, User.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findUserWithUsername(final String username) {
		final Users users = usersManagementService.findUserWithUsername(username);
		return MapperExtensions.map(getMapper(), users, User.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isUserInRole(final User user, final String rolename) {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		return usersManagementService.isUserInRole(users, rolename);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveAddressesFromUser(final User user, final Collection<Address> addresses) {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		final List<Addresses> addressEntities = MapperExtensions.map(getMapper(), addresses, Addresses.class);
		usersManagementService.saveAddressesFromUser(users, addressEntities);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveAddressFromUser(final User user, final Address address) {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		final Addresses addressEntity = MapperExtensions.map(getMapper(), address, Addresses.class);
		usersManagementService.saveAddressFromUser(users, addressEntity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Serializable saveNewUser(final User user) throws UserAlreadyExistsException {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		return usersManagementService.saveNewUser(users);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Serializable saveUserOnlyWithEmail(final User user) throws UserAlreadyExistsException {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		return usersManagementService.saveUserOnlyWithEmail(users);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethod saveUserWithContactmethod(final User user, final Contactmethod contact) throws BatchUpdateException {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		Contactmethods contactmethods = MapperExtensions.map(getMapper(), contact, Contactmethods.class);
		contactmethods = usersManagementService.saveUserWithContactmethod(users, contactmethods);
		final Contactmethod contactmethod = MapperExtensions.map(getMapper(), contactmethods, Contactmethod.class);
		return contactmethod;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> saveUserWithContactmethods(final User user, final List<Contactmethod> contacts)
			throws BatchUpdateException {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		List<Contactmethods> contactmethods = MapperExtensions.map(getMapper(), contacts, Contactmethods.class);
		contactmethods = usersManagementService.saveUserWithContactmethods(users, contactmethods);
		final List<Contactmethod> contactmethodDomainObjects = MapperExtensions.map(getMapper(), contactmethods, Contactmethod.class);
		return contactmethodDomainObjects;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveUserWithRoles(final User user, final Collection<Role> roles) {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		final List<Roles> roleEntities =  MapperExtensions.map(getMapper(), roles, Roles.class);
		usersManagementService.saveUserWithRoles(users, roleEntities);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethod setEmail(final String email, final User user) throws EmailAlreadyExistsException {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		final Contactmethods contactmethods = usersManagementService.setEmail(email, users);
		final Contactmethod contactmethod = MapperExtensions.map(getMapper(), contactmethods, Contactmethod.class);
		return contactmethod;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setUsername(final String username, final User user) throws UserAlreadyExistsException {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		return usersManagementService.setUsername(username, users);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethod updateContactmethod(final String contactmethodValue, final ContactmethodType contactmethodType,
			final Contactmethod contactmethod) {
		Contactmethods contactmethods = MapperExtensions.map(getMapper(), contactmethod, Contactmethods.class);
		contactmethods = usersManagementService.updateContactmethod(contactmethodValue, contactmethodType, contactmethods);
		final Contactmethod contactmethodDomainObject = MapperExtensions.map(getMapper(), contactmethods, Contactmethod.class);
		return contactmethodDomainObject;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateUsername(final String username, final User user) throws UserAlreadyExistsException {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		return usersManagementService.updateUsername(username, users);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean userIsInRole(final User user, final Role role) {
		final Users users = MapperExtensions.map(getMapper(), user, Users.class);
		final Roles roleEntity =  MapperExtensions.map(getMapper(), role, Roles.class);
		return usersManagementService.userIsInRole(users, roleEntity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ValidationErrors validate(final UsernameSignUpModel model) {
		return usersManagementService.validate(model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SignUpUserResult signUpUser(final UsernameSignUpModel model, final Set<Role> roles, final UserModel userModel) {
		final List<Roles> roleEntities =  MapperExtensions.map(getMapper(), roles, Roles.class);
		return usersManagementService.signUpUser(model, new HashSet<>(roleEntities), userModel);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Resource persistResource(final ResourcesModel resourceModel, final Integer userId) {
		final Resources resources = usersManagementService.persistResource(resourceModel, userId);
		final Resource resource = MapperExtensions.map(getMapper(), resources, Resource.class);
		return resource;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteResource(final ResourcesModel resource, final Integer userDataId) {
		usersManagementService.deleteResource(resource, userDataId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserData deleteBlacklisted(final User blacklisted, final Integer userDataId) {
		final Users users = MapperExtensions.map(getMapper(), blacklisted, Users.class);
		final UserDatas userDatas = usersManagementService.deleteBlacklisted(users, userDataId);
		final UserData userData = MapperExtensions.map(getMapper(), userDatas, UserData.class);
		return userData;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserData deleteAddress(final Address address, final UserData ud) {
		final Addresses addresses = MapperExtensions.map(getMapper(), address, Addresses.class);
		UserDatas userDatas = MapperExtensions.map(getMapper(), ud, UserDatas.class);
		userDatas = usersManagementService.deleteAddress(addresses, userDatas);
		final UserData userData = MapperExtensions.map(getMapper(), userDatas, UserData.class);
		return userData;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User addUserContact(final User user, final User contact) {
		Users users = MapperExtensions.map(getMapper(), user, Users.class);
		final Users contacts = MapperExtensions.map(getMapper(), contact, Users.class);
		users = usersManagementService.addUserContact(users, contacts);
		final User userDomainObject = MapperExtensions.map(getMapper(), users, User.class);
		return userDomainObject;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isValid(String token) {
		return usersManagementService.isValid(token);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String newAuthenticationToken(String username) {
		return usersManagementService.newAuthenticationToken(username);
	}

}
