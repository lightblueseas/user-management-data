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

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.collections.pairs.Triple;
import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.management.domain.Recommendation;

/**
 * The interface {@link RecommendationsResource} provides methods for resolving recommendation
 * objects.
 */
@Path("/recommendation/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RecommendationsResource extends RestfulResource<Integer, Recommendation>
{

	/**
	 * Find all the {@link Recommendation} objects from the given parameters.
	 *
	 * @param recommendation
	 *            the recommendation
	 * 
	 * @return the list of found {@link Recommendation} objects.
	 */
	@POST
	@Path("/find")
	List<Recommendation> find(Triple<User, User, String> recommendation);

	/**
	 * Find the {@link Recommendation} object from the given parameters.
	 *
	 * @param recommendation
	 *            the recommendation
	 * @return the found {@link Recommendation} object
	 */
	@POST
	@Path("/find/recommendation")
	Recommendation findRecommendations(Triple<User, User, String> recommendation);
}
