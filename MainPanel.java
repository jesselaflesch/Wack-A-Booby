package MainPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Children.Booby;
import Children.Splat;
import Classes.Game;
import Classes.Movement;
import Classes.Player;
import Interface.UpdateArrays;
import Timers.BoobyImageTimer;
import Timers.BoobyTimerListener;

//**********************************************************************
/* Author = Jesse LaFlesch
* File = Driver.java
* Creation Date: 4/5/18
* Purpose = Light weight container for all the things
***********************************************************************/

public class MainPanel extends JPanel implements UpdateArrays
{
	private Player myPlayer;
	private Game myGame;
	private Booby myBooby;
	private Booby[] myBoobyArray = new Booby[5];
	private ImageIcon myImage1, myReversedImage1, mySplatImage;
	private ImageIcon[] myBoobyImageArray = new ImageIcon[5];
	private ImageIcon[] myReversedImageArray = new ImageIcon[5];
	private Splat mySplat;
	private ArrayList<Splat> mySplatArray = new ArrayList<Splat>();


	private BoobyTimerListener myBoobyMovement; 
	private BoobyImageTimer myBoobyImageTimer;
	
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
			myReversedImage1 = new ImageIcon(myBooby.getImageNameReversed());
			myReversedImageArray[i] = myReversedImage1;
			myBoobyImageArray[i] = myImage1;
			myBoobyArray[i] = myBooby;
			
		}
		
		
		myBoobyMovement = new BoobyTimerListener(myPlayer, myBoobyArray, myBoobyImageArray, this);
		myBoobyMovement.startTimer();
		addMouseListener(myBoobyMovement);
		myBoobyImageTimer = new BoobyImageTimer(myPlayer, myBoobyArray, myBoobyImageArray, this, myReversedImageArray);
		myBoobyImageTimer.startTimer();
		repaint();
	}
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		
		for(int i = 0; i < myBoobyImageArray.length; i++)
		{
			if (myBoobyImageArray[i] == null)
			{
				mySplat = new Splat(myBoobyArray[i].getxLoc(), myBoobyArray[i].getyLoc());
				mySplatImage = new ImageIcon(mySplat.getImageName());
				mySplatArray.add(mySplat);
				myBooby = new Booby(generator.nextInt(maxNum) + minNum, generator.nextInt(maxNum) + minNum);
				myBoobyArray[i] = myBooby;
				myImage1 = new ImageIcon(myBooby.getImageName());
				myBoobyImageArray[i] = myImage1;
				myBoobyMovement.updateBoobyArray(myBoobyArray, myBoobyImageArray);
				myBoobyImageTimer.updateBoobyArray(myBoobyArray, myBoobyImageArray);
			}
			else
			{			
				page.drawImage(myBoobyImageArray[i].getImage(), myBoobyArray[i].getxLoc(), myBoobyArray[i].getyLoc(), null);
			}
			
		}
		for (int i = 0; i < mySplatArray.size(); i++)
		{
			page.drawImage(mySplatImage.getImage(), mySplatArray.get(i).getxLoc(), mySplatArray.get(i).getyLoc(), null);
		}
		
	}
	public void setMyBoobyImageArray(int i, ImageIcon image) 
	{
		this.myBoobyImageArray[i] = image;
	}
	public void setMyBoobyImageArrayNull(int i)
	{
		this.myBoobyImageArray[i] = null;
	}

	@Override
	public void updateBoobyArray(Booby[] myBoobyArray, ImageIcon[] myBoobyImageArray) 
	{
		for (int i = 0; i < myBoobyArray.length; i++)
		{
			this.myBoobyArray[i] = myBoobyArray[i];
		}
		
		for (int i = 0; i < myBoobyImageArray.length; i++)
		{
			this.myBoobyImageArray[i] = myBoobyImageArray[i];
		}
		
	}
}
