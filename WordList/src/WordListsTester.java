//***************************************
// This is the main tester class for the
// dictionary list sorter
//
//creates a new object reference
//Akiva Dollin-acd2174
//****************************************

import java.io.IOException;

public class WordListsTester 
{

	public static void main(String[] args) 
	{
		System.out.println("Welcome. Here are some things to"
				+ " look for in the dictionary:");
		try 
		{	
		ChooseWordList s = new ChooseWordList();
		s.List();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}
