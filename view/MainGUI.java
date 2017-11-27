package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import model.ApplicationModel;

public class MainGUI extends JFrame {
	private static final Toolkit KIT = Toolkit.getDefaultToolkit();
	private static final Dimension SCREENSIZE = KIT.getScreenSize();
	private SplashPanel mySplashPanel;
	private LandingPanel myLandingPanel;
	private CategoryPanel myCategoryPanel;
	private ProjectPanel myProjectPanel;
	private SubmitPanel mySubmitPanel;
	private ApplicationModel myApplicationModel;
	
	public MainGUI() {
		mySplashPanel = new SplashPanel();
		myLandingPanel = new LandingPanel();
		myCategoryPanel = new CategoryPanel();
		myProjectPanel = new ProjectPanel();
		mySubmitPanel = new SubmitPanel();
		myApplicationModel = new ApplicationModel();
		setup();
	}
	
	private void setup() {
		setTitle("K");
		setSize(800, 600);
		setLocation(SCREENSIZE.width / 2 - getWidth() / 2, 
					SCREENSIZE.height / 2 - getHeight() / 2);
		setVisible(true);
	}
	
	private void load() {
		
	}
	
	private void save() {
		
	}
}
