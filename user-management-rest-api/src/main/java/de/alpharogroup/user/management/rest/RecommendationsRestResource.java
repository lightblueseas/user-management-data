package de.alpharogroup.user.management.rest;


import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.domain.Recommendation;
import de.alpharogroup.user.management.rest.api.RecommendationsResource;
import de.alpharogroup.user.management.service.api.RecommendationService;

public class RecommendationsRestResource
	extends
		AbstractRestfulResource<Integer, Recommendation, RecommendationService>
	implements
		RecommendationsResource
{

}
