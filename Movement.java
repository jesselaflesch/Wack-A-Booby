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

import MainPanel.MainPanel;

public class Movement implements MouseListener
{

	private Player myPlayer;
	private Booby[] myBooby = new Booby[5];
	private Game myGame;
	private Timer myTimer = new Timer(400, new timerListener());
	private MainPanel myPanel;
	private int boobyHeight, boobyWidth, playerHeight, playerWidth, randint;
	private Integer[][] boobyLeftRightx = new Integer[2][5];
	private Integer[][] boobyTopBottomy = new Integer[2][5];
	private ImageIcon myBoobyImage, myPlayerImage;
	
	private Random generator = new Random();
	
	
	public Movement(Player myPlayer, Booby[] myBooby, ImageIcon myPlayerImage, ImageIcon myBoobyImage,
			MainPanel myPanel)
	{
		this.myPlayer = myPlayer;
		this.myBooby = myBooby;
		this.myPanel = myPanel;
		this.myPlayerImage = myPlayerImage;
		this.myBoobyImage = myBoobyImage;
				
		this.playerHeight = myPlayerImage.getIconHeight();
		this.playerWidth = myPlayerImage.getIconWidth();
		this.boobyHeight = myBoobyImage.getIconHeight();
		this.boobyWidth = myBoobyImage.getIconWidth();
		
	// Setting up x and y in 2D array
		for (int rows = 0; rows < boobyLeftRightx.length; rows++)
		{
			for (int cols = 0; cols < boobyLeftRightx[rows].length; cols++) 
			{
				if (rows == 0)
				{
					boobyLeftRightx[rows][cols] = this.myBooby[cols].getxLoc();
				}
				else
				{
					boobyLeftRightx[rows][cols] = this.myBooby[cols].getxLoc() + myBoobyImage.getIconWidth();
				}
			}
		}
		for (int rows = 0; rows < boobyTopBottomy.length; rows++)
		{
			for (int cols = 0; cols < boobyTopBottomy[rows].length; cols++) 
			{
				if (rows == 0)
				{
					boobyTopBottomy[rows][cols] = this.myBooby[cols].getyLoc();
				}
				else
				{
					boobyTopBottomy[rows][cols] = this.myBooby[cols].getyLoc() + myBoobyImage.getIconHeight();
				}
			}
		}
		
		
		
	} // End Constructor
	
	
	private class timerListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			randint = generator.nextInt(4);
			switch (randint)
			{
			case 0:
				for (int i = 0; i < myBooby.length; i++)
				{
					myBooby[i].setxLoc(myBooby[i].getxLoc() - 5);
					myBooby[i].setyLoc(myBooby[i].getyLoc() - 5);
				//Border Control
					/*if (playerLeftx() < 0)
					{
						myPlayer.setxLoc(0);
					}*/
				}
				break;
			case 1:
				for (int i = 0; i < myBooby.length; i++)
				{
					myBooby[i].setxLoc(myBooby[i].getxLoc() + 5);
					myBooby[i].setyLoc(myBooby[i].getyLoc() + 5);
				}
				break;
			case 2:
				for (int i = 0; i < myBooby.length; i++)
				{
					myBooby[i].setxLoc(myBooby[i].getxLoc() - 5);
					myBooby[i].setyLoc(myBooby[i].getyLoc() + 5);
				}
				break;
			case 3:
				for (int i = 0; i < myBooby.length; i++)
				{
					myBooby[i].setxLoc(myBooby[i].getxLoc() + 5);
					myBooby[i].setyLoc(myBooby[i].getyLoc() - 5);
				}
			}
			
			myPanel.repaint();
		}
		
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
