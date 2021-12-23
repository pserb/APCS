/*
TNPG: Pserb & Co (Andrew Piatesky, Paul Serbanescu, Joseph Othman) and Burnt Peanut
APCS
HW49 - Be More Rational
2021-12-22
time spent: 15min
*/

public class Driver {
  public static void main(String[] args) {
    Rational jhonny = new Rational(2,3);
    Rational j2nny = new Rational(2,3);
    Rational jeff = new Rational(4,5);
    String omg = new String("omg");

    System.out.println("Testing our .compareTo(Object) method...");
    System.out.println(jhonny.compareTo(j2nny)); // print 0
    System.out.println(jhonny.compareTo(jeff)); // print -1
    System.out.println("\nComparing Rational to non-Rational Comparable...");
    System.out.println(jhonny.compareTo(omg)); // print omg u cray, -1;

    System.out.println("\nTesting our .equals(Object) method...");
    System.out.println(jhonny.equals(j2nny)); // print true
    System.out.println(j2nny.equals(jeff)); // print false
    System.out.println("\nRational equals non-Rational Comparable...");
    System.out.println(jeff.equals(omg)); // print omg u cray, false;
  }
}
