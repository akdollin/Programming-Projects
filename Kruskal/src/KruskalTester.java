//***************************************
// This is the MAIN class for the Kruskal GUI.
//This class is passed in a file, calls the reader and
//calls the GUI constructor class.
//Akiva Dollin-acd2164
//****************************************
import java.io.File;
import java.io.FileNotFoundException;

public class KruskalTester
{
	public static void main(String[] args)
	{
		try
		{
			//does not have two files needed
			if(args.length!=1)
			{
				System.out.println("Please input only one file names.");
				System.exit(0);
			}
			else
			{
				//point.txt
				File filePoints = new File(args[0]);
				//calls class to read in data
				FileReader reader = new FileReader(filePoints);
				System.out.println("*************************************************************");
				System.out.println("Below are the CityPairs for the Kruskal Minimum Spanning Tree");
				System.out.println("*************************************************************");
				//create GUI
				new KruskalGUI(reader);
				System.out.println("Program Terminated");
			}
		}
		catch (FileNotFoundException e) //catch problems with importing file
		{
			e.printStackTrace();
		}
	}
}