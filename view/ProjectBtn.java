package view;
import java.awt.Dimension;

import javax.swing.JButton;

import model.ProjectModel;


/*
 * projects buttons to be used in the landing panel and catagory panel
 * Author:Carter Odem
 */
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
