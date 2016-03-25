//***************************************
// This is the FileReader class for the Dijkstra GUI.
//This class is passed in a file and reads it line by line. It fills 
//a hash map with the city points, and a heap with the edges.
//Akiva Dollin-acd2164
//****************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileReader 
{
	//save the edges by weight - priority
	public BinaryHeap<Edge> heap;
	//save XY cords
	public static HashMap<String,Point> points;
	//max x and y used by component constructor
	public static int maxWidth = 0;
	public static int maxHeight = 0;
	public static int sizeCounter = 0;

	public FileReader(File f) throws FileNotFoundException
	{
		//scan from file
		Scanner scanner = new Scanner(f);
		points = new HashMap<String,Point>();
		//instantiate hash with empty point
		points.put("Empty", new Point("Empty",0,0));

		while(scanner.hasNextLine()) //determines if there is a next line
		{
			String line = scanner.nextLine();
			//add name of each city with x and y cords
			addCities(line);
		}
		scanner.close();

		//printPoints();
		//add edges to priority queue
		addEdges();
		//printHeap();
	}
	private void addEdges() 
	{
		//instantiate heap with empty edge
		heap = new BinaryHeap();
		Point p = new Point("Empty",0,0);
		Edge e = new Edge(p,p);
		heap.insert(e);
		//completed graph, so add each edge from every vertex
		//adds twice
		for(String rootName : points.keySet())
		{
			for(String otherName : points.keySet())
			{
				if(otherName != "Empty" && rootName!= "Empty")
				{
					if(otherName!=rootName)
					{
						heap.insert(new Edge(points.get(rootName)
								,points.get(otherName)));
					}
				}
			}
		}
	}
	//accessor for hash
	public HashMap<String, Point> getPoints() 
	{
		return points;
	}
	//method to print heap
	//used for testing
	public void printHeap()
	{
		BinaryHeap<Edge> temp = heap;
		
		while(!temp.isEmpty())
		{
			Edge e = heap.deleteMin();
			System.out.println(e.point1.name+" "+e.point2.name+" --> "+e.weight);
		}
	}
	//method used for testing
	private void printPoints() 
	{	
		for(String name : points.keySet())
		{
			System.out.println(points.get(name).name+"--> x: "
					+points.get(name).xCord+" y: "
					+points.get(name).yCord);
		}
	}
	//add data into hash from file
	//set name and xy coordinates 
	private void addCities(String line) 
	{		
		//split line
		StringTokenizer st = new StringTokenizer(line);
		
		while (st.hasMoreTokens()) 
		{
			//name if city is first 
			String name = st.nextToken();
			//int of xy coordinates
			int xCord= Integer.parseInt(st.nextToken());
			int yCord= Integer.parseInt(st.nextToken());
			//create new point with line
			Point city = new Point(name,xCord,yCord);	
			//update max sizes// used by GUI
			if(xCord>maxWidth)
			{
				maxWidth = xCord;
			}
			if(yCord>maxHeight)
			{
				maxHeight = yCord;
			}
			//check for duplicates
			if(!points.containsKey(name))
			{
				//add to hash
				points.put(name,city);
				sizeCounter++;
			}
		}	
	}

}