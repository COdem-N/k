package model;

import java.awt.EventQueue;

import view.MainGUI;

/**
 * The main driver class of the program.
 * 
 * @author Carter Odem, Peter Bae, Alex Merk, edited by Logan Stafford
 * @version 1.0
 */
public class Main {

    /************************************
     ** CLASS CONSTRUCTOR AND METHODS **
     ***********************************/
	
	/**
	 * The main method - simply a caller for the MainGUI class.
	 * 
	 * @param args Command line arguments (not applicable for this program).
	 */
	public static void main(String[] args) {
		
		/* Creating and running the MainGUI class. */
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGUI();
            }
        });
	}

}