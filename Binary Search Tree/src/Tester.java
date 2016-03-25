//***************************************
// This is the Tester class for the 
//Binary Search Tree problem.
//This class inserts several values into the tree.
//This class then lazy deletes some of those values and then...
//...recalls every method in BinarySearchTree class to make sure they work.
//Akiva Dollin-acd2164
//****************************************
public class Tester 
{
	public static void main(String[] args) 
	{

		BinarySearchTree<Integer> t = new BinarySearchTree();

		System.out.println( "Checking... (no more output means success)" );

			t.insert( 7 );
			t.insert( 5 );
			t.insert( 8 );
			t.insert( 3 );
			t.insert( 2 );
			t.insert( 1 );
			
		System.out.println("******Before Lazy Deletion******");
		t.printTree( );
		System.out.println("");
		
		//lazy delete
//		t.remove(1);
//		t.remove(2);
//		t.remove(3);
//		t.remove(4);
//		t.remove(5);
		//t.remove(6);
		System.out.println("Node# " + t.numLeaf());
		
		System.out.println("******After Lazy Deletion******");
////************************************//
////		Test Methods
////************************************//
//		
//		//Max 
//		System.out.print("Max:"+t.findMax()+"-->");
//		t.printTree( );
//		//Min
//		System.out.println("");
//		System.out.print("Min:"+t.findMin()+"-->");
//		t.printTree( );
//		//insert
//		System.out.println("");
//		t.insert(4);
//		System.out.print("After insert(): ");
//		t.printTree( );
//
//		//contains
//		System.out.println("");
//		if(t.contains(3))
//			System.out.print("contains(): Contains this element."); 
//		else
//			System.out.print("contains(): Does not contain this element");
//		//isEmpty  //test with the whole tree
//		System.out.println("");
//		if(t.isEmpty())
//			System.out.print("isEmpty(): This tree is empty."); 
//		else
//			System.out.print("isEmpty(): This tree is not empty.");
//		//makeEmpty()
//		System.out.println("");
//		t.makeEmpty();    
//		t.printTree( );
	}
}
