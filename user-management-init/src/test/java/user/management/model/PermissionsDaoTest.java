package user.management.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import de.alpharogroup.user.management.daos.PermissionsDao;
import de.alpharogroup.user.management.entities.Permissions;
import de.alpharogroup.user.management.service.api.PermissionsService;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class PermissionsDaoTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private PermissionsDao permissionsDao;
	@Autowired
	private PermissionsService permissionsService;

	@Test(enabled = false)
	public void getAllPermissions() {
		List<Permissions> list = permissionsService.findAll();
		AssertJUnit.assertEquals(2, list.size());

	}

}
