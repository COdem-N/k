package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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

/**
 * Class to manage the submission of projects and the according panel.
 * 
 * @author Logan Stafford, edited by Peter Bae
 * @version 1.0
 */
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
     * The JFrame of the program.
     */
    private JFrame myFrame;
    
    /**
     * The ApplicationModel object used for display purposes.
     */
    private ApplicationModel myApplicationModel;
    
    /**
     * A CategoryPanel object used for display purposes (used to display the Category Panel).
     */
    private CategoryPanel myCategoryPanel;
    
    /**
     * A JLabel object to set next to the "Title" text box.
     */
    private JLabel myLabelTitle = new JLabel("Title: ");
    
    /**
     * A JLabel object to set next to the "Difficulty" text box.
     */
    private JLabel myLabelDiff = new JLabel("Difficulty: ");
    
    /**
     * A JLabel object to set next to the "Cost" text box.
     */
    private JLabel myLabelCost = new JLabel("Cost: ");
    
    /**
     * A JLabel object to set next to the "Materials" text box.
     */
    private JLabel myLabelMaterials = new JLabel("Materials: ");
    
    /**
     * A JLabel object to set next to the "Directions" text box.
     */
    private JLabel myLabelDirections = new JLabel("Directions: ");
    
    /**
     * A JLabel object to set next to the "Tags" text box.
     */
    private JLabel myLabelTags = new JLabel("Tags: ");
    
    /**
     * A String object representing the image path of the uploaded picture.
     */
    private String myImagePath;
    
    /**
     * A JTextArea object for inputting the "Title".
     */
    private JTextArea myTextTitle = new JTextArea(2, 20);
    
    /**
     * A JTextArea object for inputting the "Materials".
     */
    private JTextArea myTextMaterials = new JTextArea(5, 20);
    
    /**
     * A JTextArea object for inputting the "Directions".
     */
    private JTextArea myTextDirections = new JTextArea(10, 20);
    
    /**
     * A JextArea object for inputting the "Tags".
     */
    private JTextArea myTextTags = new JTextArea(2,20);
    
    /**
     * A JSlider object used to input the project difficulty.
     */
    private JSlider myDiffSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN_VALUE, SLIDER_MAX_VALUE, SLIDER_DEFAULT_VALUE);
    
    /**
     * A JSlider object used to input the project cost.
     */
    private JSlider myCostSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN_VALUE, SLIDER_MAX_VALUE, SLIDER_DEFAULT_VALUE);
    
    /**
     * A JButton object for submitting the pending project.
     */
    private JButton mySubmitButton = new JButton("Submit");
    
    /**
     * A JButton object for canceling the pending project.
     */
    private JButton myCancelButton = new JButton("Cancel");
    
    /**
     * A JButton object for adding a picture to the pending project.
     */
    private JButton myPicButton = new JButton("Add Picture...");
    
    /************************************
     ** CLASS CONSTRUCTOR AND METHODS **
     ***********************************/
    
    /**
     * The SubmitPanel constructor.
     */
	public SubmitPanel() {
		/* Constructing the panel with a GridBag layout. */
		super(new GridBagLayout());
		
        /* Setting some properties of the panel. */
        setPreferredSize(SUBMIT_PANEL_SIZE);
        setBackground(SUBMIT_PANEL_BG_COLOR);
	}
	
	/**
	 * The passIn method for the SubmitPanel. 
	 * This method allows for switching of panels.
	 * 
	 * @param theFrame The JFrame of the project.
	 * @param theApp The ApplicationModel data of the project.
	 * @param theCat The Category Panel of the project.
	 */
	public void passIn(JFrame theFrame, ApplicationModel theApplicationModel, CategoryPanel theCategoryPanel) {
		myFrame = theFrame;
		myApplicationModel = theApplicationModel;
		myCategoryPanel = theCategoryPanel;
	}
	
	/**
	 * The setup() method of the SubmitPanel. 
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
        this.add(myLabelTitle, constraints);
        constraints.gridy = 2;
        this.add(myLabelDiff, constraints);
        constraints.gridy = 3;
        this.add(myLabelCost, constraints);
        constraints.gridy = 4;
        this.add(myLabelMaterials, constraints);
        constraints.gridy = 5;
        this.add(myLabelDirections, constraints);
        constraints.gridy = 6;
        this.add(myLabelTags, constraints);
        
        /* Enabling line wrap on all the text fields. */
        myTextMaterials.setLineWrap(true);
        myTextDirections.setLineWrap(true);
        
        /* Adding text boxes to the panel. */
        final JScrollPane scrollTitle = new JScrollPane(myTextTitle);
        final JScrollPane scrollMaterials = new JScrollPane(myTextMaterials);
        final JScrollPane scrollDirections = new JScrollPane(myTextDirections);
        final JScrollPane scrollTags = new JScrollPane(myTextTags);
        
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(scrollTitle, constraints);
        constraints.gridy = 2;
        this.add(myDiffSlider, constraints);
        constraints.gridy = 3;
        this.add(myCostSlider, constraints);
        constraints.gridy = 4;
        this.add(scrollMaterials, constraints);
        constraints.gridy = 5;
        this.add(scrollDirections, constraints);
        constraints.gridy = 6;
        this.add(scrollTags, constraints);
            
        /* Adding the "Submit", "Cancel", and "Add Picture" buttons. */        
        constraints.gridx = 2;
        constraints.gridy = 2;
        this.add(myPicButton, constraints);
        constraints.gridy = 5;
        this.add(myCancelButton, constraints);
        constraints.gridx = 9;
        this.add(mySubmitButton, constraints);
         
        /* Setting up a basic border for the panel. */
        final TitledBorder border = new TitledBorder(new LineBorder(Color.BLACK),
                "Submit a New Project",
                TitledBorder.CENTER,
                TitledBorder.BELOW_TOP);
		border.setTitleColor(Color.BLACK);
		this.setBorder(border);
	}
	
	/**
	 * Creates the Difficulty slider and corresponding labels for it.
	 */
	private void setupDifficultySlider() {		
		/* Setting up Slider options for selecting project difficulty. */
        myDiffSlider.setMajorTickSpacing(1);
        myDiffSlider.setPaintTicks(true);
        myDiffSlider.setPaintLabels(true);
        
        /* Setting up labels for the slider ticks. */
        Hashtable<Integer, JLabel> diffLabelTable = new Hashtable<Integer, JLabel>();
        diffLabelTable.put(new Integer(1), new JLabel("Easy"));
        diffLabelTable.put(new Integer(2), new JLabel("Med"));
        diffLabelTable.put(new Integer(3), new JLabel("Hard"));
        myDiffSlider.setLabelTable(diffLabelTable);
	}
	
	/**
	 * Creates the Cost slider and corresponding labels for it.
	 */
	private void setupCostSlider() {		
        /* Setting up Slider options for selecting project cost. */
        myCostSlider.setMajorTickSpacing(1);
        myCostSlider.setPaintTicks(true);
        myCostSlider.setPaintLabels(true);
        
        /* Setting up labels for the slider ticks. */
        Hashtable<Integer, JLabel> costLabelTable = new Hashtable<Integer, JLabel>();
        costLabelTable.put(new Integer(1), new JLabel("$"));
        costLabelTable.put(new Integer(2), new JLabel("$$"));
        costLabelTable.put(new Integer(3), new JLabel("$$$"));
        myCostSlider.setLabelTable(costLabelTable);
	}

	/**
	 * Creates the Add Picture Button object for the SubmitPanel.
	 */
	private void buildPictureButton() {
		myPicButton.addActionListener((theEvent) -> {
		    JFileChooser chooser = new JFileChooser();
		    File newFile = new File("imgs/" + ProjectModel.getRunningID() + ".png");
		    
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "JPG, PNG, & GIF Images", "jpg", "gif", "png");
		    chooser.setFileFilter(filter);
		    int returnVal = chooser.showOpenDialog(getParent());
		    if (returnVal == JFileChooser.APPROVE_OPTION) {
		    	try {
					Files.copy(chooser.getSelectedFile().toPath(), 
							newFile.toPath(), 
							StandardCopyOption.REPLACE_EXISTING);
					myImagePath = newFile.getPath();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		 
		});
	}
	
	/**
	 * Creates the Cancel Button object for the SubmitPanel.
	 */
	private void buildCancelButton() {
		myCancelButton.addActionListener((theEvent) -> { 
			reset();
			move();
		});
	}
	
	/**
	 * Removes the SubmitPanel from the frame and replaces
	 * it with the CategoryPanel.
	 */
	private void move() {
		this.setVisible(false);
		myFrame.remove(this);
		myCategoryPanel.setVisible(true);
		myFrame.add(myCategoryPanel);	
	}

	/**
	 * Resets the SubmitPanel.
	 */
	private void reset() {
		myTextTitle.setText("");
		myTextMaterials.setText("");
		myImagePath = null;
	    myTextDirections.setText("");
	    myTextTags.setText("");
	    myDiffSlider.setValue(2);
	    myCostSlider.setValue(2);   
	}

	/**
	 * Creates the Submit Button object for the SubmitPanel.
	 */
	private void buildSubmitButton() {		
		mySubmitButton.addActionListener((theEvent) -> { 		
			if (myTextTitle.getText().equals("") | 
				myImagePath == null |
				myTextMaterials.getText().equals("") | 
				myTextDirections.getText().equals("") | 
				myTextTags.getText().equals("")) {
                JOptionPane.showMessageDialog(null,
                							  "One or more fields are empty. "
                							  + "Please complete form.", 
                							  "Warning", 
                							  JOptionPane.INFORMATION_MESSAGE);				
			} else {
				createProject();
				reset();
				move();
			}			
		});
	}
	
	/**
	 * Creates a ProjectModel object and shows a dialog box.
	 */
	private void createProject() {
		ProjectModel newProject = new ProjectModel(myTextTitle.getText(), 
												   myImagePath, 
												   myTextMaterials.getText(), 
												   myDiffSlider.getValue(), 
												   myCostSlider.getValue(), 
												   myTextDirections.getText(), 
												   formatTags(myTextTags.getText()));			
		
		myApplicationModel.addProject(newProject);
		
		JOptionPane.showMessageDialog(null,
        		"Project Successfully Created!", "Project Created!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Formats the input tag String into a list of String.
	 * 
	 * @param theInput The raw String input.
	 * @return List of tags as Strings.
	 */
	private List<String> formatTags(String theInput) {
		List<String> strList = new ArrayList<String>();
		String[] strArr = theInput.toLowerCase().split(",");
		for (String s : strArr) {
			while (s.charAt(0) == ' ') {
				s = s.substring(1);
			}
			while (s.charAt(s.length() - 1) == ' ') {
				s = s.substring(0, s.length() - 2);
			}
			strList.add(s);
		}
		return strList;
	}

}