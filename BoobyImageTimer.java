package Timers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import Children.Booby;
import Classes.Movement;
import Classes.Player;
import MainPanel.MainPanel;

public class BoobyImageTimer extends Movement implements ActionListener
{

	private ImageIcon myImage1;
	private ImageIcon[] myReversedImageArray = new ImageIcon[5];
	
	public BoobyImageTimer(Player myPlayer, Booby[] myBoobyArray, ImageIcon[] myBoobyImageArray, MainPanel myPanel,
			ImageIcon[] myReversedImageArray) 
	{
		super(myPlayer, myBoobyArray, myBoobyImageArray, myPanel);
		
	}
	
	public void startTimer()
	{
		myBoobyImageTimer = new Timer(500, new BoobyImageTimer(myPlayer, myBoobyArray, myBoobyImageArray, myPanel, myReversedImageArray));
		myBoobyImageTimer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		for(int i = 0; i < myBoobyArray.length; i++)
		{
		// Setting image path to reversed image
			if (myBoobyArray[i].getImageName().equals("./src/Images/Booby1.jpg"))
			{
				myBoobyArray[i].setImageName(myBoobyArray[i].getReverseImagePath(i));
			}
			else if (myBoobyArray[i].getImageName().equals("./src/Images/Booby2.jpg"))
			{
				myBoobyArray[i].setImageName(myBoobyArray[i].getReverseImagePath(i));
			}
			else if (myBoobyArray[i].getImageName().equals("./src/Images/Booby3.jpg"))
			{
				myBoobyArray[i].setImageName(myBoobyArray[i].getReverseImagePath(i));
			}
			else if (myBoobyArray[i].getImageName().equals("./src/Images/Booby4.jpg"))
			{
				myBoobyArray[i].setImageName(myBoobyArray[i].getReverseImagePath(i));
			}
			else if (myBoobyArray[i].getImageName().equals("./src/Images/Booby5.jpg"))
			{
				myBoobyArray[i].setImageName(myBoobyArray[i].getReverseImagePath(i));
			}
		// Setting image path back to normal image
			else if (myBoobyArray[i].getImageName().equals("./src/Images/Booby1a.jpg"))
			{
				myBoobyArray[i].setImageName(myBoobyArray[i].getImagePath(i));
			}
			else if (myBoobyArray[i].getImageName().equals("./src/Images/Booby2a.jpg"))
			{
				myBoobyArray[i].setImageName(myBoobyArray[i].getImagePath(i));
			}
			else if (myBoobyArray[i].getImageName().equals("./src/Images/Booby3a.jpg"))
			{
				myBoobyArray[i].setImageName(myBoobyArray[i].getImagePath(i));
			}
			else if (myBoobyArray[i].getImageName().equals("./src/Images/Booby4a.jpg"))
			{
				myBoobyArray[i].setImageName(myBoobyArray[i].getImagePath(i));
			}
			else if (myBoobyArray[i].getImageName().equals("./src/Images/Booby5a.jpg"))
			{
				myBoobyArray[i].setImageName(myBoobyArray[i].getImagePath(i));
			}
			else if (myBoobyArray[i].getImageName().equals("./src/Images/Kapow.jpg"))
			{
				continue;
				//myBoobyArray[i].setImageName(myBoobyArray[i].getImagePath(generator.nextInt(myBoobyArray.length)));
			}
		}
		myPanel.updateBoobyArray(myBoobyArray, myBoobyImageArray);
		setImageArray();
		myPanel.repaint();
	}
	
// Method to update MainPanel's Image Array
	private void setImageArray()
	{
		for(int i = 0; i < myBoobyArray.length; i++)
		{
			myImage1 = new ImageIcon(myBoobyArray[i].getImageName());
			myPanel.setMyBoobyImageArray(i, myImage1);
		}
	}
	
	
}
