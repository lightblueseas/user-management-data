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
package de.alpharogroup.user.management.rest.client;

import de.alpharogroup.address.book.rest.api.AddressesResource;
import de.alpharogroup.address.book.rest.api.CountriesResource;
import de.alpharogroup.address.book.rest.api.FederalstatesResource;
import de.alpharogroup.address.book.rest.api.ZipcodesResource;

import de.alpharogroup.resource.system.rest.api.ResourcesResource;

import de.alpharogroup.cxf.rest.client.AbstractRestClient;
import de.alpharogroup.user.management.rest.api.AuthenticationsResource;
import de.alpharogroup.user.management.rest.api.ContactmethodsResource;
import de.alpharogroup.user.rest.api.PermissionsResource;
import de.alpharogroup.user.management.rest.api.RecommendationsResource;
import de.alpharogroup.user.rest.api.RelationPermissionsResource;
import de.alpharogroup.user.rest.api.ResetPasswordsResource;
import de.alpharogroup.user.management.rest.api.RobinsonsResource;
import de.alpharogroup.user.rest.api.RolesResource;
import de.alpharogroup.user.management.rest.api.RuleViolationsResource;
import de.alpharogroup.user.management.rest.api.UserCreditsResource;
import de.alpharogroup.user.management.rest.api.UserDatasResource;
import de.alpharogroup.user.management.rest.api.UserManagementResource;
import de.alpharogroup.user.management.rest.api.UsersResource;
import lombok.Getter;

/**
 * The class {@link UserManagementSystemRestClient} is a rest client for the
 * dating-system that are persists in the database.
 */
public class UserManagementSystemRestClient extends AbstractRestClient
{

	/**
	 * The {@link AddressesResource}.
	 */
	@Getter
	private final AddressesResource addressesResource;

	/**
	 * The {@link CountriesResource}.
	 */
	@Getter
	private final CountriesResource countriesResource;

	/**
	 * The {@link FederalstatesResource}.
	 */
	@Getter
	private final FederalstatesResource federalstatesResource;

	/**
	 * The {@link ZipcodesResource}.
	 */
	@Getter
	private final ZipcodesResource zipcodesResource;

	/**
	 * The {@link ResourcesResource}.
	 */
	@Getter
	private final ResourcesResource resourcesResource;

	/**
	 * The {@link AuthenticationsResource}.
	 */
	@Getter
	private final AuthenticationsResource authenticationsResource;

	/**
	 * The {@link ContactmethodsResource}.
	 */
	@Getter
	private final ContactmethodsResource contactmethodsResource;

	/**
	 * The {@link PermissionsResource}.
	 */
	@Getter
	private final PermissionsResource permissionsResource;

	/**
	 * The {@link RecommendationsResource}.
	 */
	@Getter
	private final RecommendationsResource recommendationsResource;

	/**
	 * The {@link RelationPermissionsResource}.
	 */
	@Getter
	private final RelationPermissionsResource relationPermissionsResource;

	/**
	 * The {@link ResetPasswordsResource}.
	 */
	@Getter
	private final ResetPasswordsResource resetPasswordsResource;

	/**
	 * The {@link RobinsonsResource}.
	 */
	@Getter
	private final RobinsonsResource robinsonsResource;

	/**
	 * The {@link RolesResource}.
	 */
	@Getter
	private final RolesResource rolesResource;

	/**
	 * The {@link RuleViolationsResource}.
	 */
	@Getter
	private final RuleViolationsResource ruleViolationsResource;

	/**
	 * The {@link UserCreditsResource}.
	 */
	@Getter
	private final UserCreditsResource userCreditsResource;

	/**
	 * The {@link UserDatasResource}.
	 */
	@Getter
	private final UserDatasResource userDatasResource;

	/**
	 * The {@link UserDatasResource}.
	 */
	@Getter
	private final UserManagementResource userManagementResource;

	/**
	 * The {@link UsersResource}.
	 */
	@Getter
	private final UsersResource usersResource;

	/**
	 * Instantiates a new {@link UserManagementSystemRestClient} with the default base url.
	 */
	public UserManagementSystemRestClient()
	{
		this(DEFAULT_BASE_HTTP_URL);
	}

	/**
	 * Instantiates a new {@link UserManagementSystemRestClient}.
	 *
	 * @param baseUrl
	 *            the base url
	 */
	public UserManagementSystemRestClient(final String baseUrl)
	{
		super(baseUrl);
		authenticationsResource = newResource(AuthenticationsResource.class);
		contactmethodsResource = newResource(ContactmethodsResource.class);
		permissionsResource = newResource(PermissionsResource.class);
		recommendationsResource = newResource(RecommendationsResource.class);
		relationPermissionsResource = newResource(RelationPermissionsResource.class);
		resetPasswordsResource = newResource(ResetPasswordsResource.class);
		robinsonsResource = newResource(RobinsonsResource.class);
		rolesResource = newResource(RolesResource.class);
		ruleViolationsResource = newResource(RuleViolationsResource.class);
		userCreditsResource = newResource(UserCreditsResource.class);
		userDatasResource = newResource(UserDatasResource.class);
		userManagementResource = newResource(UserManagementResource.class);
		usersResource = newResource(UsersResource.class);

		addressesResource = newResource(AddressesResource.class);
		countriesResource = newResource(CountriesResource.class);
		federalstatesResource = newResource(FederalstatesResource.class);
		zipcodesResource =  newResource(ZipcodesResource.class);

        	resourcesResource  = newResource(ResourcesResource.class);
	}

}
