package de.alpharogroup.user.management.rest;


import java.util.List;

import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.domain.RuleViolation;
import de.alpharogroup.user.management.domain.model.Infringement;
import de.alpharogroup.user.management.rest.api.RuleViolationsResource;
import de.alpharogroup.user.management.service.api.RuleViolationService;

public class RuleViolationsRestResource
	extends
		AbstractRestfulResource<Integer, RuleViolation, RuleViolationService>
	implements
		RuleViolationsResource
{

	@Override
	public RuleViolation save(Infringement model) {
		return getDomainService().save(model);
	}
	
	@Override
	public List<RuleViolation> find(Infringement model) {
		return getDomainService().find(model.getDetector(), model.getViolator(), model.getReason(), model.getDescription());
	}

}
