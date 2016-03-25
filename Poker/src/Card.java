//***************************************
// This is the card class for the 
//poker assignment
//-has compareTo methods to sort the hand, and 
//the toString method to interpret suits
//defines a card and has methods for getting the suit and the value
//Akiva Dollin-acd2174
//****************************************

public class Card implements Comparable<Card>
{
	public int suit; // use integers 1-4 to encode the suit
	public int value; // use integers 1-13 to encode the value

	public Card(int s, int v)
	{
		//make a card with suit s and value v
		this.suit = s;
		this.value = v;
	}

	public int getValue()
	{
		return value;
	}
	
	public int getSuit()
	{
		return suit;
	}
	
	//compareTo()
	public int compareTo(Card c)
	{
		return ((Integer) this.value).compareTo(c.value);
	}

	public String toString()
	{
		// use this method to easily print a Card object

		String suit = null;
		if (this.suit==3)
		{
			suit= "s"; //spades
		}
		else if (this.suit==2)
		{
			suit= "h"; //hearts
		}
		else if (this.suit==1)
		{
			suit= "d"; //diamond
		}
		else if (this.suit==0)
		{
			suit= "c"; //clubs
		}

		return (suit +"" + this.value);
	}
}