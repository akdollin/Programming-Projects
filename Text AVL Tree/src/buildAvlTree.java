//***************************************
// This is the buildAvlTree class for the AVL word problem.
//This class takes a file, reads each line, removes commas and periods
//It then inserts the word into the tree and prints the tree.  
//Akiva Dollin-acd2164
//****************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class buildAvlTree
{
	public buildAvlTree(File f) throws FileNotFoundException
	{
		AvlTree<String> fileTree = new AvlTree<String>(f);

		Scanner scanner = new Scanner(f);
		while(scanner.hasNextLine()) //determines if there is a next line
		{
			String uncheckedLine = scanner.nextLine();     //goes to the next line

			StringTokenizer tokenString = new StringTokenizer(uncheckedLine);

			while(tokenString.hasMoreTokens())
			{
				String finalWord = fixWord(tokenString.nextToken());
				fileTree.insert(finalWord);
			}

			fileTree.lineCounter++;
		}
		scanner.close();
		fileTree.printTree();
	}

	private String fixWord(String s) 
	{
		//String s = word.toLowerCase();
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == ',' && i == s.length() - 1)
			{
				s = deleteCharAt(s, i);
			}
			else if (s.charAt(i) == '.' && i == s.length() - 1)
			{
				s = deleteCharAt(s, i);
			}
		}
		return s;
	}
	private static String deleteCharAt(String s, int index) 
	{
		//deletes characters by adding two substrings and skipping over index
		return s.substring(0, index) + s.substring(index + 1);

	}
}