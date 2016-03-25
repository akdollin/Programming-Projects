//***************************************
// This is the SpellCheckTester class for the spell check
//problem.
//This class creates an instance of the spellCheckFile class.
//This class takes in two file names through command line args.
//Akiva Dollin-acd2164
//****************************************
import java.io.File;
import java.io.FileNotFoundException;

public class SpellCheckTester
{
	public static void main (String []args) 
	{
		try
		{
			//does not have two files needed
			if(args.length!=3)
			{
				System.out.println("Please input three file names.");
				System.exit(0);
			}
			else
			{
				//save files as File objects
				File largeF = new File(args[0]);
				File personalF = new File(args[1]);
				File inputF= new File(args[2]);
				SpellCheckerFiles test =new SpellCheckerFiles(largeF, personalF, inputF);
			}
		}
		catch (FileNotFoundException e) //catch problems with importing file
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Program Terminated");
		}
	}
}
