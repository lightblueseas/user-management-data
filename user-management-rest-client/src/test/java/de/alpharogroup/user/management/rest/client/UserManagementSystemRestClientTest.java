/*
 * Copyright 2015 Alpha Ro Group UG (haftungsbeschrängt).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.alpharogroup.user.management.rest.client;

import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import de.alpharogroup.auth.models.AuthenticationErrors;
import de.alpharogroup.auth.models.AuthenticationResult;
import de.alpharogroup.user.management.domain.Contactmethod;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.rest.api.AuthenticationsResource;
import de.alpharogroup.user.management.rest.api.ContactmethodsResource;
import de.alpharogroup.user.management.rest.api.UsersResource;

/**
 * The class {@link UserManagementSystemRestClientTest}.
 */
public class UserManagementSystemRestClientTest {
	UserManagementSystemRestClient restClient;

	@BeforeClass
	public static void setUpClass() throws Exception {

	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@BeforeMethod
	public void setUpMethod() throws Exception {
		if (restClient == null) {
			restClient = new UserManagementSystemRestClient();
		}
	}

	@AfterMethod
	public void tearDownMethod() throws Exception {
	}

	/**
	 * Test the {@link ContactmethodsResource}.
	 *
	 * Note: you have to start a rest server to test this or you have to mock
	 * it.
	 */
	@Test(enabled = false)
	public void testContactmethodsResource() {
		ContactmethodsResource restResource = restClient.getContactmethodsResource();
		Contactmethod contact = restResource.read(12);
		
		Contactmethod compare = restResource.read(15);
		
		// http://localhost:8080/contactmethod/compare/{}/{}/
//		boolean result = restResource.compare(contact, compare);
//		System.out.println(result);

	}
	
	/**
	 * Test the {@link AuthenticationsResource}.
	 *
	 * Note: you have to start a rest server to test this or you have to mock
	 * it.
	 */
	@Test(enabled = true)
	public void testAuthenticationsResource() {
		AuthenticationsResource authenticationsResource = restClient.getAuthenticationsResource();
		
		UsersResource usersResource = restClient.getUsersResource();
		List<User> allUsers = usersResource.findAll();
		System.out.println(allUsers);
		
		AuthenticationResult<User, AuthenticationErrors>  result = authenticationsResource.authenticate("michael.knight@gmail.com", "xxx");
		
		AssertJUnit.assertNotNull(result);
		AssertJUnit.assertEquals(result.getUser().getUsername(), "michael.knight");
	}
}
