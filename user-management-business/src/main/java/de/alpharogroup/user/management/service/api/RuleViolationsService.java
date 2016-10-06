package de.alpharogroup.user.management.service.api;

import java.util.List;

import de.alpharogroup.db.service.api.BusinessService;
import de.alpharogroup.user.management.application.models.InfringementModel;
import de.alpharogroup.user.management.entities.RuleViolations;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.enums.RuleViolationReason;

/**
 * The interface {@link RuleViolationsService}.
 */
public interface RuleViolationsService extends BusinessService<RuleViolations, Integer>{

	/**
	 * Persist the given domain object {@link InfringementModel}.
	 *
	 * @param model the model
	 * @return the persisted {@link RuleViolations} object.
	 */
	RuleViolations save(InfringementModel model);
	
	/**
	 * Find a all {@link RuleViolations} objects from the given arguments.
	 *
	 * @param detector the detector
	 * @param violator the violator
	 * @param reason the reason
	 * @param description the description
	 * @return the found {@link RuleViolations} objects.
	 */
	List<RuleViolations> find(Users detector, Users violator, RuleViolationReason reason, String description);
}