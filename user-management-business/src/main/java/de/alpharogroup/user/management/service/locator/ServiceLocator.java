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
package de.alpharogroup.user.management.service.locator;

import de.alpharogroup.user.management.service.api.ContactmethodsService;
import de.alpharogroup.user.management.service.api.RecommendationsService;
import de.alpharogroup.user.management.service.api.RobinsonsService;
import de.alpharogroup.user.management.service.api.RuleViolationsService;
import de.alpharogroup.user.management.service.api.UserCreditsService;
import de.alpharogroup.user.management.service.api.UserDatasService;
import de.alpharogroup.user.management.service.api.UsersManagementService;
import de.alpharogroup.user.management.service.api.UsersService;
import de.alpharogroup.user.service.api.PermissionsService;
import de.alpharogroup.user.service.api.RelationPermissionsService;
import de.alpharogroup.user.service.api.ResetPasswordsService;
import de.alpharogroup.user.service.api.RolesService;

public interface ServiceLocator
{


	/**
	 * Gets the contactmethods service.
	 *
	 * @return the contactmethods service
	 */
	ContactmethodsService getContactmethodsService();

	/**
	 * Gets the permission service.
	 *
	 * @return the permission service
	 */
	PermissionsService getPermissionsService();

	/**
	 * Gets the RecommendationsService.
	 *
	 * @return the RecommendationsService.
	 */
	RecommendationsService getRecommendationsService();

	/**
	 * Gets the RelationPermissionsService.
	 *
	 * @return the RelationPermissionsService.
	 */
	RelationPermissionsService getRelationPermissionsService();

	/**
	 * Gets the reset passwords service.
	 *
	 * @return the reset passwords service
	 */
	ResetPasswordsService getResetPasswordsService();

	/**
	 * Gets the robinsons service.
	 *
	 * @return the robinsons service
	 */
	RobinsonsService getRobinsonsService();

	/**
	 * Gets the roles service.
	 *
	 * @return the roles service
	 */
	RolesService getRolesService();

	/**
	 * Gets the rule violations service.
	 *
	 * @return the rule violations service
	 */
	RuleViolationsService getRuleViolationsService();

	/**
	 * Gets the user credits service.
	 *
	 * @return the user credits service
	 */
	UserCreditsService getUserCreditsService();

	/**
	 * Gets the user data service.
	 *
	 * @return the user data service
	 */
	UserDatasService getUserDatasService();

	/**
	 * Gets the user management service.
	 *
	 * @return the user management service
	 */
	UsersManagementService getUserManagementService();

	/**
	 * Gets the users service.
	 *
	 * @return the users service
	 */
	UsersService getUsersService();

	/**
	 * Sets the contactmethods service.
	 *
	 * @param contactmethodsService
	 *            the new contactmethods service
	 */
	void setContactmethodsService(ContactmethodsService contactmethodsService);

	/**
	 * Sets the permission business service.
	 *
	 * @param permissionService
	 *            the new permission business service
	 */
	void setPermissionsService(PermissionsService permissionService);

	/**
	 * Sets the RecommendationsService.
	 *
	 * @param recommendationsService
	 *            the new RecommendationsService
	 */
	void setRecommendationsService(RecommendationsService recommendationsService);

	/**
	 * Sets the RelationPermissionsService.
	 *
	 * @param relationPermissionsService
	 *            the new RelationPermissionsService
	 */
	void setRelationPermissionsService(RelationPermissionsService relationPermissionsService);

	/**
	 * Sets the reset passwords business service.
	 *
	 * @param resetPasswordsService
	 *            the new reset passwords business service
	 */
	void setResetPasswordsService(ResetPasswordsService resetPasswordsService);

	/**
	 * Sets the robinsons service.
	 *
	 * @param robinsonsService
	 *            the new robinsons service
	 */
	void setRobinsonsService(RobinsonsService robinsonsService);

	/**
	 * Sets the roles service.
	 *
	 * @param rolesService
	 *            the new roles service
	 */
	void setRolesService(RolesService rolesService);

	/**
	 * Sets the rule violations service.
	 *
	 * @param ruleViolationsService
	 *            the new rule violations service
	 */
	void setRuleViolationsService(RuleViolationsService ruleViolationsService);

	/**
	 * Sets the user credits service.
	 *
	 * @param userCreditsService
	 *            the user credits service
	 */
	void setUserCreditsService(UserCreditsService userCreditsService);

	/**
	 * Sets the user data service.
	 *
	 * @param userDataService
	 *            the user data service
	 */
	void setUserDatasService(UserDatasService userDataService);

	/**
	 * Sets the user management service.
	 *
	 * @param userManagementService
	 *            the new user management service
	 */
	void setUserManagementService(UsersManagementService userManagementService);

	/**
	 * Sets the users business service.
	 *
	 * @param usersService
	 *            the new users business service
	 */
	void setUsersService(UsersService usersService);

}
