package user.management.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import de.alpharogroup.user.management.daos.ContactmethodsDao;
import de.alpharogroup.user.management.entities.Contactmethods;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class ContactmethodsDaoTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private ContactmethodsDao contactmethodsDao;


	@Test(enabled=false)
	public void testFindAll() {
		final List<Contactmethods> all =  contactmethodsDao.findAll();
		System.out.println(all);
	}

}
