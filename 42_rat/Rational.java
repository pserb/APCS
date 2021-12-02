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
      int a = this.numerator;
      int b = this.denominator;

       while (a != b) {
        if (a > b) {
          a -= b;
        } else {
          b -= a;
        }
      }
      return a;
    }

    public void reduce() {
      int factor = this.gcd();

      this.numerator /= factor;
      this.denominator /= factor;
    }

    public int compareTo(Rational r) {
      Rational simple = this;
      simple.reduce();
      r.reduce();
      // try to do it this way, somehow Rational being called on is changing
      // simple.subtract(r);
      // return simple.numerator;

      // this method works
      if ((simple.numerator == r.numerator) && (simple.denominator == r.denominator)) {
        return 0;
      } else if (simple.floatValue() > r.floatValue()) {
        return 1;
      } else {
        return -1;
      }
    }


    public static void main(String[] args) {
      Rational r = new Rational(2,3); //Stores the rational number 2/3
      Rational s = new Rational(1,2); //Stores the rational number 1/2
      Rational t = new Rational(4,18); //Stores the rational number 4/18
      System.out.println(r + " + " + s);
      r.add(s);  //Adds r to s, changes r to 7/6.  s remains 1/2
      System.out.println("r: " + r); //prints r
      r.subtract(s); //subtracts s from r, changes r to 8/12 (same as 2/3)
      System.out.println("r minus s: " + r);
      r.reduce();
      System.out.println("r simplified: " + r);

      // t is 4/18
      System.out.println("\nGCD of t: " + t.gcd()); // should be 2

      System.out.println("t: " + t);
      t.reduce();
      System.out.println("t simplified: " + t);
      //t.reduce(); //Changes t to 2/9

      Rational big = new Rational(1,2);
      Rational small = new Rational(1,3);

      System.out.println("\nComparing 1/2 to 1/3: " + big.compareTo(small)); // should print 1
      System.out.println("BIG N SMALL " + big + " " + small);
      System.out.println("\nComparing 1/3 to 1/2: " + small.compareTo(big)); // should print -1


      Rational same1 = new Rational(3,4);
      Rational same2 = new Rational(3,4);

      System.out.println("\nComparing 3/4 to 3/4: " + same1.compareTo(same2)); // should print 0


      Rational first = new Rational(1,3);
      Rational second = new Rational(1,2);

      System.out.println(first + " " + second);
      first.subtract(second);
      System.out.println(first + " " + second);
      // System.out.println(first.add(second));
    }
  }
