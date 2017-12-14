package test;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

import model.ApplicationModel;
import view.CategoryPanel;
import view.LandingPanel;
import view.ProjectPanel;
import view.SubmitPanel;

/**
 * Test for the CategoryPanel class.
 * @author Alex Merk
 */
public class CategoryPanelTest {
	
	static private CategoryPanel testPanel;

	/**
	 * Test to make sure the constructor does not construct a null object.
	 */
	@Test
	@Before
	public void testCategoryPanel() {
		testPanel = new CategoryPanel();
	
		assertNotNull(testPanel);
	}
	
	/**
	 * Tests the moving between panels, as well as constructors
	 */
	@Test
	public void testMoving()  {
		final JFrame testFrame = new JFrame();
		final LandingPanel testLading = new LandingPanel();
		final SubmitPanel testSubmit = new SubmitPanel();
		final ProjectPanel testProject = new ProjectPanel();
		
		testPanel.passIn(testFrame, new ApplicationModel(), testLading, testSubmit, testProject);
		testLading.passIn(testFrame, new ApplicationModel(), testPanel);
		testProject.passIn(testFrame, testPanel);
		testSubmit.passIn(testFrame, new ApplicationModel(), testPanel);
		testPanel.moveToSubmit();
		assertNotNull(testSubmit);
		
		testPanel.moveToLanding();
		assertNotNull(testLading);
		testLading.moveToCategory();
		
		testPanel.moveToProject();
		assertNotNull(testPanel);
	}
}
