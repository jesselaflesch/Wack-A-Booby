package Children;

import Parent.Animal;

public class Booby extends Animal
{
	private String[] imagePath = new String[5];
	private String[] reverseImagePath = new String[5];
	
	public Booby(int xLoc, int yLoc) 
	{super(xLoc, yLoc);
	
	for (int i = 0; i < imagePath.length; i++)
	{
		imagePath[i] = "./src/Images/Booby" + (i + 1) + ".jpg";
		reverseImagePath[i] = "./src/Images/Booby" + (i + 1) + "a.jpg";
	}
	
	
	randint = generator.nextInt(5);
	switch (randint)
	{
	case 0:
		imageName = "./src/Images/Booby1.jpg";
		imageNameReversed = "./src/Images/Booby1a.jpg";
		break;
	case 1:
		imageName = "./src/Images/Booby2.jpg";
		imageNameReversed = "./src/Images/Booby2a.jpg";
		break;
	case 2:
		imageName = "./src/Images/Booby3.jpg";
		imageNameReversed = "./src/Images/Booby3a.jpg";
		break;
	case 3:
		imageName = "./src/Images/Booby4.jpg";
		imageNameReversed = "./src/Images/Booby4a.jpg";
		break;
	case 4:
		imageName = "./src/Images/Booby5.jpg";
		imageNameReversed = "./src/Images/Booby5a.jpg";
		break;
	}
		
	}

	public String getImagePath(int i) 
	{
		return imagePath[i];
	}
	public String getReverseImagePath(int i) 
	{
		return reverseImagePath[i];
	}

	@Override
	public String getImageName() 
	{
		return imageName;
	}

	@Override
	public String getImageNameReversed() 
	{
		return imageNameReversed;
	}

	@Override
	public void setImageName(String imageName) 
	{
		this.imageName = imageName;
	}

	@Override
	public void setImageNameReversed(String imageNameReversed) 
	{
		this.imageNameReversed = imageNameReversed;
	}
}
