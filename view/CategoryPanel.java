package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import javafx.scene.layout.Border;
import model.ApplicationModel;

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
    
    private JTextField mySearchBar;
    
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
	private void setup() {
		this.setLayout(new BorderLayout());
		buildScrollMenu();
		buildSearchMenu();
		this.setVisible(true);
	}
	
	/**
	 * Constructs the menu for scrolling through submitted projects.
	 */
	private void buildScrollMenu() {
		final JPanel myCategoryPanel = new JPanel();
		myCategoryPanel.setBackground(Color.BLACK);
		GridLayout myCategoryLayout = new GridLayout(20, 2);
		myCategoryLayout.setHgap(10);
		myCategoryLayout.setVgap(10);
		myCategoryPanel.setLayout(myCategoryLayout);
		final JScrollPane myCategoryScroller = new JScrollPane(myCategoryPanel);
		myCategoryScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		myCategoryScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		myCategoryScroller.setPreferredSize(new Dimension(50, 6000));
		myCategoryScroller.getVerticalScrollBar().setUnitIncrement(20);
		this.add(myCategoryScroller, BorderLayout.CENTER);
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
		
		
	}
	
	private JTextField buildSearchBar() {
		final JTextField mySearchBar = new JTextField("Enter tag to search for.");
		/*
		mySearchBar.addActionListener((theEvent) -> {
			
		});
		*/
		return mySearchBar;
	}
	
	private JButton buildBackButton() {
		final JButton myBackButton = new JButton("Back");
		myBackButton.addActionListener((theEvent) -> { 
			
		});
		return myBackButton;
	}
	
	private JButton buildSearchButton() {
		final JButton mySearchButton = new JButton("Search");
		mySearchButton.addActionListener((theEvent) -> {
			myTag = mySearchBar.getText();
		});
		return mySearchButton;
	}
	
	/**
	 * Receives a tag from the LandingPanel and updates the shown projects.
	 * @param theTag is the string received from the LandingPanel.
	 */
	protected void sendTag(final String theTag) {
		myTag = theTag;
	}
	
	public void passIn(ApplicationModel theApp, LandingPanel theLand, 
					   SubmitPanel theSub, ProjectPanel thePro) {
		myApplcationModel = theApp;
		myLandingPanel = theLand;
		myProjectPanel = thePro;
		mySubmitPanel = theSub;
	}
}