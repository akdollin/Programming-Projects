import java.util.Scanner;
import java.io.*;

public class ExampleB //this one uses exceptions//java object that represents unwanted event
{

  public static void main(String[] args) 
  {
	try
	{
   	  File inFile = new File(args[0]); //instantiate file object
	  Scanner input = new Scanner(inFile); //feed it to a scanner
	  String word;
	  PrintWriter output = new PrintWriter(args[1]); //sees it out of bounds//then goes to the first catch
	  while(input.hasNext()){
	    word=input.nextLine();
	    output.println(word);
	  }
	  output.close();
	}
	catch(IOException e) //file not found
	{
	  System.out.println("Please try again with correct input file name");
	}
	catch(ArrayIndexOutOfBoundsException e)
	{
	  System.out.println("At least two command line arguments "); //first catch for index out of bounds
	}
  }
}