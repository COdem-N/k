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
import javax.swing.SwingConstants;

import model.ApplicationModel;

/**
 * @author Carter Odem
 * @author Logan Stafford (comments and editing)
 * 
 * The landing page for the application from here you can either search a tag or click on one
 *  of the most popular tags
 */
@SuppressWarnings("serial")
public class LandingPanel extends JPanel {

    /************************************
     **          CLASS FIELDS         **
     ***********************************/
	
	/**
	 * A Dimension object representing the panel size of the Landing panel.
	 */
	private static final Dimension LANDING_PANEL_SIZE = new Dimension(800, 600);

	/**
	 * A Color object to be used as the background color of the Landing panel.
	 */
	private static final Color LANDING_PANEL_BG_COLOR = new Color(0, 0, 75);

    /**
     * A JTextField object used for the Search bar.
     */
	private JTextField mySearchBar = new JTextField("Enter tag(s) to search for here...");

    /**
     * A JLabel object used to label the Search bar.
     */
	private JLabel mySearchLabel = new JLabel("Search for a Project! Or, choose from common tags below.");

    /**
     * An array of JButton objects used to represent each category of projects.
     */
	private JButton[] myProjectButtons = new JButton[8];
	
    /**
     * The JFrame of the program.
     */
	private JFrame myFrame;

	/**
	 * The ApplicationModel (back end) of the program.
	 */
	private ApplicationModel myApplicationModel;

	/**
	 * the next panel that will potentially called
	 */
	private CategoryPanel myCategoryPanel;

    /************************************
     ** CLASS CONSTRUCTOR AND METHODS **
     ***********************************/
	
    /**
     * The LandingPanel() constructor. This just creates a LandingPanel and sets
     * it's layout and size.
     * 
     * @author Logan Stafford
     */
	public LandingPanel() {
		super();
		this.setLayout(new GridBagLayout());
		
		/* Setting some properties of the panel. */
		setPreferredSize(LANDING_PANEL_SIZE);
		setBackground(LANDING_PANEL_BG_COLOR);
	}


    /**
     * The passIn() method. This is used for switching between panels in the program.
     * 
     * @author Carter Odem
     */
	public void passIn(JFrame theFrame, ApplicationModel theApplicationModel, CategoryPanel theCategoryPanel) {
		myApplicationModel = theApplicationModel;
		myCategoryPanel = theCategoryPanel;
		myFrame = theFrame;
	}

    /**
     * The moveToCategory() method. THis is used to switch back to the CategoryPanel.
     * 
     * @author Carter Odem
     */
	public void moveToCategory() {
		this.setVisible(false);
		myFrame.remove(this);
		myFrame.add(myCategoryPanel);
		myCategoryPanel.setVisible(true);
	}
	
	/**
	 * The setup() method, used to initialize all the components and 
	 * add them to the LandingPanel.
	 * 
	 * @author Carter Odem
	 * @author Peter Bae (editing) 
	 * @author Logan Stafford (editing)
	 */
	public void setup() {
		for (int i = 0; i < 8; i++) {
			myProjectButtons[i] = new JButton();
			myProjectButtons[i].setVerticalTextPosition(SwingConstants.BOTTOM);
			myProjectButtons[i].setHorizontalTextPosition(SwingConstants.CENTER);
		}
		
		/* Setting up an action for the search bar. */
		AbstractAction action = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
				moveToCategory();
				myCategoryPanel.setTag(mySearchBar.getText());
			}
		};
		
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTH;
		
		/* Setting up the search bar. */
		c.insets = new Insets(5, 0, 20, 0);
		mySearchBar.addActionListener(action);
		mySearchBar.setPreferredSize(new Dimension(600, 25));
		mySearchLabel.setForeground(Color.WHITE);
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		this.add(mySearchLabel, c);
		
		c.gridy = 1;		
		this.add(mySearchBar, c);
		
		List<String> tags = myApplicationModel.getTags();			
		int tagCount = myApplicationModel.getTags().size();
		
		/* Only if there are no projects... */
		if (tagCount != 0) {			
			
			/* Setting up the first row of tag buttons. */
			for (int i = 0; i < (tagCount > 4 ? 4 : tagCount); i++) {
				c.gridwidth = 1;
				c.gridx = i;
				c.gridy = 2;
				ImageIcon icon = new ImageIcon(myApplicationModel.getProjects(tags.get(i)).get(0).getImageLink());
				Image image = icon.getImage();
				image = image.getScaledInstance(140, 140, Image.SCALE_SMOOTH);
				icon = new ImageIcon(image);				
				
				myProjectButtons[i].setText(tags.get(i));
				myProjectButtons[i].setIcon(icon);
				
				String tag = myApplicationModel.getTags().get(i);
				myProjectButtons[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						myCategoryPanel.setTag(tag);
						moveToCategory();
					}
				});
				
				this.add(myProjectButtons[i], c);
			}
			
			/* Setting up the second row of tag buttons. */
			for (int i = 0; i < (tagCount > 8 ? 4 : tagCount - 4); i++) {
				c.gridwidth = 1;
				c.gridx = i;
				c.gridy = 3;
				ImageIcon icon = new ImageIcon(myApplicationModel.getProjects(myApplicationModel.getTags().get(i+4)).get(0).getImageLink());
				Image image = icon.getImage();
				image = image.getScaledInstance(140, 140, Image.SCALE_SMOOTH);
				icon = new ImageIcon(image);
				String tag = myApplicationModel.getTags().get(i+4);
				
				myProjectButtons[i + 4].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						myCategoryPanel.setTag(tag);
						moveToCategory();
					}
				});
				
				myProjectButtons[i + 4].setText(tags.get(i + 4));
				myProjectButtons[i + 4].setIcon(icon);
				this.add(myProjectButtons[i + 4], c);
			}
		}
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
	}
	
	/**
	 * Resets the search bar.
	 * 
	 * @author Carter Odem
	 */
	private void reset() {
		mySearchBar.setText("");
	}

}