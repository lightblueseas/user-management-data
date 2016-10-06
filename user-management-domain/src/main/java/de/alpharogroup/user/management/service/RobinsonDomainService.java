package de.alpharogroup.user.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
@Service("robinsonDomainService")
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
	public void setRobinsonsDao(final RobinsonsDao robinsonsDao) {
		setDao(robinsonsDao);
	}

	/**
	 * Sets the specific {@link RobinsonsMapper}.
	 *
	 * @param mapper
	 *            the new {@link RobinsonsMapper}.
	 */
	@Autowired
	public void setRobinsonsMapper(RobinsonsMapper mapper) {
		setMapper(mapper);
	}
	
}
