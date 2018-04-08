package Frame;

import javax.swing.JFrame;

import MainPanel.MainPanel;

//**********************************************************************
/* Author = Jesse LaFlesch
* File = Driver.java
* Creation Date: 4/5/18
* Purpose = Heavy weight container for all the things
***********************************************************************/

public class Driver {
	
	public static void main(String[] args)  {
		
	// Making the frame
		JFrame myFrame = new JFrame("Wack-A-Booby");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	// Making a panel using LevelPanel class that we made
		MainPanel mainPanel = new MainPanel(); 
		
	// Putting that panel on the frame and making it visible
		myFrame.getContentPane().add(mainPanel);
		myFrame.add(mainPanel);
		myFrame.pack();
		myFrame.setVisible(true);
		
		
	}

}