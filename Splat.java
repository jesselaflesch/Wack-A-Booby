package Children;

import Parent.Animal;

public class Splat extends Animal
{
	
	
	public Splat(int xLoc, int yLoc) 
	{
		super(xLoc, yLoc);
		
		imageName = "./src/Images/Kapow.jpg";
		
	}

	@Override
	public String getImageName() 
	{
		return imageName;
	}

	@Override
	public String getImageNameReversed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setImageName(String imageName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setImageNameReversed(String imageNameReversed) {
		// TODO Auto-generated method stub
		
	}

}
