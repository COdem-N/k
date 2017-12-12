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
 * @author Logan Stafford, edited by Peter Bae
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
    private static final Color PROJECT_PANEL_BG_COLOR = new Color(60, 141, 13);
    
    /**
     * 
     */
    private CategoryPanel myCategoryPanel;
   
    /**
     * 
     */
    private JLabel heading;
    
    /**
     * 
     */
    private BufferedImage imageIcon;
    
    /**
     * 
     */
    private JLabel myName;
    
    /**
     * 
     */
    private JLabel difficulty;
    
    /**
     * 
     */
    private JLabel cost;
    
    /**
     * 
     */
    private JLabel tags;
    
    /**
     * 
     */
    private JLabel materials;
    
    /**
     * 
     */
    private JLabel directions;

    /**
     * 
     */
    private JFrame myFrame;
    
    /**
     * 
     */
    private JLabel image;
    
    /**
     * 
     */
    private JLabel nameResult;
    
    /**
     * 
     */
    private JLabel difficultyResult;
    
    /**
     * 
     */
    private JLabel costResult;
    
    /**
     * 
     */
    private JLabel tagsResult;
    
    /**
     * 
     */
    private JLabel materialsResult;
    
    /**
     * 
     */
    private JLabel directionsResult;
    
    /**
     * 
     */
    private JButton back;
    
    /************************************
     ** CLASS CONSTRUCTOR AND METHODS **
     ***********************************/
    
	public ProjectPanel() {
		super();
			
	        /* Setting some properties of the panel. */
	        
	        this.setLayout(new GridBagLayout());
	        heading = new JLabel("Welcome to the Project");
	        myName = new JLabel("Name:");
	        difficulty = new JLabel("Difficulty:");
	        cost = new JLabel("cost:");
	        tags = new JLabel("Tags:");
	        materials = new JLabel("Materials:");
	        directions = new JLabel("Directions:");
	        try {
	        		imageIcon = ImageIO.read(new File("view/desk.png"));
	        		imageIcon = getScaledImage(imageIcon, 250, 250);
	        } catch (IOException ex) {
	        		//System.out.println("Here");
	        }
	        
	        image = new JLabel(new ImageIcon(imageIcon));
	        
	        nameResult = new JLabel("Desk ");
	        difficultyResult = new JLabel("Easy");
	        costResult = new JLabel("$$");
	        tagsResult = new JLabel("Indoor,outdoor");
	        materialsResult = new JLabel("Wood, Nails, Saw, Hammer ");
	        directionsResult = new JLabel("Directions will be displayed here");
	        
	        back = new JButton("Back:");
	        this.setLayout(new GridBagLayout());
	        setPreferredSize(PROJECT_PANEL_SIZE);
			setBackground(PROJECT_PANEL_BG_COLOR);
	        setup();
	}

    /**
     * 
     */
	public void passIn(JFrame theFrame, CategoryPanel theCat) {
		myCategoryPanel = theCat;
		myFrame = theFrame;
	}	
	
	/**
	 * Sets up the Panel according to the passed in ProjectModel.
	 * 
	 * @param theProject The passed in ProjectModel.
	 */
	public void setupPage(ProjectModel theProject) {
		setPreferredSize(PROJECT_PANEL_SIZE);
        setBackground(PROJECT_PANEL_BG_COLOR);
        
		nameResult.setText(theProject.getName());
		
		switch (theProject.getDifficulty()) {
		case 1:
			difficultyResult.setText("Beginner");
			break;
		case 2:
			difficultyResult.setText("Intermediate");
			break;
		case 3:
			difficultyResult.setText("Expert");
		}
		
		switch (theProject.getCost()) {
		case 1:
			costResult.setText("$");
			break;
		case 2:
			costResult.setText("$$");
			break;
		case 3:
			costResult.setText("$$$");
		}
		
		StringBuilder tags = new StringBuilder();
		tags.append(theProject.getTags().get(0));
		for (int i = 1; i < theProject.getTags().size(); i++) {
			tags.append(", " + theProject.getTags().get(i));
		}
		tagsResult.setText(tags.toString());
		
		materialsResult.setText(theProject.getMaterials());
		
		directionsResult.setText(theProject.getBody());
		
		image.setIcon(new ImageIcon(theProject.getImageLink()));
	}
	
    /**
     * 
     */
	public void setup() {
		setPreferredSize(PROJECT_PANEL_SIZE);
        setBackground(PROJECT_PANEL_BG_COLOR);
        
        back.addActionListener((theEvent) -> {
        	this.setVisible(false);
			myFrame.remove(this);
			myFrame.add(myCategoryPanel);
			myCategoryPanel.setVisible(true);
        });
        
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(20, 20, 20, 20);
        
        constraints.gridx = 0;
        constraints.gridy = 0; 
        this.add(heading);
        constraints.gridy = 10;
		this.add(myName, constraints);
		constraints.gridy = 20;
		this.add(difficulty, constraints);
		constraints.gridy = 30;
		this.add(cost, constraints);
		constraints.gridy = 40;
		this.add(tags, constraints);
		constraints.gridy = 50;
		this.add(materials, constraints);
		constraints.gridy = 60;
		this.add(directions, constraints);
		
		constraints.gridx = 20;
        constraints.gridy = 10;
		
        this.add(nameResult, constraints);
		constraints.gridy = 20;
		this.add(difficultyResult, constraints);
		constraints.gridy = 30;
		this.add(costResult, constraints);
		constraints.gridy = 40;
		this.add(tagsResult, constraints);
		constraints.gridy = 50;
		this.add(materialsResult, constraints);
		constraints.gridy = 60;
		this.add(directionsResult, constraints);
		
		
		constraints.gridx = 40;
        constraints.gridy = 100;
		this.add(back,constraints);
		
		constraints.gridx = 40;
		constraints.gridheight = 100;
		constraints.gridy = 0;
        this.add(image,constraints);
	}
	
    /**
     * 
     */
	private BufferedImage getScaledImage(BufferedImage src, int w, int h){
	    int finalw = w;
	    int finalh = h;
	    double factor = 1.0d;
	    if(src.getWidth() > src.getHeight()){
	        factor = ((double)src.getHeight()/(double)src.getWidth());
	        finalh = (int)(finalw * factor);                
	    }else{
	        factor = ((double)src.getWidth()/(double)src.getHeight());
	        finalw = (int)(finalh * factor);
	    }   

	    BufferedImage resizedImg = new BufferedImage(finalw, finalh, BufferedImage.TRANSLUCENT);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(src, 0, 0, finalw, finalh, null);
	    g2.dispose();
	    return resizedImg;
	}

}