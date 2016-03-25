//***************************************
// This is the CityReader class for the Dijkstra GUI.
//This class is passed in two files from the tester, 
//and reads each line. This fills the map with pairs,
//and the vertices with points. 
//Akiva Dollin-acd2164
//****************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CityReader 
{
	public ArrayList<Vertex> vertices;
	public static HashMap<String,Vertex> map;
	public CityReader(){}
	public static int maxHeight=0;
	public static int maxWidth=0;

	public CityReader(File pair, File point) throws FileNotFoundException
	{
		//initialize hashMap
		map = new HashMap<String,Vertex>();
		//add one empty item to avoid errors
		map.put("Empty", new Vertex("Empty Map"));

		//add city names
		Scanner scanner = new Scanner(pair);
		while(scanner.hasNextLine()) //determines if there is a next line
		{
			String line = scanner.nextLine();
			addCities(line);
		}
		scanner.close();

		//add edges
		Scanner scanner1 = new Scanner(pair);
		while(scanner1.hasNextLine()) //determines if there is a next line
		{
			String line = scanner1.nextLine();
			setEdgeAdjacencies(line);
		}
		scanner1.close();

		//set xy cords
		Scanner scanner2 = new Scanner(point);
		while(scanner2.hasNextLine())
		{
			String data = scanner2.nextLine();
			setXYCords(data);
		}
		scanner2.close();
	}
	//method to all city names to hash
	private void addCities(String line) 
	{
		//splits line into three parts
		String[] parts = line.split(" ");
		//first name
		Vertex city1 = new Vertex(parts[0]);
		//second name
		Vertex city2 = new Vertex(parts[1]);	

		//add to Hash - avoid duplicates
		if(!map.containsKey(parts[0]))
		{
			map.put(parts[0], city1);
		}
		if(!map.containsKey(parts[1]))
		{
			map.put(parts[1], city2);
		}
	}

	//print method used for testing
	private void printPoints() 
	{	
		//enhanced loop which prints all points in hash
		for(String name : getMap().keySet())
		{
			System.out.println(map.get(name).name+"--> x: "
					+map.get(name).xCord+" y: "
					+map.get(name).yCord);
		}
	}
	//print method to print city names and adjacencies
	public void printCities()
	{
		for (String name: map.keySet())
		{  
			System.out.print(name+": ");
			for( int i=0;i<map.get(name).adjacencies.size();i++)
			{
				System.out.print("-->"+map.get(name).adjacencies.get(i).target.name);
				
			}
			System.out.println("");
		}
	}
	//method that takes each line of points file 
	//and break it up and adds it to the value in Hash
	private void setXYCords(String data) 
	{
		//splits the line
		StringTokenizer st = new StringTokenizer(data);
		while (st.hasMoreTokens()) 
		{
			String city = st.nextToken(); //city name

			if(map.containsKey(city))
			{
				//set the x and y coordinates of each item in Hash
				map.get(city).xCord= Integer.parseInt(st.nextToken());
				map.get(city).yCord= Integer.parseInt(st.nextToken());
			}
		}	
		//set the max height used for GUI panel sizing
		for(String key : map.keySet())
		{
			if(map.get(key).xCord>maxWidth)
			{
				maxWidth = map.get(key).xCord;
			}
			if(map.get(key).yCord>maxHeight)
			{
				maxHeight = map.get(key).yCord;
			}
		}
	}
	//accesor for map
	public HashMap<String,Vertex> getMap()
	{
		return map;
	}
	//accesor for height
	public int getHeight()
	{
		return maxHeight;
	}
	//accesor for width
	public int getWidth()
	{
		return maxWidth;
	}
	//method which adds adjacencies to each city in Hash
	private void setEdgeAdjacencies(String line) 
	{
		String[] parts = line.split(" "); //splits the line
		//distance for specific edge
		BigDecimal distance = new BigDecimal(parts[2]); 
		//create edge with info and add it to adjacencies
		Edge e = new Edge(map.get(parts[1]),distance);
		map.get(parts[0]).adjacencies.add(e);
		//add edge from A to B, AND B to A
		Edge e2 = new Edge(map.get(parts[0]),distance);
		map.get(parts[1]).adjacencies.add(e2);
	}
}