package user.management.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import de.alpharogroup.user.management.daos.RolesDao;
import de.alpharogroup.user.management.entities.Roles;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class RolesDaoTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private RolesDao rolesDao;



	@Test(enabled=false)
	public void testFindAll() {
		final List<Roles> all = rolesDao.findAll();
		System.out.println(all);
	}
}
