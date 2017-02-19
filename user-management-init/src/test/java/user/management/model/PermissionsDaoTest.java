package user.management.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import de.alpharogroup.user.repositories.PermissionsDao;
import de.alpharogroup.user.entities.Permissions;
import de.alpharogroup.user.service.api.PermissionsService;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class PermissionsDaoTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private PermissionsDao permissionsDao;
	@Autowired
	private PermissionsService permissionsService;

	@Test(enabled = false)
	public void getAllPermissions() {
		final List<Permissions> list = permissionsService.findAll();
		AssertJUnit.assertEquals(2, list.size());

	}

}
