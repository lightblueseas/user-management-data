package de.alpharogroup.user.management.rest;

import java.io.Serializable;
import java.sql.BatchUpdateException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

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
import de.alpharogroup.user.management.rest.api.UserManagementResource;
import de.alpharogroup.user.management.service.api.UserManagementService;
import de.alpharogroup.user.management.sign.up.SignUpUserResult;
import de.alpharogroup.user.management.sign.up.UserModel;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link UserManagementRestResource}.
 */
public class UserManagementRestResource implements UserManagementResource {
	
	/** The user management service. */
	@Getter
	@Setter
	private UserManagementService userManagementService;

	@Override
	public boolean isInRole(KeyValuePair<String, List<Role>> roleSearchModel) {
		return userManagementService.isInRole(roleSearchModel.getKey(), roleSearchModel.getValue());
	}

	@Override
	public boolean existsUserWithEmail(Contactmethod emailContact) {
		return userManagementService.existsUserWithEmail(emailContact);
	}

	@Override
	public List<Address> findAddessesFromUser(User user) {
		return userManagementService.findAddessesFromUser(user);
	}

	@Override
	public Address findAddressFromUser(User user) {
		return userManagementService.findAddressFromUser(user);
	}

	@Override
	public List<Contactmethod> findAllEmailContactmethodsFromUser(User user) {
		return userManagementService.findAllEmailContactmethodsFromUser(user);
	}

	@Override
	public List<Contactmethod> findAllFaxContactmethodsFromUser(User user) {
		return userManagementService.findAllFaxContactmethodsFromUser(user);
	}

	@Override
	public List<Contactmethod> findAllInternetContactmethodsFromUser(User user) {
		return userManagementService.findAllInternetContactmethodsFromUser(user);
	}

	@Override
	public List<Contactmethod> findAllMobileContactmethodsFromUser(User user) {
		return userManagementService.findAllMobileContactmethodsFromUser(user);
	}

	@Override
	public List<Contactmethod> findAllTelefonContactmethodsFromUser(User user) {
		return userManagementService.findAllTelefonContactmethodsFromUser(user);
	}

	@Override
	public Contactmethod findEmailContactFromUser(User user) {
		return userManagementService.findEmailContactFromUser(user);
	}

	@Override
	public Contactmethod findFaxContactFromUser(User user) {
		return userManagementService.findFaxContactFromUser(user);
	}

	@Override
	public Contactmethod findInternetContactFromUser(User user) {
		return userManagementService.findInternetContactFromUser(user);
	}

	@Override
	public Contactmethod findMobileContactFromUser(User user) {
		return userManagementService.findMobileContactFromUser(user);
	}

	@Override
	public List<Role> findRolesFromUser(User user) {
		return userManagementService.findRolesFromUser(user);
	}

	@Override
	public Contactmethod findTelefonContactFromUser(User user) {
		return userManagementService.findTelefonContactFromUser(user);
	}

	@Override
	public User findUserWithEmail(String email) {
		return userManagementService.findUserWithEmail(email);
	}

	@Override
	public User findUserWithEmailOrUsername(String emailOrUsername) {
		return userManagementService.findUserWithEmailOrUsername(emailOrUsername);
	}

	@Override
	public User findUserWithUsername(String username) {
		return userManagementService.findUserWithUsername(username);
	}

	@Override
	public boolean isUserInRole(KeyValuePair<User, String> userSearchModel) {
		return userManagementService.isUserInRole(userSearchModel.getKey(), userSearchModel.getValue());
	}

	@Override
	public void saveAddressesFromUser(KeyValuePair<User, Collection<Address>> userSaveModel) {
		userManagementService.saveAddressesFromUser(userSaveModel.getKey(), userSaveModel.getValue());		
	}

	@Override
	public void saveAddressFromUser(KeyValuePair<User, Address> userSaveModel) {
		userManagementService.saveAddressFromUser(userSaveModel.getKey(), userSaveModel.getValue());	
	}

	@Override
	public Serializable saveNewUser(User user) throws UserAlreadyExistsException {
		return userManagementService.saveNewUser(user);
	}

