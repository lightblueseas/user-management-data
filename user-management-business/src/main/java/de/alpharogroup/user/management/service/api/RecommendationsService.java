package de.alpharogroup.user.management.service.api;

import java.util.List;

import de.alpharogroup.db.service.jpa.BusinessService;
import de.alpharogroup.user.management.entities.Recommendations;
import de.alpharogroup.user.management.entities.Users;

public interface RecommendationsService extends BusinessService<Recommendations, Integer> {
	List<Recommendations> find(Users user, Users recommended,  String email);
	Recommendations findRecommendations(Users user, Users recommended,  String email);
}