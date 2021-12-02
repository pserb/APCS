/*
TNPG: Pseb & Co (Andrew Piatesky, Paul Serbanescu, Joseph Othman) and Burnt Peanut
APCS
HW41 - Be Rational/Getting more comfortable with classes/created a class that can express rational numbers through the use of instance variables.
2021-12-1
time spent: 25min

DISCOVERIES:
A rational number is actually a number that can be expressed by a ratio
this() has to go in the first line of a overloaded constructor, never encountered that before

QUESTION:

*/

public class Rational {

    // INSTANCE VARIABLES
    private int numerator, denominator;

    public Rational() {
      numerator = 0;
      denominator = 1;
    }

    public Rational(int p, int q) {
      this();
      if (q != 0) {
        numerator = p;
        denominator = q;
      }
      else {
        System.out.println("denominator cannot be 0");
      }
    }

    public String toString() {
      return numerator + "/" + denominator;
    }

    public double floatValue() {
      return (double)numerator / denominator;
    }

    public void multiply(Rational r) {
        this.numerator *= r.numerator;
        this.denominator *= r.denominator;
    }

    public void divide(Rational r) {
      if (r.numerator != 0) {
        this.numerator *= r.denominator;
        this.denominator *= r.numerator;
      } else {
        System.out.println("Cannot divide by 0");
      }
    }

    public void add(Rational r) {
      this.numerator = (this.numerator * r.denominator) + (r.numerator * this.denominator);
      this.denominator *= r.denominator;
    }

    public void subtract(Rational r) {
      this.numerator = (this.numerator * r.denominator) - (r.numerator * this.denominator);
      this.denominator *= r.denominator;
    }

    public int gcd() {
      while (this.numerator != this.denominator) {
        if (this.numerator > this.denominator) {
          
        }
      }
    }

    // GCDEW copied from HW26.
    // public static int gcdEW(int a, int b) {
    //   while (a != b) {
    //     if (a > b) {
    //       a -= b;
    //     } else {
    //       b -= a;
    //     }
    //   }
    //   return a;
    // }


    public static void main(String[] args) {
      // Rational r = new Rational();
      // Rational p = new Rational(5,3);
      // Rational q = new Rational(1,3);
      //
      // System.out.println(r);
      // System.out.println(p);
      //
      // System.out.println(r.floatValue());
      // System.out.println(p.floatValue());
      //
      // System.out.println("\n" + q + " * " + p);
      // q.multiply(p);
      // System.out.println(q);
      // System.out.println(p);
      //
      // System.out.println("\n" + q + " / " + p);
      // q.divide(p);
      // System.out.println(q);
      // System.out.println(p);
      Rational r = new Rational(2,3); //Stores the rational number 2/3
      Rational s = new Rational(1,2); //Stores the rational number 1/2
      Rational t = new Rational(4,18); //Stores the rational number 4/18
      System.out.println(r + " + " + s);
      r.add(s);  //Adds r to s, changes r to 7/6.  s remains 1/2
      System.out.println(r); //prints r
      r.subtract(s); //subtracts s from r, changes r to 8/12 (same as 2/3)
      System.out.println(r);
      //t.reduce(); //Changes t to 2/9
    }
  }
