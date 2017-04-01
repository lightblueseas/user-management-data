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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.enums.GenderType;
import de.alpharogroup.user.management.service.api.UsersService;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class UsersBusinessServiceTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private UsersService usersService;

	@Test(enabled=false)
	public void testFindUsers() {
		final Integer from = 18;
		final Integer until = 50;
		final List<Users> users = usersService.findUsers(from, GenderType.MALE, until);
		System.out.println(users);
	}

	@Test(enabled=false)
	public void testFindUsersWithGeohash() {
		final Integer from = 18;
		final Integer until = 50;
		final List<Users> users = usersService.findUsers(from, GenderType.MALE, until, "u0ww");
		System.out.println(users);
	}
	@Test(enabled=false)
	public void testFindRelationPermissions() {
		final Users michaelProvider = usersService.findUserWithEmail("james.dean@gmail.com");
		michaelProvider.setActive(true);
		usersService.merge(michaelProvider);
//		Users adolfSubscriber = usersService.findUserWithEmail("adolf.frankenstein@gmail.com");
//		Permissions permission = permissionsService.findByShortcut("vui");
//		Set<Permissions> permissions = new HashSet<Permissions>();
//		permissions.add(permission);
//		RelationPermissions relationPermission = relationPermissionsService.findRelationPermissions(michaelProvider, adolfSubscriber, permission);
//		if(relationPermission != null) {
//			relationPermission = UserManagementFactory.getInstance().newRelationPermissions(michaelProvider, adolfSubscriber, permissions);
//			relationPermission = relationPermissionsService.merge(relationPermission);
//		}
//		RelationPermissions relationPermissions = relationPermissionsService.findRelationPermissions(michaelProvider, adolfSubscriber);
//		System.out.println(relationPermissions);
	}

}
