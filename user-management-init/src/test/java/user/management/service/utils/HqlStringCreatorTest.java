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
		expected = "select p from Permissions p where p.description=:description";	
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
