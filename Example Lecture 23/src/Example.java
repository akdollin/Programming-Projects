import java.util.Scanner;
import java.io.*;

public class Example
{

  public static void main(String[] args) throws IOException
  {
	File inFile = new File(args[0]);  //String in the command line argument. Will be a file name "textFile.txt"
	Scanner input = new Scanner(inFile); //gives it the file name//instead of seeing keyboard, it sees the file
	
	String word;
	PrintWriter output = new PrintWriter(args[1]); //print and println //give it a string//creates that file//
	while(input.hasNext())   //comes from scanner class//hasNExt() is boolean//the close output stream
	{
	  word=input.next();
	  output.println(word);
	}
	  output.close();  //close stream//then dumps file into the buffer
  }
}