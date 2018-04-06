package Classes;

public class Player 
{
	
	private String name, imageName;	
	private int xLoc, yLoc, itemsCollected, score;
	private Movement playerMovement;
	
	public Player()
	{
		
		this.xLoc = 0;
		this.yLoc = 0;
		this.itemsCollected = 0;
		this.score = 0;
	}

}
