////import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Scanner;
//
//
//public class WordListsTester 
//{
//
//	public static void main(String[] args) throws IOException 
//	{
//		System.out.println("Welcome. Here are some things to"
//				+ " look for in the dictionary:");
//
//		System.out.println("1: Words of a given length.");
//		
//		System.out.println("2: Words starting with a "
//				+ "given letter and of a given length.");
//		
//		System.out.println("3: Words containing a specific "
//				+ "letter and of a given length.");
//		
//		System.out.println("4: Words with given number of "
//				+ "vowels and of a given length.");
//		
//		System.out.println("5: Words with a given number of given letter.");
//
//		WordLists w = new WordLists("dictionary.txt");
//		System.out.println("Which list would you like? (1-5)");
//		Scanner input = new Scanner(System.in);
//		String i = input.next();
//
//		if (i.equals("1"))
//		{
//			System.out.print("Enter the length of the words "
//					+ "you want to generate: ");
//			int n = Integer.parseInt(input.next());
//			w.lengthN(n);
//			//input.reset();
//		}
//
//		else if (i.equals("2"))
//		{
//			System.out.print("Enter the first letter of the words you want"
//				+ " to generate: ");
//			String s = input.next();
//			char firstLetter = s.charAt(0);
//			
//			System.out.print("Enter the length of the words "
//					+ " you want to generate: ");
//			int n = Integer.parseInt(input.next());
//			w.startsWith(n, firstLetter);
//			//input.reset();
//		}
//
//		else if (i.equals("3"))
//		{
//			System.out.print("Enter a letter to generate a list of "
//					+ " all words that contain that letter: ");
//			String s = input.next();
//			char included = s.charAt(0);
//			System.out.print("Enter the length of the words "
//					+ " you want to generate: ");
//			int n = Integer.parseInt(input.next());
//			w.containsLetter(n, included);
//			//input.reset();
//		}
//
//		else if (i.equals("4"))
//		{
//			System.out.print("Enter a number to generate a list of all words that"
//					+ " contain that number of vowels: ");
//			int m = Integer.parseInt(input.next());
//			
//			System.out.print("Enter the length of the words "
//					+ "you want to generate: ");
//			int n = Integer.parseInt(input.next());
//			w.vowelHeavy(n, m);
//			//input.reset();
//		}
//
//		else if (i.equals("5"))
//		{
//			System.out.print("Enter the letter that you want to search for: ");
//			String s = input.next();
//			char included = s.charAt(0);
//
//			System.out.print("Enter the number of occurences of that letter: ");
//			int m = Integer.parseInt(input.next());
//			w.multiLetter(m, included);
//			//input.reset();
//		}
//		System.out.println("Would you like to find another list? y/n");
//		nextList = new Scanner(System.in);
//		if(nextList.next().equals("y"))
//		{
//			
//		}
//	}
//}
