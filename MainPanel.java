package MainPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Children.Booby;
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
	private Booby myBooby;
	private Booby[] myBoobyArray = new Booby[5];
	private ImageIcon myImage1;
	private ImageIcon[] myBoobyImageArray = new ImageIcon[5];
	private Movement movement; 
	
	private JPanel myCenterPanel;
	
	private Random generator = new Random();
	private int minNum = 50;
	private int maxNum = 1401;
	
	public MainPanel()
	{
		myPlayer = new Player();

		
		setPreferredSize(new Dimension(2000,1400));
		setLayout(new BorderLayout());
		setFocusable(true);
		
		for(int i = 0; i < myBoobyArray.length; i++)
		{
			myBooby = new Booby(generator.nextInt(maxNum) + minNum, generator.nextInt(maxNum) + minNum);
			myImage1 = new ImageIcon(myBooby.getImageName());
			myBoobyImageArray[i] = myImage1;
			myBoobyArray[i] = myBooby;
		}
		
		movement = new Movement(myPlayer, myBoobyArray, myBoobyImageArray, this);
		movement.startTimer();
		addMouseListener(movement);
		repaint();
	}
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		
		for(int i = 0; i < myBoobyImageArray.length; i++)
		{
			if (myBoobyImageArray[i] == null)
			{
				continue;
			}
			else
			{
				page.drawImage(myBoobyImageArray[i].getImage(), myBoobyArray[i].getxLoc(), myBoobyArray[i].getyLoc(), null);
			}
		}
	}
}
