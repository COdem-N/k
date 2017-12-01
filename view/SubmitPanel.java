package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SubmitPanel extends JPanel {

    /**
     * A Dimension object representing the panel size of the Submit panel.
     */
    private static final Dimension SUBMIT_PANEL_SIZE = new Dimension(800, 600); 
    
    /**
     * A Color object to be used as the background color of the Submit panel.
     */
    private static final Color SUBMIT_PANEL_BG_COLOR = new Color(60, 141, 13);
    
	public SubmitPanel() {
			super();
			
	        /* Setting some properties of the panel. */
	        setPreferredSize(SUBMIT_PANEL_SIZE);
	        setBackground(SUBMIT_PANEL_BG_COLOR);
	}
	
}