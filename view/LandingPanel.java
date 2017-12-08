package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.ApplicationModel;

/*
 * Author: Carter Odem
 * the landing page for the application from here you can either search a tag or click on one
 *  of the most popular tags
 */
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

	// the Search bar
	private JTextField searchBar = new JTextField();

	// label for the search bar
	private JLabel saerchLb = new JLabel("search");

	// array of buttons that will be used as category's
	private ProjectBtn[] projectBtns = new ProjectBtn[8];

	// button to import projects to the application
	private JButton importBtn = new JButton("Import");
	// button to save all the projects to a file
	private JButton exportBtn = new JButton("Export");
	
	JFrame myFrame;

	/**
	 * the back end model
	 */
	private ApplicationModel myApplicationModel;

	/**
	 * the next panel that will potentialy called
	 */
	private CategoryPanel myCategoryPanel;

	// defualt constructor for the landing panel setting the layout and size
	public LandingPanel() {
		super();
		this.setLayout(new GridBagLayout());
		config();
		/* Setting some properties of the panel. */
		setPreferredSize(LANDING_PANEL_SIZE);
		setBackground(LANDING_PANEL_BG_COLOR);
	}

	/*
	 * pass in function to get the data from the application model
	 */
	public void passIn(JFrame theFrame,ApplicationModel theApp, CategoryPanel theCat) {
		myApplicationModel = theApp;
		myCategoryPanel = theCat;
		myFrame = theFrame;
	}

	public void move() {
		myFrame.remove(this);
		myFrame.add(myCategoryPanel);
	}
	/*
	 * Config method to initialize all the components and add them to the landing
	 * panel
	 */
	public void config() {
		// action for the search BAR
		AbstractAction action = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				move();
				myCategoryPanel.sendTag(searchBar.getText());
			}
		};

		GridBagConstraints c = new GridBagConstraints();
		if (myApplicationModel != null) {
			List<String> catagories = myApplicationModel.getTags();
		}
		// only run if there are no projects
		if (myApplicationModel != null) {
			// setting up the catagory buttons
			for (int i = 0; i < 4; i++) {
				ImageIcon img = new ImageIcon(myApplicationModel.getProjects(myApplicationModel.getTags().get(i)).get(0).getImageLink());
				c.insets = new Insets(5, 0, 0, 0);
				c.ipady = 200;
				c.ipadx = 150;
				c.gridx = i;
				c.gridy = 2;
				String tag = myApplicationModel.getTags().get(i);
				projectBtns[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						myCategoryPanel.sendTag(tag);
					}
				});
				projectBtns[i].setIcon(img);
				projectBtns[i] = new ProjectBtn();
				this.add(projectBtns[i], c);

			}
			// setting up the second row of catagory buttons
			for (int i = 0; i < 4; i++) {
				ImageIcon img = new ImageIcon(
						myApplicationModel.getProjects(myApplicationModel.getTags().get(i + 3)).get(0).getImageLink());
				c.ipady = 200;
				c.ipadx = 150;
				c.gridx = i;
				c.gridy = 3;
				String tag = myApplicationModel.getTags().get(i);
				projectBtns[i + 3].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						myCategoryPanel.sendTag(tag);
					}
				});
				projectBtns[i + 3].setIcon(img);
				projectBtns[i] = new ProjectBtn();
				this.add(projectBtns[i], c);
			}
		}else{// default buttons
		
			
		}

		// setting up the search bar
		c.ipady = 10;
		c.ipadx = 600;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;

		c.insets = new Insets(5, 0, 30, 0);
		searchBar.addActionListener(action);
		searchBar.setPreferredSize(new Dimension(600, 50));

		this.add(searchBar, c);

		// Setting up the import and export buttons
		c.anchor = GridBagConstraints.WEST;
		this.add(saerchLb, c);
		c.insets = new Insets(10, 5, 5, 5);
		c.ipadx = 80;
		c.fill = GridBagConstraints.NONE;
		c.gridx = 2;
		c.gridy = 4;

		this.add(importBtn, c);

		c.gridx = 3;
		c.gridy = 4;
		this.add(exportBtn, c);

	}

//	/**
//	 * A test method to run and display this panel only.
//	 */
//	public static void main(String[] args) {
//		final JFrame frame = new JFrame("Landing page");
//
//		LandingPanel landingPage = new LandingPanel();
//
//		frame.add(landingPage);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(LANDING_PANEL_SIZE);
//		frame.setResizable(false);
//		frame.setLocationRelativeTo(null);
//		frame.setVisible(true);
//	}

}