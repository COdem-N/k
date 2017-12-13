package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.ApplicationModel;
import model.ProjectModel;

/**
 * Category Panel class. Displays all of the projects with a given tag. Allows users to search for a specific tag, as well as submit new projects.
 * 
 * @author Alex Merk, Peter Bae, edited by Logan Stafford
 */
@SuppressWarnings("serial")
public class CategoryPanel extends JPanel {
	
    /************************************
     **          CLASS FIELDS         **
     ***********************************/
	
    /**
     * A Dimension object representing the panel size of the Category panel.
     */
    private static final Dimension CATEGORY_PANEL_SIZE = new Dimension(800, 600); 
    
    /**
     * A Color object to be used as the background color of the Category panel.
     */
    private static final Color CATEGORY_PANEL_BG_COLOR = new Color(0, 0, 75);
    
    /**
     * Holds the currently submitted projects.
     */
    private ApplicationModel myApplicationModel;
    
    /**
     * A LandingPanel object used for display purposes (used to display the Landing Panel).
     */
    private LandingPanel myLandingPanel;
    
    /**
     * A ProjectPanel object used for display purposes (used to display the ProjectPanel).
     */
    private ProjectPanel myProjectPanel;
    
    /**
     * A SubmitPanel object used for display purposes (used to display the SubmitPanel).
     */
    private SubmitPanel mySubmitPanel;
    
    /**
     * Used to scroll through all submitted projects.
     */
    private JScrollPane mySubmissionScroller;
    
    /**
     * Used to display all submitted projects.
     */
    private JPanel mySubmissionsPanel;
    
    /**
     * Saves the tag sent by LandingPanel that the user wishes to view.
     */
    private String myTag;
    
    /**
     * List of submitted projects whose tag list contains myTag.
     */
    private List<ProjectModel> myProjects;
    
    /**
     * List of buttons used for submitted projects.
     */
    private List<JButton> myProjectButtons;
    
    /**
     * Search bar where users can enter a tag to search for.
     */
    private JTextField mySearchBar;
    
    /**
     * Frame for the GUI.
     */
    private JFrame myFrame;
    
    /************************************
     ** CLASS CONSTRUCTOR AND METHODS **
     ***********************************/
    
    /**
     * Default constructor.
     * 
     * @author Peter Bae.
     */
	public CategoryPanel() {
			super();
			
	        /* Setting some properties of the panel. */
	        setPreferredSize(CATEGORY_PANEL_SIZE);
	        setBackground(CATEGORY_PANEL_BG_COLOR);
	        setup();
	}
	
	/**
	 * Adds the visual components of the panel.
	 * 
	 * @author Alex Merk.
	 */
	protected void setup() {
		this.setLayout(new BorderLayout());
		buildSubPanel();
		buildSearchMenu();
		this.add(buildSubmitButton(), BorderLayout.SOUTH);
	}
	
	/**
	 * Constructs the scroll window.
	 * 
	 * @author Peter Bae.
	 */
	private void buildSubPanel() {
		mySubmissionsPanel = new JPanel();
		mySubmissionsPanel.setLayout(new GridBagLayout());
	}
	
	/**
	 * Constructs the search menu for the window.
	 * 
	 * @author Alex Merk.
	 */
	private void buildSearchMenu() {
		final JPanel mySearchPanel = new JPanel(new BorderLayout());
		mySearchBar = buildSearchBar();
		mySearchPanel.add(mySearchBar, BorderLayout.CENTER);
		mySearchPanel.add(buildBackButton(), BorderLayout.WEST);
		mySearchPanel.add(buildSearchButton(), BorderLayout.EAST);
		this.add(mySearchPanel, BorderLayout.NORTH);
	}
	
    /**
     * Constructs the button for submitting a new project.
     * 
     * @author Alex Merk.
     */
	private JButton buildSubmitButton() {
		final JButton mySubmitButton = new JButton("Submit A New Project...");
		mySubmitButton.addActionListener((theEvent) -> {
			moveToSubmit();
		});
		return mySubmitButton;
	}
	
    /**
     * Constructs the search bar to search for any tag.
     * 
     * @author Alex Merk.
     */
	private JTextField buildSearchBar() {
		mySearchBar = new JTextField("Enter tag(s) to search for here..."); 
		return mySearchBar;
	}
	
	/**
     * Constructs the search button to search for all projects of a given tag.
     * 
     * @author Alex Merk.
     */
	private JButton buildSearchButton() {
		final JButton mySearchButton = new JButton("Search");
		mySearchButton.addActionListener((theEvent) -> {
			myTag = mySearchBar.getText();
		});
		return mySearchButton;
	}
	
