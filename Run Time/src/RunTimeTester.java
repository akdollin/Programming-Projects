//***************************************
// This is the main class for the run time
//problem.
//This class scans in a value from the user, creates an instance of 
//the RunTimeLoops class and then calls the methods for each loop.
//Akiva Dollin-acd2164
//****************************************
import java.util.Scanner;

public class RunTimeTester {
	
	public static void main(String[] args) 
	{
		//Scan in input for n
		System.out.println("Please give me a value for n.");
		Scanner input = new Scanner(System.in);
		int nValue = input.nextInt();
		
		//create an instance of the RunTimeLoops class
		RunTimeLoops r = new RunTimeLoops();
		
		//call each method with the inputed value
		r.b1(nValue);
		r.b2(nValue);
		r.b3(nValue);
		r.b4(nValue);
		r.b5(nValue);
		r.b6(nValue);
		
		//indicate the end of the program
		System.out.println("Here are my results.Bye!");
	}
}

