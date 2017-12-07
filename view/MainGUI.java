package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.ApplicationModel;
import model.ProjectModel;

@SuppressWarnings("serial")
public class MainGUI implements WindowListener {
	
	private static final Toolkit KIT = Toolkit.getDefaultToolkit();
	private static final Dimension SCREENSIZE = KIT.getScreenSize();
	private LandingPanel myLandingPanel;
	private CategoryPanel myCategoryPanel;
	private ProjectPanel myProjectPanel;
	private SubmitPanel mySubmitPanel;
	private ApplicationModel myApplicationModel;
	private JFrame myframe;
	
	public MainGUI() {
		myframe = new JFrame();
		myLandingPanel = new LandingPanel();
		myLandingPanel.config();
		myCategoryPanel = new CategoryPanel();
		myCategoryPanel.setup();
		myProjectPanel = new ProjectPanel();
		myProjectPanel.setup();
		mySubmitPanel = new SubmitPanel();	
		mySubmitPanel.setup();
		try {
			load();
		} catch (IOException e) {
			System.out.println("No existing save");
			myApplicationModel = new ApplicationModel();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myframe.addWindowListener(this);
		setup();
	}
	
	private void setup() {
		//git adtestProject();
		myLandingPanel.passIn(myframe,myApplicationModel, myCategoryPanel);
		myCategoryPanel.passIn(myframe,myApplicationModel, myLandingPanel, mySubmitPanel, myProjectPanel);
		myProjectPanel.passIn(myframe,myApplicationModel, myCategoryPanel);
		mySubmitPanel.passIn(myframe,myApplicationModel, myCategoryPanel);
		
		myframe.setTitle("K");
		myframe.setSize(800, 600);
		myframe.setLocation(SCREENSIZE.width / 2 - myframe.getWidth() / 2, 
					SCREENSIZE.height / 2 - myframe.getHeight() / 2);
		myframe.setVisible(true);
		
		
		myframe.add(myCategoryPanel);
		myCategoryPanel.setVisible(false);
		myframe.add(myProjectPanel);
		myProjectPanel.setVisible(false);
		myframe.add(mySubmitPanel);
		mySubmitPanel.setVisible(false);
		
		
		myframe.add(myLandingPanel);
		
		
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void testProject()  {
		ProjectModel test = new ProjectModel("testing", "icon.png", "a hammer", 2, 2, "test project", null);
		myApplicationModel.addProject(test);
	}
	
	private void load() throws IOException, ClassNotFoundException {
		FileInputStream fis =  new FileInputStream("saveFile.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ProjectModel.onLoad((int) ois.readObject());
		myApplicationModel = (ApplicationModel) ois.readObject();
		
		System.out.println(myApplicationModel);
		ois.close();
		fis.close();
	}
	
	private void save() throws IOException {
		FileOutputStream fos = new FileOutputStream("saveFile.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(ProjectModel.getRunningID());
		oos.writeObject(myApplicationModel);
		
		oos.close();
		fos.close();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		try {
			save();
		} catch (IOException e1) {
			System.out.println("Couldn't find the file path");
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}