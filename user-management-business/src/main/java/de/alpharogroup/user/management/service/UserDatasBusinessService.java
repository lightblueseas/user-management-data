package de.alpharogroup.user.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.torpedoquery.jpa.Torpedo;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.management.daos.UserDatasDao;
import de.alpharogroup.user.management.entities.UserDatas;
import de.alpharogroup.user.management.entities.Users;
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
	public void setUserDataDao(UserDatasDao userDataDao) {
		setDao(userDataDao);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public UserDatas findBy(Users user) {
		UserDatas from = Torpedo.from(UserDatas.class);
		Torpedo.where(from.getOwner()).eq(user);
		org.torpedoquery.jpa.Query<UserDatas> select = Torpedo.select(from);
		List<UserDatas> userDatas = select.list(getDao().getEntityManager());
		return ListExtensions.getFirst(userDatas);		
	}

}