package de.alpharogroup.user.management.rest;


import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.domain.RuleViolation;
import de.alpharogroup.user.management.rest.api.RuleViolationsResource;
import de.alpharogroup.user.management.service.api.RuleViolationService;

public class RuleViolationsRestResource
	extends
		AbstractRestfulResource<Integer, RuleViolation, RuleViolationService>
	implements
		RuleViolationsResource
{

}
