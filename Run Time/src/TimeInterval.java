//***************************************
// This is the time interval class for the run time
//problem.
//This class defines the methods for timing the run time for an operation.
//This class is from courseWorks. 
//Akiva Dollin-acd2164
//****************************************
public class TimeInterval 
{
		//instance variables. 
	   private long startTime, endTime;
	   private long elapsedTime; // Time Interval in milliseconds

	   //To begin timing. Uses method from Java API
	   public void startTiming() {
	      elapsedTime = 0;
	      startTime = System.currentTimeMillis();
	   }

	   //To end timing. Uses method from Java API
	   public void endTiming() {
	      endTime = System.currentTimeMillis();
	      elapsedTime = endTime - startTime;
	   }

	   //return complete elapsedTime
	   public double getElapsedTime() {
	     return (double) elapsedTime / 1000.0;
	   }
	}