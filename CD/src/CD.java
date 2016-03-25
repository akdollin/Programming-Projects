//********************************************************************
//  CD.java       Author: Lewis/Loftus   (modified by cannon)
//
//  Represents a compact disc.
//********************************************************************

import java.text.NumberFormat;
import java.util.Locale;

public class CD
{
   private String title, artist;
   private double cost;
   private int tracks;

   public CD (String name, String singer, double price, int numTracks)
   {
      title = name;
      artist = singer;
      cost = price;
      tracks = numTracks;
   }


   public String toString()
   {
      NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);

      String description;

      description = fmt.format(cost) + "\t" + tracks + "\t";
      description += title + "\t" + artist;

      return description;
   }

}