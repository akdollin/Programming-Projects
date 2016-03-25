//***************************************
// This is the perimeter comparator class for the 
//rectangle problem.
//This class contains the findPerimeter().
//This class contains the compare() for comparing perimeters.
//Akiva Dollin-acd2164
//****************************************
import java.util.Comparator;
public class perimeterCompare implements Comparator<Rectangle>
{
	//defines the perimeter as Width*2+Length*2
	public int getPerimeter(Rectangle r) //Takes a rectangle as an object
	{
		int perimeter = r.getWidth()*2 + r.getLength()*2;
		return perimeter;
	}

	//compare() to find the larger perimeter between two rectangle objects
	public int compare(Rectangle r1, Rectangle r2)
	{
		if (getPerimeter(r1) > getPerimeter(r2))
			return 1;
		else if (getPerimeter(r1) < getPerimeter(r2))
			return -1;
		else
			return 0;
	}

}