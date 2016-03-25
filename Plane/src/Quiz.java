import java.util.Scanner;

public class Quiz 
{
	String player1;
	
	public Scanner input;
	public String userAnswer;
	

	public Quiz()
	{
		System.out.println("I'm Bored. Would U Like To Play A Game? (y/n)");
		String userAnswer = new Scanner(System.in);
	}
	
	public void play()
	{
		userAnswer=input.next();
	}
}