	@Override
	public Serializable saveUserOnlyWithEmail(User user) throws UserAlreadyExistsException {
		return userManagementService.saveUserOnlyWithEmail(user);
	}

	@Override
	public Contactmethod saveUserWithContactmethod(KeyValuePair<User, Contactmethod> userSaveModel)
			throws BatchUpdateException {
		return userManagementService.saveUserWithContactmethod(userSaveModel.getKey(), userSaveModel.getValue());
	}

	@Override
	public List<Contactmethod> saveUserWithContactmethods(KeyValuePair<User, List<Contactmethod>> userSaveModel)
			throws BatchUpdateException {
		return userManagementService.saveUserWithContactmethods(userSaveModel.getKey(), userSaveModel.getValue());
	}

	@Override
	public void saveUserWithRoles(KeyValuePair<User, Collection<Role>> userSaveModel) {
		userManagementService.saveUserWithRoles(userSaveModel.getKey(), userSaveModel.getValue());		
	}

	@Override
	public Contactmethod setEmail(KeyValuePair<String, User> userSaveModel) throws EmailAlreadyExistsException {
		return userManagementService.setEmail(userSaveModel.getKey(), userSaveModel.getValue());
	}

	@Override
	public boolean setUsername(KeyValuePair<String, User> userSaveModel) throws UserAlreadyExistsException {
		return userManagementService.setUsername(userSaveModel.getKey(), userSaveModel.getValue());
	}

	@Override
	public Contactmethod updateContactmethod(Triple<String, ContactmethodType, Contactmethod> updateModel) {
		return userManagementService.updateContactmethod(updateModel.getLeft(), updateModel.getMiddle(), updateModel.getRight());
	}

	@Override
	public boolean updateUsername(KeyValuePair<String, User> updateModel) throws UserAlreadyExistsException {
		return userManagementService.updateUsername(updateModel.getKey(), updateModel.getValue());
	}

	@Override
	public boolean userIsInRole(KeyValuePair<User, Role> searchModel) {
		return userManagementService.userIsInRole(searchModel.getKey(), searchModel.getValue());
	}

	@Override
	public ValidationErrors validate(UsernameSignUpModel model) {
		return userManagementService.validate(model);
	}

	@Override
	public SignUpUserResult signUpUser(Triple<UsernameSignUpModel, Set<Role>, UserModel> saveModel) {
		return userManagementService.signUpUser(saveModel.getLeft(), saveModel.getMiddle(), saveModel.getRight());
	}

	@Override
	public Resource persistResource(KeyValuePair<ResourcesModel, Integer> saveModel) {
		return userManagementService.persistResource(saveModel.getKey(), saveModel.getValue());
	}

	@Override
	public void deleteResource(KeyValuePair<ResourcesModel, Integer> deleteModel) {
		userManagementService.deleteResource(deleteModel.getKey(), deleteModel.getValue());
	}

	@Override
	public UserData deleteBlacklisted(KeyValuePair<User, Integer> deleteModel) {
		return userManagementService.deleteBlacklisted(deleteModel.getKey(), deleteModel.getValue());
	}

	@Override
	public UserData deleteAddress(KeyValuePair<Address, UserData> deleteModel) {
		return userManagementService.deleteAddress(deleteModel.getKey(), deleteModel.getValue());
	}

	@Override
	public User addUserContact(KeyValuePair<User, User> saveModel) {
		return userManagementService.addUserContact(saveModel.getKey(), saveModel.getValue());
	}

	@Override
	public boolean existsUserWithEmail(String email) {
		return userManagementService.existsUserWithEmail(email);
	}

	@Override
	public boolean existsUserWithUsername(String username) {
		return userManagementService.existsUserWithUsername(username);
	}

	@Override
	public boolean existsUserWithEmailOrUsername(String emailOrUsername) {
		return userManagementService.existsUserWithEmailOrUsername(emailOrUsername);
	}

	@Override
	public InsertUserState existsUserWithEmailOrUsername(KeyValuePair<String, String> searchModel) {
		return userManagementService.existsUserWithEmailOrUsername(searchModel.getKey(), searchModel.getValue());
	}

}
