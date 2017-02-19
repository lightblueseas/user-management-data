package de.alpharogroup.user.management.service.api;

import java.util.List;

import de.alpharogroup.service.domain.DomainService;
import de.alpharogroup.user.management.domain.Recommendation;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.management.entities.Recommendations;

/**
 * The interface {@link RecommendationService}.
 */
public interface RecommendationService extends DomainService<Integer, Recommendation> {

	/**
	 * Find all the {@link Recommendation} objects from the given parameters.
	 *
	 * @param user the user the recommended another user
	 * @param recommended the recommended user
	 * @param email the email where to send the recommendation
	 * @return the list of found {@link Recommendations} objects.
	 */
	List<Recommendation> find(User user, User recommended, String email);
	
	/**
	 * Find the {@link Recommendations} object from the given parameters.
	 *
	 * @param user the user
	 * @param recommended the recommended
	 * @param email the email
	 * @return the found {@link Recommendations} object
	 */
	Recommendation findRecommendations(User user, User recommended,  String email);
}
