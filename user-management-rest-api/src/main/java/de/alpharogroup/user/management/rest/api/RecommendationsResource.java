package de.alpharogroup.user.management.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.service.rs.RestfulResource;
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

}
