package de.alpharogroup.user.management.service;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.management.application.models.InfringementModel;
import de.alpharogroup.user.management.daos.RuleViolationsDao;
import de.alpharogroup.user.management.entities.RuleViolations;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.enums.RuleViolationReason;
import de.alpharogroup.user.management.factories.UserManagementFactory;
import de.alpharogroup.user.management.service.api.RuleViolationsService;
import de.alpharogroup.user.management.service.util.HqlStringCreator;

@Transactional
@Service("ruleViolationsService")
public class RuleViolationsBusinessService extends
		AbstractBusinessService<RuleViolations, Integer, RuleViolationsDao>
		implements RuleViolationsService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setRuleViolationsDao(RuleViolationsDao ruleViolationsDao) {
		setDao(ruleViolationsDao);
	}

	public RuleViolations save(InfringementModel model) {
		RuleViolations ruleViolations = UserManagementFactory.getInstance()
				.newRuleViolations(model.getDetector(), model.getViolator(),
						model.getDescription(), model.getReason());
		return merge(ruleViolations);
	}
	
	@SuppressWarnings("unchecked")
	public List<RuleViolations> find(Users detector, Users violator, RuleViolationReason reason, String description) {
		String hqlString = HqlStringCreator.forRuleViolations(detector, violator, reason, description);
		final Query query = getQuery(hqlString);
		if(detector != null){
			query.setParameter("detector", detector);
		}
		if(violator != null){
			query.setParameter("violator", violator);
		}
		if(reason != null){
			query.setParameter("reason", reason);			
		}
		if(description != null && !description.isEmpty()){
			query.setParameter("description", description);			
		}
		final List<RuleViolations> ruleViolations = query.getResultList();
		return ruleViolations;
	}

}