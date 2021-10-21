/**
   Scrooge Playducks - Paul Serbanescu, Yuki Feng, Jaylen Zeng
   APCS
   HW21 - STAtisTically Speaking
   2021-10-20
   DISCO:
   Math.round() can somewhat do what typecasting can do, but in a different way.
   There are two possible params for Math.round(), a double and a float.
   Math.round(double) returns a long. Longs cannot be casted to ints automatically. (doubles and long are the same bit length)
   But, if you input that long back into Math.round(), java interprets and casts the long to a float, and so
   Math.round(float) returns an int (floats and ints are the same bit length)

   This is different than casting because if a double 4.86765 was casted to an int, it would return 4, but this method of
   Rounding returns 5.

   For this assignment and what we are doing, it makes more sense for the value to be rounded to the nearest int (to get the most accurate value)

   QCC:
   Is there a different method of changing datatypes without typecasting?
   I heard that using binary is possible, but is it a "better" way, what are the pros/cons?
   
   TASK:
   Implement each method without typecasting.
 **/

public class StatsDriver {

    //main method for testing functionality
    public static void main(String[] args ) {
        System.out.println(Stats.mean(2,2));
        System.out.println(Stats.mean(4.5,1.5));
  
        System.out.println("------");
  
        System.out.println(Stats.max(5,20));
        System.out.println(Stats.max(5,5));
        System.out.println(Stats.max(1.5,1.5));
        System.out.println(Stats.max(1.5,21.5));
  
        System.out.println("------");
  
        System.out.println(Stats.max(1,2,3));
        System.out.println(Stats.max(3,2,1));
        System.out.println(Stats.max(1,3,2));
        System.out.println(Stats.max(1,1,2));
        System.out.println(Stats.max(2,2,2));
        System.out.println(Stats.max(1,2,2));
        
        System.out.println(Stats.max(1.5,3.0,2.2));
        System.out.println(Stats.max(2.0,1.0,1.0));
        
  
        System.out.println("------");
  
        System.out.println(Stats.geoMean(10,20));
        System.out.println(Stats.geoMean(10,10));
        System.out.println(Stats.geoMean(0,10));
        
        System.out.println("------");
  
        System.out.println(Stats.geoMean(10.0,20.0));
        System.out.println(Stats.geoMean(10.0,10.0));
        System.out.println(Stats.geoMean(0.0,10.0));
  
        System.out.println("------");
        
        System.out.println(Stats.geoMean(10, 10, 10));
  
        System.out.println("------");
  
        System.out.println(Stats.geoMean(10.0, 10.0, 10.0));
  
      }
}