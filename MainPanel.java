package MainPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Classes.Booby;
import Classes.Game;
import Classes.Movement;
import Classes.Player;

//**********************************************************************
/* Author = Jesse LaFlesch
* File = Driver.java
* Creation Date: 4/5/18
* Purpose = Light weight container for all the things
***********************************************************************/

public class MainPanel extends JPanel
{
	private Player myPlayer;
	private Game myGame;
	private Booby[] myBooby = new Booby[5];
	private ImageIcon myImage1;
	private ImageIcon[] myBoobyImage = new ImageIcon[5];
	private Movement movement; 
	
	private JPanel myCenterPanel;
	
	private Random generator = new Random();
	private int minNum = 50;
	private int maxNum = 701;
	
	public MainPanel()
	{
		
		setPreferredSize(new Dimension(2000,1400));
		setLayout(new BorderLayout());
		setFocusable(true);
	}
	
}
