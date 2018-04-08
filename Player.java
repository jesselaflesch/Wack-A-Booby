package Classes;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class Player 
{
	
	private String name, password;
	private final String NAME = "Cassens";
	private final String NAME2 = "LaFlesch";
	private final String CPASSWORD = "Michael";
	private final String LPASSWORD = "Jesse";
	private int xLoc, yLoc, score, response;
	private Font font1 = new Font("New Times Roman", Font.BOLD, 40);
	
	public Player()
	{
		do
		{
			UIManager.put("OptionPane.minimumSize",new Dimension(600,300));
			UIManager.put("OptionPane.buttonFont", new FontUIResource(font1));
			UIManager.put("TextField.font", new FontUIResource(font1));
			JLabel myLabel = new JLabel("<HTML>You must first log in to play. <BR>Only authorized people can play.<BR>Enter your last name.</HTML>");
			myLabel.setFont(font1);
			this.name = JOptionPane.showInputDialog(myLabel);
		}
		while (this.name.equalsIgnoreCase(NAME) == false && this.name.equalsIgnoreCase(NAME2) == false);
		if (name.equalsIgnoreCase(NAME))
		{
			do
			{
				UIManager.put("OptionPane.minimumSize",new Dimension(600,300));
				UIManager.put("OptionPane.buttonFont", new FontUIResource(font1));
				UIManager.put("TextField.font", new FontUIResource(font1));
				JLabel myLabel = new JLabel("<HTML>I see you, Mr. " + NAME + ".<BR>And what is your password?<BR>"
						+ "Hint: Try your first name.</HTML>");
				myLabel.setFont(font1);
				this.password = JOptionPane.showInputDialog(myLabel);
			}
			while (this.password.equalsIgnoreCase(CPASSWORD) == false);
		}
		else if (name.equalsIgnoreCase(NAME2))
		{
			do
			{
				UIManager.put("OptionPane.minimumSize",new Dimension(600,300));
				UIManager.put("OptionPane.buttonFont", new FontUIResource(font1));
				UIManager.put("TextField.font", new FontUIResource(font1));
				JLabel myLabel = new JLabel("<HTML>I see you, Mr. " + NAME2 + ".<BR>And what is your password?<BR>"
						+ "Hint: Try your first name.</HTML>");
				myLabel.setFont(font1);
				this.password = JOptionPane.showInputDialog(myLabel);
			}
			while (this.password.equalsIgnoreCase(LPASSWORD) == false);
		}
		do
		{
			UIManager.put("OptionPane.minimumSize",new Dimension(600,300));
			UIManager.put("OptionPane.buttonFont", new FontUIResource(font1));
			UIManager.put("TextField.font", new FontUIResource(font1));
			JDialog.setDefaultLookAndFeelDecorated(true);
			JLabel myLabel = new JLabel("<HTML>Are you ready for this?</HTML>");
			myLabel.setFont(font1);
			JLabel myLabel2 = new JLabel("Confirm");
			myLabel2.setFont(font1);
			response = JOptionPane.showConfirmDialog(null, myLabel);
		}
		while(response == JOptionPane.NO_OPTION || response == JOptionPane.CANCEL_OPTION);
	}
	
	public int getxLoc() {
		return xLoc;
	}


	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}


	public int getyLoc() {
		return yLoc;
	}


	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}
	
	public void pickUpItem() 
	{
		score++;
	}

}
