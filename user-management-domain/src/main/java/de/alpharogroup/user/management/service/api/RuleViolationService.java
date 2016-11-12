package de.alpharogroup.user.management.service.api;

import java.util.List;

import de.alpharogroup.service.domain.DomainService;
import de.alpharogroup.user.management.application.models.InfringementModel;
import de.alpharogroup.user.management.domain.RuleViolation;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.domain.model.Infringement;
import de.alpharogroup.user.management.enums.RuleViolationReason;

/**
 * The interface {@link RuleViolationService}.
 */
public interface RuleViolationService extends DomainService<Integer, RuleViolation> {

	/**
	 * Persist the given domain object {@link InfringementModel}.
	 *
	 * @param model the model
	 * @return the persisted {@link RuleViolation} object.
	 * @deprecated use instead {@link RuleViolationService#save(Infringement)}
	 */
	@Deprecated
	RuleViolation save(InfringementModel model);
	
	/**
	 * Persist the given domain object {@link Infringement}.
	 *
	 * @param model the model
	 * @return the persisted {@link RuleViolation} object.
	 */
	RuleViolation save(Infringement model);
	
	/**
	 * Find a all {@link RuleViolation} objects from the given arguments.
	 *
	 * @param detector the detector
	 * @param violator the violator
	 * @param reason the reason
	 * @param description the description
	 * @return the found {@link RuleViolation} objects.
	 */
	List<RuleViolation> find(User detector, User violator, RuleViolationReason reason, String description);
}
