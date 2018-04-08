package Classes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import Children.Booby;
import Interface.UpdateArrays;
import MainPanel.MainPanel;

public class Movement implements MouseListener, UpdateArrays
{

	protected Player myPlayer;
	protected Booby[] myBoobyArray = new Booby[5];
	protected Timer myBoobyTimer, myBoobyImageTimer;
	protected MainPanel myPanel;
	protected int boobyHeight, boobyWidth, playerHeight, playerWidth, randint;
	protected Integer[][] boobyLeftRightx = new Integer[2][5];
	protected Integer[][] boobyTopBottomy = new Integer[2][5];
	protected ImageIcon[] myBoobyImageArray = new ImageIcon[5];
	
	protected Random generator = new Random();
	
	
	public Movement(Player myPlayer, Booby[] myBoobyArray, ImageIcon[] myBoobyImageArray, MainPanel myPanel)
	{
		this.myPlayer = myPlayer;
		this.myBoobyArray = myBoobyArray;
		this.myPanel = myPanel;
		for (int i = 0; i < myBoobyImageArray.length; i++)
		{
			this.myBoobyImageArray[i] = myBoobyImageArray[i];
		}
				
		
	// Setting up x and y in 2D array
		for (int rows = 0; rows < boobyLeftRightx.length; rows++)
		{
			for (int cols = 0; cols < boobyLeftRightx[rows].length; cols++) 
			{
				if (rows == 0)
				{
					boobyLeftRightx[rows][cols] = this.myBoobyArray[cols].getxLoc();
				}
				else
				{
					boobyLeftRightx[rows][cols] = this.myBoobyArray[cols].getxLoc() + this.myBoobyImageArray[cols].getIconWidth();
				}
			}
		}
		for (int rows = 0; rows < boobyTopBottomy.length; rows++)
		{
			for (int cols = 0; cols < boobyTopBottomy[rows].length; cols++) 
			{
				if (rows == 0)
				{
					boobyTopBottomy[rows][cols] = this.myBoobyArray[cols].getyLoc();
				}
				else
				{
					boobyTopBottomy[rows][cols] = this.myBoobyArray[cols].getyLoc() + this.myBoobyImageArray[cols].getIconHeight();
				}
			}
		}
		
		
		
	} // End Constructor
	
	protected boolean areRectsColliding(int r1TopLeftX, int r1BottomRightX,int r1TopLeftY, int r1BottomRightY, int r2TopLeftX, 
			int r2BottomRightX, int r2TopLeftY, int r2BottomRightY) 
	{
		if (r1TopLeftX < r2BottomRightX && r1BottomRightX >
		r2TopLeftX && r1TopLeftY < r2BottomRightY && r1BottomRightY > r2TopLeftY) 
		{
		return true;
		}
		else 
		{
		return false; 
		} 
	}
	
	protected boolean isWithinRect(int r1LeftX, int r1RightX,int r1TopY, int r1BottomY, int r2X, int r2Y) 
	{
		if (r1LeftX < r2X && r1RightX >	r2X && r1TopY < r2Y && r1BottomY > r2Y) 
		{
		return true;
		}
		else 
		{
		return false; 
		} 
	}
	
	@Override
	public void mousePressed(MouseEvent e) 
	{
		myPlayer.setxLoc(e.getX());
		myPlayer.setyLoc(e.getY());
		for (int i = 0; i < myBoobyArray.length; i++)
		{
			if (isWithinRect(myBoobyArray[i].getxLoc(), myBoobyArray[i].getxLoc() + myBoobyImageArray[i].getIconWidth(), 
					myBoobyArray[i].getyLoc(), myBoobyArray[i].getyLoc() + myBoobyImageArray[i].getIconHeight(), 
					myPlayer.getxLoc(), myPlayer.getyLoc()))
			{
				myPanel.setMyBoobyImageArrayNull(i);
			}
			else
			{
				continue;
			}
		}
		
		myPanel.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
