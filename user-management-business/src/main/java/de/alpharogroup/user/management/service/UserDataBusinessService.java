package de.alpharogroup.user.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.management.daos.UserDataDao;
import de.alpharogroup.user.management.entities.UserData;
import de.alpharogroup.user.management.service.api.UserDataService;

@Transactional
@Service("userDataService")
public class UserDataBusinessService extends AbstractBusinessService<UserData, Integer, UserDataDao> implements UserDataService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setUserDataDao(UserDataDao userDataDao) {
		setDao(userDataDao);
	}

}