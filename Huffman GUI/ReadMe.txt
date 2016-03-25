//***************************************
// This is the ReadMe file for the Huffman program.
//Akiva Dollin-acd2164
//****************************************

This was a tough program. 

This program has 6 classes. 
Huffman Code: 0=left, 1=right 

To Run:
Simply compile and run with a file name to test as command line args. The rest will just pop up. 
UnderflowException:
This is the generic underflow exception class from Weiss. 

Node:
This class defines our Huffman nodes as having a character, a frequency, and a left and right. This class also has the Node compareTo()
which compares based on the frequency. 

BinaryHeap:
This is the Weiss BinaryHeap class; 

HuffmanCode:
This is the class that builds the tree. It takes in a file, and scans it in line by line. 
Each line is counted by its frequency, and is created as a Node, and put into the heap. These nodes are compared together by the 
makeTree() and combines trees recursively until we are left we only the root Node. The makeTree() 
follows the idea of taking the two smallest frequencies, combining them, and then reinserting them into the heap. 
We then print to the console all the frequencies 
and all the Huffman encoding based on the original file. The decode method is done recursivley and 
the encode method is done by iterating through the codes array, while iterating through the final Huffman string.To get the Huffman code,
we traverse the tree, and every time we move down left we add a 0, and every time we move right, we add a 1.  

Program Tester:
This is the main class. It has two parts, the main method and the GUI methods. The main is a simple try catch that takes in 
a file and calls the HuffmanCode class to create a tree internally.The instance of the HuffmanCode is declared outside 
so that it can be accessed throughout the GUI methods. It then calls the GUI methods. The constructor is ProgramTester. 
The GUI creates a frame with one panel. The panel has a textfield and three buttons. The buttons correspond to the HuffmanCode methods.
The text field is initialized with the final Huffman string. Reset, resets the text field to that string. New line characters during a
decode are printed as spaces. You cannot encode a new line character, but you can encode a space. 

Tree Panel: DOES NOT WORK 

The next thing the program should have done was create a  second panel with a graphic. This panel would have graphic which calls the 
Tree Panel class. This class would have defined the ovals and the line positions. This graphic would take in the root of the tree
and traverse the tree. Every time it moved left, it would draw a line from the location it started at (the center top initially), to a
location proportionally more left ever time. It would then paint a circle, fill it with a text field that prints the corresponding character,
and the encoding for that node. The same thing would be done for right. This would paint the tree from the top down. A scroll pane would also be 
added to account for trees that are larger than the window can handle. The size of the panel would be initialized by the height of the tree, through a method
in the BinaryHeap class. 

The algorithm for this is shown here: 

function drawTree(int[] tree, Graphics g, int start_x, int start_y, int end_x, int end_y)
    calculate even amounts for lines
    if right side is not null
        draw line from old coordinates to newly calculate right side coordinates
        run drawTree with new coordinates
    if left side is not null
        draw line from old coordinates to newly calculated left side coordinates
        run drawTree with new coordinates

recursion should die when no right or left side branches need to be drawn

This graphic would be displayed with a horizontal and a vertical scroll pane. 

	