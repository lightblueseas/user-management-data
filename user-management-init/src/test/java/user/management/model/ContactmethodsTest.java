/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *  *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *  *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package user.management.model;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.management.enums.ContactmethodType;
import de.alpharogroup.user.management.factories.UserManagementFactory;

public class ContactmethodsTest
{

	@Test(enabled = true)
	public void testEqualsAndHashCodeContract()
	{
		Contactmethods contactmethods1 = UserManagementFactory.getInstance()
			.newContactmethods(ContactmethodType.EMAIL, "abc@gmail.com");
		Contactmethods contactmethods2 = UserManagementFactory.getInstance()
			.newContactmethods(ContactmethodType.EMAIL, "abc@gmail.com");

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

	@Test(enabled = true)
	public void testHashCode()
	{

		Contactmethods contactmethods1 = UserManagementFactory.getInstance()
			.newContactmethods(ContactmethodType.EMAIL, "abc@gmail.com");
		Contactmethods contactmethods2 = UserManagementFactory.getInstance()
			.newContactmethods(ContactmethodType.EMAIL, "abc@gmail.com");
		int hc1 = contactmethods1.hashCode();
		int hc2 = contactmethods2.hashCode();
		AssertJUnit.assertTrue(hc1 == hc2);
		contactmethods1.setId(1);
		contactmethods2.setId(2);

		hc1 = contactmethods1.hashCode();
		hc2 = contactmethods2.hashCode();
		AssertJUnit.assertTrue(hc1 != hc2);

	}

}
