package user.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.enums.ContactmethodType;
import de.alpharogroup.user.management.service.api.ContactmethodsService;
import de.alpharogroup.user.management.service.api.UsersService;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class ContactmethodsBusinessServiceTest {


	/** The contactmethods business service. */
	@Autowired
	private ContactmethodsService contactmethodsService;
	@Autowired
	private UsersService usersService;
	@Test(enabled=false)
	public void testFindContactmethod() {
		final Users michaelProvider = usersService.findUserWithEmail("michael.knight@gmail.com");
		final List<Contactmethods> cms = contactmethodsService.findContactmethod(ContactmethodType.INTERNET, michaelProvider);
		for (final Contactmethods contactmethods : cms) {
			System.out.println(contactmethods);
		}
	}

}
