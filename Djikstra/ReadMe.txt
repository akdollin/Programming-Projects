//***************************************
// This is the ReadMe for the Dijkstra Program 
//Akiva Dollin-acd2164
//****************************************

To Run: To run this program, simply compile with two command line args. The first is the pairs.txt and the second is the points.txt.
The GUI will pop up. To see the Dijkstra work between two cities, selected them through the combo boxes and press the shortest path button.


This program has 8 classes. 

BinaryHeap: This is the generic BinaryHeap from Weiss.

UnderflowException: This is from Weiss also.

DijkstraTester:
This is the main class. It takes in two files as the command line args, calls the file reader class and calls
the GUI constructor class.

CityReader: This class reads in the info from the files so it can be accessed by the Dijkstra algorithm. 
It takes three scanners. The first reads each new city name and adds it to a HashMap. The next scanner reads through it again and 
adds the adcacencies to each item in the hash. The third scanner goes through it again and updates the x and Y coordinates of the 
items in the Hash. This class also saves the greatest x and y to build the panel later in the GUI.

Dijkstra: This class takes in the info from the CityReader and uses the Dijkstra algorithm. This class uses a source to compute all 
the distances to every nodes in the hash. It then uses the source to find the shortest path between the two. computePaths() is the Dijkstra
algorithm. This class saves a List which is filled with the shortest path based on the desired source and target. These two parameters are 
instantiated in the GUI class. 

DijkstraGUI: This class creates the GUI. The GUI is defined as having a buttonPanel which has the comboBoxes, filled with the cities. 
These combo boxes are attached to actions which update the source and target variable on the dijkstra class. The bottom has the textFields with
the actual shortest path and distance of it.It also has a reset button
which switches the map back to a full map and a show shortest path button.
The scroller is attached to the cityPanel and is painted by the MyComponent and newComponent classes.
 
drawComponent: This class paints the panel with the full map. It uses the max width and height as sizes. The points are not given in the
 correct format, so they are placed in the correct position by subtract the max height by every y value. The draw() looks through every 
 vertex and its adjacency list to draw the names and the circles. The lines are drawn by the adjacencies as well. 
 
newComponent: This class draw only the Dijkstra shortest path. It looks through the data structure with the path 
provided by the Dilkstra class and draws the cities and the circles. It then uses the path to connect the path with lines.