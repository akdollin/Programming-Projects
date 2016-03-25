import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;

public class ListTester 
{
	public static void main(String[] args) 
	{
		//make one List: L
		ArrayList<Integer> p = new ArrayList<Integer>();  //indexes
		ArrayList<Integer> l = new ArrayList<Integer>();

		//0123456789
		for(int i=0; i<10; i++)
			l.add(i);

		p.add(0);
		p.add(2);
		p.add(3);
		p.add(5);
		p.add(9);

		printLots( l, p);
	}

	public static void printLots(ArrayList<Integer> l, ArrayList<Integer> p)
	{
		//has next and next
		Iterator<Integer> iter = p.iterator();  //indexes
		Iterator<Integer> iter2 = l.iterator(); //numbers

		Integer index;
		Integer prevIndex= -1;
		Integer value = 0;

		while (iter.hasNext())  //more indexes to find
		{
			index = iter.next();  

			for(int i=prevIndex; i<index; i++)
			{
				value = iter2.next();
			}

			prevIndex=index;

			System.out.println(value);

		}
	}
}
