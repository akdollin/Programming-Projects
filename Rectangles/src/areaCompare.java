//***************************************
// This is the area comparator class for the 
//rectangle problem.
//This class contains the findArea().
//This class contains the compare() for comparing areas.
//Akiva Dollin-acd2164
//****************************************
import java.util.Comparator;
public class areaCompare implements Comparator<Rectangle>
{
	//defines the area as Width*Length
	public int getArea(Rectangle r) //Takes a rectangle as an object
	{
		int area = r.getWidth()*r.getLength();
		return area;
	}
		
	//compare() to find the larger area between two rectangle objects	
	public int compare(Rectangle r1, Rectangle r2)
	{
		if (getArea(r1) > getArea(r2))
				return 1;
		else if (getArea(r1) < getArea(r2))
			return -1;
		else
			return 0;
	    }
	}
