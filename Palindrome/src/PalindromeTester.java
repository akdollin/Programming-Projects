//***************************************
// This is the Tester class for the palindrome question. 
//This class has a try catch to catch by files. 
//Akiva Dollin-acd2164
//****************************************
import java.io.File;
import java.io.FileNotFoundException;

public class PalindromeTester 
{
	public static void main(String[] args)
	{

		try //try/catch to catch exceptions
		{  
			//import new file
			File palindromeFile = new File("palindrome.txt");

			//Filling array with characters from each line
			Palindrome p = new Palindrome(palindromeFile);
		}
		
		catch (FileNotFoundException e) //catch problems with importing file
		{
			e.printStackTrace();
		}		
	}
}

