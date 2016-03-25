//***************************************
// This is the readMe file for the run time problem.
//Akiva Dollin-acd2164
//****************************************

This is the Run Time tester from the book. This program has three classes. The timer class (TimeInterval)...
...is from P. Blaer and utilizes Java methods to time the run time of the given loops. 
The RunTimeTester begins by scanning in a value for n to be tested by each loop. The program the creates an instance of the class with the loops.
It then calls each individual method, using the nValue as the argument. 
The last line in this class prints a simple goodbye statement and is used to confirm the termination of the program. 

The RunTimeLoops class creates an instance of the timer class, and then has 6 methods, each containing a different loop.
These loops are from the book. Within each loop, the program begins timing at the very beginning of the loop, and stops timing at the very end.
Each one of these methods also prints the elapsedTime for the loop. 
What is important to note is that the loops with a lower order than n^2 have randomized sums. 
This is to spike up the timing, to allow it to be seen. The last two loops are normal. 

To run this program: Simply compile and run the RunTimeTester. Then input a value for n.
This program is used to show the relationship between different run times. Therefore, if the value of n is too great, it may take some time 
to complete the program. Once the goodbye line is printed, the program has completed. 

Various values and run times for n can be found in the written assignment. 