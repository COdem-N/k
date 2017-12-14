package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ProjectModel;

/**
 * Class to manage the Projects panel.
 * 
 * @author Karan Singla, Peter Bae, edited by Logan Stafford
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ProjectPanel extends JPanel {
	
    /************************************
     **          CLASS FIELDS         **
     ***********************************/
	
    /**
     * A Dimension object representing the panel size of the Project panel.
     */
    private static final Dimension PROJECT_PANEL_SIZE = new Dimension(800, 600); 
    
    /**
     * A Color object to be used as the background color of the Project panel.
     */
    private static final Color PROJECT_PANEL_BG_COLOR = new Color(0, 0, 75);
    
    /**
     * The Category panel of the program.
     */
    private CategoryPanel myCategoryPanel;
   
    /**
     * A JLabel object used for the heading of the window.
     */
    private JLabel myHeading;
    
    /**
     * A BufferedImage object used for the ImageIcon.
     */
    private BufferedImage myImageIcon;
    
    /**
     * A Jlabel object used for the name of a project.
     */
    private JLabel myName;
    
    /**
     * A Jlabel object used for the difficulty of a project.
     */
    private JLabel myDifficulty;
    
    /**
     * A Jlabel object used for the cost of a project.
     */
    private JLabel myCost;
    
    /**
     * A Jlabel object used for the tags of a project.
     */
    private JLabel myTags;
    
    /**
     * A Jlabel object used for the materials of a project.
     */
    private JLabel myMaterials;
    
    /**
     * A Jlabel object used for the directions of a project.
     */
    private JLabel myDirections;

    /**
     * The JFrame of the program.
     */
    private JFrame myFrame;
    
    /**
     * A JLabel used for the results of a project's image.
     */
    private JLabel myImage;
    
    /**
     * A JLabel used for the results of a project's name.
     */
    private JLabel myNameResult;
    
    /**
     * A JLabel used for the results of a project's difficulty.
     */
    private JLabel myDifficultyResult;
    
    /**
     * A JLabel used for the results of a project's cost.
     */
    private JLabel myCostResult;
    
    /**
     * A JLabel used for the results of a project's tags.
     */
    private JLabel myTagsResult;
    
    /**
     * A JLabel used for the results of a project's materials.
     */
    private JLabel myMaterialsResult;
    
    /**
     * A JLabel used for the results of a project's directions.
     */
    private JLabel myDirectionsResult;
    
    /**
     * A JButton that is used for the "Back" functionality.
     */
    private JButton myBackButton;
    
    /************************************
     ** CLASS CONSTRUCTOR AND METHODS **
     ***********************************/
    
    /**
     * The ProjectPanel constructor. Creates a sample project and displays the project's information.
     * 
     * @author Karan Singla
     */
	public ProjectPanel() {
		super();
			
        /* Setting some properties of the panel. */	        
        this.setLayout(new GridBagLayout());
        myHeading = new JLabel(" --- Project Summary --- ");
        myName = new JLabel("Name:");
        myDifficulty = new JLabel("Difficulty:");
        myCost = new JLabel("Cost:");
        myTags = new JLabel("Tags:");
        myMaterials = new JLabel("Materials:");
        myDirections = new JLabel("Directions:");
        
        /* Setting the text color to white so as to be visible against the navy background. */
        myHeading.setForeground(Color.WHITE);
        myName.setForeground(Color.WHITE);
        myDifficulty.setForeground(Color.WHITE);
        myCost.setForeground(Color.WHITE);
        myTags.setForeground(Color.WHITE);
        myMaterials.setForeground(Color.WHITE);
        myDirections.setForeground(Color.WHITE);
        
        try {
    		myImageIcon = ImageIO.read(new File("view/desk.png"));
    		myImageIcon = getScaledImage(myImageIcon, 250, 250);
        } catch (IOException ex) {
        	
        }
        
        myImage = new JLabel(new ImageIcon(myImageIcon));	        
        myNameResult = new JLabel("Desk ");
        myDifficultyResult = new JLabel("Easy");
        myCostResult = new JLabel("$$");
        myTagsResult = new JLabel("Indoor, outdoor");
        myMaterialsResult = new JLabel("Wood, Nails, Saw, Hammer ");
        myDirectionsResult = new JLabel("Directions will be displayed here");	        
        myBackButton = new JButton("Back");
        
        /* Setting the text color to white so as to be visible against the navy background. */
        myNameResult.setForeground(Color.WHITE);
        myDifficultyResult.setForeground(Color.WHITE);
        myCostResult.setForeground(Color.WHITE);
        myTagsResult.setForeground(Color.WHITE);
        myMaterialsResult.setForeground(Color.WHITE);
        myDirectionsResult.setForeground(Color.WHITE);               
        
        /* Setting some properties of the panel. */	 
        this.setLayout(new GridBagLayout());
        setPreferredSize(PROJECT_PANEL_SIZE);
		setBackground(PROJECT_PANEL_BG_COLOR);
        setup();
	}

    /**
     * The passIn() method used for moving between panels.
     * 
     * @author Karan Singla
     * 
     * @param theFrame The program's JFrame.
     * @param theCategoryPanel The program's Category panel.
     */
	public void passIn(JFrame theFrame, CategoryPanel theCategoryPanel) {
		myCategoryPanel = theCategoryPanel;
		myFrame = theFrame;
	}	
	
	/**
	 * Sets up the Panel according to the passed in ProjectModel.
	 * 
	 * @author Karan Singla
	 * 
	 * @param theProject The passed in ProjectModel.
	 */
	public void setupPage(ProjectModel theProject) {
		/* Setting the panel preferences (size and background color). */
		setPreferredSize(PROJECT_PANEL_SIZE);
        setBackground(PROJECT_PANEL_BG_COLOR);
        
		myNameResult.setText(theProject.getName());
		
		switch (theProject.getDifficulty()) {
		case 1:
			myDifficultyResult.setText("Beginner");
			break;
		case 2:
			myDifficultyResult.setText("Intermediate");
			break;
		case 3:
			myDifficultyResult.setText("Expert");
		}
		
		switch (theProject.getCost()) {
		case 1:
			myCostResult.setText("$");
			break;
		case 2:
			myCostResult.setText("$$");
			break;
		case 3:
			myCostResult.setText("$$$");
		}
		
		StringBuilder tags = new StringBuilder();
		tags.append(theProject.getTags().get(0));
		
		for (int i = 1; i < theProject.getTags().size(); i++) {
			tags.append(", " + theProject.getTags().get(i));
		}
		
		myTagsResult.setText(tags.toString());		
		myMaterialsResult.setText(theProject.getMaterials());		
		myDirectionsResult.setText(theProject.getBody());		
		myImage.setIcon(new ImageIcon(theProject.getImageLink()));
	}
	
    /**
     * The setup() method. This creates the panel and sets up all the components using a GridBad layout manager.
     * 
     * @author Karan Singla
     * @author Logan Stafford (editing)
     */
	public void setup() {
		/* Setting the panel preferences (size and background color). */
		setPreferredSize(PROJECT_PANEL_SIZE);
        setBackground(PROJECT_PANEL_BG_COLOR);
        
        /* Setting up the functionality of the Back button. */
        myBackButton.addActionListener((theEvent) -> {
        	this.setVisible(false);
			myFrame.remove(this);
			myFrame.add(myCategoryPanel);
			myCategoryPanel.setVisible(true);
        });
        
        /* Setting up the GridBag constraints. */
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(20, 20, 20, 20);        
        constraints.gridx = 0;
        constraints.gridy = 0; 
        
        /* Adding components to the panel. */
        this.add(myHeading);
        constraints.gridy = 10;
		this.add(myName, constraints);
		constraints.gridy = 20;
		this.add(myDifficulty, constraints);
		constraints.gridy = 30;
		this.add(myCost, constraints);
		constraints.gridy = 40;
		this.add(myTags, constraints);
		constraints.gridy = 50;
		this.add(myMaterials, constraints);
		constraints.gridy = 60;
		this.add(myDirections, constraints);		
		constraints.gridx = 20;
        constraints.gridy = 10;		
        this.add(myNameResult, constraints);
		constraints.gridy = 20;
		this.add(myDifficultyResult, constraints);
		constraints.gridy = 30;
		this.add(myCostResult, constraints);
		constraints.gridy = 40;
		this.add(myTagsResult, constraints);
		constraints.gridy = 50;
		this.add(myMaterialsResult, constraints);
		constraints.gridy = 60;
		this.add(myDirectionsResult, constraints);				
		constraints.gridx = 40;
        constraints.gridy = 100;        
		this.add(myBackButton,constraints);		
		constraints.gridx = 40;
		constraints.gridheight = 100;
		constraints.gridy = 0;		
        this.add(myImage,constraints);
	}
	
    /**
     * The getScaledImage method of the ProjectPanel. This scales a given image down to the desired size
     * so that it can fit into the panel.
     * 
     * @author Karan Singla
     * @author Logan Stafford (editing)
     * 
     * @param originalImage The original image that is to be scaled.
     * @param theWidth The desired width of the new image.
     * @param theHeight The desired height of the new image.
     * @return A new, scaled BufferedImage of the original.
     */
	private BufferedImage getScaledImage(BufferedImage originalImage, int theWidth, int theHeight){
	    int finalWidth = theWidth;
	    int finalHeight = theHeight;
	    double scaleFactor = 1.0d;
	    
	    if (originalImage.getWidth() > originalImage.getHeight()) {
	        scaleFactor = ((double)originalImage.getHeight()/(double)originalImage.getWidth());
	        finalHeight = (int)(finalWidth * scaleFactor);                
	    } else {
	        scaleFactor = ((double)originalImage.getWidth()/(double)originalImage.getHeight());
	        finalWidth = (int)(finalHeight * scaleFactor);
	    }   

	    BufferedImage resizedImage = new BufferedImage(finalWidth, finalHeight, BufferedImage.TRANSLUCENT);
	    Graphics2D g2 = resizedImage.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(originalImage, 0, 0, finalWidth, finalHeight, null);
	    g2.dispose();
	    
	    return resizedImage;
	}

}