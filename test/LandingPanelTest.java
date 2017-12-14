package test;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

import view.CategoryPanel;
import view.LandingPanel;
import view.MainGUI;

public class LandingPanelTest {


	@Test
	public void testLandingPanel() {
		final JFrame frame = new JFrame("");

		LandingPanel landPanel = new LandingPanel();

		assertNotNull(landPanel);

	}

	@Test
	public void testMoveToCategory() {
		final JFrame frame = new JFrame("");
		LandingPanel landPanel = new LandingPanel();
		CategoryPanel Category = new CategoryPanel();
	
		landPanel.passIn(frame,null,Category);
		landPanel.moveToCategory();
		assertNotNull(landPanel);
	}

	@Test
	public void testSetup() {
		MainGUI muGui = new MainGUI();
		assertNotNull(muGui);
	}

}
