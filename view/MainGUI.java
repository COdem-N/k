package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFrame;

import model.ApplicationModel;
import model.ProjectModel;

/**
 * The main GUI for the program.
 * 
 * @author Peter Bae
 * @author Logan Stafford (editing)
 * @author Carter Odem (editing)
 * 
 * @version 1.0
 */
public class MainGUI implements WindowListener {
	
    /************************************
     **          CLASS FIELDS         **
     ***********************************/
	
	/**
	 * Toolkit used to set the frame location.
	 */
	private static final Toolkit KIT = Toolkit.getDefaultToolkit();
	
	/**
	 * Gets the user's monitor resolutions.
	 */
	private static final Dimension SCREENSIZE = KIT.getScreenSize();
	
	/**
	 * First Panel of the program.
	 */
	private LandingPanel myLandingPanel;
	
	/**
	 * Panel to display the tagged Projects.
	 */
	private CategoryPanel myCategoryPanel;
	
	/**
	 * Panel to display the individual Project details.
	 */
	private ProjectPanel myProjectPanel;
	
	/**
	 * Panel used to submit new projects.
	 */
	private SubmitPanel mySubmitPanel;
	
	/**
	 * Aggregation of ProjectModels
	 */
	private ApplicationModel myApplicationModel;
	
	/**
	 * The main frame for the program.
	 */
	private JFrame myFrame;
	
    /************************************
     ** CLASS CONSTRUCTOR AND METHODS **
     ***********************************/
	
	/**
	 * Constructor to initialize and setup all the panels
	 * and loads from an existing save file if one exists.
	 * 
	 * @author Peter Bae
	 */
	public MainGUI() {
		myFrame = new JFrame();
		myLandingPanel = new LandingPanel();
		myCategoryPanel = new CategoryPanel();
		myProjectPanel = new ProjectPanel();	
		mySubmitPanel = new SubmitPanel();	
		
		try {
			load();
			//System.out.println(myApplicationModel.getTags().size());
		} catch (IOException e) {
			System.out.println("No existing save");
			myApplicationModel = new ApplicationModel();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		myFrame.addWindowListener(this);
		setup();
	}
	
	/**
	 * Helper method to setup all the panels.
	 * 
	 * @author Peter Bae
	 */
	private void setup() {
		myLandingPanel.passIn(myFrame, myApplicationModel, myCategoryPanel);
		myCategoryPanel.passIn(myFrame, myApplicationModel, myLandingPanel, mySubmitPanel, myProjectPanel);
		myProjectPanel.passIn(myFrame, myCategoryPanel);
		mySubmitPanel.passIn(myFrame, myApplicationModel, myCategoryPanel);
		
		myLandingPanel.setup();
		myCategoryPanel.setup();
		myProjectPanel.setup();
		mySubmitPanel.setup();
		
		myFrame.setTitle("Special K - DIY Project Manager");
		myFrame.setSize(800, 600);
		myFrame.setLocation(SCREENSIZE.width / 2 - myFrame.getWidth() / 2, 
					SCREENSIZE.height / 2 - myFrame.getHeight() / 2);
		myFrame.setVisible(true);
		
		
		myFrame.add(myCategoryPanel);
		myCategoryPanel.setVisible(false);
		myFrame.add(myProjectPanel);
		myProjectPanel.setVisible(false);
		myFrame.add(mySubmitPanel);
		mySubmitPanel.setVisible(false);
		myFrame.add(myLandingPanel);
		
		myFrame.setResizable(false);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Saves from an existing save file if that file exists,
	 * if not, creates a new save file.
	 * 
	 * @author Peter Bae
	 * 
	 * @throws IOException If the file path is not valid.
	 * @throws ClassNotFoundException Thrown if type casts are wrong.
	 */


	private void load() throws IOException, ClassNotFoundException {
		FileInputStream fis =  new FileInputStream("saveFile.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ProjectModel.setRunningID((int) ois.readObject());
		myApplicationModel = (ApplicationModel) ois.readObject();

		ois.close();
		fis.close();
	}
	
	/**
	 * Saves the current session to a save file.
	 * 
	 * @author Peter Bae
	 * 
	 * @throws IOException Thrown if the file path cannot be accessed.
	 */
	private void save() throws IOException {
		FileOutputStream fos = new FileOutputStream("saveFile.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(ProjectModel.getRunningID());
		oos.writeObject(myApplicationModel);
		
		oos.close();
		fos.close();
	}

    /**
     * 
     */
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Tries to save before closing out of the program.
	 * 
	 * @author Peter Bae
	 * 
	 * @param theEvent The closing event.
	 */
	@Override
	public void windowClosing(WindowEvent theEvent) {
		try {
			save();
		} catch (IOException e1) {
			System.out.println("Couldn't find the file path");
		}
	}

    /**
     * 
     */
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

    /**
     * 
     */
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

    /**
     * 
     */
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

    /**
     * 
     */
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

    /**
     * 
     */
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}