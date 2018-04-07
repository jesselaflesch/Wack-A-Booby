package Parent;

import java.util.Random;

public abstract class Animal 
{

	private int xLoc, yLoc;
	protected int randint;
	protected String imageName;
	
	protected Random generator = new Random();
	
	public Animal(int xLoc, int yLoc)
	{
		
		this.xLoc = xLoc; 
		this.yLoc = yLoc;
		
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

	public abstract String getImageName();

}
