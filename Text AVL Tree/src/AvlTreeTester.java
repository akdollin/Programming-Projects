//***************************************
// This is the AvlTreeTester class for the AVL word problem.
//This class takes a file as a command line args and makes
//an instance of the buildTree class.
//Akiva Dollin-acd2164
//****************************************
import java.io.File;
import java.io.FileNotFoundException;

public class AvlTreeTester 
{
	public static void main(String[] args)
	{
		try //try/catch to catch exceptions
		{  
			if (args.length>0)
			{
				File file = new File(args[0]);
				buildAvlTree wordTree = new buildAvlTree(file);
			}
			else
			{
				System.out.println("Input file as a command line args.");
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


