package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
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
	private JLabel mySearchLabel = new JLabel("Search");

	// array of buttons that will be used as category's
	private JButton[] projectBtns = new JButton[8];

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
		this.setVisible(false);
		myFrame.remove(this);
		myFrame.add(myCategoryPanel);
		myCategoryPanel.setVisible(true);
	}
	/*
	 * Config method to initialize all the components and add them to the landing
	 * panel
	 */
	public void setup() {
		for (int i = 0; i < 8; i++) {
			projectBtns[i] = new JButton();
		}
		// action for the search BAR
		AbstractAction action = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
				move();
				myCategoryPanel.sendTag(searchBar.getText());
			}
		};
		
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTH;
		
		// setting up the search bar
		//c.ipady = 10;
		//c.ipadx = 10;
		

		c.insets = new Insets(5, 0, 30, 0);
		searchBar.addActionListener(action);
		searchBar.setPreferredSize(new Dimension(600, 25));
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		this.add(mySearchLabel, c);
		
		c.gridy = 1;
		
		this.add(searchBar, c);

		// Setting up the import and export buttons
		//c.anchor = GridBagConstraints.WEST;
		
		//c.insets = new Insets(10, 5, 5, 5);
		//c.ipadx = 80;
		//c.fill = GridBagConstraints.NONE;

		
		List<String> tags = myApplicationModel.getTags();
			
		int tagCount = myApplicationModel.getTags().size();
		// only run if there are no projects
		if (tagCount != 0) {
			// setting up the first row of tag buttons
			for (int i = 0; i < (tagCount > 4 ? 4 : tagCount); i++) {
				c.gridwidth = 1;
				c.gridx = i;
				c.gridy = 2;
				ImageIcon icon = new ImageIcon(myApplicationModel.getProjects(myApplicationModel.getTags().get(i)).get(0).getImageLink());
				Image image = icon.getImage();
				image = image.getScaledInstance(140, 140, Image.SCALE_SMOOTH);
				icon = new ImageIcon(image);
				
//				c.insets = new Insets(5, 0, 0, 0);
//				c.ipady = 200;
//				c.ipadx = 150;
				
				projectBtns[i].setIcon(icon);
				
				String tag = myApplicationModel.getTags().get(i);
				projectBtns[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						myCategoryPanel.sendTag(tag);
						move();
					}
				});
				
				this.add(projectBtns[i], c);

			}
			// setting up the second row of tag buttons
			for (int i = 0; i < (tagCount > 8 ? 4 : tagCount - 4); i++) {
				c.gridwidth = 1;
				c.gridx = i;
				c.gridy = 3;
				ImageIcon icon = new ImageIcon(myApplicationModel.getProjects(myApplicationModel.getTags().get(i+4)).get(0).getImageLink());
				Image image = icon.getImage();
				image = image.getScaledInstance(140, 140, Image.SCALE_SMOOTH);
				icon = new ImageIcon(image);
				String tag = myApplicationModel.getTags().get(i+4);
				projectBtns[i + 4].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						myCategoryPanel.sendTag(tag);
						move();
					}
				});
				projectBtns[i + 4].setIcon(icon);
				this.add(projectBtns[i+4], c);
			}
		}
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;

		this.add(importBtn, c);
		c.gridx = 2;

		this.add(exportBtn, c);
	}
	
	private void reset() {
		searchBar.setText("");
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