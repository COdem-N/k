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
     * 
     */
    private ApplicationModel myApplcationModel;
    
    /**
     * 
     */
    private LandingPanel myLandingPanel;
    
    private ProjectPanel myProjectPanel;
    
    private SubmitPanel mySubmitPanel;
    
	public CategoryPanel() {
			super();
			
	        /* Setting some properties of the panel. */
	        setPreferredSize(CATEGORY_PANEL_SIZE);
	        setBackground(CATEGORY_PANEL_BG_COLOR);
	        setup();
	}
	
	private void setup() {
		this.setLayout(new BorderLayout());
		buildScrollMenu();
		this.setVisible(true);
	}
	
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
	
	private void buildSearchMenu() {
		final JPanel mySearchPanel = new JPanel(new BorderLayout());
		final JTextField mySearchBar = new JTextField("Enter tag to search for.");
		// TODO finish mySearchBar.addActionListener();
		final JButton myBackButton = new JButton("Back");
		// TODO finish myBackButton.addActionListener();
		final JButton mySearchButton = new JButton("Back");
		// TODO finish mySearchButton.addActionListener();
	}
	
	public void passIn(ApplicationModel theApp, LandingPanel theLand, 
					   SubmitPanel theSub, ProjectPanel thePro) {
		myApplcationModel = theApp;
		myLandingPanel = theLand;
		myProjectPanel = thePro;
		mySubmitPanel = theSub;
	}
}