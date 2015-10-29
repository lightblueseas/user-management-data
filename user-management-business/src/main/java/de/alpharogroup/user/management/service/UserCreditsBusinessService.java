package de.alpharogroup.user.management.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.management.daos.UserCreditsDao;
import de.alpharogroup.user.management.entities.UserCredits;
import de.alpharogroup.user.management.service.api.UserCreditsService;

@Transactional
@Service("userCreditsService")
public class UserCreditsBusinessService extends AbstractBusinessService<UserCredits, Integer, UserCreditsDao> implements UserCreditsService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setUserCreditsDao(UserCreditsDao userCreditsDao) {
		setDao(userCreditsDao);
	}

}