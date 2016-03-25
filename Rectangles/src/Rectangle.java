//***************************************
// This is the rectangle class for the 
//rectangle problem.
//This class contains the getWidth and getLength methods.
//Akiva Dollin-acd2164
//****************************************
public class Rectangle {
	private int length;
	private int width;
	
	//Constructor initializes instances variable
	//defines a rectangle as having a width and a length
	public Rectangle(int w, int l) {
		this.width = w;
		this.length = l;
	}
	
	public int getLength() //accessor method for length
	{
		return length;
	}
	
	public int getWidth() //accessor method for width
	{
		return width; 
	}

}
