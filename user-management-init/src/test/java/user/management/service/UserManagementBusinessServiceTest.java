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
package user.management.service;

import java.io.File;
import java.sql.BatchUpdateException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import de.alpharogroup.address.book.service.api.AddressesService;
import de.alpharogroup.auth.models.AuthenticationErrors;
import de.alpharogroup.auth.models.AuthenticationResult;
import de.alpharogroup.auth.models.UsernameSignUpModel;
import de.alpharogroup.date.CreateDateExtensions;
import de.alpharogroup.email.messages.Mimetypes;
import de.alpharogroup.file.search.PathFinder;
import de.alpharogroup.resource.system.application.model.ModelSynchronizer;
import de.alpharogroup.resource.system.application.model.ResourcesModel;
import de.alpharogroup.resource.system.application.util.ModelConverter;
import de.alpharogroup.resource.system.entities.Resources;
import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.entities.Roles;
import de.alpharogroup.user.management.entities.UserDatas;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.enums.ContactmethodType;
import de.alpharogroup.user.management.enums.GenderType;
import de.alpharogroup.user.management.factories.UserManagementFactory;
import de.alpharogroup.user.management.factories.UserManagementModelFactory;
import de.alpharogroup.user.management.service.api.AuthenticationsService;
import de.alpharogroup.user.management.service.api.ContactmethodsService;
import de.alpharogroup.user.service.api.RolesService;
import de.alpharogroup.user.management.service.api.UserDatasService;
import de.alpharogroup.user.management.service.api.UsersManagementService;
import de.alpharogroup.user.management.service.api.UsersService;
import de.alpharogroup.user.management.sign.up.SignUpUserResult;
import de.alpharogroup.user.management.sign.up.UserModel;
import lombok.Getter;
import lombok.Setter;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class UserManagementBusinessServiceTest extends AbstractTestNGSpringContextTests {

	/** The Addresses business service. */
	@Autowired
	private AddressesService addressesService;
	@Autowired
	private UsersManagementService userManagementService;
	@Autowired
	private RolesService rolesService;
	@Autowired
	private UsersService usersService;

	/** The users business service. */
	@Autowired
	@Getter
	@Setter
	private UserDatasService userDatasService;
	/** The contactmethods business service. */
	@Autowired
	private ContactmethodsService contactmethodsService;

	/** The attribute for {@link AuthenticationsService}. */
	@Autowired
	private AuthenticationsService authenticationsService;

	@Test(enabled=false)
	public void testSignUpUser() {
		SignUpUserResult result;
		final UserManagementModelFactory userManagementModelFactory = UserManagementModelFactory.getInstance();
		UserModel userModel = userManagementModelFactory.newUserModel(
				"Knight",
				CreateDateExtensions.newDate(1974, 8, 28),
				"Michael",
				GenderType.MALE,
				"127.0.0.1",
				"Knight",
				Locale.GERMAN,
				"01721745676",
				"032325444444",
				"032325444445",
				addressesService.get(30224)); // Ludwigsburg

		UsernameSignUpModel model = userManagementModelFactory.newUsernameSignupModel(
				"michael.knight@gmail.com",
				"xxx",
				"xxx",
				Boolean.TRUE,
				"michael.knight");

		final Set<Roles> roles = createRolesSet();

		result = userManagementService.signUpUser(model, roles, userModel);
		// Check if the user can authenticate ...
		final AuthenticationResult<Users, AuthenticationErrors> authenticationResult = authenticationsService.authenticate("michael.knight@gmail.com", "xxx");
		final Users user = authenticationResult.getUser();
		System.out.println("Username:"+user.getUsername());

		userModel = userManagementModelFactory.newUserModel(
				"Frankenstein",
				CreateDateExtensions.newDate(1974, 8, 28),
				"Adolf",
				GenderType.MALE,
				"127.0.0.1",
				"Frankenstein",
				Locale.GERMAN,
				"01741762636",
				"042327445445",
				"042327445446",
				addressesService.get(14178));//Stuttgart

		model = userManagementModelFactory.newUsernameSignupModel(
				"adolf.frankenstein@gmail.com",
				"xxx",
				"xxx",
				Boolean.TRUE,
				"frankenstein");

		result = userManagementService.signUpUser(model, roles, userModel);

		userModel = userManagementModelFactory.newUserModel(
				"Dean",
				CreateDateExtensions.newDate(1974, 8, 28),
				"James",
				GenderType.MALE,
				"127.0.0.1",
				"Dean",
				Locale.GERMAN,
				"01541662535",
				"072327545348",
				"072327545349",
				addressesService.get(35448));// Worms

		model = userManagementModelFactory.newUsernameSignupModel(
				"james.dean@gmail.com",
				"xxx",
				"xxx",
				Boolean.TRUE,
				"james.dean");

		result = userManagementService.signUpUser(model, roles, userModel);
		System.out.println(result);


	}

	public Set<Roles> createRolesSet() {
		final List<Roles> r = rolesService.findAll();
		final Set<Roles> roles = new HashSet<>();
		if(r != null && !r.isEmpty()) {
			roles.add(r.get(0));
		} else {
			final Roles role = rolesService.createAndSaveRole("ADMIN", "The admin role");
			roles.add(role);
		}
		return roles;
	}

	@Test(enabled=false)
	public void testFindUserWithEmailOrUsername(){
		String emailOrUsername = "michael.knight";
		Users user = userManagementService
				.findUserWithEmailOrUsername(emailOrUsername);

		AssertJUnit.assertNotNull(user);

		emailOrUsername = "michael.knight@gmail.com";
		user = userManagementService
				.findUserWithEmailOrUsername(emailOrUsername);
		AssertJUnit.assertNotNull(user);
	}

	@Test(enabled=true)
	public void testFindEmailContactFromUser() {
		final String emailOrUsername = "michael.knight";
	final Users user = userManagementService
			.findUserWithEmailOrUsername(emailOrUsername);
	AssertJUnit.assertNotNull(user);
	final Contactmethods cm = userManagementService.findEmailContactFromUser(user);
	AssertJUnit.assertNotNull(cm.getContactmethod());
	}


	@Test(enabled=false)
	public void testSaveUserImage() {
		final Users michaelProvider = usersService.findUserWithEmail("michael.knight@gmail.com");
		final File testResoureDir = PathFinder.getSrcTestResourcesDir();
		final File imgDir = new File(testResoureDir, "images");
		final File img = new File(imgDir, "frankenstein.jpeg");
		final String mimeType = Mimetypes.getMimeType(img);
		//

		final ResourcesModel fileModel = ModelSynchronizer.toResourceModel(img, mimeType, "A photo from user "+michaelProvider.getUsername());
		for (int i = 0; i < 100; i++) {
			userManagementService.persistResource(fileModel, michaelProvider.getId());
			System.out.println(i);
		}
	}
	@Test(enabled=false)
	public void testRemoveUserResource() {
		final Users michaelProvider = usersService.findUserWithEmail("michael.knight@gmail.com");
		//
		final UserDatas userData = userDatasService.findBy(michaelProvider);
		final Set<Resources> resources = userData.getResources();
		System.out.println("resources size:"+resources.size());
		for (final Resources resource : resources) {
			userManagementService.deleteResource(ModelConverter.toResourcesModel(resource), userData.getId());
		}
	}
	@Test(enabled=false)
	public void testfindContactmethods() throws BatchUpdateException {
		final Users michaelProvider = usersService.findUserWithEmail("james.dean@gmail.com");
		Contactmethods contactmethod = UserManagementFactory.getInstance().newContactmethods(ContactmethodType.INTERNET, "http://www.jamesdean.gr");
		contactmethod = userManagementService.saveUserWithContactmethod(michaelProvider, contactmethod);
		usersService.refresh(michaelProvider);
		final List<Contactmethods> cm = userManagementService.findAllInternetContactmethodsFromUser(michaelProvider);
		AssertJUnit.assertTrue(cm.contains(contactmethod));
	}


	@Test(enabled=false)
	public void testFindContactmethod() {
		final Users michaelProvider = usersService.findUserWithEmail("james.dean@gmail.com");
		final List<Contactmethods> cms = contactmethodsService.findContactmethod(ContactmethodType.INTERNET, michaelProvider);
		for (final Contactmethods contactmethods : cms) {
			System.out.println(contactmethods);
		}
	}

}
