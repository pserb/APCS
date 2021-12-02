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
      return ( numerator + "/" + denominator);
    }
  
    public double floatValue() {
      return (numerator * 1.0)/ denominator;
    }
  
    public void multiply(Rational r) {
        numerator *= r.numerator;
        denominator *= r.denominator;
    }
  
    public void divide(Rational r) {
        numerator *= r.denominator;
        denominator *= r.numerator;
    }
  
    public static void main(String[] args) {
      Rational r = new Rational();
      Rational p = new Rational(5,3);
      Rational q = new Rational(1,3);
  
      System.out.println(r);
      System.out.println(p);
  
      System.out.println(r.floatValue());
      System.out.println(p.floatValue());
  
      System.out.println("\n" + q + " * " + p);
      q.multiply(p);
      System.out.println(q);
      System.out.println(p);
  
      System.out.println("\n" + q + " / " + p);
      q.divide(p);
      System.out.println(q);
      System.out.println(p);
    }
  }