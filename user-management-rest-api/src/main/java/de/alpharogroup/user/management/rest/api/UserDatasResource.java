package de.alpharogroup.user.management.rest.api;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.management.domain.UserData;

/**
 * The interface {@link UserDatasResource} provides methods for resolve user data of users.
 */
@Path("/user/data/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UserDatasResource extends RestfulResource<Integer, UserData>
{

	/**
	 * Find the {@link UserData} object by the given {@link User} object.
	 *
	 * @param user the user
	 * @return the found {@link UserData} object or null if does not exist.
	 */
	@POST
	@Path("/find/by/user")
	UserData findBy(User user);


	/**
	 * Find the {@link UserData} object by the given {@link Integer} user id.
	 *
	 * @param userid the user id
	 * @return the found {@link UserData} object or null if does not exist.
	 */
	@GET
	@Path("/find/by/{userid}/")
	UserData findBy(@PathParam("userid") final Integer userid);
}
