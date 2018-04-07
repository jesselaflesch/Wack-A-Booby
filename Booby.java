package Children;

import java.util.Random;

import Parent.Animal;

public class Booby extends Animal
{
	
	
	public Booby(int xLoc, int yLoc) 
	{super(xLoc, yLoc);
	
	randint = generator.nextInt(5);
	switch (randint)
	{
	case 0:
		imageName = "./src/Images/Booby1.jpg";
		break;
	case 1:
		imageName = "./src/Images/Booby2.jpg";
		break;
	case 2:
		imageName = "./src/Images/Booby3.jpg";
		break;
	case 3:
		imageName = "./src/Images/Booby4.jpg";
		break;
	case 4:
		imageName = "./src/Images/Booby5.jpg";
		break;
	}
		
	}

	@Override
	public String getImageName() 
	{
		return imageName;
	}
}
