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
package de.alpharogroup.user.management.service.api;

import java.util.List;

import de.alpharogroup.service.domain.DomainService;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.management.domain.Recommendation;
import de.alpharogroup.user.management.entities.Recommendations;

/**
 * The interface {@link RecommendationService}.
 */
public interface RecommendationService extends DomainService<Integer, Recommendation>
{

	/**
	 * Find all the {@link Recommendation} objects from the given parameters.
	 *
	 * @param user
	 *            the user the recommended another user
	 * @param recommended
	 *            the recommended user
	 * @param email
	 *            the email where to send the recommendation
	 * @return the list of found {@link Recommendations} objects.
	 */
	List<Recommendation> find(User user, User recommended, String email);

	/**
	 * Find the {@link Recommendations} object from the given parameters.
	 *
	 * @param user
	 *            the user
	 * @param recommended
	 *            the recommended
	 * @param email
	 *            the email
	 * @return the found {@link Recommendations} object
	 */
	Recommendation findRecommendations(User user, User recommended, String email);
}
