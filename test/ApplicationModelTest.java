/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.ApplicationModel;
import model.ProjectModel;

/**
 * Test for ApplicationModel
 * @author Peter Bae
 *
 */
public class ApplicationModelTest {

	/**
	 * The ApplicationModel to be tested.
	 */
	private ApplicationModel am;
	
	/**
	 * A ProjectModel to be tested with.
	 */
	private ProjectModel pm;
	
	/**
	 * Another ProjectModel to be tested with.
	 */
	private ProjectModel pm2;
	
	/**
	 * Yet another ProjectModel to be tested with.
	 */
	private ProjectModel pm3;
	
	/**
	 * Initializing the ApplicationModel
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		am = new ApplicationModel();
		
		List<String> list = new ArrayList<String>();
		list.add("test");
		
		List<String> list2 = new ArrayList<String>();
		list2.add("test2");
		
		pm = new ProjectModel("test",
				   "testLink",
				   "testMat",
				    1,
				    2,
				    "testBody",
				    list);
		pm2 = new ProjectModel("test2",
				    "testLink2",
				    "testMat2",
				     2,
				     2,
				     "testBody2",
				     list);
		pm3 = new ProjectModel("test3",
			    "testLink3",
			    "testMat3",
			     3,
			     1,
			     "testBody3",
			     list2);
	}

	/**
	 * Tests the addProject method
	 */
	@Test
	public void testAddProject() {
		am.addProject(pm);
		am.addProject(pm2);
		List<ProjectModel> pmList = new ArrayList<ProjectModel>();
		pmList.add(pm);
		pmList.add(pm2);
		assertEquals(am.getProjects(), pmList);
	}
	
	/**
	 * Tests the getProject method that takes in a String argument.
	 */
	@Test
	public void testGetProjectTag() {
		am.addProject(pm);
		am.addProject(pm2);
		am.addProject(pm3);
		List<ProjectModel> pmList = new ArrayList<ProjectModel>();
		pmList.add(pm);
		pmList.add(pm2);
		assertEquals(am.getProjects("test"), pmList);
	}
	
	/**
	 * Tests the getTags method.
	 */
	@Test
	public void testGetTags() {
		am.addProject(pm);
		am.addProject(pm2);
		am.addProject(pm3);
		
		List<String> strList = new ArrayList<String>();
		strList.add("test");
		strList.add("test2");
		
		assertEquals(am.getTags(), strList);
	}
	
	/**
	 * Tests the getTags method when empty.
	 */
	@Test
	public void testGetTagsEmpty() {		
		List<String> strList = new ArrayList<String>();
		
		assertEquals(am.getTags(), strList);
	}
	
	/**
	 * Tests the getTagMap method.
	 */
	@Test
	public void testGetTagMap() {
		am.addProject(pm);
		am.addProject(pm2);
		am.addProject(pm3);
		
		Map<String, Integer> map = new TreeMap<String, Integer>();
		map.put("test", 2);
		map.put("test2", 1);
		assertEquals(am.getTagMap(),map);
	}
	
	/**
	 * Tests the toString method.
	 */
	@Test
	public void testToString() {
		am.addProject(pm);
		am.addProject(pm2);
		am.addProject(pm3);
		
		assertEquals(am.toString(),"3,0\ntest\ntestLink\ntestMat\n1,2\ntestBody\ntest, \n\n"
								 + "3,1\ntest2\ntestLink2\ntestMat2\n2,2\ntestBody2\ntest, \n\n"
								 + "3,2\ntest3\ntestLink3\ntestMat3\n3,1\ntestBody3\ntest2, \n\n");
	}
	
	/**
	 * Tests the toString method when empty.
	 */
	@Test
	public void testToStringEmpty() {		
		assertEquals(am.toString(),"Empty");
	}
}
