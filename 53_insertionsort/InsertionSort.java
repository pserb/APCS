// Team NA_ME: Max Schneider, Paul Serbanescu, Orion Roven
// APCS pd7
// HW53 -- implementing insertion sort
// 2022-01-06r
// time spent: .1 hrs

/******************************
 * class InsertionSort -- implements InsertionSort algorithm
 *
 * ALGO:
  * Swap first two if appropriate
  * Add in another element at the appropriate place.
  * Stop after all elements are added
 * DISCO
   * Non-void was already done
   * Organized methods are good partition needs to stop before reaching the full size
 * QCC
 * q0: How many passes to sort n elements?
 * a0: n
 * q1: What do you know after pass p?
 * a1: the first p elements are sorted, but not necessarily in the final spot
 * q2: How will you know when sorted?
 * a2: You have made n passes
 * q3: What constitues a pass?
 * a3: A new element is correctly sorted in the sorted range
 * q4: What must you track?
 * a4: The unsorted and sorted ranges
 ******************************/


import java.util.ArrayList;

public class InsertionSort
{
  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
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
  public static void shuffle( ArrayList al ) {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of InsertionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void insertionSortV( ArrayList<Comparable> data )
  {
    for(int partition = 1; partition < data.size(); partition++) {
      //partition marks first item in unsorted region

      System.out.println( "\npartition: " + partition + "\tdataset:"); //diag
      System.out.println( data );

      //traverse sorted region from right to left
      for(int i = partition; i > 0; i--) {

        // "walk" the current item to where it belongs
        // by swapping adjacent items
        if ( data.get(i).compareTo(data.get(i-1)) < 0) {

          System.out.println( "swap indices "+(i-1)+" & "+i+"..." ); //diag
          Comparable dummy = data.get(i);
          data.set(i,data.get(i-1));
          data.set(i-1,dummy);
        }
        else
          break;
      }
    }
  }//end insertionSortV


  // ArrayList-returning insertionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable>
    insertionSort( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input )
      data.add( o );

    //sort working ArrayList
    insertionSortV( data );

    //return working ArrayList
    return data;
  }//end insertionSort
  
  
  public static void main( String [] args )
  {
    /*===============for VOID methods=============
    System.out.println("\n*** Testing sort-in-place (void) version... *** ");
    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "\nArrayList glen before sorting:\n" + glen );
    insertionSortV(glen);
    System.out.println( "\nArrayList glen after sorting:\n" + glen );
    
    ArrayList coco = populate( 10, 1, 1000 );
    System.out.println( "\nArrayList coco before sorting:\n" + coco );
    insertionSortV(coco);
    System.out.println( "\nArrayList coco after sorting:\n" + coco );
      ============================================*/

      System.out.println( "*** Testing non-void version... *** " );
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "\nArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = insertionSort( glen );
      System.out.println( "\nsorted version of ArrayList glen:\n"
      + glenSorted );
      System.out.println( "\nArrayList glen after sorting:\n" + glen );
      
      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = insertionSort( coco );
      System.out.println( "\nsorted version of ArrayList coco:\n"
      + cocoSorted );
      System.out.println( "\nArrayList coco after sorting:\n" + coco );
      System.out.println( coco );
      /*==========for AL-returning methods==========
      ============================================*/
      
    }//end main
    
  }//end class InsertionSort
