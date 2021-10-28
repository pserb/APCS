/**
   Princess Peach - Paul Serbanescu, Yuki Feng, Jaylen Zeng, David Deng
   APCS
   HW21 - GCD Three Ways
   2021-27-20

   DISCO:
   the brute force method while it is the easiest to think of and write, it is much more inneficient and less clean than the while or, best of all recursive methods
   
   QCC:
   N/A

   ALGO:
   Brute force:
   init counter, var to store smallest num, gcd ans
   if (a > b), a = smallest, otherwise b = smallest
   while (counter < smallest)
   counter++
   if a mod counter and b mod counter == 0, gcd = counter, return gcd

   Recursive:
   if (a == b) return a (or b)
   otherwise, if a > b, return gcdER(a-b, b), otherwise return gcdER(a, b-a)

   Iterative:
   while a != b, if a > b, a -= b, otherwise b -= a
   return a
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

    // === New Methods === //
    public static int gcd(int a, int b) {
      int counter = 0;
      int gcd = 0;
      int smallest = 0;

      if (a > b) {
        smallest = b;
      } smallest = a;

      while (counter < smallest) {
        counter++;
        if (a % counter == 0 && b % counter == 0) {
          gcd = counter;
        }
      }
      return gcd;
    }

    public static int gcdER(int a, int b) {
      if (a == b) {
        return a;
      } else {
        if (a > b) {
          return gcdER(a-b, b);
        } return gcdER(a, b-a);
      }
    }

    public static int gcdEW(int a, int b) {
      while (a != b) {
        if (a > b) {
          a -= b;
        } else {
          b -= a;
        }
      }
      return a;
    }

    public static void main(String[] args) {
      // Test Brute Force GCD
      System.out.println("== Brute Force ==");
      System.out.println("GCD of 2, 4 is: " + gcd(2, 4));
      System.out.println("GCD of 9, 15 is: " + gcd(9, 15));
      System.out.println("GCD of 56, 12 is: " + gcd(56, 12));

      // Test Recursive GCD
      System.out.println("\n== Recursive ==");
      System.out.println("GCD of 2, 4 is: " + gcdER(2, 4));
      System.out.println("GCD of 9, 15 is: " + gcdER(9, 15));
      System.out.println("GCD of 56, 12 is: " + gcdER(56, 12));

      // Test Iterative GCD
      System.out.println("\n== Iterative ==");
      System.out.println("GCD of 2, 4 is: " + gcdEW(2, 4));
      System.out.println("GCD of 9, 15 is: " + gcdEW(9, 15));
      System.out.println("GCD of 56, 12 is: " + gcdEW(56, 12));
    }//end main
  
  }//end class