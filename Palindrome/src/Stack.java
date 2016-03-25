//***************************************
// This is the Stack class for the 
//palindrome problem.
//This class contains push, pop, ...
//...isEmpty, and isFull methods.
//Akiva Dollin-acd2164
//****************************************
public class Stack 
{
	public char arr[];
	public int size;
	public int top1;

	public Stack(int n)  // constructor
	{
		size = n;
		arr = new char[n];
		top1 = -1;   
	}

	public void push(char x)
	{
		if(isFull())
		{
			System.out.println("Stack1 Overflow");
		}
		else 
		{
			top1++;
			arr[top1] = x;
		}
	}

	public char pop()
	{
			char x = arr[top1];
			top1--;
			return x;
	}
	
	public boolean isFull()
	{
		if(top1+1>=size)
			return true;
		else
			return false;
	}

	public boolean isEmpty1()
	{
		if(top1<0)
		{
			return true;
		}
		else
			return false;
	}
}