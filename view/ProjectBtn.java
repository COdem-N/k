package view;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import model.ProjectModel;



public class ProjectBtn extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProjectModel theProject;
	
	ProjectBtn() {
		super();
//		this.setBorder(BorderFactory.createEmptyBorder());
//		this.setContentAreaFilled(false);
		this.setPreferredSize(new Dimension(150, 200));
	}

}
