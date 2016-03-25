//******************************
//	models a Player in Pig
//******************************

import java.util.Scanner;

public class Player 
{
	private boolean isHuman;
	private int score;  //just for players
	private Die myDie;
	private Scanner input;

	public Player(int human)
	{
		//isHuman=(human>0);    //isHuman is a boolean, so its equal to a boolean
		if (human>0)
			isHuman=true;
		else
			isHuman=false;

		myDie=new Die(6);  //so you can switch how many sides the die has
		score=0;
		input = new Scanner(System.in);  //only for the human players

	}


	public void play() 
	{
		if(isHuman)
			playHuman();  //no implicit parameter because its only used in this class
		//could add a this.playHuman();
		else
			playComp();
	}


	private void playHuman() 
	{
		int current=0;
		int runningTotal=0;
		int again=1;

		while(again==1 && score+runningTotal<100) 
		{
			myDie.roll();
			current=myDie.getSide();
			System.out.println("You rolled a " + current);
			if (current == 1) 
			{
				again=0; 
				runningTotal=0;
			}
			else 
			{
				runningTotal=runningTotal+current;
				System.out.println("Your round total is now " + runningTotal);
				System.out.println("Roll again? (1-yes, 0-no)");
				again=input.nextInt();
			}

		}//end while
		score=score+runningTotal;
		System.out.println("Your total score is: " + score);
	}//end method

	private void playComp() //private because 
	{
		int current=0;
		int runningTotal=0;

		while(runningTotal<22 && current != 1 && score+runningTotal<100) 
		{
			myDie.roll();
			current=myDie.getSide();
			System.out.println("Computer rolled a " + current);
			if (current == 1)
			{
				runningTotal = 0;
			}
			else 
			{
				runningTotal = current+runningTotal; 	 
			}

		}//end while
		score=score+runningTotal;
		System.out.println("Computer is done");
		System.out.println("Computer total score is: " + score);
	} //end playComp


	public int getScore() 
	{
		return score;
	}

} // end class  