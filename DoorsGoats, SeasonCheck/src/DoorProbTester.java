
public class DoorProbTester 
{
	static int change = 0;
	static int dontChange = 0;

	public static void main(String[] args)
	{
		
		
		for (int n=1; n<=1000; n++)
		{
			DoorProb.gameShow();
			
		}
	
	System.out.println("I have simulated this game 1000 times.");
	System.out.println("These were my results:");
	System.out.println("The number of times the player should not have changed: " + dontChange);
	System.out.println("The number of times the player should have changed: " + change);
	}
}
