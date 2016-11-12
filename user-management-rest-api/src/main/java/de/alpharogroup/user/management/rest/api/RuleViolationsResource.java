package de.alpharogroup.user.management.rest.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.management.application.models.InfringementModel;
import de.alpharogroup.user.management.domain.RuleViolation;
import de.alpharogroup.user.management.domain.model.Infringement;

/**
 * The interface {@link RuleViolationsResource} provides methods for resolve rule violations of
 * users.
 */
@Path("/rule/violation/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RuleViolationsResource extends RestfulResource<Integer, RuleViolation>
{
	
	/**
	 * Persist the given domain object {@link InfringementModel}.
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
	List<RuleViolation> find(Infringement model);
	
}
