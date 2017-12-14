package test;

import static org.junit.Assert.assertNotNull;

import javax.swing.JFrame;

import org.junit.Test;

import view.CategoryPanel;
import view.LandingPanel;
import view.MainGUI;

public class LandingPanelTest {

	
    /**
     * a test for the constructor to make sure it creates an object.
     * 
     * @author Carter Odem
     */
	@Test
	public void testLandingPanel() {
		LandingPanel landPanel = new LandingPanel();

		assertNotNull(landPanel);
	}
    /**
     *  a test to make sure that the move to category. doesn't remove the previous panel
     * 
     * @author Carter Odem
     */
	@Test
	public void testMoveToCategory() {
		final JFrame frame = new JFrame("");
		LandingPanel landPanel = new LandingPanel();
		CategoryPanel Category = new CategoryPanel();
	
		landPanel.passIn(frame,null,Category);
		landPanel.moveToCategory();
		assertNotNull(landPanel);
	}
    /**
     * a test of the setup method to make sure that it can create the GUI properly
     * 
     * @author Carter Odem
     */
	@Test
	public void testSetup() {
		MainGUI muGui = new MainGUI();
		assertNotNull(muGui);
	}

}