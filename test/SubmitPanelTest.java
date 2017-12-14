package test;

import static org.junit.Assert.assertNotNull;
import javax.swing.JFrame;
import org.junit.Test;
import view.CategoryPanel;
import view.SubmitPanel;
import view.MainGUI;

/**
 * The JUnit test class for the SubmitPanel.
 * 
 * @author Logan Stafford
 */
public class SubmitPanelTest {

	/**
	 * A test to ensure the SubmitPanel constructor does not
	 * create a null object.
	 */
	@Test
	public void testSubmitPanel() {
		SubmitPanel submitPanel = new SubmitPanel();

		assertNotNull(submitPanel);
	}

	/**
	 * A test to ensure that the move() method works correctly,
	 * and that the submitPanel can move
	 */
	@Test
	public void testMoveToCategory() {
		final JFrame frame = new JFrame("");
		SubmitPanel submitPanel = new SubmitPanel();
		CategoryPanel Category = new CategoryPanel();
	
		submitPanel.passIn(frame,null,Category);
		submitPanel.move();
		assertNotNull(submitPanel);
	}

	/**
	 * A test to ensure the setup() method works correctly 
	 * within the mainGUI class.
	 */
	@Test
	public void testSetup() {
		MainGUI myGUI = new MainGUI();
		assertNotNull(myGUI);
	}

}