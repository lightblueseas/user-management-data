package user.management.model;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import de.alpharogroup.user.management.daos.ResetPasswordsDao;
import de.alpharogroup.user.management.entities.ResetPasswords;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class ResetPasswordsDaoTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private ResetPasswordsDao resetPasswordsDao;

	

	@Test
	public void testFindAll() {
		List<ResetPasswords> all = resetPasswordsDao.findAll();
		System.out.println(all);		
	}
}