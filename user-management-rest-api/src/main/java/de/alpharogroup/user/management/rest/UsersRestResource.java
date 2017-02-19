package de.alpharogroup.user.management.rest;


import java.util.List;

import de.alpharogroup.address.book.domain.Address;
import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.collections.pairs.Triple;
import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.domain.Role;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.management.domain.model.UserSearchCriteria;
import de.alpharogroup.user.management.enums.GenderType;
import de.alpharogroup.user.management.rest.api.UsersResource;
import de.alpharogroup.user.management.service.api.UserService;

public class UsersRestResource
	extends
 AbstractRestfulResource<Integer, User, UserService>
	implements
		UsersResource
{
	
	public List<User> findAll() {
		return getDomainService().findAll();
	}

	@Override
	public boolean existsUserWithUsername(String username) {
		return getDomainService().existsUserWithUsername(username);
	}

	@Override
	public List<Address> findAddressesFromUser(User user) {
		return getDomainService().findAddressesFromUser(user);
	}

	@Override
	public Address findAddressFromUser(User user) {
		return getDomainService().findAddressFromUser(user);
	}

	@Override
	public List<Role> findRolesFromUser(User user) {
		return getDomainService().findRolesFromUser(user);
	}

	@Override
	public User findUserWithEmail(String email) {
		return getDomainService().findUserWithEmail(email);
	}

	@Override
	public User findUserWithUsername(String username) {
		return getDomainService().findUserWithUsername(username);
	}

	@Override
	public boolean userIsInRole(KeyValuePair<User, Role> user) {
		return getDomainService().userIsInRole(user.getKey(), user.getValue());
	}

	@Override
	public List<User> findUsers(Triple<Integer, GenderType, Integer> searchCriteria) {
		return getDomainService().findUsers(searchCriteria.getLeft(), searchCriteria.getMiddle(), searchCriteria.getRight());
	}

	@Override
	public List<User> findUsers(UserSearchCriteria userSearchCriteria) {
		return getDomainService().findUsers(
				userSearchCriteria.getFrom(), 
				userSearchCriteria.getSearchGender(), 
				userSearchCriteria.getUntil(), 
				userSearchCriteria.getGeohash());
	}
}
