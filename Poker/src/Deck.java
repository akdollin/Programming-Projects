//***************************************
// This is the deck class for the 
//poker assignment
//
// creates a deck, shuffles it, and deals the top card
//Akiva Dollin-acd2174
//****************************************
import java.util.Random;

public class Deck 
{
	
	private Card[] theDeck;
	
	public int top; // the index of the top of the deck
	// add more instance variables if needed
	Random r;
	
	public Deck()
	{
		// make a 52 card deck here
		top=-1;
		theDeck = new Card[52];
		initDeck();
		r  = new Random();
		
	}
	
	public void initDeck()  //each element has s and v
	{
		for(int i=0; i<4; i++) //0=s, 1=h, 2=d, 3=c
		{
			for(int j=1; j<=13; j++)
			{
				theDeck[(i*13+j)-1] = new Card(i,j);
			}	
		}
	}
	
	public void shuffle()
	{
		// shuffle the deck here
		for(int i=0; i<1000; i++)
		{
			
			int a = r.nextInt(51);  //picks random number out of 52
			int b = r.nextInt(51);
			
			Card temp = new Card(0,0);
			temp = theDeck[a];
			theDeck[a] = theDeck[b];
			theDeck[b] = temp;
		}
		top=-1;
	}
	
	public Card deal()
	{
		// deal the top card in the deck
		top += 1;
		return theDeck[top];
	}
}