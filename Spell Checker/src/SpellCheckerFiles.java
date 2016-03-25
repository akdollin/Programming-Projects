//***************************************
// This is the SpellCheckerFiles class for the spell check
//problem.
//This class contains all the methods for spell checking.
//This class creates an instance of the hash table as well.
//Akiva Dollin-acd2164
//****************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpellCheckerFiles 
{
	//instance of the hash table class
	public SpellCheckerHash<String> hasher;
	//to print line numbers
	public int lineCounter;
	//constructor//calls the insert methods for both files
	public SpellCheckerFiles(File largeDiction, File personDiction, File inputF) throws FileNotFoundException
	{
		lineCounter=1;
		hasher = new SpellCheckerHash<String>();
		addBigDictionary(largeDiction);
		addPersonalDictionary(personDiction);
		checkInputFile(inputF);
	}
	private void checkInputFile(File inputF) throws FileNotFoundException 
	{
		Scanner scanner = new Scanner(inputF);
		while(scanner.hasNextLine()) //determines if there is a next line
		{
			String line = scanner.nextLine(); //goes to the next line
			String lowerLine = line.toLowerCase();
			String finalLine = fixWord(lowerLine);

			if(hasher.contains(finalLine))
			{
				//prints file line and the word in personalFile
				System.out.println(finalLine +"-->Duplicate-Line:["+lineCounter+"]");
			}
			else
			{
				spellCheckerRemove(finalLine);
				spellCheckerAdd(finalLine);
				spellCheckerSwap(finalLine);
			}
			lineCounter++;
		}
		scanner.close();		
	}
	//adds each word in file to hash table
	private void addBigDictionary(File largeDiction) throws FileNotFoundException 
	{
		Scanner scanner = new Scanner(largeDiction);
		while(scanner.hasNextLine()) //determines if there is a next line
		{
			String line = scanner.nextLine();     //goes to the next line
			//take out case and trailing punct.
			String lowerLine = line.toLowerCase();
			String finalLine = fixWord(lowerLine);
			hasher.insert(finalLine);
		}
		scanner.close();
	}
	//finds matched words in the hash table//calls spell check methods
	private void addPersonalDictionary(File personDiction) throws FileNotFoundException 
	{
		Scanner scanner = new Scanner(personDiction);
		while(scanner.hasNextLine()) //determines if there is a next line
		{
			String line = scanner.nextLine(); //goes to the next line
			String lowerLine = line.toLowerCase();
			String finalLine = fixWord(lowerLine);
			//if its a duplicate, do nothing
			if(hasher.contains(finalLine))
			{
				;
			}
			else
			{
				hasher.insert(finalLine);
			}
			lineCounter++;
		}
		scanner.close();
	}
	
	//method to remove trailing punct. and case
	private String fixWord(String s) 
	{
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == ',' && i == s.length() - 1)
			{
				s = removeCharAt(s, i);
			}
			else if (s.charAt(i) == '.' && i == s.length() - 1)
			{
				s = removeCharAt(s, i);
			}
		}
		return s;
	}
	//gives suggestions for spelling based on removing one char in the word
	private void spellCheckerRemove(String s) 
	{
		int counter=0;
		String tempFinal=s;
		for(int i=0; i<s.length(); i++)
		{
			String temp=s;
			char charToRemove = s.charAt(i);
			String option=removeCharAt(temp,i);

			if(hasher.contains(option))
			{
				counter++;
				System.out.print(temp+"["+lineCounter+"]"+"-->Remove{"+charToRemove+"} -->Output: " + option);
				System.out.println("");
			}
		}
		if(counter == 0)
		{
			System.out.println(tempFinal+"["+lineCounter+"]"+"-->No Remove Suggestions.");
		}
	}
	//private method for the removal of certain characters
	private static String removeCharAt(String s, int pos) 
	{
		return s.substring(0, pos) + s.substring(pos + 1);
	}
	//spell check with addition method
	public void spellCheckerAdd(String s)
	{
		//count suggestions
		int counter = 0;
		//full alphabet plus apostrophe
		char[] letters ={'a','b','c','d','e','f','g','h','i','j','k',
				'l','m','n','o','p','q','r','s','t','u','v','w','x','y','z', '\''};
		//loop looks through each space and tries to add the entire alphabet
		for (int i = 0; i < s.length(); i++)
		{
			for (int k = 0; k < letters.length; k++)
			{
				//adding the char
				String option = s.substring(0,i) + letters[k] + s.substring(i, s.length());

				if (hasher.contains(option))
				{
					System.out.println(s+"["+lineCounter+"]"+ "-->Add Character ' " 
				+ letters[k]+" ' -->Output: "+option);
					
					counter++;
				}
			}
		}

		if (counter == 0)
		{
			System.out.println(s+"["+lineCounter+"]"+ "-->No Add Suggestions.");
		}
	}
	//swap method
	private void spellCheckerSwap(String s)
	{
		int counter =0;
		//save the original to print it later
		String option = s;
		//put all chars of word into array
		char[] wordArray = s.toCharArray();
		
		for(int i = 0; i < wordArray.length-1; i++)
		{
			//swap adjacents
			char temp = wordArray[i];
			char next = wordArray[i+1];
			wordArray[i] = next;
			wordArray[i+1] = temp;
			//reconcatonate
			s = String.copyValueOf(wordArray);
			if(hasher.contains(s))
			{
				System.out.println(option+"["+lineCounter+"]"+"-->Swap Letters{"+ next + "," + temp
						+ "} -->Output:" + s);
				counter++;
				//reswap back to original and continue
				if(i<wordArray.length)
				{
					wordArray[i] = temp;
					wordArray[i+1] = next;
				}
			}
			//reswap back to original and continue
			else
			{
				wordArray[i] = temp;
				wordArray[i+1] = next;
			}
		}

		if(counter == 0)
		{
			System.out.println(option+"["+lineCounter+"]"+ "-->No Swap Suggestions.");
		}
	}
	
}
