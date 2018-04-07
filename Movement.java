package Classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import Children.Booby;
import Interface.Move;
import MainPanel.MainPanel;

public class Movement implements MouseListener
{

	private Player myPlayer;
	private Booby[] myBoobyArray = new Booby[5];
	private Game myGame;
	private Timer myTimer = new Timer(30, new timerListener());
	private MainPanel myPanel;
	private int boobyHeight, boobyWidth, playerHeight, playerWidth, randint;
	private Integer[][] boobyLeftRightx = new Integer[2][5];
	private Integer[][] boobyTopBottomy = new Integer[2][5];
	private ImageIcon myBoobyImage;
	private ImageIcon[] myBoobyImageArray = new ImageIcon[5];
	
	private Random generator = new Random();
	
	
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
	
	public void startTimer()
	{
		myTimer.start();
	}
	
	private class timerListener implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			
			for (int i = 0; i < myBoobyArray.length; i++)
			{
				randint = generator.nextInt(8);
				switch (randint)
				{
				case 0:
					//goUpAndLeft(myBoobyArray[i]);
					
					myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() - (generator.nextInt(10) + 1));
					myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() - (generator.nextInt(10) + 1));
					break;
				case 1:
					myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() + (generator.nextInt(7) + 1));
					myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() + (generator.nextInt(7) + 1));
					break;
				case 2:
					myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() - (generator.nextInt(10) + 1));
					myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() + (generator.nextInt(10) + 1));
					break;
				case 3:
					myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() + (generator.nextInt(10) + 1));
					myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() - (generator.nextInt(10) + 1));
					break;
				case 4:
					myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() - (generator.nextInt(15) + 1));
					myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() - (generator.nextInt(15) + 1));
					break;
				case 5:
					myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() + (generator.nextInt(11) + 1));
					myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() + (generator.nextInt(11) + 1));
					break;
				case 6:
					myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() - (generator.nextInt(15) + 1));
					myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() + (generator.nextInt(15) + 1));
					break;
				case 7:
					myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() + (generator.nextInt(15) + 1));
					myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() - (generator.nextInt(15) + 1));
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

		/*@Override
		public void goUpAndLeft(Booby[] myBoobyArray) 
		{
			myBoobyArray[i].setxLoc(myBoobyArray[i].getxLoc() - (generator.nextInt(10) + 1));
			myBoobyArray[i].setyLoc(myBoobyArray[i].getyLoc() - (generator.nextInt(10) + 1));
			
		}

		@Override
		public void goUpAndRight(Booby[] myBoobyArray) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void goDownAndLeft(Booby[] myBoobyArray) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void goDownAndRight(Booby[] myBoobyArray) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void goUpAndLeftFast(Booby[] myBoobyArray) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void goUpAndRightFast(Booby[] myBoobyArray) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void goDownAndLeftFast(Booby[] myBoobyArray) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void goDownAndRightFast(Booby[] myBoobyArray) {
			// TODO Auto-generated method stub
			
		}*/
				
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
