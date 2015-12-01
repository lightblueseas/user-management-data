package de.alpharogroup.user.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.alpharogroup.address.book.domain.Address;
import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.management.daos.UsersDao;
import de.alpharogroup.user.management.domain.Role;
import de.alpharogroup.user.management.domain.User;
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
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Address> findAddressesFromUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Address findAddressFromUser(User user) {
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
	public User findUserWithEmail(String email) {
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
	public boolean userIsInRole(User user, Role role) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> findUsers(Integer from, GenderType searchGender, Integer until) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> findUsers(Integer from, GenderType searchGender, Integer until, String geohash) {
		// TODO Auto-generated method stub
		return null;
	}
}
