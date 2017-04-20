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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.application.models.InfringementModel;
import de.alpharogroup.user.management.daos.RuleViolationsDao;
import de.alpharogroup.user.management.entities.RuleViolations;
import de.alpharogroup.user.management.enums.RuleViolationReason;
import de.alpharogroup.user.management.factories.UserManagementFactory;
import de.alpharogroup.user.management.service.api.RuleViolationsService;
import de.alpharogroup.user.management.service.util.HqlStringCreator;

@Transactional
@Service("ruleViolationsService")
public class RuleViolationsBusinessService
	extends
		AbstractBusinessService<RuleViolations, Integer, RuleViolationsDao>
	implements
		RuleViolationsService
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<RuleViolations> find(Users detector, Users violator, RuleViolationReason reason,
		String description)
	{
		String hqlString = HqlStringCreator.forRuleViolations(detector, violator, reason,
			description);
		final Query query = getQuery(hqlString);
		if (detector != null)
		{
			query.setParameter("detector", detector);
		}
		if (violator != null)
		{
			query.setParameter("violator", violator);
		}
		if (reason != null)
		{
			query.setParameter("reason", reason);
		}
		if (description != null && !description.isEmpty())
		{
			query.setParameter("description", description);
		}
		final List<RuleViolations> ruleViolations = query.getResultList();
		return ruleViolations;
	}

	public RuleViolations save(InfringementModel model)
	{
		RuleViolations ruleViolations = UserManagementFactory.getInstance().newRuleViolations(
			model.getDetector(), model.getViolator(), model.getDescription(), model.getReason());
		return merge(ruleViolations);
	}

	@Autowired
	public void setRuleViolationsDao(RuleViolationsDao ruleViolationsDao)
	{
		setDao(ruleViolationsDao);
	}

}