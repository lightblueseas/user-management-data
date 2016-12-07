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

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import de.alpharogroup.auth.Credentials;
import de.alpharogroup.auth.models.AuthenticationErrors;
import de.alpharogroup.auth.models.AuthenticationResult;
import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.collections.pairs.Triple;
import de.alpharogroup.user.management.domain.Contactmethod;
import de.alpharogroup.user.management.domain.Permission;
import de.alpharogroup.user.management.domain.Recommendation;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.enums.ContactmethodType;
import de.alpharogroup.user.management.rest.api.AuthenticationsResource;
import de.alpharogroup.user.management.rest.api.ContactmethodsResource;
import de.alpharogroup.user.management.rest.api.PermissionsResource;
import de.alpharogroup.user.management.rest.api.RecommendationsResource;
import de.alpharogroup.user.management.rest.api.RelationPermissionsResource;
import de.alpharogroup.user.management.rest.api.ResetPasswordsResource;
import de.alpharogroup.user.management.rest.api.RobinsonsResource;
import de.alpharogroup.user.management.rest.api.RolesResource;
import de.alpharogroup.user.management.rest.api.RuleViolationsResource;
import de.alpharogroup.user.management.rest.api.UserCreditsResource;
import de.alpharogroup.user.management.rest.api.UserDatasResource;
import de.alpharogroup.user.management.rest.api.UserManagementResource;
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
	 * Test the {@link AuthenticationsResource}.
	 *
	 * Note: you have to start a rest server to test this or you have to mock
	 * it.
	 */
	@Test(enabled = false)
	public void testAuthenticationsResource() {
		AuthenticationsResource authenticationsResource = restClient.getAuthenticationsResource();
		
		UsersResource usersResource = restClient.getUsersResource();
		List<User> allUsers = usersResource.findAll();
		System.out.println(allUsers);

		// http://localhost:8080/auth/compare/find/michael.knight/xxx
		AuthenticationResult<User, AuthenticationErrors>  result = authenticationsResource.authenticate("michael.knight@gmail.com", "xxx");
		
		AssertJUnit.assertNotNull(result);
		AssertJUnit.assertEquals(result.getUser().getUsername(), "michael.knight");		

		Credentials credentials = Credentials.builder().username("michael.knight").password("xxx").build();
		
		Response tokenResponse = authenticationsResource.authenticate(credentials);
		String token = tokenResponse.readEntity(String.class);
		AssertJUnit.assertNotNull(token);
	}
	
	/**
	 * Test the {@link ContactmethodsResource}.
	 *
	 * Note: you have to start a rest server to test this or you have to mock
	 * it.
	 */
	@Test(enabled = true)
	public void testContactmethodsResource() {
		AuthenticationsResource authenticationsResource = restClient.getAuthenticationsResource();
		ContactmethodsResource resource = restClient.getContactmethodsResource();
		AssertJUnit.assertNotNull(resource);
		
		String email = "michael.knight@gmail.com";
				
		KeyValuePair<Contactmethod, Contactmethod> comparison = 
				KeyValuePair.<Contactmethod, Contactmethod>builder()
				.key(Contactmethod.builder()
						.contactmethod(ContactmethodType.EMAIL)
						.contactvalue(email)
						.build())
				.value(Contactmethod.builder()
						.contactmethod(ContactmethodType.EMAIL)
						.contactvalue(email)
						.build())
				.build();
		// http://localhost:8080/contactmethod/compare/contactmethod/
		boolean actual = resource.compare(comparison);

		boolean expected = true;
		AssertJUnit.assertEquals(expected, actual);
		
		comparison.getValue().setContactvalue("james.dean@gmail.com");

		actual = resource.compare(comparison);
		
		expected = false;
		AssertJUnit.assertEquals(expected, actual);

		// http://localhost:8080/contactmethod/exists/michael.knight@gmail.com
		KeyValuePair<String, ContactmethodType> contactMethod = 
				KeyValuePair.<String, ContactmethodType>builder()
				.key(email)
				.value(ContactmethodType.EMAIL)
				.build();
		Credentials credentials = Credentials.builder().username("michael.knight").password("xxx").build();
		
		Response tokenResponse = authenticationsResource.authenticate(credentials);
		String token = tokenResponse.readEntity(String.class);
		WebClient.client(resource).header("Authorization", "Bearer " + token);
		actual = resource.existsContact(contactMethod);
		expected = true;
		AssertJUnit.assertEquals(expected, actual);

		List<Contactmethod> cms = resource.findContact(contactMethod);		
		AssertJUnit.assertNotNull(cms);
		
		cms = resource.find(contactMethod);		
		AssertJUnit.assertNotNull(cms);
		
		KeyValuePair<ContactmethodType, User> contactMethodsFromUser = 
				KeyValuePair.<ContactmethodType, User>builder()
				.key(ContactmethodType.EMAIL)
				.value(getTestUser())
				.build();
		
		cms = resource.findContactmethod(contactMethodsFromUser);	
		AssertJUnit.assertNotNull(cms);	
		
		Contactmethod cm = Contactmethod.builder()
				.contactvalue("foo@bar.org")
				.contactmethod(ContactmethodType.EMAIL)
				.build();
		cm = resource.create(cm);	
		AssertJUnit.assertNotNull(cms);	
		cm.setContactvalue("foo.bla@bar.org");
		
		resource.update(cm);
		
		cm = resource.read(cm.getId());
		AssertJUnit.assertEquals(cm.getContactvalue(), "foo.bla@bar.org");
		
		resource.delete(cm.getId());
		
		cm = resource.read(cm.getId());
		
		AssertJUnit.assertNull(cm);
		
	}
	
	/**
	 * Test the {@link PermissionsResource}.
	 *
	 * Note: you have to start a rest server to test this or you have to mock
	 * it.
	 */
	@Test(enabled = false)
	public void testPermissionsResource() {
		PermissionsResource resource = restClient.getPermissionsResource();
		
		String permissionName = "delete";
		
		Permission expected = Permission.builder()
				.permissionName(permissionName)
				.shortcut("del")
				.description("Delete file")
				.build();
		
		Permission actual = resource.findByName(expected.getPermissionName());
		
		if(actual == null) {
			actual = resource.create(expected);
		}

		AssertJUnit.assertEquals(expected, actual);
		
	}
	

	
	/**
	 * Test the {@link RecommendationsResource}.
	 *
	 * Note: you have to start a rest server to test this or you have to mock
	 * it.
	 */
	@Test(enabled = false)
	public void testRecommendationsResource() {
		UsersResource usersResource = restClient.getUsersResource();
		RecommendationsResource recommendationsResource = restClient.getRecommendationsResource();
		String sendToEmail = "foo@bar.org";
		String promoterEmail ="michael.knight@gmail.com";
		String recommendedUserEmail = "james.dean@gmail.com";
		User promoter = usersResource.findUserWithEmail(promoterEmail);
		User recommendedUser = usersResource.findUserWithEmail(recommendedUserEmail);

		
		Recommendation expected = Recommendation.builder()
				.email(sendToEmail)
				.user(promoter)
				.recommended(recommendedUser)
				.invitationText("See this profile is cool.")
				.sent(Boolean.FALSE)
				.build();
		Triple<User, User, String> searchCriteria = Triple.<User, User, String>builder().left(promoter).middle(recommendedUser).right(sendToEmail).build();
		Recommendation actual = recommendationsResource.findRecommendations(searchCriteria);
		
		if(actual == null) {
			actual = recommendationsResource.create(expected);
		}

		AssertJUnit.assertEquals(expected.getEmail(), actual.getEmail());
		AssertJUnit.assertEquals(expected.getInvitationText(), actual.getInvitationText());		
	}
	
	public User getTestUser() {
		UsersResource usersResource = restClient.getUsersResource();
		String promoterEmail ="michael.knight@gmail.com";
		User testUser = usersResource.findUserWithEmail(promoterEmail);
		return testUser;
	}
	
	/**
	 * Test the {@link RelationPermissionsResource}.
	 *
	 * Note: you have to start a rest server to test this or you have to mock
	 * it.
	 */
	@Test(enabled = false)
	public void testRelationPermissionsResource() {
		RelationPermissionsResource resource = restClient.getRelationPermissionsResource();

		AssertJUnit.assertNotNull(resource);
	}
	
	/**
	 * Test the {@link ResetPasswordsResource}.
	 *
	 * Note: you have to start a rest server to test this or you have to mock
	 * it.
	 */
	@Test(enabled = false)
	public void testResetPasswordsResource() {
		ResetPasswordsResource resource = restClient.getResetPasswordsResource();

		AssertJUnit.assertNotNull(resource);
	}
	
	/**
	 * Test the {@link RobinsonsResource}.
	 *
	 * Note: you have to start a rest server to test this or you have to mock
	 * it.
	 */
	@Test(enabled = false)
	public void testRobinsonsResource() {
		RobinsonsResource resource = restClient.getRobinsonsResource();
		AssertJUnit.assertNotNull(resource);
	}
	
	/**
	 * Test the {@link RolesResource}.
	 *
	 * Note: you have to start a rest server to test this or you have to mock
	 * it.
	 */
	@Test(enabled = false)
	public void testRolesResource() {
		RolesResource resource = restClient.getRolesResource();
		AssertJUnit.assertNotNull(resource);
	}
	
	/**
	 * Test the {@link RuleViolationsResource}.
	 *
	 * Note: you have to start a rest server to test this or you have to mock
	 * it.
	 */
	@Test(enabled = false)
	public void testRuleViolationsResource() {
		RuleViolationsResource resource = restClient.getRuleViolationsResource();
		AssertJUnit.assertNotNull(resource);
	}
	
	/**
	 * Test the {@link UserCreditsResource}.
	 *
	 * Note: you have to start a rest server to test this or you have to mock
	 * it.
	 */
	@Test(enabled = false)
	public void testUserCreditsResource() {
		UserCreditsResource resource = restClient.getUserCreditsResource();
		AssertJUnit.assertNotNull(resource);
	}
	
	/**
	 * Test the {@link UserDatasResource}.
	 *
	 * Note: you have to start a rest server to test this or you have to mock
	 * it.
	 */
	@Test(enabled = false)
	public void testUserDatasResource() {
		UserDatasResource resource = restClient.getUserDatasResource();
		AssertJUnit.assertNotNull(resource);
	}
	
	/**
	 * Test the {@link UserManagementResource}.
	 *
	 * Note: you have to start a rest server to test this or you have to mock
	 * it.
	 */
	@Test(enabled = false)
	public void testUserManagementResource() {
		UserManagementResource resource = restClient.getUserManagementResource();
		AssertJUnit.assertNotNull(resource);
	}
	
	/**
	 * Test the {@link UsersResource}.
	 *
	 * Note: you have to start a rest server to test this or you have to mock
	 * it.
	 */
	@Test(enabled = false)
	public void testUsersResource() {
		UsersResource resource = restClient.getUsersResource();

		String userEmail = "james.dean@gmail.com";
		User expected = resource.findUserWithEmail(userEmail);

		AssertJUnit.assertEquals(expected.getUsername(), "james.dean");
	}
}
