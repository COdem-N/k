package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import model.ApplicationModel;

@SuppressWarnings("serial")
public class LandingPanel extends JPanel {
	
    /**
     * A Dimension object representing the panel size of the Landing panel.
     */
    private static final Dimension LANDING_PANEL_SIZE = new Dimension(800, 600); 
    
    /**
     * A Color object to be used as the background color of the Landing panel.
     */
    private static final Color LANDING_PANEL_BG_COLOR = new Color(60, 141, 13);
    
    /**
     * 
     */
    private ApplicationModel myApplcationModel;
    
    /**
     * 
     */
    private CategoryPanel myCategoryPanel;
    
	public LandingPanel() {
			super();
			
	        /* Setting some properties of the panel. */
	        setPreferredSize(LANDING_PANEL_SIZE);
	        setBackground(LANDING_PANEL_BG_COLOR);
	}
	
	public void passIn(ApplicationModel theApp, CategoryPanel theCat) {
		myApplcationModel = theApp;
		myCategoryPanel = theCat;
	}
	
}