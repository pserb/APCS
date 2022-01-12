// Paul Serbanescu
// APCS pd07
// HW 55 - Never Fear, Big Oh Is Here!
// 2022-1-11t

/** Time Complexities
 * toString() - O(n)
 * remove() - O(n)
 * size() - O(1)
 * get() - O(1)
 * addLinear() - O(n)
 * addBinary() - O(log_2 n)
 */

 /*
 DISCO:
 addLinear has linear time - O(n),
 addBinary has logarithmic time - O(log_2 n)

 QCC:
 N/A
 */

/**********************************************
 * class OrderedArrayList
 * wrapper class for ArrayList
 * maintains invariant that elements are ordered (ascending)
 *
 * typed for Integers
 *
 * ArrayList spec at
 * https://www2.cs.duke.edu/csed/ap/subset/doc/ap/java/util/ArrayList.html
 **********************************************/


import java.util.ArrayList;

public class OrderedArrayList
{

  // instance of class ArrayList, holding objects of type Integer
  // (i.e., objects of a class that implements interface Integer)
  private ArrayList<Integer> _data;


  // default constructor
  // initializes instance variables
  public OrderedArrayList()
  {
    _data = new ArrayList<Integer>();
  }


  //pass-tru functionality
  // O(n)
  public String toString()
  {
    return _data.toString();
  }


  //pass-tru functionality
  // O(n)
  public Integer remove( int index )
  {
    return _data.remove(index);
  }


  //pass-tru functionality
  // O(1)
  public int size()
  {
    return _data.size();
  }


  //pass-tru functionality
  // O(1)
  public Integer get( int index )
  {
    return _data.get(index);
  }


  //modified functionality
  //insert at appropriate location to maintain sortedness
  // depends on if using addLinear() - O(n)  or  addBinary() - O(log_2 n)
  public boolean add( Integer newVal )
  {
    //call exactly 1 of the helper methods below...  your favorite?

    // addLinear(newVal);
    addBinary(newVal);
    return true;
  }


  // inserts newVal at the appropriate index
  // maintains ascending order of elements
  // uses a linear search to find appropriate index
  // O(n)
  public void addLinear(Integer newVal)
  {
    int passes = 0;
    for( int p = 0; p < _data.size(); p++ ) {
      passes++;
      if ( newVal.compareTo( _data.get(p) ) < 0 ) {
        //newVal < oal[p]
        _data.add( p, newVal );
        System.out.println(passes);
        return; //Q:why not break?
      }
    }
    _data.add( newVal ); //newVal > every item, so add to end
    System.out.println(passes);//tstn
  }


  // inserts newVal at the appropriate index
  // maintains ascending order of elements
  // uses a binary search to find appropriate index
  // O(log_2 n)
  public void addBinary(Integer newVal)
  {
    int passes = 0;//tstn
    //initialize high, low, midpt indices
    int lo = 0;
    int med = 0;
    int hi = _data.size()-1;

    while ( lo <= hi ) { //running until target is found or bounds cross
      passes++;//tstn

      med = (lo + hi) / 2;
      int x = _data.get(med).compareTo( newVal );

      if ( x == 0 ) {
        //equal value found, insert here
        _data.add( med, newVal );
        System.out.println(passes);//tstn
        return;
      }
      else if ( x > 0 )
        //newVal < med, so look at lower half of data
        hi = med - 1;
      else
        //newVal > med, so look at upper half of data
        lo = med + 1;
    }
    // If you made it this far, newVal is not present.
    // So insert at lo.
    _data.add( lo, newVal );
    System.out.println(passes);//tstn
    //Q: How do you know lo is correct insertion index?
  }

  // purely for testing purposes
  public static void main(String[] args) {
      OrderedArrayList oal = new OrderedArrayList();
      for (int i = 0; i < 100; i++) {
          oal.add(i);
      }
  }//end main

}//end class OrderedArrayList
