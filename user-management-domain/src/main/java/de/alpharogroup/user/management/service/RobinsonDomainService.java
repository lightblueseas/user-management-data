package de.alpharogroup.user.management.service;

import org.springframework.beans.factory.annotation.Autowired;

import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.management.daos.RobinsonsDao;
import de.alpharogroup.user.management.domain.Robinson;
import de.alpharogroup.user.management.entities.Robinsons;
import de.alpharogroup.user.management.mapper.RobinsonsMapper;
import de.alpharogroup.user.management.service.api.RobinsonService;
import de.alpharogroup.user.management.service.api.RobinsonsService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link RobinsonDomainService}.
 */
public class RobinsonDomainService extends
		AbstractDomainService<Integer, Robinson, Robinsons, RobinsonsDao, RobinsonsMapper> implements RobinsonService {

	/** The {@link RobinsonsService}. */
	@Autowired
	@Getter
	@Setter
	private RobinsonsService robinsonsService;

	/**
	 * Sets the specific {@link RobinsonsDao}.
	 *
	 * @param robinsonsDao
	 *            the new {@link RobinsonsDao}.
	 */
	@Autowired
	public void setRobinsonsDao(RobinsonsDao robinsonsDao) {
		setDao(robinsonsDao);
	}
}
