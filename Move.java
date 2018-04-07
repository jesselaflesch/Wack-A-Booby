package Interface;

import Children.Booby;

public interface Move 
{	
	public void goUpAndLeft(Booby[] myBoobyArray);
	
	public void goUpAndRight(Booby[] myBoobyArray);
	
	public void goDownAndLeft(Booby[] myBoobyArray);
	
	public void goDownAndRight(Booby[] myBoobyArray);
	
	public void goUpAndLeftFast(Booby[] myBoobyArray);
	
	public void goUpAndRightFast(Booby[] myBoobyArray);
	
	public void goDownAndLeftFast(Booby[] myBoobyArray);
	
	public void goDownAndRightFast(Booby[] myBoobyArray);

}
