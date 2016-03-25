import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class ListTree
{
	private BinaryNode root;
	public int nodeCounter;
	public int lineCounter;
	public ListTree(){}
	
	//constructor
	public ListTree(File f) throws FileNotFoundException
	{
		root = null;
		nodeCounter=0;
		lineCounter=1;

		Scanner scanner = new Scanner(f);
		while(scanner.hasNextLine()) //determines if there is a next line
		{
			String eachLine = scanner.nextLine();     //goes to the next line
			addWords(eachLine);
			lineCounter++;
		}
		printTree();
		scanner.close();
	}
	
	private void addWords(String s) 
	{
		String[] words = s.split(" ");  

		for (String word : words)  
		{  
			System.out.println(word);
			insert(word);  
		}  
	}
	
	//subclass BINARYNODE
	private static class BinaryNode
	{
		//instance variable
		String element;            // The data in the node
		BinaryNode left;   // Left child
		BinaryNode right;  // Right child
		Boolean deleted;  //for lazy deletion
		LinkedList<Integer> list;
		int lineIndex;

		//constructor for root
		public BinaryNode( String theElement, BinaryNode left, BinaryNode right, Boolean f, Integer lineIndex)
		{
			element  = theElement;
			this.left   = left;
			this.right   = right;
			deleted = false;
			this.list = new LinkedList<Integer>();
			list.add(lineIndex);
		}
	}
	
	//public insert method
	public void insert( String x )
	{
		root = insert( x, root );
	}

	//private insert method
	private BinaryNode insert( String x, BinaryNode t )
	{
		nodeCounter++;
		if( t == null )
			return new BinaryNode( x, null, null,false, lineCounter);
		if(t.left==null && t.right==null)
			t.left=insert( x, t.left );
//		if(t.right==null)
//			t.right = insert( x, t.right );
//		int compareResult = x.compareTo( t.element );
//
//		if( compareResult < 0 )
//			t.left = insert( x, t.left );
//		else if( compareResult > 0 )
//			t.right = insert( x, t.right );
//		else if (compareResult==0)
//			if(t.deleted=true)
//				t.deleted=false;
//		  // Duplicate; do nothing
		return t;
	}

	public String findMin( )
	{
		if( isEmpty( ) )
			throw new UnderflowException("Underflow" );
		return findMin( root ).element;
	}
	
	private BinaryNode findMin(BinaryNode t) 
	{
		if (t == null) 
			return null;
		BinaryNode temp= findMin(t.left);

		if (temp != null) 
			return temp;
		if (!t.deleted) 
			return t;
		else
			return findMin(t.right);
	}

	public String findMax( )
	{
		if( isEmpty( ) )
			throw new UnderflowException("Underflow" );
		return findMax( root ).element;
	}
	
	private BinaryNode findMax( BinaryNode t )
	{
		if (t == null) 
			return null;
		BinaryNode temp= findMax(t.right);

		if (temp != null) 
			return temp;
		if (!t.deleted) 
			return t;
		else
			return findMax(t.left);
	}

	public boolean contains( String x )
	{
		return contains( x, root );
	}

	private boolean contains( String x, BinaryNode t )
	{
		if( t == null )
			return false;

		int compareResult = x.compareTo( t.element );

		if( compareResult < 0 )
			return contains( x, t.left );
		else if( compareResult > 0 )
			return contains( x, t.right );
		else 
			if(t.deleted=true)
				return false;
		return true;   
	}
	
	public void remove(String x)
	{
		remove(x,root);
	}

	private void remove(String x, BinaryNode t)
	{
		nodeCounter--;
		if(contains(x))
		{
			int compareResult = x.compareTo( t.element );

			if( compareResult < 0 )
				remove( x, t.left );
			else if( compareResult > 0 )
				remove( x, t.right );
			else
				t.deleted = true;
		}
	}

	public void makeEmpty( )
	{
		root = null;
	}

	public boolean isEmpty( )
	{
		if(nodeCounter==0)
			return true;

		return false;
	}

	public void printTree( )
	{
		if (! isEmpty( )) 
			printTree( root );
		else
			System.out.println("Exception, Underflow");
	}

	private void printTree( BinaryNode t )
	{
		if( t != null)
		{
			printTree( t.left );
			if(!t.deleted)
				System.out.println(t.element+"-Lines: "+t.list);
			
			printTree( t.right );
		}
	}
}