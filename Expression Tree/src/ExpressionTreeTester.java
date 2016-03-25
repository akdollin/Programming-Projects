//***************************************
// This is the main Tester class for the 
//Expression tree problem.
//This class scans in a postfix expression.
//This class creates an instance of the ExpressionTree...
//...and passes it the expression to be tested and evaluated.
//Akiva Dollin-acd2164
//****************************************
import java.util.Scanner;

public class ExpressionTreeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter a postfix expression to evaluate:");
		
		Scanner input = new Scanner(System.in);
		String expression = input.next();
		ExpressionTree et = new ExpressionTree(expression);
		
	}

}
