//import java.util.ArrayList;
//
////public Card toCard(String s)
////	{
////		return new Card(s.charAt(0), parseInts.substring(1));
////		
////	}
//
////other idea
////		for( int i=0; i<6; i++)
////		{
////		int a=input.next();
////		remove.hand[a];
////		}
//		
//
////p.replaceCards(junkCards);
////		System.out.println(Arrays.toString(trashCards));
//		System.out.println(Arrays.toString(indexes));
//
////input indexes of cards to replace in an array type String
//		String[] trashIndexes = input.next().split(" ");
//		int[] trashCards = new int[trashIndexes.length];
//		//create array type Card to store indexes with size of
//				//how many indexes you input
//		//store parsed indexes in placements
//				//of new trashCards array
//		hand[trashIndexes.charAt(i)]
//				//trashCards[i] = p.indexToCard(Integer.parseInt(indexes[i]));
//				
//				public ArrayList<Card> getHand()
//				{
//					return hand;
//				}
//		
//		
//
//		public boolean isStraight()
//	    {
//	          
//			//checks cards for straight. The value+1
//			for (int i = 0; i < 5; i++)
//			{
//				if (p.getCardinHand(i) == p.getCardinHand(i+1))
//				{
//					return true;
//				}
//			}
//			return false;
//			
//		// you will likely want many more methods here
//		// see discussion in class
//	    }
//		
//		
//		
//		
//		if(hand.size() == 0)
//		{
//			hand.add(c); 
//		}
//		else
//		{
//			boolean placed = false;
//			int index = 0;
//			while(!placed)
//			{
//				if(c.getValue() > hand.get(index).getValue())
//				{
//					index++;
//				}
//				else if(c.getValue() == hand.get(index).getValue())
//				{
//					if(c.getSuit().getRank()>hand.get(index).getSuit().getRank())
//					{
//						index++;
//					}
//					else 
//					{
//						hand.add(index+1, c);     //implemet rank() of all the suits
//						placed= true;
//					}
//					
//				}	
//				else if(c.getValue()< hand.get(index).getValue())
//				{
//					hand.add(index+1, c);
//					placed=true;
//				}
//			}
//		}	
//		
////		if(c.getValue() == this.getValue() &&
////		c.getSuit() == this.getSuit()){
////	return 0; 
////}if(c.getValue() > this.getValue()){
////	return -1; 
////}else{
////	return 1; 
////}
//		
//		if(top==52)
//		{
//			System.out.println("You have reached the bottom! Lets shuffle!");
//			shuffle();
//			top=-1;	
//		}
//		if(top==53)
//		{
//			top=-1;
//		}