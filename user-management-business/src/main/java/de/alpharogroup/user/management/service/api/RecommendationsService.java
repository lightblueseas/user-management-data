package de.alpharogroup.user.management.service.api;

import java.util.List;

import de.alpharogroup.db.service.jpa.BusinessService;
import de.alpharogroup.user.management.entities.Recommendations;
import de.alpharogroup.user.management.entities.Users;

/**
 * The interface {@link RecommendationsService}.
 */
public interface RecommendationsService extends BusinessService<Recommendations, Integer> {
	
	/**
	 * Find all the {@link Recommendations} objects from the given parameters.
	 *
	 * @param user the user the recommended another user
	 * @param recommended the recommended user
	 * @param email the email where to send the recommendation
	 * @return the list of found {@link Recommendations} objects.
	 */
	List<Recommendations> find(Users user, Users recommended, String email);
	
	/**
	 * Find the {@link Recommendations} object from the given parameters.
	 *
	 * @param user the user
	 * @param recommended the recommended
	 * @param email the email
	 * @return the found {@link Recommendations} object
	 */
	Recommendations findRecommendations(Users user, Users recommended,  String email);
}