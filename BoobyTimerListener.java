package Timers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import Children.Booby;
import Classes.Movement;
import Classes.Player;
import Interface.Move;
import MainPanel.MainPanel;

public class BoobyTimerListener extends Movement implements ActionListener, Move
{
	
	public BoobyTimerListener(Player myPlayer, Booby[] myBoobyArray, ImageIcon[] myBoobyImageArray, MainPanel myPanel) {
		super(myPlayer, myBoobyArray, myBoobyImageArray, myPanel);
		
		
	}
	
	public void startTimer()
	{
		myBoobyTimer = new Timer(40, new BoobyTimerListener(myPlayer, myBoobyArray, myBoobyImageArray, myPanel));
		myBoobyTimer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		
		for (int i = 0; i < myBoobyArray.length; i++)
		{
			randint = generator.nextInt(16);
			switch (randint)
			{
			case 0:
				goUpAndLeft(i);
				break;
			case 1:
				goDownAndRight(i);
				break;
			case 2:
				goDownAndLeft(i);
				break;
			case 3:
				goUpAndRight(i);
				break;
			case 4:
				goUpAndLeftFast(i);
				break;
			case 5:
				goDownAndRightFast(i);
				break;
			case 6:
				goDownAndLeftFast(i);
				break;
			case 7:
				goUpAndRightFast(i);
				break;
			case 8:
				goUp(i);
				break;
			case 9:
				goDown(i);
				break;
			case 10:
				goLeft(i);
				break;
			case 11:
				goRight(i);
				break;
			case 12:
				goRightFast(i);
				break;
			case 13:
				goLeftFast(i);
				break;
			case 14:
				goUpFast(i);
				break;
			case 15:
				goDownFast(i);
				break;
			} // End switch
		}//End for loop
	// Update 2D array and border control.
		for (int i = 0; i < myBoobyArray.length; i++)
		{
			boobyLeftRightx[0][i] = myBoobyArray[i].getxLoc();
			boobyLeftRightx[1][i] = myBoobyArray[i].getxLoc() + myBoobyImageArray[i].getIconWidth();
			boobyTopBottomy[0][i] = myBoobyArray[i].getyLoc();
			boobyTopBottomy[1][i] = myBoobyArray[i].getyLoc() + myBoobyImageArray[i].getIconHeight();
		//Border Control
			if (boobyLeftRightx[0][i] < 0)
			{
				myBoobyArray[i].setxLoc(0);
				boobyLeftRightx[0][i] = myBoobyArray[i].getxLoc();
				boobyLeftRightx[1][i] = myBoobyArray[i].getxLoc() + myBoobyImageArray[i].getIconWidth();
			}
			else if (boobyLeftRightx[1][i] > 2000)
			{
				myBoobyArray[i].setxLoc(2000 - myBoobyImageArray[i].getIconWidth());
				boobyLeftRightx[0][i] = myBoobyArray[i].getxLoc();
				boobyLeftRightx[1][i] = myBoobyArray[i].getxLoc() + myBoobyImageArray[i].getIconWidth();
			}
			if (boobyTopBottomy[0][i] < 0)
			{
				myBoobyArray[i].setyLoc(0);
				boobyTopBottomy[0][i] = myBoobyArray[i].getyLoc();
				boobyTopBottomy[1][i] = myBoobyArray[i].getyLoc() + myBoobyImageArray[i].getIconHeight();
			}
			else if (boobyTopBottomy[1][i] > 1400)
			{
				myBoobyArray[i].setyLoc(1400 - myBoobyImageArray[i].getIconHeight());
				boobyTopBottomy[0][i] = myBoobyArray[i].getyLoc();
				boobyTopBottomy[1][i] = myBoobyArray[i].getyLoc() + myBoobyImageArray[i].getIconHeight();
			}
			
		}
		myPanel.repaint();
	}

	@Override
	public void goUpAndLeft(int i) 
	{
		myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() - (generator.nextInt(10) + 1));
		myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() - (generator.nextInt(10) + 1));
	}

	@Override
	public void goUpAndRight(int i) 
	{
		myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() + (generator.nextInt(10) + 1));
		myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() - (generator.nextInt(10) + 1));
	}

	@Override
	public void goDownAndLeft(int i) 
	{
		myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() - (generator.nextInt(10) + 1));
		myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() + (generator.nextInt(10) + 1));
		
	}

	@Override
	public void goDownAndRight(int i) 
	{
		myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() + (generator.nextInt(7) + 1));
		myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() + (generator.nextInt(7) + 1));			
	}

	@Override
	public void goUpAndLeftFast(int i) 
	{
		myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() - (generator.nextInt(15) + 1));
		myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() - (generator.nextInt(15) + 1));			
	}

	@Override
	public void goUpAndRightFast(int i) 
	{
		myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() + (generator.nextInt(15) + 1));
		myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() - (generator.nextInt(15) + 1));
	}

	@Override
	public void goDownAndLeftFast(int i) 
	{
		myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() - (generator.nextInt(15) + 1));
		myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() + (generator.nextInt(15) + 1));
	}

	@Override
	public void goDownAndRightFast(int i) 
	{
		myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() + (generator.nextInt(11) + 1));
		myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() + (generator.nextInt(11) + 1));
	}

	@Override
	public void goLeft(int i) 
	{
		myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() - (generator.nextInt(10) + 1));
	}

	@Override
	public void goRight(int i) 
	{
		myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() + (generator.nextInt(10) + 1));
	}

	@Override
	public void goUp(int i) 
	{
		myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() - (generator.nextInt(10) + 1));
	}

	@Override
	public void goDown(int i) 
	{
		myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() + (generator.nextInt(10) + 1));
	}

	@Override
	public void goLeftFast(int i) 
	{
		myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() - (generator.nextInt(15) + 1));
	}

	@Override
	public void goRightFast(int i) 
	{
		myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() + (generator.nextInt(15) + 1));
	}

	@Override
	public void goUpFast(int i) 
	{
		myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() - (generator.nextInt(15) + 1));
	}

	@Override
	public void goDownFast(int i) 
	{
		myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() + (generator.nextInt(15) + 1));
	}	
} // End timerListener class