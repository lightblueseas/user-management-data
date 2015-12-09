package de.alpharogroup.user.management.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.management.domain.RuleViolation;

/**
 * The interface {@link RuleViolationsResource} provides methods for resolve rule violations of
 * users.
 */
@Path("/rule/violation/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RuleViolationsResource extends RestfulResource<Integer, RuleViolation>
{

}
