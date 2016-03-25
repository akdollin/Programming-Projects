//problem set 2, R6.1
import java.util.Scanner;

public class testR61
{
	public static void main(String[] args)
	{
		//input an integer n
		Scanner input = new Scanner (System.in);
		System.out.println("Please enter a value for n " );
		int n = input.nextInt();
		int x= 1;
		int j= 0;
		int z=10;
		int y= 1;
		int w = n-1;
		
		//r61a
		while(j<n)
		{
			System.out.println(j);
			j = (int) Math.pow(x, 2);
			x++;
		}
		
		//r61b
		while(w>=z) //n>10 && 
		{
			if(w%z==0) {
				System.out.println(w);
				w -= 10;
			} else {
				w--;
			}

		}

		//r61c
		while(n>y)
		{
			System.out.println(y);
			y *= 2;
		}
	}
}
