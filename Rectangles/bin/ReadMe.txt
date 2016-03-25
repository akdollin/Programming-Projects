//***************************************
// This is the ReadMe for the 
//rectangle problem.
//Akiva Dollin-acd2164
//****************************************

This program has four classes.

The main class --> Problem1 begins the program. 
It initializes an array of type Rectangle with a size of 10.
It then fills the array using a for loop with rectangle objects (See Rectangle Class).
An enhanced for loop prints out each rectangle in the array to make it easy to check the programs success. 
It then calls the findMax() which compares the rectangles and finds the largest area. 
It then saves this largest rectangle to a new Rectangle and prints it.
The same is then done for the largest perimeter.
The main class also includes the generic findMax() found in the text book.

The perimeterCompare class and the areaCompare class are nearly identical in structure.
They both implement comparator with a type Rectangle.
Within their respective Constructors they define Area as w*l and Perimeter as 2w+2l.
They both also have a compare() which is used to compare the Area or the Perimeter of two Rectangles 
and determine which is larger. 

The Rectangle class defines a Rectangle object as having a width and a length.
It also has two methods that return the width and the length. 

To run this program: As it exists now, the program will fill an array with 10 rectangles and tell you which rectangle 
has the largest area and perimeter. 
However, the rectangles are created in a simple incrementing for loop, so the rectangles will be the same every time you 
run the program. To test for other values, have the for loop create less Rectangles and plug in your own Rectangles for the missing indices.

for (int i = 0; i < 9; i++) 
{
		RectangleArray[i] = new Rectangle(i + 5, i + 10);
}
RectangleArray[9] = new Rectangle(5,20);
RectangleArray[10] = new Rectangle(2,100);

Akiva Dollin
acd2164
