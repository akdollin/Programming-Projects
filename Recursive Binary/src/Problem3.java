//***************************************
// This is the main class for the recursive binary problem.
//This class scans in a file of sorted integers.
//This class iterates through the file once to count the number of items.
//This class fills an array with each item in the file.
//It then takes a desired value to search for.
//It then uses a recursive binary search to find the item and its index.
//Akiva Dollin-acd2164
//****************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem3 
{
	public static void main(String[] args)
	{
		try //try/catch to catch exceptions
		{  
			//import new file
			File file = new File("array.txt");
			int arraySize = 0;

			//Reading each line of file to determine size of needed array
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) //determines if there is a next line
			{
				scanner.nextLine();     //goes to the next line
				arraySize++;
			}
			scanner.close();
			
			//fill the new array with file
			int[] arr = new int[arraySize];
			Scanner scanner2 = new Scanner(file);
			for(int i=0; i<arraySize; i++)
			{
				arr[i] = scanner2.nextInt();
			}   
			scanner2.close();
			
			//Scan in desired target 
			System.out.println("Please enter the search key: ");
			Scanner input = new Scanner(System.in);
			int target = input.nextInt();
			
			//call binarySearch() 
			//pass in array, min, max:length-1 of the array, and the target
			binarySearch(arr, 0, arr.length-1, target);
		}  
		catch (FileNotFoundException e) //catch problems with importing file
		{
			e.printStackTrace();
		}
	}

	//recursive binary method
	public static int binarySearch(int[] arr, int leftPoint, int rightPoint, int target)
	{
		//define midPoint
		int midPoint=(rightPoint+leftPoint)/2;
		
		//if it doesn't exist
		if(rightPoint<leftPoint)
			System.out.println("The Target Does Not Exist.");
		
		//if the midPoint is the target
		else if(arr[midPoint]==target)
			System.out.println("Index: " + midPoint + " Value: " + arr[midPoint]);
		
		//if the target is larger than the midPoint
		else if(arr[midPoint]<target) 
			return binarySearch(arr, midPoint+1, rightPoint, target);
		
		//if the target is less than the midPoint
		else if(arr[midPoint]>target)
			return binarySearch(arr, leftPoint, midPoint-1, target);			
		return -1;
	}
}
