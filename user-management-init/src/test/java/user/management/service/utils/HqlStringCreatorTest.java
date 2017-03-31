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
package user.management.service.utils;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import de.alpharogroup.user.management.service.util.HqlStringCreator;

public class HqlStringCreatorTest {

	@Test
	public void testForPermissions() {
		String actual;
		String expected;

		actual = HqlStringCreator.forPermissions(null, null, null);
		expected = "select p from Permissions p";
		AssertJUnit.assertEquals(expected, actual);

		actual = HqlStringCreator.forPermissions("foo", null, null);
		expected = "select p from Permissions p where p.description=:description";
		AssertJUnit.assertEquals(expected, actual);

		actual = HqlStringCreator.forPermissions("foo", "bar", null);
		expected = "select p from Permissions p where p.description=:description and p.permissionName=:permissionName";
		AssertJUnit.assertEquals(expected, actual);
		//
//		actual = HqlStringCreator.forResources("bla", null, null, null);
//		expected = "select img from Resources img where img.description=:description";
//		AssertJUnit.assertEquals(expected, actual);
//
//		actual = HqlStringCreator.forResources(null, "bla", null, null);
//		expected = "select img from Resources img where img.filename=:filename";
//		AssertJUnit.assertEquals(expected, actual);
//
//		actual = HqlStringCreator.forResources(null, null, "400", null);
//		expected = "select img from Resources img where img.filesize=:filesize";
//		AssertJUnit.assertEquals(expected, actual);
//
//		actual = HqlStringCreator.forResources(null, null, null, "jpg");
//		expected = "select img from Resources img where img.contentType=:contentType";
//		AssertJUnit.assertEquals(expected, actual);
//
//		actual = HqlStringCreator.forResources("bla", "name", null, null);
//		expected = "select img from Resources img where img.description=:description and img.filename=:filename";
//		AssertJUnit.assertEquals(expected, actual);
//
//		actual = HqlStringCreator.forResources("bla", "name", "400", null);
//		expected = "select img from Resources img where img.description=:description and img.filename=:filename and img.filesize=:filesize";
//		AssertJUnit.assertEquals(expected, actual);
//
//		actual = HqlStringCreator.forResources("bla", "name", "400", "jpg");
//		expected = "select img from Resources img where img.description=:description and img.filename=:filename and img.filesize=:filesize and img.contentType=:contentType";
//		AssertJUnit.assertEquals(expected, actual);
	}

}
