//***************************************
// This is the game class for the 
// poker assignment 
//-has two constructors one with and one without
//command line args
//-shuffles first, then deals a hand, sorts it...
//and determines the hand
//Akiva Dollin-acd2174
//****************************************
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game 
{
	private Player p;
	private Deck cards; 
	private Scanner input;
	private Scanner nextHand;
	private Card c;

	public Game(String[] testHand)  //command line args: 
	{
		//initialize instance variables
		System.out.println("Let's play poker! 1 token a hand.");
		p = new Player(); 
		cards = new Deck();
		c = new Card(0,0);
		//enhanced to check all inputs 
		for(String s : testHand)
		{
			int value = Integer.parseInt(s.substring(1));
			String strSuit = s.substring(0, 1); 
			int numSuit;

			if (strSuit.equals("s"))
			{
				numSuit = 3; 
			}
			else if (strSuit.equals("h"))
			{
				numSuit= 2; 
			}
			else if (strSuit.equals("d"))
			{
				numSuit= 1; 
			}else
			{
				numSuit= 0; 
			}

			Card c = new Card(numSuit, value);

			p.addCard(c);

		}
		//sorts hand
		Collections.sort(p.printHand());
	}

	public Game()
	{
		System.out.println("Let's play poker! 1 token a hand.");
		// This constructor is to actually play a normal game
		p = new Player();
		cards = new Deck();
		c = new Card(0,0);
		//shuffles at begging of game and deals a hand
		cards.shuffle();
		dealHand();
	}

	public void play()
	{
		//to stop game when people run out
		if(p.getTokens()==0)
		{
			System.out.println("You have no more tokens. Bye");
		}
		else
		{
		p.playCost();
		System.out.print("My hand is: " + p.printHand());


		//offer to replace cards
		input = new Scanner(System.in);
		System.out.println("\n"+ "Would you like to replace cards? y/n");
		if (input.next().equals("y"))
		{
			System.out.println("Enter the indexes of the cards to replace.");
			System.out.println("No Spaces!");

			//scan string of indexes to replace
			String trashIndexes = input.next();

			for( int i=0; i<trashIndexes.length(); i++)
			{
				String a = trashIndexes.substring(i,i+1);
				p.replaceCards(Integer.parseInt(a), cards.deal());
			}
			Collections.sort(p.printHand());
			System.out.print("My new hand is: " + p.printHand());
		}
		//check the cards and print out result
		checkHand(p.printHand());
		//print out how many tokens you have
		p.getTokens();
		}
		//play again?
		nextHand = new Scanner(System.in);
		System.out.println("Would you like to play another hand? y/n");
		if(nextHand.next().equals("y"))
			{
			//to restart a new hand
				p.clearHand();
				cards.shuffle();
				dealHand();
				play();
			}
		else
		{
			System.out.println("Thanks for playing!");
			p.getTokens();
		}
	}

	public void dealHand()
	{
		//deals five cards
		for (int i=0; i<5; i++)
		{
			p.addCard(cards.deal());
		}	
		//sorts hand by value
		Collections.sort(p.printHand());
	}

	public String checkHand(ArrayList<Card> hand)
	{
		if (checkRoyalFlush()==true)
		{
			System.out.println("You have a Royal Flush..Sick!");
			p.addTokens(250);
			return "";
		}
		else if(checkStraightFlush()==true)
		{
			System.out.println("You have a straight flush!");
			p.addTokens(50);
			return "";
		}
		else if (checkFourKind()==true)
		{
			System.out.println("You have four of a kind, yay.");
			p.addTokens(25);
			return "";
		}
		else if(checkFullHouse()==true)
		{
			System.out.println("You have a full house!");
			p.addTokens(6);
			return "";
		}
		else if(checkFlush()==true)
		{
			System.out.println("You have a flush!");
			p.addTokens(5);
			return "";
		}
		else if(checkStraight()==true)
		{
			System.out.println("You have a straight!");
			p.addTokens(4);
			return "";
		}
		else if(checkTriple()==true)
		{
			System.out.println("You have a triple!");
			p.addTokens(3);
			return "";
		}
		else if(checkTwoPair()==true)
		{
			System.out.println("You have two pair, yay.");
			p.addTokens(2);
			return "";
		}
		else if(checkPair()==true)
		{
			System.out.println("You have a pair!");
			p.addTokens(1);
			return "";
		}
		else if(checkHighCard()==true)
		{
			System.out.println("You have a high card!" + "");
			return "";
		}
		return "";
	}


	public int cardValue(int i)
	{
		int cardValue = p.printHand().get(i).getValue(); 
		return cardValue;
	}
	public int cardSuit(int i)
	{
		int cardSuit = p.printHand().get(i).getSuit(); 
		return cardSuit;
	}


	public boolean checkRoyalFlush()
	{
		if(checkStraightFlush()==true && cardValue(4)==13)
		{
			return true;
		}
		else
		{
			return false;
		}	
	}

	public boolean checkStraightFlush()
	{
		if(checkFlush()== true && checkStraight()==true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean checkFourKind()
	{
		int count=0;
		int count2=0;
		for(int i=0; i<3; i++)
		{
			if(cardValue(i)==cardValue(i+1))
			{
				count++;
			}
		}

		for(int i=1; i<4; i++)
		{
			if(cardValue(i)==cardValue(i+1))
			{
				count2++;
			}
			else
			{
				count2--;
			}
		}

		if(count==3 || count2==3)
		{
			return true;
		}

		return false;
	}

	public boolean checkFullHouse()
	{
		int count=0;
		//first possible format of full house
		for(int i=0; i<4; i++)
		{
			if(cardValue(i)==cardValue(i+1))
			{
				count++;
			}
		}
		//second possible format of full house
		if(count==3)
		{
			return true;
		}
		return false;
	}

	public boolean checkFlush()
	{
		int count=0;
		for(int i=0; i<4; i++)
		{
			if(cardSuit(i)==cardSuit(i+1))
			{
				count++;
			}
		}

		if(count==4)
		{
			return true;
		}
		return false;
	}

	public boolean checkStraight()   
	{
		int count=0;
		for(int i=0; i<4; i++)
		{	
			if(cardValue(i)+1==cardValue(i+1))
			{
				count++;
			}
		}

		if(count==4)
		{
			return true;
		}
		else if(count==3&&cardValue(0)==1&&cardValue(4)==13)  //royal straight
		{
			return true;
		}
		return false;
	}

	public boolean checkTriple()
	{
		int count=0;
		for(int i=0; i<4; i++)
		{
			if(cardValue(i)==cardValue(i+1))
			{
				count++;
			}
		}

		if(count==2)
		{
			return true;
		}
		return false;
	}

	public boolean checkTwoPair()
	{
		if(cardValue(0)==cardValue(1) && cardValue(3)==cardValue(4))
		{
			return true;
		}
		else if(cardValue(0)==cardValue(1) && cardValue(2)==cardValue(3))	
		{
			return true;
		}
		else if(cardValue(1)==cardValue(2) && cardValue(3)==cardValue(4))	
		{
			return true;
		}
		return false;
	}

	public boolean checkPair()
	{
		int count=0;
		for(int i=0; i<4; i++)
		{
			if(cardValue(i)==cardValue(i+1))
			{
				count++;
			}
		}

		if(count==1)
		{
			return true;
		}
		return false;
	}

	public boolean checkHighCard()
	{
		if(cardValue(0)==1)
		{
			System.out.println("High Card: Ace");
		}
		else 
		{
			System.out.println("/n"+"High Card: "+cardValue(4));
		}
		return true;
	}
}