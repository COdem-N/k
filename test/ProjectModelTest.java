package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.ProjectModel;

/**
 * Test for ProjectModel
 * @author Peter Bae
 */
public class ProjectModelTest {

	/**
	 * Test ProjectModel
	 */
	private ProjectModel pm;
	
	/**
	 * Initializing the ProjectModel
	 * @throws Exception
	 */
	@Before
	public void setUpBefore() throws Exception {
		List<String> list = new ArrayList<String>();
		list.add("test");
		pm = new ProjectModel("test",
							  "testLink",
							  "testMat",
							   1,
							   2,
							   "testBody",
							   list);
	}

	/**
	 * Tests for equality throughout the whole list of fields.
	 */
	@Test
	public void testProjectModel() {
		List<String> list = new ArrayList<String>();
		list.add("test");
		assertEquals(pm.getID(), 6);
		assertEquals(pm.getName(), "test");
		assertEquals(pm.getImageLink(), "testLink");
		assertEquals(pm.getMaterials(), "testMat");
		assertEquals(pm.getDifficulty(), 1);
		assertEquals(pm.getCost(), 2);
		assertEquals(pm.getBody(), "testBody");
		assertEquals(pm.getTags(), list);
	}

	/**
	 * Tests the set and get methods for RunningID.
	 */
	@Test
	public void testSetRunningID() {
		ProjectModel.setRunningID(5);
		assertEquals(ProjectModel.getRunningID(), 5);
	}
	
	/**
	 * Tests the toString method.
	 */
	@Test
	public void testToString() {
		assertEquals(pm.toString(),"6,5\ntest\ntestLink\ntestMat\n1,2\ntestBody\ntest, \n\n");
	}
}
