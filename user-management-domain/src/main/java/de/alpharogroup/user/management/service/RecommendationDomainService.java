package de.alpharogroup.user.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.management.daos.RecommendationsDao;
import de.alpharogroup.user.management.domain.Recommendation;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.entities.Recommendations;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.mapper.RecommendationsMapper;
import de.alpharogroup.user.management.service.api.RecommendationService;
import de.alpharogroup.user.management.service.api.RecommendationsService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link RecommendationDomainService}.
 */
public class RecommendationDomainService
		extends AbstractDomainService<Integer, Recommendation, Recommendations, RecommendationsDao, RecommendationsMapper>
		implements RecommendationService {

	/** The {@link RecommendationsService}. */
	@Autowired
	@Getter
	@Setter
	private RecommendationsService recommendationsService;

	/**
	 * Sets the specific {@link RecommendationsDao}.
	 *
	 * @param recommendationsDao
	 *            the new {@link RecommendationsDao}.
	 */
	@Autowired
	public void setRecommendationsDao(RecommendationsDao recommendationsDao) {
		setDao(recommendationsDao);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Recommendation> find(User user, User recommended, String email) {
		Users users = getMapper().map(user, Users.class);
		Users recommendeds = getMapper().map(recommended, Users.class);
		List<Recommendations> recommendations =recommendationsService.find(users, recommendeds, email);
		return getMapper().toDomainObjects(recommendations);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Recommendation findRecommendations(User user, User recommended, String email) {
		Users users = getMapper().map(user, Users.class);
		Users recommendeds = getMapper().map(recommended, Users.class);
		return getMapper().toDomainObject(recommendationsService.findRecommendations(users, recommendeds, email));
	}

}
