/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *  *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *  *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
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
	 * Find the {@link UserData} object by the given {@link Integer} user id.
	 *
	 * @param userid
	 *            the user id
	 * @return the found {@link UserData} object or null if does not exist.
	 */
	@GET
	@Path("/find/by/{userid}/")
	UserData findBy(@PathParam("userid") final Integer userid);


	/**
	 * Find the {@link UserData} object by the given {@link User} object.
	 *
	 * @param user
	 *            the user
	 * @return the found {@link UserData} object or null if does not exist.
	 */
	@POST
	@Path("/find/by/user")
	UserData findBy(User user);
}
