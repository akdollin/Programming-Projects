//***************************************
// This is the Dijkstra class for the Dijkstra GUI.
//This class compares the cities and finds the shortest path
//between two cities. 
//Akiva Dollin-acd2164
//****************************************
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra 
{
	public static String source="";
	public static String target="";
	public BigDecimal finalDistance = new BigDecimal("0");
	public static List<Vertex> finalPath;
	public CityReader reader;
	//constructor to initialize cityReader class
	public Dijkstra(CityReader reader)
	{
		this.reader = reader;
	}
	public void run(CityReader reader)
	{
		//finds paths based on source provided by the GUI
		if(reader.getMap().containsKey(source))
		{
			computePaths(reader.getMap().get(source));
		}
		else
		{
			//catch weird input...like blank boxes
			System.out.println("Invalid Source.");
		}
		//finds paths based on target provided by the GUI
		//this methods calls the dijkstra algorithm
		if(reader.getMap().containsKey(target))
		{
			//print to console for testing
			System.out.println("Distance from " + source +
					" to "+target+": " +
					reader.getMap().get(target).minDistance);

			//update instance variable for usage by GUI
			finalDistance = reader.getMap().get(target).minDistance;

			//initialze final distance array
			List<Vertex> path = new ArrayList<Vertex>();
			//calls dijkstra algorithm
			path = getShortestPathTo(reader.getMap().get(target),path);
			//print path
			System.out.println("Path: " + path);
		}
		else
		{
			System.out.println("Invalid Target.");
		}
	}
	//dijkstra algorithm 
	public void computePaths(Vertex source)
	{
		//initialize min distance
		source.minDistance = new BigDecimal("0");
		//initialize heap...start with source
		BinaryHeap<Vertex> vertexHeap = new BinaryHeap<Vertex>();
		vertexHeap.insert(source);

		while (!vertexHeap.isEmpty()) 
		{
			//look at first vertex so far
			Vertex u = vertexHeap.deleteMin();

			// look at adjacent vertices of this Vertex
			for (Edge e : u.adjacencies)
			{
				//look at the next Vertex
				Vertex v = e.target;
				//look at its weight
				BigDecimal weight = e.weight;
				//the distance for each adjacacent vertex 
				//is saved as the distance from source
				BigDecimal distanceThroughU = u.minDistance.add( weight);

				//compare the distance so far to the lowest
				//distance found through the adjacent vertices
				if(distanceThroughU.compareTo(v.minDistance) < 0)
				{
					v.minDistance = distanceThroughU ;
					v.previous = u;
					//add the vertex to the heap to be looked 
					//at next if its path is shortest
					vertexHeap.insert(v);  //use decrease key(), add heap with total, completed array- different constructor
				}
			}
		}
	}
	//follows the path of shortest lengths back to source
	public  List<Vertex> getShortestPathTo(Vertex target, List<Vertex> path)
	{
		for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
			path.add(vertex);
		//reverses order to pront correctly
		Collections.reverse(path);
		//update instance variable used by GUI
		finalPath = path;
		return path;
	}

	private List<Vertex> setFinalPath(CityReader reader, List<Vertex> path) 
	{
		path.add(reader.getMap().get(source));
		return path;
	}
	//used by GUI to change the target
	public void updateTarget(String targetCityName) 
	{
		target= targetCityName;

	}
	//accessor for distance
	public BigDecimal getDistance()
	{
		return finalDistance;
	}
	//accessor for path
	public List<Vertex> getPath()
	{
		return finalPath;
	}
	//used by GUI to change source
	public void updateSource(String sourceCityName)
	{
		source= sourceCityName;		
	}
}
//subclass that defines vertex
class Vertex implements Comparable<Vertex>
{
	public final String name;
	public ArrayList<Edge> adjacencies = new ArrayList<Edge>();
	public BigDecimal minDistance = BigDecimal.valueOf(Double.MAX_VALUE);
	public Vertex previous;
	public int xCord;
	public int yCord;

	public Vertex(String argName) 
	{ 
		name = argName;
	}

	public String toString() 
	{ 
		return name; 
	}
	//compareTo based in minDistance
	public int compareTo(Vertex v)
	{
		return minDistance.compareTo(v.minDistance);
	}
}
//subclass which defines edges
class Edge
{
	public final Vertex target;
	public final BigDecimal weight;

	public Edge(Vertex argTarget, BigDecimal argWeight)
	{ 
		target = argTarget; 
		weight = argWeight; 
	}
}