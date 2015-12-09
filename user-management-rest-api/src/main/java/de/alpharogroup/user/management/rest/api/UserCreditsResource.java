package de.alpharogroup.user.management.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.management.domain.UserCredit;

/**
 * The interface {@link UserCreditsResource} provides methods for resolve user credits of users.
 */
@Path("/user/credit/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UserCreditsResource extends RestfulResource<Integer, UserCredit>
{

}
