// PSerb & Co. Paul Serbanescu, Andrew Piatetsky, Joseph Othman
// APCS pd7
// HW48 -- Binary Search
// 2021-12-16
// time spent: 0.4 hrs

/***
DISCO:
- Binary search is a much more efficient algorithm for searching whether or not an element is
in a given array, and returning its index.
- Binary search compares the target to the value at the "average" index of the current search
space, changing the bounds of the search space as necessary to limit the search.
- While linear search would require at most (hi-lo+1) steps to find an element, binary search
only requires the floor of log base 2 of the same expression, plus 1 steps in a worst case
scenario to find an element.
- The log comes from continuously dividing the search space by 2, instead of subtracting 1.
Dividing by 2 is the "best" because you will always have 2 search spaces that sum to a "whole"
serach space (whatever the search space size was at the start of this guess), so the 2 new search
spaces must sum to the whole. This implies that one of the search spaces is at least half the size
of the old search space, and binary search allows this "equality" to occur.

QCC:
- How do we rigorously compare to algorithms in terms of speed; how can we say an algo is truly
more efficient than another one?
- Is binary search the fastest searching algorithm? If so, how can it be shown that no others are
faster?

***/

/**
   class BinSearch
   Binary search on array of Comparables
**/

public class BinSearch
{

  /**
     int binSearch(Comparable[],Comparable) -- searches an array of
     Comparables for target Comparable
     pre:  input array is sorted in ascending order
     post: returns index of target, or returns -1 if target not found
  **/
  public static int binSearch ( Comparable[] a, Comparable target )
  {
    //uncomment exactly 1 of the 2 stmts below:

    // return binSearchIter( a, target, 0, a.length-1 );
    return binSearchRec( a, target, 0, a.length-1 );
  }


  public static int binSearchRec( Comparable[] a,
                                  Comparable target,
                                  int lo, int hi )
  {

    int tPos = -1; //init return var to flag value -1

    int m = (lo + hi) / 2; //init mid pos var

    // run until lo and hi cross
    // if they do, return tPos (-1)
    if (lo > hi) {
      return tPos;
    }

    // target found
    if (a[m].compareTo(target) == 0) {
      tPos = m;
    } 

    // value at mid index higher than target
    else if (a[m].compareTo(target) > 0) {
      hi = m - 1;
      return binSearchRec(a, target, lo, hi);
    }

    // value at mid index lower than target
    else if (a[m].compareTo(target) < 0) {
      lo = m + 1;
      return binSearchRec(a, target, lo, hi);
    }

    return tPos;
  }//end binSearchRec


  public static int binSearchIter( Comparable[] a,
                                   Comparable target,
                                   int lo, int hi )
  {

    int tPos = -1; //init return var to flag value -1
    int m = (lo + hi) / 2; //init mid pos var

    while(lo <= hi) { // run until lo & hi cross

      //update mid pos var
      m = (lo + hi) / 2;
      // target found
      if (a[m].compareTo(target) == 0) {
        tPos = m;
        break;
      }
      // value at mid index higher than target
      else if (a[m].compareTo(target) > 0) {
        hi = m - 1;
      }
      // value at mid index lower than target
      else if (a[m].compareTo(target) < 0) {
        lo = m + 1;
      }

    }
    return tPos;
  }//end binSearchIter



  //tell whether an array is sorted in ascending order
  private static boolean isSorted( Comparable[] arr )
  {

    boolean retBoo = true; //init to true, assume array is sorted

    //Q: Why would a FOREACH loop not suffice here?
    for( int i=0; i < arr.length-1; i++ ) {
      if ( ( arr[i].compareTo(arr[i+1]) > 0 ) ) {
        return false;
      }
    }
    return retBoo; //if entire array was traversed, it must be sorted
  }


  // utility/helper fxn to display contents of an array of Objects
  private static void printArray( Comparable[] arr ) {
    String output = "[ ";

    for( Comparable c : arr )
	    output += c + ", ";

    output = output.substring( 0, output.length()-2 ) + " ]";

    System.out.println( output );
  }



  //main method for testing
  //minimal -- augment as necessary
  public static void main ( String[] args )
  {

    /*----------------------------------------------------*/

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    System.out.println("\nNow testing binSearch on Comparable array...");

    //Declare and initialize array of Comparables
    Comparable[] iArr = { 2, 4, 6, 8, 6, 42 };
    printArray( iArr );
    System.out.println( "iArr1 sorted? -- " + isSorted(iArr) );

    Comparable[] iArr2 = { 2, 4, 6, 8, 13, 42 };
    printArray( iArr2 );
    System.out.println( "iArr2 sorted? -- " + isSorted(iArr2) );

    Comparable[] iArr3 = new Integer[10000];
    for( int i = 0; i < iArr3.length; i++ ) {
    iArr3[i] = i * 2;
    }

    //printArray( iArr3 );
    //System.out.println( "iArr3 sorted? -- " + isSorted(iArr3) );

    //search for 6 in array
    System.out.println( binSearch(iArr2,2) );
    System.out.println( binSearch(iArr2,4) );
    System.out.println( binSearch(iArr2,6) );
    System.out.println( binSearch(iArr2,8) );
    System.out.println( binSearch(iArr2,13) );
    System.out.println( binSearch(iArr2,42) ); 

    //search for 43 in array
    System.out.println( binSearch(iArr2,43) );

    System.out.println( "now testing binSearch on iArr3..." );
    System.out.println( binSearch(iArr3,4) );
    System.out.println( binSearch(iArr3,8) );
    System.out.println( binSearch(iArr3,5) );

    //search for 43 in array
    System.out.println( binSearch(iArr3,43) );
    /*====================================================*/


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  }//end main()

}//end class BinSearch2
