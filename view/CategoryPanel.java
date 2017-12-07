package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.ApplicationModel;
import model.ProjectModel;

@SuppressWarnings("serial")
public class CategoryPanel extends JPanel {
	
    /**
     * A Dimension object representing the panel size of the Category panel.
     */
    private static final Dimension CATEGORY_PANEL_SIZE = new Dimension(800, 600); 
    
    /**
     * A Color object to be used as the background color of the Category panel.
     */
    private static final Color CATEGORY_PANEL_BG_COLOR = new Color(60, 141, 13);
    
    /**
     * Holds the currently submitted projects.
     */
    private ApplicationModel myApplcationModel;
    
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
     * Saves the tag sent by LandingPanel that the user wishes to view.
     */
    private String myTag;
    
    private JButton myBackButton;
    
    private JButton mySearchButton;
    
    private JButton mySubmitButton;
    
    private JTextField mySearchBar;
    
    private JPanel myCategoryPanel;
    
    private JFrame myframe;
    
    /**
     * Default constructor.
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
	 */
	protected void setup() {
		this.setLayout(new BorderLayout());
		buildScrollMenu();
		buildSearchMenu();
	}
	
	/**
	 * Constructs the menu for scrolling through submitted projects.
	 */
	private void buildScrollMenu() {
		populate();
		final JScrollPane myCategoryScroller = new JScrollPane(myCategoryPanel);
		myCategoryScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		myCategoryScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		myCategoryScroller.setPreferredSize(new Dimension(50, 6000));
		myCategoryScroller.getVerticalScrollBar().setUnitIncrement(20);
		this.add(myCategoryScroller, BorderLayout.CENTER);
		this.add(buildSubmitButton(), BorderLayout.SOUTH);
	}
	
	/**
	 * Constructs the search menu for the window.
	 */
	private void buildSearchMenu() {
		final JPanel mySearchPanel = new JPanel(new BorderLayout());
		myBackButton = buildBackButton();
		mySearchButton = buildSearchButton();
		mySearchBar = buildSearchBar();
		mySearchPanel.add(mySearchBar, BorderLayout.CENTER);
		mySearchPanel.add(myBackButton, BorderLayout.WEST);
		mySearchPanel.add(mySearchButton, BorderLayout.EAST);
		this.add(mySearchPanel, BorderLayout.NORTH);
	}
	
	private JButton buildSubmitButton() {
		mySubmitButton = new JButton("Submit new project");
		mySubmitButton.addActionListener((theEvent) -> {
			myframe.remove(this);
			myframe.add(mySubmitPanel);
			mySubmitPanel.setVisible(true);
		});
		return mySubmitButton;
	}
	
	private JTextField buildSearchBar() {
		mySearchBar = new JTextField("Enter tag to search for.");
		return mySearchBar;
	}
	
	private JButton buildBackButton() {
		final JButton myBackButton = new JButton("Back");
		myBackButton.addActionListener((theEvent) -> { 
			this.setVisible(false);
			myframe.remove(this);
			myLandingPanel.setVisible(true);
			myframe.add(myLandingPanel);
			
		});
		return myBackButton;
	}
	
	private JButton buildSearchButton() {
		final JButton mySearchButton = new JButton("Search");
		mySearchButton.addActionListener((theEvent) -> {
			myTag = mySearchBar.getText();
			populate();
		});
		return mySearchButton;
	}
	
	private void populate() {
		if (myApplcationModel != null) {
			List<ProjectModel> myProjects = myApplcationModel.getProjects(myTag);
			myCategoryPanel = new JPanel();
			myCategoryPanel.setBackground(Color.BLACK);
			GridLayout myCategoryLayout = new GridLayout(myProjects.size() / 2, 2);
			myCategoryLayout.setHgap(10);
			myCategoryLayout.setVgap(10);
			myCategoryPanel.setLayout(myCategoryLayout);
			for(ProjectModel project : myProjects) {
				JButton projectButton = new JButton(project.getName());
				try {
					projectButton.setIcon(new ImageIcon(project.getImageLink()));
				} catch (Exception e){
					System.out.println(e);
				}
				projectButton.addActionListener((theEvent) -> {
					this.setVisible(false);
					myframe.remove(this);
					myframe.add(myProjectPanel);
					myProjectPanel.setVisible(true);
				});
				myCategoryPanel.add(projectButton);
			}
		}
		//Comment this after testing
		myCategoryPanel = new JPanel();
		GridLayout myCategoryLayout = new GridLayout(5, 2);
		myCategoryLayout.setHgap(10);
		myCategoryLayout.setVgap(10);
		myCategoryPanel.setLayout(myCategoryLayout);
		for (int i = 0; i < 5; i++) {
			JButton fake = new JButton("test");
			fake.addActionListener((theEvent) -> {
				this.setVisible(false);
				myframe.remove(this);
				myframe.add(myProjectPanel);
				myProjectPanel.setVisible(true);
			});
			myCategoryPanel.add(fake);
		}
		//Comemnt this after testing.
	}
	
	/**
	 * Receives a tag from the LandingPanel and updates the shown projects.
	 * @param theTag is the string received from the LandingPanel.
	 */
	protected void sendTag(final String theTag) {
		myTag = theTag;
		myframe.setTitle(myTag);
		this.setVisible(true);
	}
	
	public void passIn(JFrame theFrame,ApplicationModel theApp, LandingPanel theLand, 
					   SubmitPanel theSub, ProjectPanel thePro) {
		myApplcationModel = theApp;
		myLandingPanel = theLand;
		myProjectPanel = thePro;
		mySubmitPanel = theSub;
		myframe = theFrame;
	}
}