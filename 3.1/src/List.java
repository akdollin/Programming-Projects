
public class List 
{
	private Node head;
	private int ListCount;
	
	public List() 
	{
		head = new Node(null);
		ListCount=0;
	}
	
	public void add(Object data)
	{
		Node tempNode = new Node(data);
		Node currentNode = head;
		
		while(currentNode.getNext() != null)
		{
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(tempNode);
		ListCount++;
	}
	
	public void add(Object data, int index)
	{
		Node tempNode = new Node(data);
		Node currentNode = head;
		
		//searches through list for the index or the last item
		for (int i=1; i<index && currentNode.getNext() !=null; i++)
		{
			currentNode = currentNode.getNext();
		}
		tempNode.setNext(currentNode.getNext());
		currentNode.setNext(tempNode);
		ListCount++;  //number of elements in the variable
	}
	
	public Object get(int index)
	{
		if (index<=0)  //must be greater than one
			return null;
		
		Node currentNode = head.getNext();
		for (int i=1; i<index; i++)
		{
			if(currentNode.getNext() ==null)
				return null;
			else 
				currentNode = currentNode.getNext();
		}
		return currentNode.getData();
	}
	
	public int size()
	{
		return ListCount;
	}
}
