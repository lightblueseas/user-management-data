package de.alpharogroup.user.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.management.daos.RobinsonsDao;
import de.alpharogroup.user.management.entities.Robinsons;
import de.alpharogroup.user.management.service.api.RobinsonsService;

@Transactional
@Service("robinsonsService")
public class RobinsonsBusinessService extends AbstractBusinessService<Robinsons, Integer, RobinsonsDao> implements RobinsonsService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setRobinsonsDao(RobinsonsDao robinsonsDao) {
		setDao(robinsonsDao);
	}

}