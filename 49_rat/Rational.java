/*
TNPG: Pseb & Co (Andrew Piatesky, Paul Serbanescu, Joseph Othman) and Burnt Peanut
APCS
HW42 - Be More Rational
2021-12-6
time spent: 25min

DISCOVERIES:
A rational number is actually a number that can be expressed by a ratio of integers.
this() has to go in the first line of a overloaded constructor, never encountered that before.

QUESTIONS:
How might we use the compareTo method to generate equivalent representations of the same rational number?
Can we generate a 2D-array of length N to generate all rationals with numerator, denominator at most N? Making N large would allow us
to generate many rationals without needing many instances of class Rational.
*/

public class Rational implements Comparable {

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

    public int compareToHelper(Rational r) {
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

    public int compareTo(Object x) {
      if (x instanceof Rational) {
        return compareToHelper((Rational) x);
      } else {
        System.out.println("you cray, that not a rational!");
        return -1;
      }
    }

    public boolean equals(Object other) {
      if (other instanceof Rational) {
        if (compareToHelper((Rational) other) == 0) {
          return true;
        } else {
          return false;
        }
      } else {
        System.out.println("you cray, that not a rational!");
        return false;
      }
    }

  }
