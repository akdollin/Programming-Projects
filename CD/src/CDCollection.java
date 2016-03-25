//********************************************************************
//  CDCollection.java       Author: Lewis/Loftus (modified by cannon)
//
//  Represents a collection of compact discs.
//********************************************************************

import java.text.NumberFormat;
import java.util.Locale;
//import java.util.Arrays;
public class CDCollection
{
   private CD[] collection;
   private int count;
   private double totalCost;

   public CDCollection ()
   {
      collection = new CD[100];
      count = 0;
      totalCost = 0.0;
   }

  
   public void addCD (String title, String artist, double cost,
                      int tracks)
   {
      if (count == collection.length)
         increaseSize();

      collection[count] = new CD (title, artist, cost, tracks);
        totalCost += cost;
      count++;
   }

 
   public String toSttring()
   {
      NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);

      String report = "~~~~~~~~~~~~~~Wow Cool~~~~~~~~~~~~~~~~~~~~~~~\n";
      report += "My CD Collection\n\n";

      report += "Number of CDs: " + count + "\n";
      report += "Total cost: " + fmt.format(totalCost) + "\n";
      report += "Average cost: " + fmt.format(totalCost/count);

      report += "\n\nCD List:\n\n";

      for (int cd = 0; cd < count; cd++)
         report += collection[cd].toString() + "\n";

      return report;
   }


   private void increaseSize ()
   {
      CD[] temp = new CD[collection.length + 100];

      for (int cd = 0; cd < collection.length; cd++)
	temp[cd] = collection[cd];
      
      collection = temp;
   }


}