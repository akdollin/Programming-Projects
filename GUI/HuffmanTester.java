//***************************************
// This is the HuffmanTester class for the spell check
//problem.
//This class creates an instance of the HuffmanCode class.
//This class takes in one file names through command line args.
//Akiva Dollin-acd2164
//****************************************
import java.io.File;
import java.io.FileNotFoundException;

public class HuffmanTester
{
	public static void main (String []args) 
	{
		try
		{
			//does not have two files needed
			if(args.length!=1)
			{
				System.out.println("Please input file name.");
				System.exit(0);
			}
			else
			{
				//save files as File objects
				File file = new File(args[0]);
				HuffmanCode huffCode = new HuffmanCode(file);
				
				//GUIComponent gui = new GUIComponent();

			    //gui.createAndShowGUI();

				
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
