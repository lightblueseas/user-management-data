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
package de.alpharogroup.user.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.daos.RecommendationsDao;
import de.alpharogroup.user.management.domain.Recommendation;
import de.alpharogroup.user.management.entities.Recommendations;
import de.alpharogroup.user.management.mapper.RecommendationsMapper;
import de.alpharogroup.user.management.service.api.RecommendationService;
import de.alpharogroup.user.management.service.api.RecommendationsService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link RecommendationDomainService}.
 */
@Transactional
@Service("recommendationDomainService")
public class RecommendationDomainService
	extends
		AbstractDomainService<Integer, Recommendation, Recommendations, RecommendationsDao, RecommendationsMapper>
	implements
		RecommendationService
{

	/** The {@link RecommendationsService}. */
	@Autowired
	@Getter
	@Setter
	private RecommendationsService recommendationsService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Recommendation> find(final User user, final User recommended, final String email)
	{
		final Users users = getMapper().map(user, Users.class);
		final Users recommendeds = getMapper().map(recommended, Users.class);
		final List<Recommendations> recommendations = recommendationsService.find(users,
			recommendeds, email);
		return getMapper().toDomainObjects(recommendations);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Recommendation findRecommendations(final User user, final User recommended,
		final String email)
	{
		final Users users = getMapper().map(user, Users.class);
		final Users recommendeds = getMapper().map(recommended, Users.class);
		return getMapper()
			.toDomainObject(recommendationsService.findRecommendations(users, recommendeds, email));
	}

	/**
	 * Sets the specific {@link RecommendationsDao}.
	 *
	 * @param recommendationsDao
	 *            the new {@link RecommendationsDao}.
	 */
	@Autowired
	public void setRecommendationsDao(final RecommendationsDao recommendationsDao)
	{
		setDao(recommendationsDao);
	}

	/**
	 * Sets the specific {@link RecommendationsMapper}.
	 *
	 * @param mapper
	 *            the new {@link RecommendationsMapper}.
	 */
	@Autowired
	public void setRecommendationsMapper(RecommendationsMapper mapper)
	{
		setMapper(mapper);
	}

}
