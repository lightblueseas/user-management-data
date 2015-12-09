package de.alpharogroup.user.management.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.management.domain.Robinson;

/**
 * The interface {@link RobinsonsResource} provides methods for robinson users. Robinson users are
 * users that do not want to be disturbed, like email or other messages or advertising.
 */
@Path("/robinson/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RobinsonsResource extends RestfulResource<Integer, Robinson>
{

}
