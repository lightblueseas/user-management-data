package user.management.model;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.management.enums.Contactmethod;
import de.alpharogroup.user.management.factories.UserManagementFactory;

public class ContactmethodsTest {

	@Test(enabled=true)
	public void testHashCode() {

		Contactmethods contactmethods1 = UserManagementFactory.getInstance()
				.newContactmethods(Contactmethod.EMAIL, "abc@gmail.com");
		Contactmethods contactmethods2 = UserManagementFactory.getInstance()
				.newContactmethods(Contactmethod.EMAIL, "abc@gmail.com");
		int hc1 = contactmethods1.hashCode();
		int hc2 = contactmethods2.hashCode();
		AssertJUnit.assertTrue(hc1 == hc2);
		contactmethods1.setId(1);
		contactmethods2.setId(2);

		hc1 = contactmethods1.hashCode();
		hc2 = contactmethods2.hashCode();
		AssertJUnit.assertTrue(hc1 != hc2);
		
	}

	@Test(enabled=true)
	public void testEqualsAndHashCodeContract() {
		Contactmethods contactmethods1 = UserManagementFactory.getInstance()
				.newContactmethods(Contactmethod.EMAIL, "abc@gmail.com");
		Contactmethods contactmethods2 = UserManagementFactory.getInstance()
				.newContactmethods(Contactmethod.EMAIL, "abc@gmail.com");

		AssertJUnit.assertTrue(contactmethods1.equals(contactmethods2));

		AssertJUnit.assertTrue(contactmethods1.hashCode() == contactmethods2.hashCode());
		
		contactmethods1.setId(1);
		contactmethods2.setId(2);

		AssertJUnit.assertFalse(contactmethods1.equals(contactmethods2));

		AssertJUnit.assertFalse(contactmethods1.hashCode() == contactmethods2.hashCode());
		
		contactmethods1.setId(2);
		contactmethods2.setId(2);

		AssertJUnit.assertTrue(contactmethods1.equals(contactmethods2));

		AssertJUnit.assertTrue(contactmethods1.hashCode() == contactmethods2.hashCode());
	}

}
