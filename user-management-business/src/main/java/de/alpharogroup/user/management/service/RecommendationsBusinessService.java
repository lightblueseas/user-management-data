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

import javax.persistence.Query;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.management.daos.RecommendationsDao;
import de.alpharogroup.user.management.entities.Recommendations;
import de.alpharogroup.user.entities.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.user.management.service.api.RecommendationsService;
import de.alpharogroup.user.management.service.util.HqlStringCreator;

@Transactional
@Service("recommendationsService")
public class RecommendationsBusinessService extends AbstractBusinessService<Recommendations, Integer, RecommendationsDao> implements RecommendationsService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setRecommendationsDao(RecommendationsDao recommendationsDao) {
		setDao(recommendationsDao);
	}	
	
	public Recommendations findRecommendations(Users user, Users recommended,  String email) {
		return ListExtensions.getFirst(find(user, recommended, email));
	}
	
	@SuppressWarnings("unchecked")
	public List<Recommendations> find(Users user, Users recommended,  String email) {
		String hqlString = HqlStringCreator.forRecommendations(user, recommended, email);
		final Query query = getQuery(hqlString);
		if(user != null){
			query.setParameter("user", user);
		}
		if(recommended != null){
			query.setParameter("recommended", recommended);
		}
		if(email != null){
			query.setParameter("email", email);			
		}
		final List<Recommendations> recommendations = query.getResultList();
		return recommendations;		
	}

}