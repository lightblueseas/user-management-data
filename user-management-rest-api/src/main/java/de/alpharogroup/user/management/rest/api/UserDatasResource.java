package de.alpharogroup.user.management.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.management.domain.UserData;

/**
 * The interface {@link UserDatasResource} provides methods for resolve user data of users.
 */
@Path("/user/data/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UserDatasResource extends RestfulResource<Integer, UserData>
{

}
