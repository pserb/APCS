// JIMIN :: Ryan Lau, Melody Lew, Paul Serbanescu
// APCS pd6
// HW104 -- Heaping Piles of Sordidness
// 2022-05-20f
// time spent: 1.0 hrs

/**
 * class Heapsort
 * SKELETON
 * sorts in-place by heapifying data, then repeatedly pulling from heap
 */


/*
 * DISCO
 * The only difference between min and max heapify/childPos is one boolean expression
 *
 * QCC
 * What is the best case for heapsort?
 */

public class Heapsort
{

  /**
   * int[] sort( int[] data )  --- returns sorted input array
   * Applies heapsort algorithm (in place)
   */
  public int[] sort( int[] data )
  {
    //STEP 1&2: repeatedly pull from heap until empty
    //(Sorted region will grow from R to L)

    // i shifts the section we want to heapify (once we place the greatest val at the end in its final resting pos, we don't want to include it in the heapify)
    for (int i = 0; i < data.length; i++) {
      //heapify (logn operation)
      maxHeapify(data, data.length-i);
      //swap root with last index
      swap(0, data.length-1-i, data);
    }

    //STEP teh LAST: return modified array
    return data;

  }//end sort() -- O(nlogn)



  private void minHeapify( int[] a )
  {

    for( int i=1; i<a.length; i++ ) {
      //add a[i] as leaf
      int addValPos = i; //val to add is next non-heap element

      //now must percolate up
      while(a[i] > 0) { //potentially swap until reach root

        //pinpoint parent
        int parentPos = (i-1) / 2;

        if (a[addValPos] < a[parentPos]) {
          swap(addValPos, parentPos, a);
          addValPos = parentPos;
        }
        else
          break;
      }
    }
  }//end minHeapify() -- O(logn)



  private void maxHeapify( int[] a, int startPoint )
  {
    for( int i=startPoint-1; i>0; i-- ) {
      // System.out.println("i is: " + i);
      //add a[i] as leaf
      int addValPos = i; //val to add is next non-heap element

      //now must percolate up
      while(a[i] > 0) { //potentially swap until reach root

        //pinpoint parent
        int parentPos = (i-1) / 2;

        if (a[addValPos] > a[parentPos]) {
          swap(i, parentPos, a);
          addValPos = parentPos;
        }
        else
          break;
      }
    }
  }//end maxHeapify() -- O(logn)



  //--------------v- HELPER METHODS -v--------------
  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

  public static void shuffle( int[] d )
  {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  public static int[] buildArray( int size, int hi )
  {
    int[] retArr = new int[size];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( hi * Math.random() );
    return retArr;
  }
  //--------------^- HELPER METHODS -^--------------




  //main method for testing
  public static void main( String[] args )
  {
    int[] a = buildArray( 10, 10 );

    printArr(a);

    Heapsort h = new Heapsort();

    h.sort(a);

    printArr(a);
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main()

}//end class
