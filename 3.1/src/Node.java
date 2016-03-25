
public class Node {
	Node next;
	Object data;
	
	public Node(Object dataValue)
	{
		next = null;
		data = dataValue;
	}
	
	public Node(Object dataValue, Node nextValue)
	{
		next = nextValue;
		data = dataValue;
	}

	
	public Node getNext() {
		return next;
	}

	public void setNext(Node nextValue) {
		next = nextValue;
	}

	public Object getData() {
		return data;
	}

}
