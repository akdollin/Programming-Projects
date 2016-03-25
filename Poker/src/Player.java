//***************************************
// This is the player class for the 
// Poker assignment
// -this creates a player, a hand
//Akiva Dollin-acd2174
//****************************************
import java.util.ArrayList;

public class Player 
{
	private ArrayList<Card> hand;
	private int tokens;
	
	public Player()
	{		
		hand = new ArrayList<Card>(); 
		tokens=50;
	}

	public int addTokens(int t)
	{
		return tokens+=t;
	}
	public void playCost()
	{
		tokens=tokens-1;
	}
	public int getTokens()
	{
		System.out.println("You have "+tokens+" tokens left.");
		return tokens;
	}
	
	public void addCard(Card c)
	{
		// add the card c to the player's hand
		this.hand.add(c);
	}

	public void clearHand()
	{
		for(int i=4; i>=0; i--)
		{
			removeCard(printHand().get(i));
		}
	}
	
	public void removeCard(Card c)
	{
		this.hand.remove(c);
	}
	
	public void replaceCards(int i, Card c)
	{
		hand.set(i, c);
	
	}
	public ArrayList<Card> printHand()
	{
		return this.hand;
	}
	
}



