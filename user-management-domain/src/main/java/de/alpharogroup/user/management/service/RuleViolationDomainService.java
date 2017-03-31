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
import de.alpharogroup.user.management.application.models.InfringementModel;
import de.alpharogroup.user.management.daos.RuleViolationsDao;
import de.alpharogroup.user.management.domain.RuleViolation;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.management.domain.model.Infringement;
import de.alpharogroup.user.management.entities.RuleViolations;
import de.alpharogroup.user.entities.Users;
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
	extends
		AbstractDomainService<Integer, RuleViolation, RuleViolations, RuleViolationsDao, RuleViolationsMapper>
	implements
		RuleViolationService
{

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
	public void setRuleViolationsDao(final RuleViolationsDao ruleViolationsDao)
	{
		setDao(ruleViolationsDao);
	}

	/**
	 * Sets the specific {@link RuleViolationsMapper}.
	 *
	 * @param mapper
	 *            the new {@link RuleViolationsMapper}.
	 */
	@Autowired
	public void setRuleViolationsMapper(final RuleViolationsMapper mapper)
	{
		setMapper(mapper);
	}

	/**
	 * {@inheritDoc}
	 */
	@Deprecated
	@Override
	public RuleViolation save(final InfringementModel model)
	{

		final RuleViolations ruleViolations = ruleViolationsService.save(model);
		return getMapper().toDomainObject(ruleViolations);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RuleViolation save(final Infringement model)
	{
		final InfringementModel infringementModel = toInfringementModel(model);
		final RuleViolations ruleViolations = ruleViolationsService.save(infringementModel);
		return getMapper().toDomainObject(ruleViolations);
	}

	private InfringementModel toInfringementModel(final Infringement model)
	{
		return InfringementModel.builder()
			.violator(getMapper().map(model.getViolator(), Users.class))
			.detector(getMapper().map(model.getDetector(), Users.class))
			.description(model.getDescription()).reason(model.getReason()).build();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RuleViolation> find(final User detector, final User violator,
		final RuleViolationReason reason, final String description)
	{
		final Users detectors = getMapper().map(detector, Users.class);
		final Users violators = getMapper().map(violator, Users.class);
		final List<RuleViolations> ruleViolations = ruleViolationsService.find(detectors, violators,
			reason, description);
		return getMapper().toDomainObjects(ruleViolations);
	}

}
