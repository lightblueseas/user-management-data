package de.alpharogroup.user.management.rest;


import java.util.List;

import de.alpharogroup.address.book.domain.Address;
import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.domain.Role;
import de.alpharogroup.user.management.domain.User;
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
	public boolean userIsInRole(User user, Role role) {
		return getDomainService().userIsInRole(user, role);
	}

	@Override
	public List<User> findUsers(Integer from, GenderType searchGender, Integer until) {
		return getDomainService().findUsers(from, searchGender, until);
	}

	@Override
	public List<User> findUsers(Integer from, GenderType searchGender, Integer until, String geohash) {
		return getDomainService().findUsers(from, searchGender, until, geohash);
	}

}
