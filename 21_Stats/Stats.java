/**
   Scrooge Playducks - Paul Serbanescu, Yuki Feng, Jaylen Zeng
   APCS
   HW21 - STAtisTically Speaking
   2021-10-20
   DISCO:

   QCC:
   
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
      return Math.round(Math.pow((a * b), 0.5));
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
      return Math.round(Math.pow((a * b * c), (0.333333333)));
    }
  
  }//end class