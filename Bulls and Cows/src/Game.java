//Akiva Dollin-acd2164
//game class: runs the game, keeps track of when the player
//wins, and keeps track of how many tries
//and how many rounds the player has done


import java.util.Scanner;

public class Game
{
	//the initial guess
	private Scanner input;
	public String userGuess;
	
	//if you want to play again
	private Scanner goAgain;
	private String repeatGame;
	private int rounds;
	
	//determine when you win and how many guesses it took
	public int bulls;
	public int tries;
	
	//keeping track of best worst and average
	private int averageTries;
	private int bestTry=1000;  //starts high so that it can be compared initially 
	private int worstTry;      //will then be redefined
	

	public Game()
	{
		System.out.println("Lets Play A Game!");
		//initialize instance variables
		input = new Scanner(System.in);
		userGuess="";
		
		goAgain = new Scanner(System.in);
		repeatGame = "yes"; 
		rounds = 1;	
	}
	
	public void play()
	{
		while(repeatGame.equals("yes"))  //
		{
			bulls=0;
			tries=0;
			
			//call methods from Oracle class that determine number of bulls and cows
			Oracle o = new Oracle();

			o.generateNumber();
		//determine when you have won
			while(bulls != 4)
			{
				System.out.print("Enter a four digit number: ");
			
				userGuess = input.next();
				while(userGuess.length()!=4)
				{
						System.out.println("Try Again and Enter FOUR digits!");
						userGuess = input.next();
				}
			
				bulls = o.getBulls(userGuess);
				o.getCows(userGuess);
				tries++;
			}
			System.out.println("Congrats! It took you " + tries + " tries!");
			
			//determine, bestTry is redefined here
			if (rounds==1)
			{
				bestTry=tries;
			}
			
			//determine average 
			averageTries+=tries;
			
			//determine worst
			if (bestTry>tries)
			{
				bestTry=tries;
			}
			if (worstTry<tries)
			{
				worstTry=tries;
			}
			
			//ask to play again
			System.out.println("Would you like to play again? (y/n)");
			repeatGame=goAgain.next();
			if(repeatGame.equals("n"))
			{
				repeatGame="no";	
			}
			else if(repeatGame.equals("y"))
			{
				repeatGame="yes";
				rounds++;
			}
			
		}
		
		System.out.println("Rounds played: "+ rounds);
		System.out.println("Average tries per round: " + averageTries/rounds);
		System.out.println("Best Score in a single round: " + bestTry);
		System.out.println("Worst Score in a single round: " + worstTry);
		System.out.println("Bye");	
	}
}