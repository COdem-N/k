package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ProjectPanel extends JPanel {
	
    /**
     * A Dimension object representing the panel size of the Project panel.
     */
    private static final Dimension PROJECT_PANEL_SIZE = new Dimension(800, 600); 
    
    /**
     * A Color object to be used as the background color of the Project panel.
     */
    private static final Color PROJECT_PANEL_BG_COLOR = new Color(60, 141, 13);
    
	public ProjectPanel() {
			super();
			
	        /* Setting some properties of the panel. */
	        setPreferredSize(PROJECT_PANEL_SIZE);
	        setBackground(PROJECT_PANEL_BG_COLOR);
	}
	
}