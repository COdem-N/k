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
public class MainGUI extends JFrame implements WindowListener {
	private static final Toolkit KIT = Toolkit.getDefaultToolkit();
	private static final Dimension SCREENSIZE = KIT.getScreenSize();
	private LandingPanel myLandingPanel;
	private CategoryPanel myCategoryPanel;
	private ProjectPanel myProjectPanel;
	private SubmitPanel mySubmitPanel;
	private ApplicationModel myApplicationModel;
	
	public MainGUI() {
		myLandingPanel = new LandingPanel();
		myCategoryPanel = new CategoryPanel();
		myProjectPanel = new ProjectPanel();
		mySubmitPanel = new SubmitPanel();	
		try {
			load();
		} catch (IOException e) {
			System.out.println("No existing save");
			myApplicationModel = new ApplicationModel();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addWindowListener(this);
		setup();
	}
	
	private void setup() {
		//testProject();
		myLandingPanel.passIn(myApplicationModel, myCategoryPanel);
		myCategoryPanel.passIn(myApplicationModel, myLandingPanel, mySubmitPanel, myProjectPanel);
		myProjectPanel.passIn(myApplicationModel, myCategoryPanel);
		mySubmitPanel.passIn(myApplicationModel, myCategoryPanel);
		setTitle("K");
		setSize(800, 600);
		setLocation(SCREENSIZE.width / 2 - getWidth() / 2, 
					SCREENSIZE.height / 2 - getHeight() / 2);
		setVisible(true);
		add(myCategoryPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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