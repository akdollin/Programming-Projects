//***************************************
// This is the generic stack class for the 
//Expression tree problem.
//This class contains push, pop, ...
//...isEmpty, and isFull methods.
//Akiva Dollin-acd2164
//****************************************
public class MyStack <AnyType>
{
	public AnyType arr[];
	public int size;
	public int top1;
	private final static int DEFAULT_SIZE = 10;
	 
	public MyStack()
	{
		 this(DEFAULT_SIZE);
	}
	
	public MyStack(int n)  // constructor
	{
		size = n;
		arr = (AnyType[]) new Object [n];
		top1 = -1;   
	}

	public void push(AnyType x)
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

	public AnyType pop()
	{
			AnyType x = arr[top1];
			top1--;
			//System.out.println(x);
			return x;
	}
	
	public AnyType peek()
	{
			AnyType x = arr[top1];
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