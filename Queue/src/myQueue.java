//************//
//generic queue class
//************//

public class myQueue <AnyType> {

	public AnyType arr[];
	public int size;
	public int top;
	public int bottom;
	private final static int DEFAULT_SIZE = 10;
	public int counter = 0;

	public myQueue()
	{
		this(DEFAULT_SIZE);
	}

	public boolean isFull()
	{
		if(counter == size)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	public myQueue(int s)  // constructor
	{
		this.size = s;
		arr = (AnyType[]) new Object [size];
		top = -1;   
		bottom = -1;
	}

	public void enqueue(AnyType x)
	{

		if(!isFull())
		{
			
			top++;
			if(top>size-1)
			{
				top=0;
				arr[top] = x;
				counter++;
			}
			arr[top] = x;
			counter++;
		}
		else 
		{
			System.out.println("Queue Overflow");
			System.exit(0);
		}
	}

	public AnyType dequeue()
	{

		if(isEmpty())
		{
			System.out.println("Underflow");
			System.exit(0);
			return arr[bottom];
		}

		else
		{
			//bottom++;
			if(bottom == size-1)
			{
				bottom = 0;
				counter--;
				return arr[bottom];
			}
			else
			{
				counter--;
				bottom++;
				return(arr[bottom]);	
			}
			
		}
	}

	public AnyType peek()
	{
		if(bottom == size-1)
			{
				bottom = 0;
				return arr[bottom];
			}
		return (arr[++bottom]);
	}

	public boolean isEmpty()
	{
		if(counter == 0)
		{
			return true;
		}
		else
			return false;
	}
}