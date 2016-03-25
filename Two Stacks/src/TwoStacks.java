public class TwoStacks 
{
	public int arr[];
	public int size;
	public  int top1, top2;

	public TwoStacks(int n)  // constructor
	{
		size = n;
		arr = new int[n];
		top1 = -1;
		top2 = size;   
	}
	public void push1(int x)
	{
		if(isFull())
		{
			System.out.println("Stack1 Overflow");
			System.exit(0);
		}
		else 
		{
			top1++;
			arr[top1] = x;
		}
	}
	public void push2(int x)
	{
		if (isFull())
		{ 
			System.out.println("Stack2 Overflow");
			System.exit(0);
		}
		else
			top2--;
		arr[top2] = x;
	}
	public int pop1()
	{
		if (isEmpty1())
		{
			System.out.println("Stack1 Underflow");
			return -1;
		}
		else
		{
			int x = arr[top1];
			top1--;
			return x;
		}
	}
	public int peek1()
	{
		if (isEmpty1())
		{
			System.out.println("Stack1 Underflow");
			return -1;
		}
		else
		{
			int x = arr[top1];
			return x;
		}
	}
	// Method to pop an element from second stack
	public  int pop2()
	{
		if (isEmpty2())
		{
			System.out.println("Stack2 Underflow");
			return -1;
			
		}
		else
		{
			int x = arr[top2];
			top2++;
			return x;
		}		
	}
	public  int peek2()
	{
		if (isEmpty2())
		{
			System.out.println("Stack2 Underflow");
			return -1;
		}
		else
		{
			int x = arr[top2];
			return x;
		}	
	}
	public boolean isFull()
	{
		if(top1+1>=top2)
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
	public boolean isEmpty2()
	{
		if(top2>size-1)
		{
			return true;
		}
		else
			return false;
	}
}