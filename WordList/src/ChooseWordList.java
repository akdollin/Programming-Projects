//***************************************
// This is the class that deals with the scanner input.
// 
//The class chooses the type of list.
//Fills the list and creates a new file under a separate name.
//Akiva Dollin-acd2174
//****************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class ChooseWordList 
{
	private WordLists w;
	private Scanner input;
	private Scanner nextList;
	private int ListCounter;
	private String fileName;

	public ChooseWordList() throws FileNotFoundException
	{
		
		input = new Scanner(System.in);
		nextList = new Scanner(System.in);
		ListCounter = 1;
		fileName="List.txt";
	}
	
	public void List() throws IOException
	{
		w = new WordLists("dictionary.txt");
		System.out.println("1: Words of a given length.");
	
		System.out.println("2: Words starting with a "
				+ "given letter and of a given length.");
	
		System.out.println("3: Words containing a specific "
				+ "letter and of a given length.");
	
		System.out.println("4: Words with given number of "
				+ "vowels and of a given length.");
	
		System.out.println("5: Words with a given number of given letter.");
	
		
		System.out.println("Which list would you like? (1-5)");
		String i = input.next();
	
		if (i.equals("1"))
		{
			System.out.print("Enter the length of the words "
					+ "you want to generate: ");
			int n = Integer.parseInt(input.next());
			w.lengthN(n);
			//input.reset();
		}
	
		else if (i.equals("2"))
		{
			System.out.print("Enter the first letter of the words you want"
					+ " to generate: ");
			String s = input.next();
			char firstLetter = s.charAt(0);
	
			System.out.print("Enter the length of the words "
					+ " you want to generate: ");
			int n = Integer.parseInt(input.next());
			w.startsWith(n, firstLetter);
			//input.reset();
		}
	
		else if (i.equals("3"))
		{
			System.out.print("Enter a letter to generate a list of "
					+ " all words that contain that letter: ");
			String s = input.next();
			char included = s.charAt(0);
			System.out.print("Enter the length of the words "
					+ " you want to generate: ");
			int n = Integer.parseInt(input.next());
			w.containsLetter(n, included);
			//input.reset();
		}
	
		else if (i.equals("4"))
		{
			System.out.print("Enter a number to generate a list of all words that"
					+ " contain that number of vowels: ");
			int m = Integer.parseInt(input.next());
	
			System.out.print("Enter the length of the words "
					+ "you want to generate: ");
			int n = Integer.parseInt(input.next());
			w.vowelHeavy(n, m);
			//input.reset();
		}
	
		else if (i.equals("5"))
		{
			System.out.print("Enter the letter that you want to search for: ");
			String s = input.next();
			char included = s.charAt(0);
	
			System.out.print("Enter the number of occurences of that letter: ");
			int m = input.nextInt();
			w.multiLetter(m, included);
			//input.reset();
		}
		
		//want to do it again?
		
		saveToFile();
		
		System.out.println("\n" + "Would you like to find another list? y/n");
		String n = nextList.next();
		if(n.equals("y"))
		{
			ListCounter++;
			List();
		}
		else
		{
			System.out.println("Hope this helped, good luck!");
		}
	}
	
	public String newListFile()
	{
		fileName = "List"+ListCounter+".txt";
		return fileName;
	}
	
	public void saveToFile() throws IOException
	{	
		String[] wordsArray = w.getWordList();
		File file = new File(newListFile());  
		PrintWriter out = new PrintWriter(new FileWriter(file));  
				  
		// Write each string in the array on a separate line  
		for (String s : wordsArray) 
		{  
		    out.println(s);  
		}  
		out.close(); 
	}
}



