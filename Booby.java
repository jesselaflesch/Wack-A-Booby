package Classes;

import java.util.Random;

public class Booby 
{
	
	private int xLoc, yLoc;
	private String imageName;
	
	public Booby(String imageName, int xLoc, int yLoc)
	{
		
		this.xLoc = xLoc; 
		this.yLoc = yLoc;
		this.imageName = imageName; 
		
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

	public String getImageName()
	{
		return imageName;
	}

}
