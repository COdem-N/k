package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.ApplicationModel;
import model.ProjectModel;

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
     * An integer object to be used as a static slider value (minimum value).
     */
    private static final int SLIDER_MIN_VALUE = 1;
    
    /**
     * An integer object to be used as a static slider value (default value).
     */
    private static final int SLIDER_DEFAULT_VALUE = 2;
    
    /**
     * An integer object to be used as a static slider value (maximum value).
     */
    private static final int SLIDER_MAX_VALUE = 3;
    
    /**
     * 
     */
    private JFrame myFrame;
    
    /**
     * 
     */
    private ApplicationModel myApplicationModel;
    
    /**
     * A CategoryPanel object used for display purposes (used to display the Category Panel).
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
    
    private String imagePath = "directory";
    
    private List<String> projectTags = new ArrayList<String>();
    
    /**
     * A JTextArea object for inputting the "Title".
     */
    private JTextArea textTitle = new JTextArea(2, 20);
    
    /**
     * A JTextArea object for inputting the "Materials".
     */
    private JTextArea textMaterials = new JTextArea(10, 20);
    
    /**
     * A JTextArea object for inputting the "Directions".
     */
    private JTextArea textDirections = new JTextArea(10, 20);
    
    /**
     * A JSlider object used to input the project difficulty.
     */
    private JSlider diffSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN_VALUE, SLIDER_MAX_VALUE, SLIDER_DEFAULT_VALUE);
    
    /**
     * A JSlider object used to input the project cost.
     */
    private JSlider costSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN_VALUE, SLIDER_MAX_VALUE, SLIDER_DEFAULT_VALUE);
    
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
    private JButton buttonPic = new JButton("Add Picture...");
    
    /************************************
     ** CLASS CONSTRUCTOR AND METHODS **
     ***********************************/
    
    /**
     * The SubmitPanel constructor.
     */
	public SubmitPanel() {
		/* Constructing the panel with a GridBag layout. */
		super(new GridBagLayout());
		
		/* Calling the main setup method of the panel. */
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
	public void passIn(JFrame theFrame, ApplicationModel theApp, CategoryPanel theCat) {
		myFrame = theFrame;
		myApplicationModel = theApp;
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
        
        /* Calling helper methods to setup the sliders 
         * for selecting the project difficulty and cost.
         */
        setupDifficultySlider();
        setupCostSlider();
        buildPictureButton();
        buildCancelButton();
        buildSubmitButton();
         
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
        textMaterials.setLineWrap(true);
        textDirections.setLineWrap(true);
        
        /* Adding text boxes to the panel. */
        final JScrollPane scrollTitle = new JScrollPane(textTitle);
        final JScrollPane scrollMaterials = new JScrollPane(textMaterials);
        final JScrollPane scrollDirections = new JScrollPane(textDirections);
        
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(scrollTitle, constraints);
        constraints.gridy = 2;
        this.add(diffSlider, constraints);
        constraints.gridy = 3;
        this.add(costSlider, constraints);
        constraints.gridy = 4;
        this.add(scrollMaterials, constraints);
        constraints.gridy = 5;
        this.add(scrollDirections, constraints);
            
        /* Adding the "Submit", "Cancel", and "Add Picture" buttons. */        
        constraints.gridx = 2;
        constraints.gridy = 2;
        this.add(buttonPic, constraints);
        constraints.gridy = 5;
        this.add(buttonCancel, constraints);
        constraints.gridx = 9;
        this.add(buttonSubmit, constraints);
         
        /* Setting up a basic border for the panel. */
        final TitledBorder border = new TitledBorder(new LineBorder(Color.BLACK),
                "Submit a New Project",
                TitledBorder.CENTER,
                TitledBorder.BELOW_TOP);
		border.setTitleColor(Color.BLACK);
		this.setBorder(border);
	}
	
	/**
	 * 
	 */
	private void setupDifficultySlider() {		
		/* Setting up Slider options for selecting project difficulty. */
        diffSlider.setMajorTickSpacing(1);
        diffSlider.setPaintTicks(true);
        diffSlider.setPaintLabels(true);
        
        /* Setting up labels for the slider ticks. */
        Hashtable<Integer, JLabel> diffLabelTable = new Hashtable<Integer, JLabel>();
        diffLabelTable.put(new Integer(1), new JLabel("Easy"));
        diffLabelTable.put(new Integer(2), new JLabel("Med"));
        diffLabelTable.put(new Integer(3), new JLabel("Hard"));
        diffSlider.setLabelTable(diffLabelTable);
	}
	
	/**
	 * 
	 */
	private void setupCostSlider() {		
        /* Setting up Slider options for selecting project cost. */
        costSlider.setMajorTickSpacing(1);
        costSlider.setPaintTicks(true);
        costSlider.setPaintLabels(true);
        
        /* Setting up labels for the slider ticks. */
        Hashtable<Integer, JLabel> costLabelTable = new Hashtable<Integer, JLabel>();
        costLabelTable.put(new Integer(1), new JLabel("$"));
        costLabelTable.put(new Integer(2), new JLabel("$$"));
        costLabelTable.put(new Integer(3), new JLabel("$$$"));
        costSlider.setLabelTable(costLabelTable);
	}
	
	/**
	 * 
	 */
	private void buildPictureButton() {
		buttonPic.addActionListener((theEvent) -> {
		    JFileChooser chooser = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "JPG, PNG, & GIF Images", "jpg", "gif", "png");
		    chooser.setFileFilter(filter);
		    int returnVal = chooser.showOpenDialog(getParent());
		    if (returnVal == JFileChooser.APPROVE_OPTION) {
		       System.out.println("You chose to open this file: " +
		            chooser.getSelectedFile().getName());
		    }
		 
		});
	}
	
	/**
	 * 
	 */
	private void buildCancelButton() {
		buttonCancel.addActionListener((theEvent) -> { 
			this.setVisible(false);
			myFrame.remove(this);
			myCategoryPanel.setVisible(true);
			myFrame.add(myCategoryPanel);
			
		});
	}
	
	/**
	 * 
	 */
	private void buildSubmitButton() {
		buttonSubmit.addActionListener((theEvent) -> { 
			System.out.println(textTitle.getText());
			System.out.println(imagePath);
			System.out.println(textMaterials.getText());
			System.out.println(diffSlider.getValue());
			System.out.println(costSlider.getValue());
			System.out.println(textDirections.getText());
			System.out.println(projectTags);
			
			if (textTitle.getText() == "" | textMaterials.getText() == "" | textDirections.getText() == "") {
                JOptionPane.showMessageDialog(null,
                		"One or more fields are empty. Please complete form.", "Warning", JOptionPane.INFORMATION_MESSAGE);
				
			} else {
				ProjectModel newProject = new ProjectModel(textTitle.getText(), imagePath, textMaterials.getText(), 
						diffSlider.getValue(), costSlider.getValue(), textDirections.getText(), projectTags);			
				
				myApplicationModel.addProject(newProject);
				
				JOptionPane.showMessageDialog(null,
                		"Project Successfully Created!", "Project Created!", JOptionPane.INFORMATION_MESSAGE);
				
				this.setVisible(false);
				myFrame.remove(this);
				myCategoryPanel.setVisible(true);
				myFrame.add(myCategoryPanel);
			}			
		});
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