//***************************************
// This is the wordList class
// this class defines all the methods for
//the different sorts
//
//Akiva Dollin-acd2174
//****************************************

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WordLists 
{
	private BufferedReader bReader;
	private FileInputStream fiStream;
	private String eachLine;
	private String wordList[];
	private ArrayList<String> words;
	
	public WordLists(String fileName) throws FileNotFoundException
	{
		//import the file
		
		words = new ArrayList<String>();
		fiStream = new FileInputStream("dictionary.txt");
		bReader = new BufferedReader(new InputStreamReader(fiStream));
		
	}
	
	
	public String[] lengthN(int n) throws IOException
	{
		while((eachLine = bReader.readLine()) != null)
		{
			if(eachLine.length() == n)
			{
				words.add(eachLine);
			}
		}
		
		getWordList();
		return wordList;
	}
	
	public String[] startsWith(int n, char firstLetter) throws IOException
	{
		while((eachLine = bReader.readLine()) != null)
		{
			if(eachLine.charAt(0) == firstLetter && eachLine.length() == n)
			{
				words.add(eachLine);
			}
		}
		getWordList();
		return wordList;
	}
	
	public String[] containsLetter(int n, char included) throws IOException
	{
		while((eachLine = bReader.readLine()) != null)
		{
			if(eachLine.length() == n)
			{
				for(int i=1; i<eachLine.length(); i++)
				{
					if(eachLine.charAt(i)== included)
					{
						words.add(eachLine);
					}
				}
			}
			
		}
		getWordList();
		return wordList;
	}
	
	
	public String[] vowelHeavy(int n, int m) throws IOException
	{
		while((eachLine = bReader.readLine()) != null)
		{
			int counter=0;
			if(eachLine.length() == n)
			{
				for(int i=0; i<eachLine.length(); i++)
				{
					String l=eachLine.substring(i,i+1);
					if(l.equals("a") || l.equals("e") || l.equals("i")
							|| l.equals("o") || l.equals("u"))
					{
						counter++;
					}
				}
				if(counter>=m)
				{
					words.add(eachLine);
				}
			}
			
		}
		
		getWordList();
		return wordList;
	}
	
	
	public String[] multiLetter(int m, char included) throws IOException
	{	
		
		while((eachLine = bReader.readLine()) != null)
		{
			int counter=0;
			for(int i=0; i<eachLine.length(); i++)
			{
				if(eachLine.charAt(i)== included)
				{
					counter++;
				}
			}
			if(counter==m)
			{
				words.add(eachLine);
			}
		}
		
		getWordList();
		return wordList;
	}
	
	public String [] getWordList()
	{
		wordList = new String[words.size()];
		for(int i=0; i<words.size(); i++)
		{
			wordList[i] = words.get(i);
		}
		
		for(int i=0; i <wordList.length; i++)
		{
			if(i>0)
			{
				System.out.print(" , ");
			}
			System.out.print(wordList[i]);
		}
		return this.wordList;	
	}
}
