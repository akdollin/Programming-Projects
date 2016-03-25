import java.util.Scanner;

public class SeasonTester {
	
	static int month = 0;
	static int day = 0;
	
	public static void main(String[] args)
	{			
		Scanner m = new Scanner (System.in); //import scanner
		
		//input the month
		System.out.println("Please enter the month of your date: 1 for January, 2 for February, etc.");
		month = m.nextInt();
		System.out.println("Thank You");
	
		//input the day
		System.out.println("Please enter a day in that month.");
		Scanner d = new Scanner(System.in);
		day = d.nextInt();
		System.out.println("Thank You");
		
		//run the season check method
		System.out.println("This date is " + SeasonDateCheck.dateCheck(day, month)); 
		
	}  
}
