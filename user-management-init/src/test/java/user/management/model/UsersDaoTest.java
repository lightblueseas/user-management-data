package user.management.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import de.alpharogroup.user.repositories.UsersDao;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class UsersDaoTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private UsersDao usersDao;

}
