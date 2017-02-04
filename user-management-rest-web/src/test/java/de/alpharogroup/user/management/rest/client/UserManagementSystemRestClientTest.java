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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.ws.rs.core.Response;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.configuration.security.FiltersType;
import org.apache.cxf.jaxrs.client.WebClient;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import de.alpharogroup.auth.Credentials;
import de.alpharogroup.auth.token.AuthToken;
import de.alpharogroup.collections.SetExtensions;
import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.collections.pairs.Triple;
import de.alpharogroup.cxf.rest.client.AbstractRestClient;
import de.alpharogroup.cxf.rest.client.WebClientExtensions;
import de.alpharogroup.date.CalculateDateExtensions;
import de.alpharogroup.date.CreateDateExtensions;
import de.alpharogroup.date.DateExtensions;
import de.alpharogroup.file.search.PathFinder;
import de.alpharogroup.user.management.domain.Contactmethod;
import de.alpharogroup.user.management.domain.Permission;
import de.alpharogroup.user.management.domain.Recommendation;
import de.alpharogroup.user.management.domain.RelationPermission;
import de.alpharogroup.user.management.domain.ResetPassword;
import de.alpharogroup.user.management.domain.Robinson;
import de.alpharogroup.user.management.domain.Role;
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

	private TLSClientParameters tlsClientParameters;

	private UserManagementSystemRestClient restClient;

	private AuthenticationsResource authenticationsResource;

	private UsersResource usersResource;
	
	private PermissionsResource permissionsResource;
	

	@BeforeClass
	public static void setUpClass() throws Exception {

	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@BeforeMethod
	public void setUpMethod() throws Exception {
		if (restClient == null) {
			restClient = new UserManagementSystemRestClient(AbstractRestClient.DEFAULT_BASE_HTTPS_URL);
			tlsClientParameters = getTLSClientParameters();
			authenticationsResource = restClient.getAuthenticationsResource();

			usersResource = restClient.getUsersResource();
			permissionsResource = restClient.getPermissionsResource();
			// set client params with key and trust managers. The keystore is the same as jetty
			WebClientExtensions.setTLSClientParameters(authenticationsResource, tlsClientParameters);
			WebClientExtensions.setTLSClientParameters(usersResource, tlsClientParameters);
			WebClientExtensions.setTLSClientParameters(permissionsResource, tlsClientParameters);
		}
	}

	@AfterMethod
	public void tearDownMethod() throws Exception {
	}

	/**
	 * Gets the TLS client parameters.
	 *
	 * @return the TLS client parameters
	 * @throws UnrecoverableKeyException the unrecoverable key exception
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws CertificateException the certificate exception
	 * @throws FileNotFoundException the file not found exception
	 * @throws KeyStoreException the key store exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public TLSClientParameters getTLSClientParameters() throws UnrecoverableKeyException, NoSuchAlgorithmException,
			CertificateException, FileNotFoundException, KeyStoreException, IOException {
		return WebClientExtensions.newTLSClientParameters(PathFinder.getSrcTestResourcesDir(), "keystore.ks", "JKS", "wicket");
	}
	
	/**
	 * Test the {@link AuthenticationsResource}.
	 *
	 * Note: you have to start a rest server to test this or you have to mock
	 * it.
	 */
	@Test(enabled = true)
	public void testAuthenticationsResource() {
		Credentials credentials = Credentials.builder().username("michael.knight").password("xxx").build();			

		// final String json = JsonTransformer.toJsonQuietly(credentials);
		// {"username":"michael.knight","password":"xxx"}
		// https://localhost:8443/auth/credentials
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
	@Test(enabled = false)
	public void testContactmethodsResource() {
		ContactmethodsResource resource = restClient.getContactmethodsResource();
		// set client params with key and trust managers. The keystore is the same as jetty
		WebClientExtensions.setTLSClientParameters(resource, tlsClientParameters);
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
				.value(getPromoterUser())
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
	@Test(enabled = true)
	public void testPermissionsResource() {
		
		String permissionName = "view_user_images";
		
		Permission expected = Permission.builder()
				.permissionName(permissionName)
				.shortcut("vui")
				.description("This permission grant to view the images of a user")
				.build();
		
		Permission actual = permissionsResource.findByName(expected.getPermissionName());
		
		if(actual == null) {
			actual = permissionsResource.create(expected);
		}

		AssertJUnit.assertEquals(expected.getDescription(), actual.getDescription());
		AssertJUnit.assertEquals(expected.getPermissionName(), actual.getPermissionName());
		AssertJUnit.assertEquals(expected.getShortcut(), actual.getShortcut());
		
	}
	

	
	/**
	 * Test the {@link RecommendationsResource}.
	 *
	 * Note: you have to start a rest server to test this or you have to mock
	 * it.
	 */
	@Test(enabled = true)
	public void testRecommendationsResource() {
		RecommendationsResource recommendationsResource = restClient.getRecommendationsResource();
		// set client params with key and trust managers. The keystore is the same as jetty
		WebClientExtensions.setTLSClientParameters(recommendationsResource, tlsClientParameters);
		AssertJUnit.assertNotNull(recommendationsResource);
		String sendToEmail = "foo@bar.org";
		User promoter = getPromoterUser();
		User recommendedUser = getRecommendedUser();
		
		Recommendation expected = Recommendation.builder()
				.email(sendToEmail)
				.user(promoter)
				.recommended(recommendedUser)
				.invitationText("See this profile is cool.")
				.sent(Boolean.FALSE)
				.build();
		Triple<User, User, String> searchCriteria = Triple.<User, User, String>builder()
				.left(promoter)
				.middle(recommendedUser)
				.right(sendToEmail)
				.build();
		Recommendation actual = recommendationsResource.findRecommendations(searchCriteria);
		
		if(actual == null) {
			actual = recommendationsResource.create(expected);
		}

		AssertJUnit.assertEquals(expected.getEmail(), actual.getEmail());
		AssertJUnit.assertEquals(expected.getInvitationText(), actual.getInvitationText());		
	}
	
	/**
	 * Test the {@link RelationPermissionsResource}.
	 *
	 * Note: you have to start a rest server to test this or you have to mock
	 * it.
	 */
	@Test(enabled = true)
	public void testRelationPermissionsResource() {
		RelationPermissionsResource resource = restClient.getRelationPermissionsResource();	
		// set client params with key and trust managers. The keystore is the same as jetty
		WebClientExtensions.setTLSClientParameters(resource, tlsClientParameters);
		AssertJUnit.assertNotNull(resource);	

		User promoter = getPromoterUser();
		User recommendedUser = getRecommendedUser();
		
		Permission permission = permissionsResource.findByName("view_user_images");
				
		RelationPermission expected = RelationPermission.builder()
				.provider(promoter)
				.subscriber(recommendedUser)
				.permissions(SetExtensions.newHashSet(permission))
				.build();
		
		// http://localhost:8080/relation/permission/find/all
		KeyValuePair<User, User> providerToSubscriber = 
				KeyValuePair.<User, User>builder()
				.key(promoter)
				.value(recommendedUser)
				.build();
		
		RelationPermission relationPermission = resource.findRelationPermissions(providerToSubscriber);
		
		if(relationPermission == null) {
			relationPermission = resource.create(expected);
		}
		AssertJUnit.assertNotNull(relationPermission);	

		Triple<User, User, Permission> searchCriteria = Triple.<User, User, Permission>builder()
				.left(promoter)
				.middle(recommendedUser)
				.right(permission)
				.build();
		
		List<RelationPermission> relationPermissions = resource.find(searchCriteria);
		System.out.println(relationPermissions);
//		AssertJUnit.assertNotNull(relationPermission);

	}
	
	/**
	 * Test the {@link ResetPasswordsResource}.
	 *
	 * Note: you have to start a rest server to test this or you have to mock
	 * it.
	 */
	@Test(enabled = true)
	public void testResetPasswordsResource() {
		ResetPasswordsResource resource = restClient.getResetPasswordsResource();
		// set client params with key and trust managers. The keystore is the same as jetty
		WebClientExtensions.setTLSClientParameters(resource, tlsClientParameters);
		AssertJUnit.assertNotNull(resource);
		Date now = CreateDateExtensions.now();
		Date expiryDate = CalculateDateExtensions.addDays(now, 1);
		
		ResetPassword resetPassword;
		
		resetPassword = resource.findResetPassword(getPromoterUser());
		if(resetPassword == null){
			resetPassword = ResetPassword.builder()
					.starttime(now)
					.expiryDate(expiryDate)
					.user(getPromoterUser())
					.generatedPassword("very-secret")
					.build();
			resetPassword = resource.create(resetPassword);
		}
		AssertJUnit.assertNotNull(resetPassword);
		
		KeyValuePair<User, String> userAndGenPw = KeyValuePair.<User, String>builder()
				.key(getPromoterUser())
				.value("very-secret")
				.build();
		
		ResetPassword actual = resource.findResetPassword(userAndGenPw);
		AssertJUnit.assertNotNull(actual);
		

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
		// set client params with key and trust managers. The keystore is the same as jetty
		WebClientExtensions.setTLSClientParameters(resource, tlsClientParameters);
		AssertJUnit.assertNotNull(resource);
		
		Robinson robinson =  Robinson.builder().robinson(getPromoterUser()).build();
		
		Robinson robinson2 = resource.read(50);
		AssertJUnit.assertNotNull(robinson2);
		
		
	}
	
	/**
	 * Test the {@link RolesResource}.
	 *
	 * Note: you have to start a rest server to test this or you have to mock
	 * it.
	 */
	@Test(enabled = true)
	public void testRolesResource() {
		RolesResource resource = restClient.getRolesResource();
		// set client params with key and trust managers. The keystore is the same as jetty
		WebClientExtensions.setTLSClientParameters(resource, tlsClientParameters);
		AssertJUnit.assertNotNull(resource);
		Role role;
		
		role = resource.findRole("ADMIN");
		if(role == null) {
			role = Role.builder()
					.rolename("ADMIN")
					.description("The admin role")
					.build();
			role = resource.create(role);
		}
		
		AssertJUnit.assertNotNull(role);
		
		List<Permission> permissions = resource.findAllPermissions(role);
		AssertJUnit.assertNotNull(permissions);
		
		
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
		// set client params with key and trust managers. The keystore is the same as jetty
		WebClientExtensions.setTLSClientParameters(resource, tlsClientParameters);
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
	
	public User getPromoterUser() {
		if(promoterUser == null) {
			String promoterEmail ="michael.knight@gmail.com";
			promoterUser = usersResource.findUserWithEmail(promoterEmail);	
			if(promoterUser.getActive() == null) {
				promoterUser.setActive(true);
				usersResource.update(promoterUser);
			}		
		}
		return promoterUser;
	}
	
	public User getRecommendedUser() {
		if(recommendedUser == null) {
			String promoterEmail ="james.dean@gmail.com";
			recommendedUser = usersResource.findUserWithEmail(promoterEmail);
			if(recommendedUser.getActive() == null) {
				recommendedUser.setActive(true);
				usersResource.update(recommendedUser);
			}
		}
		return recommendedUser;
	}
	
	private User promoterUser;
	
	private User recommendedUser;
	
}
