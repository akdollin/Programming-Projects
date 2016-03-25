//***************************************
// This is the ReadMe for the Kruskal GUI.
//This ReadMe includes a brief summary of each class
//and has instructions for how to run program. 
//Akiva Dollin-acd2164
//****************************************

To Run this program. Simply compile with one command line args. This file should include the names of the citues and the 
x and y coordinates. Ex: points.txt.
The GUI window will pop up with the MST printed. The total distance is found at the top of the window.
The actual edges as they were added are printed to the console.


This program has 7 classes:

BinaryHeap: Generic from Weiss. 

UnderflowException: Generic from Weiss.

KruskalTester: This is the main class. It takes in a file from command line args, calls the Reader to fill the hash and the heap,
and then calls the GUI to compute the MST and create the GUI window. 

FileReader: This class reads each line of the file with a scanner. It calls addCities on each line. This method splits the line, and
converts the data into city names, xCoordinates and yCoordinates. It then creates new points from these, and adds them into the hash. 
The hash key is the name of each city. The class then calls the edges method to add the edges between each Point. The graph is fully 
connected, so every Point is connected to everything. This is done by iterating through every Point for each point, and adding the 
corresponding edge to the heap. The heap has lots of edges, sorted by weight. 

KruskalGUI: This class is called after the heap and hash are filled. This class creates a frame with two parts. 
The first has a text field
which is filled by the final distance computed by the Kruskal algorithm. It then has a scroll pane, filled with the city Panel. 
The Panel is 
draw on by the Component. 

Kruskal: This class creates the edge list and finds the MST using the heap. It also defines a Point as having a priority,
 based on the heap.
The point also has a method which traverses up its tree to find the root. This method allows us to determine whether 
one set is part of another set. This is instead of using a disjoint set class. The Kruskal algorithm is relatively simple.
 It takes the smallest 
edge from the heap using deleteMin(). If the edges roots are the same, meaning they are in the same set, then they cannot be used. This is 
equivalent to using the two find()s. If the roots of both points are different, then add the edge to the path list, and 
union the sets by setting one of the roots to the other root. 
The tree method simply puts the edges added into a string and prints to the console. 

MSTComponent: This class extends JComponents and defines the paint(). It uses the max x and y from the FileReader class to set size. 
The draw() uses the MST defined by Kruskal to print the city names, the circles, and the lines connecting them. 
The y coordinates are put in the correct place by subtracting the greatest y. 