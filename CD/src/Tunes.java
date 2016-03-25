//********************************************************************
//  Tunes.java       Author: Lewis/Loftus (modified by cannon)
//
//  Demonstrates the use of an array of objects.
//********************************************************************

public class Tunes
{
  
   public static void main (String[] args)
   {

      CDCollection music = new CDCollection ();
      
      music.addCD ("Animals   ", "Pink Floyd", 15.0, 5);
      music.addCD ("Storm Front", "Billy Joel", 14.95, 10);
      music.addCD ("Come On Over", "Shania Twain", 1.95, 16);
      music.addCD ("Soundtrack", "Les Miserables", 17.95, 33);
      music.addCD ("Graceland", "Paul Simon", 13.90, 11);
      music.addCD ("Discipline", "King Crimson", 19.99, 26);
      music.addCD ("Greatest Hits", "Jimmy Buffet", 15.95, 13);
     
      System.out.println(music);

   }
}