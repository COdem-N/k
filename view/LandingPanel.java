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
import javax.swing.JTextField;

import model.ApplicationModel;

@SuppressWarnings("serial")
public class LandingPanel extends JPanel {

	/**
	 * A Dimension object representing the panel size of the Landing panel.
	 */
	private static final Dimension LANDING_PANEL_SIZE = new Dimension(800, 600);

	/**
	 * A Color object to be used as the background color of the Landing panel.
	 */
	private static final Color LANDING_PANEL_BG_COLOR = new Color(60, 141, 13);

	private JTextField searchBar = new JTextField();
	
	private JLabel saerchLb = new JLabel("search");

	private ProjectBtn[] projectBtns = new ProjectBtn[8];
	
	private JButton importBtn = new JButton("Import");
	private JButton exportBtn = new JButton("Export");
	
	

	/**
	 * 
	 */
	private ApplicationModel myApplcationModel;

	/**
	 * 
	 */
	private CategoryPanel myCategoryPanel;

	public LandingPanel() {
		super();
		this.setLayout(new GridBagLayout());
		config();

		/* Setting some properties of the panel. */
		setPreferredSize(LANDING_PANEL_SIZE);
		setBackground(LANDING_PANEL_BG_COLOR);
	}

	public void passIn(ApplicationModel theApp, CategoryPanel theCat) {
		myApplcationModel = theApp;
		myCategoryPanel = theCat;
	}

	public void config() {

		GridBagConstraints c = new GridBagConstraints();

		
		
		 for(int i=0; i<4; i++) {
			 c.insets = new Insets(5,0,0,0);
			 c.ipady = 200;
			 c.ipadx = 150;
			 c.gridx = i;
			 c.gridy = 2; 
			 projectBtns[i] = new ProjectBtn();
			 this.add(projectBtns[i], c);
		 
		 }
		 
		 for(int i=0; i<4; i++) {
			 c.ipady = 200;
			 c.ipadx = 150;
			 c.gridx = i; 
			 c.gridy = 3; 
			 projectBtns[i] = new ProjectBtn();
			 this.add(projectBtns[i], c);
		 
		 }
		 	c.ipady = 10;
		 	c.ipadx = 600;
			c.gridx = 0; 
			c.gridy = 0;
			c.gridwidth = 4;
		
			c.insets = new Insets(5,0,30,0);
			searchBar.setPreferredSize(new Dimension(600, 50));
			
			
			this.add(searchBar, c);
			
			c.anchor = GridBagConstraints.WEST;
			this.add(saerchLb, c);
			c.insets = new Insets(10,5,5,5);
			c.ipadx = 80;
			c.fill =GridBagConstraints.NONE ;
			c.gridx = 2; 
			c.gridy = 4;

			this.add(importBtn, c);
		
			c.gridx = 3;
			c.gridy = 4;
			this.add(exportBtn, c);
			
			


	}

	/**
	 * A test method to run and display this panel only.
	 */
	public static void main(String[] args) {
		final JFrame frame = new JFrame("Landing page");

		LandingPanel landingPage = new LandingPanel();

		frame.add(landingPage);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(LANDING_PANEL_SIZE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}