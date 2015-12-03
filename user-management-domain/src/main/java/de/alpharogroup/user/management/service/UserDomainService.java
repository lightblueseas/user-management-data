package de.alpharogroup.user.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.alpharogroup.address.book.domain.Address;
import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.management.daos.UsersDao;
import de.alpharogroup.user.management.domain.Role;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.entities.Roles;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.enums.GenderType;
import de.alpharogroup.user.management.mapper.UsersMapper;
import de.alpharogroup.user.management.service.api.UserService;
import de.alpharogroup.user.management.service.api.UsersService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link UserDomainService}.
 */
public class UserDomainService extends AbstractDomainService<Integer, User, Users, UsersDao, UsersMapper>
		implements UserService {

	/** The {@link UsersService}. */
	@Autowired
	@Getter
	@Setter
	private UsersService usersService;

	/**
	 * Sets the specific {@link UsersDao}.
	 *
	 * @param usersDao
	 *            the new {@link UsersDao}.
	 */
	@Autowired
	public void setUsersDao(UsersDao usersDao) {
		setDao(usersDao);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsUserWithUsername(String username) {
		return usersService.existsUserWithUsername(username);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Address> findAddressesFromUser(User user) {
		Users users = getMapper().toEntity(user);
		List<Addresses> addresses = usersService.findAddressesFromUser(users);
		List<Address> addresss = getMapper().map(addresses, Address.class);
		return addresss;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Address findAddressFromUser(User user) {
		Users users = getMapper().toEntity(user);
		Addresses addresses  = usersService.findAddressFromUser(users);
		Address addresss = getMapper().map(addresses, Address.class);
		return addresss;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Role> findRolesFromUser(User user) {
		Users users = getMapper().toEntity(user);
		List<Roles> roles  = usersService.findRolesFromUser(users);
		List<Role> roless = getMapper().map(roles, Role.class);
		return roless;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findUserWithEmail(String email) {
		Users users = usersService.findUserWithEmail(email);
		User user = getMapper().toDomainObject(users);
		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findUserWithUsername(String username) {
		Users users = usersService.findUserWithUsername(username);
		User user = getMapper().toDomainObject(users);
		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean userIsInRole(User user, Role role) {
		Users users = getMapper().toEntity(user);
		Roles roles =getMapper().map(role, Roles.class);
		return usersService.userIsInRole(users, roles);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> findUsers(Integer from, GenderType searchGender, Integer until) {
		List<Users> users = usersService.findUsers(from, searchGender, until);
		List<User> userss = getMapper().map(users, User.class);
		return userss;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> findUsers(Integer from, GenderType searchGender, Integer until, String geohash) {
		List<Users> users = usersService.findUsers(from, searchGender, until, geohash);
		List<User> userss = getMapper().map(users, User.class);
		return userss;
	}
	
}
