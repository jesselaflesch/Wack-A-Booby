package Classes;

public class Player 
{
	
	private String imageName;	
	private int xLoc, yLoc, score;
	private Movement playerMovement;
	
	public Player()
	{

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
