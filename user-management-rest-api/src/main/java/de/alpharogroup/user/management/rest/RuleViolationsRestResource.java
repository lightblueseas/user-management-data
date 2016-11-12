package de.alpharogroup.user.management.rest;


import java.util.List;

import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.application.models.InfringementModel;
import de.alpharogroup.user.management.domain.RuleViolation;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.enums.RuleViolationReason;
import de.alpharogroup.user.management.rest.api.RuleViolationsResource;
import de.alpharogroup.user.management.service.api.RuleViolationService;

public class RuleViolationsRestResource
	extends
		AbstractRestfulResource<Integer, RuleViolation, RuleViolationService>
	implements
		RuleViolationsResource
{

	@Override
	public RuleViolation save(InfringementModel model) {
		return getDomainService().save(model);
	}

	@Override
	public List<RuleViolation> find(User detector, User violator, RuleViolationReason reason, String description) {
		return getDomainService().find(detector, violator, reason, description);
	}

}
