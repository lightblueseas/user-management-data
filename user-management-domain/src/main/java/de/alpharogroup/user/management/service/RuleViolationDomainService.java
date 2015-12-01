package de.alpharogroup.user.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.management.application.models.InfringementModel;
import de.alpharogroup.user.management.daos.RuleViolationsDao;
import de.alpharogroup.user.management.domain.RuleViolation;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.entities.RuleViolations;
import de.alpharogroup.user.management.enums.RuleViolationReason;
import de.alpharogroup.user.management.mapper.RuleViolationsMapper;
import de.alpharogroup.user.management.service.api.RuleViolationService;
import de.alpharogroup.user.management.service.api.RuleViolationsService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link RuleViolationDomainService}.
 */
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
	public void setRuleViolationsDao(RuleViolationsDao ruleViolationsDao) {
		setDao(ruleViolationsDao);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RuleViolation save(InfringementModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RuleViolation> find(User detector, User violator, RuleViolationReason reason, String description) {
		// TODO Auto-generated method stub
		return null;
	}
}
