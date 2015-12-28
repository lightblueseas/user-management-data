package user.management.daos;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import de.alpharogroup.user.management.daos.UserCreditsDao;
import de.alpharogroup.user.management.entities.UserCredits;


@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class UserCreditsDaoTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private UserCreditsDao userCreditsDao;

	@Test(enabled=false)
	public void testFindAll() {
		final List<UserCredits> all = userCreditsDao.findAll();
		System.out.println(all);
	}
}