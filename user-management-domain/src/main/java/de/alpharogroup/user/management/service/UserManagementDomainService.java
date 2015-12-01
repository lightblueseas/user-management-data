package de.alpharogroup.user.management.service;

import java.io.Serializable;
import java.sql.BatchUpdateException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.auth.enums.InsertUserState;
import de.alpharogroup.auth.exceptions.EmailAlreadyExistsException;
import de.alpharogroup.auth.exceptions.UserAlreadyExistsException;
import de.alpharogroup.auth.models.UsernameSignUpModel;
import de.alpharogroup.auth.models.ValidationErrors;
import de.alpharogroup.resource.system.application.model.ResourcesModel;
import de.alpharogroup.resource.system.domain.Resource;
import de.alpharogroup.user.management.domain.Contactmethod;
import de.alpharogroup.user.management.domain.Role;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.domain.UserData;
import de.alpharogroup.user.management.enums.ContactmethodType;
import de.alpharogroup.user.management.service.api.UserDatasService;
import de.alpharogroup.user.management.service.api.UserManagementService;
import de.alpharogroup.user.management.service.api.UsersManagementService;
import de.alpharogroup.user.management.sign.up.SignUpUserResult;
import de.alpharogroup.user.management.sign.up.UserModel;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link UserManagementDomainService}.
 */
public class UserManagementDomainService implements UserManagementService {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The {@link UserDatasService}. */
	@Autowired
	@Getter
	@Setter
	private UsersManagementService usersManagementService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsUserWithEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsUserWithUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public InsertUserState existsUserWithEmailOrUsername(String email, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isInRole(String rolename, List<Role> roles) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsUserWithEmail(Contactmethod emailContact) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsUserWithEmailOrUsername(String emailOrUsername) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Addresses> findAddessesFromUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Addresses findAddressFromUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> findAllEmailContactmethodsFromUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> findAllFaxContactmethodsFromUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> findAllInternetContactmethodsFromUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> findAllMobileContactmethodsFromUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> findAllTelefonContactmethodsFromUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethod findEmailContactFromUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethod findFaxContactFromUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethod findInternetContactFromUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethod findMobileContactFromUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Role> findRolesFromUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethod findTelefonContactFromUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findUserWithEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findUserWithEmailOrUsername(String emailOrUsername) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findUserWithUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isUserInRole(User user, String rolename) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveAddressesFromUser(User user, Collection<Addresses> addresses) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveAddressFromUser(User user, Addresses address) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Serializable saveNewUser(User user) throws UserAlreadyExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Serializable saveUserOnlyWithEmail(User user) throws UserAlreadyExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethod saveUserWithContactmethod(User user, Contactmethod contact) throws BatchUpdateException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> saveUserWithContactmethods(User user, List<Contactmethod> contacts)
			throws BatchUpdateException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveUserWithRoles(User user, Collection<Role> roles) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethod setEmail(String email, User user) throws EmailAlreadyExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setUsername(String username, User user) throws UserAlreadyExistsException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Contactmethod updateContactmethod(String contactmethodValue, ContactmethodType contactmethodType,
			Contactmethod contactmethod) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateUsername(String username, User user) throws UserAlreadyExistsException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean userIsInRole(User user, Role role) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ValidationErrors validate(UsernameSignUpModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SignUpUserResult signUpUser(UsernameSignUpModel model, Set<Role> roles, UserModel userModel) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Resource persistResource(ResourcesModel resourceModel, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteResource(ResourcesModel resource, Integer userDataId) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserData deleteBlacklisted(User blacklisted, Integer userDataId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserData deleteAddress(Addresses address, UserData ud) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User addUserContact(User user, User contact) {
		// TODO Auto-generated method stub
		return null;
	}

}
