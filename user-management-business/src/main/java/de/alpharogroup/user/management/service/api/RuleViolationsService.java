package de.alpharogroup.user.management.service.api;

import java.util.List;

import de.alpharogroup.db.service.jpa.BusinessService;
import de.alpharogroup.user.management.application.models.InfringementModel;
import de.alpharogroup.user.management.entities.RuleViolations;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.enums.RuleViolationReason;

public interface RuleViolationsService extends BusinessService<RuleViolations, Integer>{

	RuleViolations save(InfringementModel model);
	
	List<RuleViolations> find(Users detector, Users violator, RuleViolationReason reason, String description);
}