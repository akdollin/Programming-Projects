//***************************************
// This is the main Tester class for the Dijkstra GUI.
//This class is passed in two files via command line args, 
//and calls the CityReader class. It then calls the GUI class
//Akiva Dollin-acd2164
//****************************************
import java.io.File;
import java.io.FileNotFoundException;

public class DijkstraTester
{
	public static void main(String[] args)
	{
		try
		{
			//does not have two files needed
			if(args.length!=2)
			{
				System.out.println("Please input two file names.");
				System.exit(0);
			}
			else
			{
				//save files as File objects
				File filePairs = new File(args[0]); //pairs
				File filePoints = new File(args[1]); //points
				//to read and interpret files
				CityReader reader = new CityReader(filePairs,filePoints);
				//creates the GUI
				new DijkstraGUI(reader);
				System.out.println("Program Terminated");
			}
		}
		catch (FileNotFoundException e) //catch problems with importing file
		{
			e.printStackTrace();
		}
	}
}