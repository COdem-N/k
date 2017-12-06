package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ApplicationModel;

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
    
    /**
     * 
     */
    private ApplicationModel myApplcationModel;
    
    /**
     * 
     */
    private CategoryPanel myCategoryPanel;
   
    private JLabel heading;
    
    private JLabel name;
    private JLabel difficulty;
    private JLabel cost;
    private JLabel tags;
    private JLabel materials;
    private JLabel directions;
    
    private JLabel nameResult;
    private JLabel difficultyResult;
    private JLabel costResult;
    private JLabel tagsResult;
    private JLabel materialsResult;
    private JLabel directionsResult;
    
    private JButton back;
	public ProjectPanel() {
		super();
			
	        /* Setting some properties of the panel. */
	        
	        this.setLayout(new GridBagLayout());
	        heading = new JLabel("Project Details");
	        name = new JLabel("Name:");
	        difficulty = new JLabel("Difficulty:");
	        cost = new JLabel("cost:");
	        tags = new JLabel("Tags:");
	        materials = new JLabel("Materials:");
	        directions = new JLabel("Directions:");
	        
	        nameResult = new JLabel("nameResult");
	        difficultyResult = new JLabel("difficultyResult");
	        costResult = new JLabel("costResult ");
	        tagsResult = new JLabel("tagsResult");
	        materialsResult = new JLabel("materialsResult");
	        directionsResult = new JLabel("directionsResult");
	        
	        back = new JButton("Back:");
	        this.setLayout(new GridBagLayout());
	        setPreferredSize(PROJECT_PANEL_SIZE);
			setBackground(PROJECT_PANEL_BG_COLOR);
	        setup();
	}

	public void passIn(ApplicationModel theApp, CategoryPanel theCat) {
		myApplcationModel = theApp;
		myCategoryPanel = theCat;
	}	
	
	public void setup() {
		setPreferredSize(PROJECT_PANEL_SIZE);
        setBackground(PROJECT_PANEL_BG_COLOR);
        
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(20, 20, 20, 20);
        
        constraints.gridx = 0;
        constraints.gridy = 0; 
        this.add(heading);
        constraints.gridy = 10;
		this.add(name, constraints);
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
		
	}
	public static void main(String[] args) {
		final JFrame frame = new JFrame("Project Panel");

		ProjectPanel landingPage = new ProjectPanel();

		frame.add(landingPage);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(PROJECT_PANEL_SIZE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}