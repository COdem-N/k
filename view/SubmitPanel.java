package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import model.ApplicationModel;

@SuppressWarnings("serial")
public class SubmitPanel extends JPanel {

    /************************************
     **          CLASS FIELDS         **
     ***********************************/
	
    /**
     * A Dimension object representing the panel size of the panel.
     */
    private static final Dimension SUBMIT_PANEL_SIZE = new Dimension(800, 600); 
    
    /**
     * A Color object to be used as the background color of the panel.
     */
    private static final Color SUBMIT_PANEL_BG_COLOR = new Color(200, 200, 255);
    
    /**
     * 
     */
    private ApplicationModel myApplcationModel;
    
    /**
     * 
     */
    private CategoryPanel myCategoryPanel;
    
    /**
     * A JLabel object to set next to the "Title" text box.
     */
    private JLabel labelTitle = new JLabel("Title: ");
    
    /**
     * A JLabel object to set next to the "Difficulty" text box.
     */
    private JLabel labelDiff = new JLabel("Difficulty: ");
    
    /**
     * A JLabel object to set next to the "Cost" text box.
     */
    private JLabel labelCost = new JLabel("Cost: ");
    
    /**
     * A JLabel object to set next to the "Materials" text box.
     */
    private JLabel labelMaterials = new JLabel("Materials: ");
    
    /**
     * A JLabel object to set next to the "Directions" text box.
     */
    private JLabel labelDirections = new JLabel("Directions: ");
    
    /**
     * A JTextArea object for inputting the "Title".
     */
    private JTextArea textTitle = new JTextArea(1, 20);
    
    /**
     * A JTextArea object for inputting the "Difficulty".
     */
    private JTextArea textDiff = new JTextArea(1, 20);
    
    /**
     * A JTextArea object for inputting the "Cost".
     */
    private JTextArea textCost = new JTextArea(1, 20);
    
    /**
     * A JTextArea object for inputting the "Materials".
     */
    private JTextArea textMaterials = new JTextArea(10, 20);
    
    /**
     * A JTextArea object for inputting the "Directions".
     */
    private JTextArea textDirections = new JTextArea(10, 20);
    
    /**
     * A JButton object for submitting the pending project.
     */
    private JButton buttonSubmit = new JButton("Submit");
    
    /**
     * A JButton object for canceling the pending project.
     */
    private JButton buttonCancel = new JButton("Cancel");
    
    /**
     * A JButton object for adding a picture to the pending project.
     */
    private JButton buttonPic = new JButton("Add a Picture..");
    
    /************************************
     ** CLASS CONSTRUCTOR AND METHODS **
     ***********************************/
    
    /**
     * The SubmitPanel constructor.
     */
	public SubmitPanel() {
			super(new GridBagLayout());
			
			setup();
			
	        /* Setting some properties of the panel. */
	        setPreferredSize(SUBMIT_PANEL_SIZE);
	        setBackground(SUBMIT_PANEL_BG_COLOR);
	}
	
	/**
	 * The passIn method for the SubmitPanel. This method
	 * 
	 * @param theApp
	 * @param theCat
	 */
	public void passIn(ApplicationModel theApp, CategoryPanel theCat) {
		myApplcationModel = theApp;
		myCategoryPanel = theCat;
	}
	
	/**
	 * The setup() method of the SubmitPanel.
	 * 
	 * This method initializes and sets up the panel itself.
	 */
	public void setup() {
		
		/* Setting up GridBag constraints. */
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);
         
        /* Adding text box labels to the panel. */
        constraints.gridx = 0;
        constraints.gridy = 0;     
        this.add(labelTitle, constraints);
        constraints.gridy = 2;
        this.add(labelDiff, constraints);
        constraints.gridy = 3;
        this.add(labelCost, constraints);
        constraints.gridy = 4;
        this.add(labelMaterials, constraints);
        constraints.gridy = 5;
        this.add(labelDirections, constraints);
        
        /* Enabling line wrap on all the text fields. */
        textTitle.setLineWrap(true);
        textDiff.setLineWrap(true);
        textCost.setLineWrap(true);
        textMaterials.setLineWrap(true);
        textDirections.setLineWrap(true);
        
        /* Adding text boxes to the panel. */
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(textTitle, constraints);
        constraints.gridy = 2;
        this.add(textDiff, constraints);
        constraints.gridy = 3;
        this.add(textCost, constraints);
        constraints.gridy = 4;
        this.add(textMaterials, constraints);
        constraints.gridy = 5;
        this.add(textDirections, constraints);
            
        /* Adding buttons. */        
        constraints.gridx = 2;
        constraints.gridy = 2;
        this.add(buttonPic, constraints);
        constraints.gridy = 5;
        this.add(buttonCancel, constraints);
        constraints.gridx = 9;
        this.add(buttonSubmit, constraints);
         
        /* Setting border for the panel. */
        this.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Submit a New Project"));
	}
	
    /************************************
     **       CLASS MAIN() TESTER     **
     ***********************************/
	
	/**
	 * A test method to run and display this panel only.
	 */
	public static void main(String[] args) {
		final JFrame frame = new JFrame("Submit a New Project"); 
		
		SubmitPanel submitPanel = new SubmitPanel();
		
		frame.add(submitPanel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(SUBMIT_PANEL_SIZE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
}