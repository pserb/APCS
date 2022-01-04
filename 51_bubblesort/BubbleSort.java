// PSerb & Co. Paul Serbanescu, Andrew Piatetsky, Joseph Othman
// APCS pd7
// HW51 -- implementing bubblesort
// 2022-01-04t
// time spent: 0.6 hrs

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 *
 * ALGO:
 - Starting from the final 2 elements in the given ArrayList and traversing downwards
 (to the left), compare each pair of adjacent elements. Swap 2 adjacent elements if
 the element on the left is larger than the element on the right.
 - Then, repeat this, decreasing the number of "checked" pairs by 1. (Starting from
 the rightmost pair, compare each pair of consecutive elements traversing downwards,
 except for the final pair on the left.)
 - Continue to decrease the number of pairs checked by 1 until this becomes 0.
 }
 *
 * DISCO
 - Using this bubbleSort, given an ArrayList of n elements, we can sort the ArrayList
 in at most (n)(n-1)/2 checks of adjacent elements (you can subtract 1 to account for
 knowing that the last element is in its desired location by the process of elimination,
 but we disregard this, since as n gets large, this extra check becomes negligible).
 -
 *
 * QCC
 * q0: If a pass requires no swaps, what do you know?
 * a0: The ArrayList is already sorted.
 * q1: After pass p, what do you know?
 * a1: The first p elements in the ArrayList are sorted.
 * q2: How many passes are necessary to completely sort?
 * a2: For an ArrayList of size n, we need n-1 passes to completely sort the ArrayList.
 *
 ******************************/

import java.util.ArrayList;

public class BubbleSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond:  lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al )
  {
    int randomIndex;
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
    for (int i = 0; i < data.size(); i++) {
      for (int j = data.size()-1; j > i; j--) {
        Comparable p1 = data.get(j);
        Comparable p2 = data.get(j-1);

        if (p1.compareTo(p2) < 0) {
          data.set(j, p2);
          data.set(j-1, p1);
        }
      }
    }
  }


  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
    ArrayList<Comparable> output = input;
    bubbleSortV(output);
    return output;
  }


  public static void main( String [] args )
  {

    /*===============for VOID methods=============
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      bubbleSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      ============================================*/

    /*==========for AL-returning methods==========*/
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = bubbleSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n"
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = bubbleSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n"
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      System.out.println( coco );
      /*============================================*/

  }//end main

}//end class BubbleSort
