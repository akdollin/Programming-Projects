//***************************************
// This is the ReadMe file for the recursive binary search.
//Akiva Dollin-acd2164
//****************************************
This program utilizes a recursive binary search to look through a file and determine is a specific value exists. 

This program begins by importing a file called array.txt.
Using a scanner, it looks through the file and determines the size of the needed array.

It then creates an array using the size of the file, and fills it with the input from the file. 

The program then scans in a desired target from the user. The program takes this value and uses it in an argument,
along with the array size, for the binary search method call. 

The binary search defines the midpoint. It then utilizes a normal binary search. 
However, it becomes recursive because instead of using a loop, after each if statement, the program recalls the method from the beginning. 
		