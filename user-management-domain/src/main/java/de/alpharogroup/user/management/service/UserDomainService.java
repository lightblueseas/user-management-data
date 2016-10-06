package de.alpharogroup.user.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
@Service("userDomainService")
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
	public void setUsersDao(final UsersDao usersDao) {
		setDao(usersDao);
	}

	/**
	 * Sets the specific {@link UsersMapper}.
	 *
	 * @param mapper
	 *            the new {@link UsersMapper}.
	 */
	@Autowired
	public void setUsersMapper(UsersMapper mapper) {
		setMapper(mapper);
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
	public List<Address> findAddressesFromUser(final User user) {
		final Users users = getMapper().toEntity(user);
		final List<Addresses> addresses = usersService.findAddressesFromUser(users);
		final List<Address> addresss = getMapper().map(addresses, Address.class);
		return addresss;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Address findAddressFromUser(final User user) {
		final Users users = getMapper().toEntity(user);
		final Addresses addresses  = usersService.findAddressFromUser(users);
		final Address addresss = getMapper().map(addresses, Address.class);
		return addresss;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Role> findRolesFromUser(final User user) {
		final Users users = getMapper().toEntity(user);
		final List<Roles> roles  = usersService.findRolesFromUser(users);
		final List<Role> roless = getMapper().map(roles, Role.class);
		return roless;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findUserWithEmail(final String email) {
		final Users users = usersService.findUserWithEmail(email);
		final User user = getMapper().toDomainObject(users);
		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findUserWithUsername(final String username) {
		final Users users = usersService.findUserWithUsername(username);
		final User user = getMapper().toDomainObject(users);
		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean userIsInRole(final User user, final Role role) {
		final Users users = getMapper().toEntity(user);
		final Roles roles =getMapper().map(role, Roles.class);
		return usersService.userIsInRole(users, roles);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> findUsers(final Integer from, final GenderType searchGender, final Integer until) {
		final List<Users> users = usersService.findUsers(from, searchGender, until);
		final List<User> userss = getMapper().map(users, User.class);
		return userss;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> findUsers(final Integer from, final GenderType searchGender, final Integer until, final String geohash) {
		final List<Users> users = usersService.findUsers(from, searchGender, until, geohash);
		final List<User> userss = getMapper().map(users, User.class);
		return userss;
	}

}
