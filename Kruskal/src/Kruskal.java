//***************************************
// This is the Kruskal class for the Dijkstra GUI.
//This class is passed in the instance of the Reader.
//This class computes the min spanning tree based on the Lists
//from Reader
//Akiva Dollin-acd2164
//****************************************
import java.util.ArrayList;
import java.util.List;

public class Kruskal
{
	public static ArrayList<Edge> MSTree; //final tree
	public static List<String> tree; //llist of edges added from queue
	public static int distance; //add the weight of the edges in path

	public Kruskal(FileReader fr) 
	{
		//find MST
		kruskal(fr);
		//compute distance
		getTree(fr);
	}
	public int getDistance() 
	{
		//use final MST to add the weights of all the edges
		for(Edge e : MSTree)
		{
			distance += e.weight;
		}
		return distance;
	}

	public void kruskal(FileReader fr)
	{
		//make a copy of the priority heap with the edges
		BinaryHeap<Edge> heap = fr.heap;
		//intantiate the MST
		MSTree = new ArrayList<Edge>();
		
		while(!heap.isEmpty())
		{
			//take out the smallest weight
			Edge e = heap.deleteMin();
			//if the roots are different forests
			//means that they are not in same set
			//same as disjoint sets, without the actual sets//uses pointers
			if(e.point1.getRoot() != e.point2.getRoot())
			{
				//add the edge to spanning tree
				MSTree.add(e);
				//union the forests
				e.point1.getRoot().parent = e.point2.getRoot();
			}
		}
	}
	//add the actual cities into a string to view path in console
	public void getTree(FileReader fr) 
	{
		tree = new ArrayList<String>();
		for(Edge e : MSTree)
		{
			tree.add(""+e.point1.name+e.point2.name);
		}
		System.out.println(tree);
	}
}
//subclass which defines a Point. Has priority.
class Point implements Comparable<Point>
{
	public int xCord, yCord;
	public Point parent = this;
	public String name;
	public double priority;

	public Point(String name,int x, int y) 
	{
		this.name = name;
		xCord = x;
		yCord = y;
	}
	public Point getRoot() 
	{
		if  (parent != this)
			parent = parent.getRoot(); // path compression
		return parent;
	}
	//euclydian distance computed
	public double distanceTo(Point other) 
	{
		int xDiff = xCord - other.xCord;
		int yDiff = yCord - other.yCord;
		return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
	}
	//compare points based on priority
	public int compareTo(Point other)
	{
		return (int) Math.signum(priority - other.priority);
	}
}
//subclass defines a edge//compare based on weight
class Edge implements Comparable<Edge> 
{
	public Point point1, point2;
	public double weight;

	public Edge(Point point1, Point point2) 
	{
		this.point1 = point1;
		this.point2 = point2;
		weight = point1.distanceTo(point2);
	}
	public int compareTo(Edge other)
	{
		return (int) Math.signum(weight - other.weight);
	}
}
