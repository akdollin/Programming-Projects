//***************************************
// This is the main class for the 
//rectangle problem
//This class contains the findMax method.
//This class returns all the rectangles and 
//the largest area and perimeter.
//Akiva Dollin-acd2164
//****************************************
import java.util.Comparator;

public class Problem1 {
	public static void main(String[] args) {
		
	//creates a new array of type Rectangle with 10 indices   
	Rectangle[] RectangleArray = new Rectangle[10];    

	//for loop that fills array with Rectangle objects
	for (int i = 0; i < 10; i++) {
		RectangleArray[i] = new Rectangle(i + 5, i + 10);
	}

	//enhanced loop that prints all the rectangles
	for (Rectangle r : RectangleArray) {
		System.out.println("Rectangle = " + r.getWidth() + ","
				+ r.getLength());
	}
	
	//compare and print largest area
	Rectangle bigRectangleArea = findMax(RectangleArray, new areaCompare());
	System.out.println("The Largest Area:" + bigRectangleArea.getWidth()
			+ "," + bigRectangleArea.getLength());

	//compare and print largest perimeter
	Rectangle bigRectanglePerimeter = findMax(RectangleArray,
			new perimeterCompare());
	System.out.println("The Largest Perimeter:"
			+ bigRectanglePerimeter.getWidth() + ","
			+ bigRectanglePerimeter.getLength());
}


public static <AnyType>   //findMax() to compare the rectangles

	AnyType findMax(AnyType[] arr, Comparator<? super AnyType> cmp) {
		int maxIndex = 0;

		for (int i = 1; i < arr.length; i++)
			if (cmp.compare(arr[i], arr[maxIndex]) > 0)
				maxIndex = i;
		return arr[maxIndex];
	}

}
