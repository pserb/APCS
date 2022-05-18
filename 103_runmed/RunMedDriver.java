// JIMIN :: Ryan Lau, Melody Lew, Paul Serbanescu
// APCS pd6
// HW103 -- Erica's Friends, Hugo, and The One in the Middle
// 2022-05-18h
// time spent: 0.5 hrs

/**
 * DISCO:
 * you have to import NoSuchElementException from java.util
 * heaps r so epic & fast & efficient!
 * plagarizim is great (we should do more of this)
 * Remove the print statements in the driver to actually parse through the entirety of input.nums
 * 
 * QCC:
 * how can we find the running average efficiently
 * 
 * ALGO:
 *  1. if next value < root of maxheap, add to maxheap. else, add to minheap
 *
 *  2. balance heaps if the abs value of the difference of their size is > 1
 *    (remove from larger heap, add to smaller until balanced)
 *
 *  3. at any time, find med by
 *    a) heap sizes equal: med is mean of roots
 *    b) heap sizes !equal: med is root of larger heap
 */

/**
   driver file for testing class RunMed

   (RunMed provides for calculating a running median
   of a stream of input ints)

   USAGE: Runnable as-is.
   Uncomment RunMed-specific lines below once RunMed is implemented.
   Compile, run fr same dir as RunMed.java

   to feed numbers manually:
   $ java RunMed

   to feed in prepared set:
   $ java RunMed < input.nums
   (input.nums provided; must be in same dir)

   -------------------------
   Clyde "Thluffy" Sinclair
   APCS
   2018-05-17
*/

import java.util.Scanner;

public class RunMedDriver
{
  public static void main( String[] args )
  {

    RunMed r = new RunMed();

    int n;
    double median;
    int count = 0;
    Scanner sc = new Scanner( System.in );

    while( sc.hasNextInt() ) {
      try {
        n = sc.nextInt();
        // System.out.print("read " + n + "\n");

        count++;
        // System.out.print("this many ints have been seen: " + count + "\n");

        r.add(n);
        median = r.getMedian();
        // System.out.print("median is now " + median + "\n");
      } catch (Exception e) {
        System.err.println("BOOP! probs w yer input:\n"+e);
      }
    }

    System.out.println("median is: " + r.getMedian());

  }//end main

}//end class
