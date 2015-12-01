package de.alpharogroup.user.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.management.daos.UserDatasDao;
import de.alpharogroup.user.management.entities.UserDatas;
import de.alpharogroup.user.management.service.api.UserDatasService;

@Transactional
@Service("userDatasService")
public class UserDatasBusinessService extends AbstractBusinessService<UserDatas, Integer, UserDatasDao> implements UserDatasService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setUserDataDao(UserDatasDao userDataDao) {
		setDao(userDataDao);
	}

}