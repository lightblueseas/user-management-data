package de.alpharogroup.user.management.rest;


import java.util.List;

import de.alpharogroup.collections.pairs.Triple;
import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.domain.Recommendation;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.rest.api.RecommendationsResource;
import de.alpharogroup.user.management.service.api.RecommendationService;

/**
 * The class {@link RecommendationsRestResource} .
 */
public class RecommendationsRestResource
	extends
		AbstractRestfulResource<Integer, Recommendation, RecommendationService>
	implements
		RecommendationsResource
{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Recommendation> find(Triple<User, User, String> recommendation) {
		return getDomainService().find(recommendation.getLeft(), recommendation.getMiddle(), recommendation.getRight());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Recommendation findRecommendations(Triple<User, User, String> recommendation) {
		return getDomainService().findRecommendations(recommendation.getLeft(), recommendation.getMiddle(), recommendation.getRight());
	}

}
