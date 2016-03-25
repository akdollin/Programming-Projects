//***************************************
// This is the Palindrome class for the palindrome problem.
//This class takes a file, reads each line and calls the lineCheck()
//Then the palindrome checker determines whether the line is a palindrome. 
//Akiva Dollin-acd2164
//****************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Palindrome 
{
	public Stack s;

	public Palindrome(File n) throws FileNotFoundException
	{	
		System.out.println("hi"+(32+2)+"hi");
		Scanner scanner = new Scanner(n);
		while(scanner.hasNextLine()) //determines if there is a next line
		{
			String initialLine = scanner.nextLine();     //goes to the next line
			String finalLine = LineCheck(initialLine);    //changes the line to checkable form

			if(palindromeChecker(finalLine))
				System.out.println("This line is a palindrome: " + initialLine);
			else
				System.out.println("This line is NOT a palindrome: " + initialLine);
		}
		scanner.close();
	}

	private String LineCheck(String initialLine)
	{
		String whitespaceLine = initialLine.replaceAll(" ", "");  //to remove white space
		String specialCharLine = whitespaceLine.replaceAll("[^a-zA-Z ]","");  //to remove special characters
		String finalLine = specialCharLine.toLowerCase();    //to make all lower case

		//System.out.println(finalLine);
		return finalLine;
	}

	public boolean palindromeChecker(String line)
	{
		Stack s = new Stack(line.length()/2);
		int i;
		
		//push half the line onto the stack
		for(i=0; i< line.length()/2; i++)
		{
			s.push(line.charAt(i));
			
		}
		
		
		//Even palindrome ex: HANNAH
		if(line.length()%2==0)   
		{
			int counter=0;
			
			for( int j=line.length()/2; j<=line.length()-1; j++)
			{
				//compare characters 
				if(line.charAt(j) == s.pop())   
				{
					counter++;
				}
				else
					return false;
				
			}
			//meaning its a palindrome
			if(counter==line.length()/2)
				return true;
			else
				return false;
		}
		
		//Odd palindrome ex: RACECAR
		else  
		{
			int counter=0;
			
			for(int z=i+1; z<line.length(); z++)
			{
				if(line.charAt(z)==s.pop())
				{
					counter++;
				}
			}
			if(counter==line.length()/2)
				return true;
			else
				return false;
		}

	}
	
}
