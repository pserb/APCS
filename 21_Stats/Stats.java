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

public class Stats {

    public static int mean(int a, int b) {
      return (a + b) / 2;
    }
  
    public static double mean(double a, double b) {
      return (a + b) / 2.0;
    }
  
    public static int max(int a, int b) {
      if (a >= b) {
        return a;
      } return b;
    }
  
    public static double max(double a, double b) {
      if (a >= b) {
        return a;
      }return b; 
    }

    public static int geoMean(int a, int b) {
      return Math.round(Math.round(Math.pow((a * b), 0.5)));
    }
  
    public static double geoMean(double a, double b) {
      return Math.pow((a * b), 0.5);
    }

    public static int max(int a, int b, int c) {
      if ((a >= b) && (a >= c)) {
        return a;
      } else if (b >= c) {
          return b;
       }return c;
      }          

    public static double max(double a, double b, double c) {
      if ((a >= b) && (a >= c)) {
        return a;
      } else if (b >= c) {
          return b;
       }return c;
      }          
  
  
    public static int geoMean(int a, int b, int c) {
      return Math.round(Math.round(Math.pow((a * b * c), (0.333333333))));
    }
  
    public static double geoMean(double a, double b, double c) {
      return Math.pow((a * b * c), (0.333333333));
    }
  
  }//end class