    /**
     * Constructs the back button to shift view to the landing panel.
     * 
     * @author Alex Merk.
     */
	private JButton buildBackButton() {
		final JButton myBackButton = new JButton("Back");
		myBackButton.addActionListener((theEvent) -> { 
			reset();
			moveToLanding();
		});
		return myBackButton;
	}
	
	/**
	 * Populates the panel with projects with the passed in tag. 
	 * 
	 * @author Alex Merk, Peter Bae
	 */
	private void buildScrollMenu() {
		if (myApplicationModel != null) {
			mySubmissionScroller = new JScrollPane(mySubmissionsPanel);
			mySubmissionScroller.setPreferredSize(new Dimension(600,400));
			GridBagConstraints myScrollerConstraints = new GridBagConstraints();
			myProjectButtons = new ArrayList<JButton>();
			for (int i = 0; i < myProjects.size(); i++) {
				ImageIcon myProjectIcon = new ImageIcon(myProjects.get(i).getImageLink());
				Image myProjectImage = myProjectIcon.getImage();
				myProjectImage = myProjectImage.getScaledInstance(140, 140, Image.SCALE_SMOOTH);
				myProjectIcon = new ImageIcon(myProjectImage);
				
				JButton myProjectButton = new JButton(myProjectIcon);
				myProjectButton.setVerticalTextPosition(SwingConstants.BOTTOM);
				myProjectButton.setHorizontalTextPosition(SwingConstants.CENTER);
				myProjectButton.setText(myProjects.get(i).getName());
				ProjectModel project = myProjects.get(i);
				myProjectButton.addActionListener((theEvent) -> {
					myProjectPanel.setupPage(project);
					moveToProject();
				});
				myProjectButtons.add(myProjectButton);
				myScrollerConstraints.gridy = i / 3;
				myScrollerConstraints.gridx = i % 3;
				mySubmissionsPanel.add(myProjectButton, myScrollerConstraints);
			}
			this.add(mySubmissionScroller);
		}
	}	
	
	/**
	 * Switches screen to the Project Panel.
	 * 
	 * @author Alex Merk, Peter Bae.
	 */
	private void moveToProject() {
		this.setVisible(false);
		myFrame.remove(this);
		myFrame.add(myProjectPanel);
		myProjectPanel.setVisible(true);
	}
	
	/**
     * Changes the view to the landing panel.
     * 
     * @author Alex Merk, Peter Bae.
     */
	private void moveToLanding() {
		this.setVisible(false);
		myFrame.remove(this);
		myFrame.setTitle("Special K - DIY Project Manager");
		myLandingPanel.setup();
		myLandingPanel.setVisible(true);
		myFrame.add(myLandingPanel);
	}
	
	/**
	 * Changes the view to the submit panel.
	 * 
	 * @author Alex Merk.
	 */
	private void moveToSubmit() {
		this.setVisible(false);
		myFrame.remove(this);
		myFrame.add(mySubmitPanel);
		mySubmitPanel.setVisible(true);
	}
	
	/**
     * Resets the scroll menu displaying projects.
     * 
     * @author Peter Bae
     */
	private void reset() {
		buildSubPanel();
		this.remove(mySubmissionScroller);
	}
	
	/**
	 * Receives a tag from the LandingPanel and updates the shown projects.
	 * @param theTag is the string received from the LandingPanel.
	 * 
	 * @author Alex Merk, Edited by: Peter Bae.
	 */
	protected void setTag(final String theTag) {
		myFrame.setTitle(theTag.toUpperCase());
		myTag = theTag;
		myProjects = myApplicationModel.getProjects(myTag);
		buildScrollMenu();
	}
	
	/**
	 * Passes in all of the panels to change the view.
	 * 
	 * @author Peter Bae
	 * 
	 * @param theFrame is the GUI frame.
	 * @param theApplicationModel is the list of projects.
	 * @param theLandingPanel is the landing panel.
	 * @param theSubmissionPanel is the submit panel.
	 * @param theProjectPanel is the project panel.
	 */
	public void passIn(JFrame theFrame, ApplicationModel theApplicationModel, LandingPanel theLandingPanel, 
					   SubmitPanel theSubmissionPanel, ProjectPanel theProjectPanel) {
		myApplicationModel = theApplicationModel;
		myLandingPanel = theLandingPanel;
		myProjectPanel = theProjectPanel;
		mySubmitPanel = theSubmissionPanel;
		myFrame = theFrame;
	}
	
}