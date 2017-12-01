package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SplashPanel extends JPanel {
	
    /**
     * A Dimension object representing the panel size of the Splash panel.
     */
    private static final Dimension SPLASH_PANEL_SIZE = new Dimension(800, 600); 
    
    /**
     * A Color object to be used as the background color of the Splash panel.
     */
    private static final Color SPLASH_PANEL_BG_COLOR = new Color(60, 141, 13);
    
	public SplashPanel() {
			super();
			
	        /* Setting some properties of the panel. */
	        setPreferredSize(SPLASH_PANEL_SIZE);
	        setBackground(SPLASH_PANEL_BG_COLOR);
	}
        
}