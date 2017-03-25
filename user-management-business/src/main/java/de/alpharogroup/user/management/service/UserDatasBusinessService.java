package de.alpharogroup.user.management.service;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.daos.UserDatasDao;
import de.alpharogroup.user.management.entities.UserDatas;
import de.alpharogroup.user.management.service.api.UserDatasService;

@Transactional
@Service("userDatasService")
public class UserDatasBusinessService extends AbstractBusinessService<UserDatas, Integer, UserDatasDao> implements UserDatasService {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	@Autowired
	public void setUserDataDao(final UserDatasDao userDataDao) {
		setDao(userDataDao);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public UserDatas findBy(final Users user) {
		final String hqlString =
				  "select ud from UserDatas ud "
				+ "where ud.owner=:user";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		final List<UserDatas> userDatas = query.getResultList();
		return ListExtensions.getFirst(userDatas);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public UserDatas findBy(final Integer userid) {
		final String hqlString =
				  "select ud from UserDatas ud "
				+ "where ud.owner.id=:userid";
		final Query query = getQuery(hqlString);
		query.setParameter("userid", userid);
		final List<UserDatas> userDatas = query.getResultList();
		return ListExtensions.getFirst(userDatas);
	}

}