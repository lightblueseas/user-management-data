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
import de.alpharogroup.user.management.application.models.InfringementModel;
import de.alpharogroup.user.management.domain.RuleViolation;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.management.domain.model.Infringement;
import de.alpharogroup.user.management.enums.RuleViolationReason;

/**
 * The interface {@link RuleViolationService}.
 */
public interface RuleViolationService extends DomainService<Integer, RuleViolation> {

	/**
	 * Persist the given domain object {@link InfringementModel}.
	 *
	 * @param model the model
	 * @return the persisted {@link RuleViolation} object.
	 * @deprecated use instead {@link RuleViolationService#save(Infringement)}
	 */
	@Deprecated
	RuleViolation save(InfringementModel model);
	
	/**
	 * Persist the given domain object {@link Infringement}.
	 *
	 * @param model the model
	 * @return the persisted {@link RuleViolation} object.
	 */
	RuleViolation save(Infringement model);
	
	/**
	 * Find a all {@link RuleViolation} objects from the given arguments.
	 *
	 * @param detector the detector
	 * @param violator the violator
	 * @param reason the reason
	 * @param description the description
	 * @return the found {@link RuleViolation} objects.
	 */
	List<RuleViolation> find(User detector, User violator, RuleViolationReason reason, String description);
}
