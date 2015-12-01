package de.alpharogroup.user.management.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Query;

import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.address.book.service.util.HqlStringCreator;
import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.date.CalculateDateExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;

import org.apache.log4j.Logger;

import de.alpharogroup.jgeohash.GeoHashUtils;
import de.alpharogroup.user.management.daos.UsersDao;
import de.alpharogroup.user.management.entities.Roles;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.enums.GenderType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.user.management.service.api.UsersService;

@Transactional
@Service("usersService")
public class UsersBusinessService extends AbstractBusinessService<Users, Integer, UsersDao>
	implements
		UsersService
{

	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger(UsersBusinessService.class.getName());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setUsersDao(UsersDao usersDao)
	{
		setDao(usersDao);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean existsUserWithUsername(final String username)
	{
		final Users users = findUserWithUsername(username);
		if (users != null)
		{
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Addresses> findAddressesFromUser(final Users user)
	{
		final String hqlString = "select ur.address from UserAddresses ur where ur.user=:user";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		final List<Addresses> addresses = query.getResultList();
		return addresses;
	}

	/**
	 * {@inheritDoc}
	 */
	public Addresses findAddressFromUser(final Users user)
	{
		final List<Addresses> addresses = findAddressesFromUser(user);
		if (null != addresses && (!addresses.isEmpty()))
		{
			return addresses.get(0);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<Roles> findRolesFromUser(final Users user)
	{
		final String hqlString = "select u.roles from Users u " + "where u=:user";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		final List<Roles> roles = query.getResultList();
		return roles;
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public Users findUserWithEmail(final String email)
	{
		final String hqlString = "select u from Users u inner join u.userData.contactmethods cc "
			+ "where cc.contactmethod='EMAIL' " + "and cc.contactmethod.contactvalue=:email";
		final Query query = getQuery(hqlString);
		query.setParameter("email", email);
		final List<Users> users = query.getResultList();
		return ListExtensions.getFirst(users);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public Users findUserWithUsername(final String username)
	{
		final String hqlString = "select u from Users u " + "where u.username=:username";
		final Query query = getQuery(hqlString);
		query.setParameter("username", username);
		final List<Users> users = query.getResultList();
		return ListExtensions.getFirst(users);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean userIsInRole(final Users user, final Roles role)
	{
		final List<Roles> roles = findRolesFromUser(user);
		if (null != roles && (!roles.isEmpty()))
		{
			if (roles.contains(role))
			{
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Users> findUsers(Integer from, GenderType searchGender, Integer until)
	{
		Date now = new Date(System.currentTimeMillis());
		Date start = CalculateDateExtensions.substractYearsFromDate(now, until);
		Date end = CalculateDateExtensions.substractYearsFromDate(now, from);
		final String hqlString = "select u from Users u " + "where u.userData.gender=:gender "
		// + "and u.userData.dateofbirth between :start and :end"
			+ "and u.userData.dateofbirth >= :start " + "and u.userData.dateofbirth <= :end";
		final Query query = getQuery(hqlString);
		query.setParameter("gender", searchGender);
		query.setParameter("start", start);
		query.setParameter("end", end);
		final List<Users> users = query.getResultList();
		return users;
	}

	@SuppressWarnings("unchecked")
	public List<Users> findUsers(Integer from, GenderType searchGender, Integer until,
		final String geohash)
	{
		Date now = new Date(System.currentTimeMillis());
		Date start = CalculateDateExtensions.substractYearsFromDate(now, until);
		Date end = CalculateDateExtensions.substractYearsFromDate(now, from);

		final StringBuilder hqlString = new StringBuilder();
		hqlString.append("select u from Users u " + "where u.userData.gender=:gender "
		// + "and u.userData.dateofbirth between :start and :end"
			+ "and u.userData.dateofbirth >= :start " + "and u.userData.dateofbirth <= :end ");

		Map<String, String> adjacentAreas = null;
		if (geohash != null && !geohash.trim().isEmpty())
		{
			adjacentAreas = GeoHashUtils.getTwentyFiveAreasMap(geohash);
		}
		if (adjacentAreas != null)
		{
			String firstAndSecondRingSubQuery = HqlStringCreator
				.getGeohashFirstAndSecondRingSubQuery();
			hqlString.append("and u.userData.primaryAddress.geohash in "
				+ firstAndSecondRingSubQuery);
		}

		String queryString = hqlString.toString();
		LOGGER.info("Query String from method findUsers:" + queryString);
		final Query query = getQuery(queryString);
		// Set parameters...
		query.setParameter("gender", searchGender);
		query.setParameter("start", start);
		query.setParameter("end", end);
		if (adjacentAreas != null)
		{
			for (Entry<String, String> entry : adjacentAreas.entrySet())
			{
				query.setParameter(entry.getKey(), entry.getValue() + "%");
			}
		}
		final List<Users> users = query.getResultList();
		return users;
	}

}