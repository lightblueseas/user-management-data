package de.alpharogroup.user.management.rest.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.collections.pairs.Triple;
import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.management.domain.Recommendation;
import de.alpharogroup.user.management.domain.User;

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
	 * @param recommendation the recommendation
	 * 
	 * @return the list of found {@link Recommendation} objects.
	 */
	@POST
	@Path("/find")
	List<Recommendation> find(Triple<User, User, String> recommendation);
		
	/**
	 * Find the {@link Recommendation} object from the given parameters.
	 *
	 * @param recommendation the recommendation
	 * @return the found {@link Recommendation} object
	 */
	@POST
	@Path("/find/recommendation")
	Recommendation findRecommendations(Triple<User, User, String> recommendation);
}
