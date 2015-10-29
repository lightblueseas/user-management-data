package user.management.service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import de.alpharogroup.resource.system.service.api.ResourcesService;
import de.alpharogroup.user.management.entities.Permissions;
import de.alpharogroup.user.management.entities.RelationPermissions;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.enums.Gender;
import de.alpharogroup.user.management.factories.UserManagementFactory;
import de.alpharogroup.user.management.service.api.PermissionsService;
import de.alpharogroup.user.management.service.api.RelationPermissionsService;
import de.alpharogroup.user.management.service.api.RolesService;
import de.alpharogroup.user.management.service.api.UserDataService;
import de.alpharogroup.user.management.service.api.UserManagementService;
import de.alpharogroup.user.management.service.api.UsersService;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class UsersBusinessServiceTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private UserManagementService userManagementService;
	@Autowired
	private RolesService rolesService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private PermissionsService permissionsService;	
	@Autowired
	private RelationPermissionsService relationPermissionsService;
	@Autowired	
	private ResourcesService resourcesService;
	@Autowired		
	private UserDataService userDataService;

	@Test(enabled=false)
	public void testFindUsers() {
		Integer from = 18;
		Integer until = 50;
		List<Users> users = usersService.findUsers(from, Gender.MALE, until);
		System.out.println(users);		
	}

	@Test(enabled=false)
	public void testFindUsersWithGeohash() {
		Integer from = 18;
		Integer until = 50;
		List<Users> users = usersService.findUsers(from, Gender.MALE, until, "u0ww");
		System.out.println(users);		
	}
	@Test(enabled=false)
	public void testFindRelationPermissions() {
		Users michaelProvider = usersService.findUserWithEmail("michael.knight@gmail.com");
		Users adolfSubscriber = usersService.findUserWithEmail("adolf.frankenstein@gmail.com");
		Permissions permission = permissionsService.findByShortcut("vui");
		Set<Permissions> permissions = new HashSet<Permissions>();
		permissions.add(permission);
		RelationPermissions relationPermission = relationPermissionsService.findRelationPermissions(michaelProvider, adolfSubscriber, permission);
		if(relationPermission != null) {
			relationPermission = UserManagementFactory.getInstance().newRelationPermissions(michaelProvider, adolfSubscriber, permissions);
			relationPermission = relationPermissionsService.merge(relationPermission);
		}
		RelationPermissions relationPermissions = relationPermissionsService.findRelationPermissions(michaelProvider, adolfSubscriber);
		System.out.println(relationPermissions);		
	}

}
