import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class GUIinterface extends JFrame
{
	JPanel mPanel = new JPanel();
	JButton indoor= new JButton("Add New Employee");
	JButton outdoor= new JButton("View Employees");
	
	public void ClearHome()
	{
		indoor.setVisible(false);
		outdoor.setVisible(false);
	}
	
	public void HomeView()
	{
		indoor.setVisible(true);
		outdoor.setVisible(true);
	}
	
	public GUIinterface()
	{
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		mPanel.setLayout(null);
		//home
		indoor.setBounds(150,100, 300, 150);
		outdoor.setBounds(150, 300, 300,150);
		
		indoor.setVisible(false);
		outdoor.setVisible(false);
		 
		indoor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event)
				{
					ClearHome();
					//indoor();
				}
			});
	
		
		add(mPanel);
		mPanel.add(indoor);
		mPanel.add(outdoor);
		
	}
	
}
