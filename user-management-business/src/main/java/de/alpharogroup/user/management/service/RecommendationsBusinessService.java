package de.alpharogroup.user.management.service;

import java.util.List;

import javax.persistence.Query;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.management.daos.RecommendationsDao;
import de.alpharogroup.user.management.entities.Recommendations;
import de.alpharogroup.user.management.entities.Users;

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