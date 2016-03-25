//***************************************
// This is the RunTimeLoops class for the run time
//problem.
//This class creates an instance of the timer class.
//This class copies each loop from the book and times each one.
//Each method then prints the elapsedTme. 
//Akiva Dollin-acd2164
//****************************************
import java.util.Random;
public class RunTimeLoops {
	//create instance if timer class
	TimeInterval t = new TimeInterval();
	
	public RunTimeLoops() {
		}
	
	//Loop from book. Times and prints elapsed. 
	public void b1(int n){
		int i;
		t.startTiming();
		int sum=0;
		for(i=0; i<n; i++)
			sum+= (int)(Math.random()*5+1); 
		t.endTiming();
		System.out.println("B1:" + t.getElapsedTime());
	}
	//Loop from book. Times and prints elapsed. 
	public void b2(int n){
		int i;
		int j;
		t.startTiming();
		int sum=0;
		for(i=0; i<n; i++)
			for(j=0; j<n; j++)
				sum+= (int)(Math.random()*5+1);  
		t.endTiming();
		System.out.println("B2:" + t.getElapsedTime());
	}
	//Loop from book. Times and prints elapsed. 
	public void b3(int n){
		int i;
		int j;
		t.startTiming();
		int sum=0;
		for (i=0; i<n; i++)
			for(j=0; j<n*n;j++)
				sum++;  
		t.endTiming();
		System.out.println("B3:" + t.getElapsedTime());
	}
	//Loop from book. Times and prints elapsed. 
	public void b4(int n){
		int i;
		int j;
		t.startTiming();
		int sum=0;
		for (i=0; i<n; i++)
			for(j=0; j<i;j++)
				sum+= (int)(Math.random()*5+1);  
		t.endTiming();
		System.out.println("B4:" + t.getElapsedTime());
	}
	//Loop from book. Times and prints elapsed. 
	public void b5(int n){
		int i;
		int j;
		int k;
		t.startTiming();
		int sum=0;
		for (i=0; i<n; i++)
			for(j=0; j<i*i;j++)
				for(k=0; k<j; k++)
					sum++;  
		
		t.endTiming();
		System.out.println("B5:" + t.getElapsedTime());
	}
	//Loop from book. Times and prints elapsed. 
	public void b6(int n){
		int i;
		int j;
		int k;
		t.startTiming();
		int sum=0;
		for (i=1; i<n; i++)
			for(j=1; j<i*i;j++)
				if( j%i==0)
					for(k=0; k<j; k++)
						sum++; 
		t.endTiming();
		System.out.println("B6:" + t.getElapsedTime());
	}
}