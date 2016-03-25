//****************************************
//  This class models a n-sided die
//****************************************


public class Die 
{

	private int n;
	private int side;

	public Die(int shape)
	{  //die object named rudy//
		n=shape;
		roll();
	}

	public Die()
	{
		n=6;
		roll();
	}

	public void roll()
	{
		side = (int) (Math.random() * n + 1); //number between one and n not including n
	}

	public int getSide() 
	{
		return side;
	}

} //end class