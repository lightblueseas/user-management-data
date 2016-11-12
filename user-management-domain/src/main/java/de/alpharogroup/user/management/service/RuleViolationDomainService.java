package de.alpharogroup.user.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.lang.object.CopyObjectExtensions;
import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.management.application.models.InfringementModel;
import de.alpharogroup.user.management.daos.RuleViolationsDao;
import de.alpharogroup.user.management.domain.RuleViolation;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.domain.model.Infringement;
import de.alpharogroup.user.management.entities.RuleViolations;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.enums.RuleViolationReason;
import de.alpharogroup.user.management.mapper.RuleViolationsMapper;
import de.alpharogroup.user.management.service.api.RuleViolationService;
import de.alpharogroup.user.management.service.api.RuleViolationsService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link RuleViolationDomainService}.
 */
@Transactional
@Service("ruleViolationDomainService")
public class RuleViolationDomainService
		extends AbstractDomainService<Integer, RuleViolation, RuleViolations, RuleViolationsDao, RuleViolationsMapper>
		implements RuleViolationService {

	/** The {@link RuleViolationsService}. */
	@Autowired
	@Getter
	@Setter
	private RuleViolationsService ruleViolationsService;

	/**
	 * Sets the specific {@link RuleViolationsDao}.
	 *
	 * @param ruleViolationsDao
	 *            the new {@link RuleViolationsDao}.
	 */
	@Autowired
	public void setRuleViolationsDao(final RuleViolationsDao ruleViolationsDao) {
		setDao(ruleViolationsDao);
	}

	/**
	 * Sets the specific {@link RuleViolationsMapper}.
	 *
	 * @param mapper
	 *            the new {@link RuleViolationsMapper}.
	 */
	@Autowired
	public void setRuleViolationsMapper(RuleViolationsMapper mapper) {
		setMapper(mapper);
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Deprecated
	@Override
	public RuleViolation save(final InfringementModel model) {
		
		final RuleViolations ruleViolations = ruleViolationsService.save(model);
		return getMapper().toDomainObject(ruleViolations);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RuleViolation save(Infringement model) {
		InfringementModel infringementModel = InfringementModel.builder().build();
		CopyObjectExtensions.copyQuietly(model, infringementModel);
		final RuleViolations ruleViolations = ruleViolationsService.save(infringementModel);
		return getMapper().toDomainObject(ruleViolations);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RuleViolation> find(final User detector, final User violator, final RuleViolationReason reason, final String description) {
		final Users detectors = getMapper().map(detector, Users.class);
		final Users violators = getMapper().map(violator, Users.class);
		final List<RuleViolations> ruleViolations = ruleViolationsService.find(detectors, violators, reason, description);
		return getMapper().toDomainObjects(ruleViolations);
	}

}
