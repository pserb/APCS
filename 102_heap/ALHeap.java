// JIMIN :: Ryan Lau, Melody Lew, Paul Serbanescu
// APCS pd6
// HW102 -- Heap On Heapin' On
// 2022-05-17t
// time spent: 0.7 hrs
/*
disco:
0. it will always be a complete tree
1. we get a "nodes" parent via idx
2. we cannot simply call .remove(0) to remove the min b/c runtime will be O(n) rather than O(log(n))

view parent:
    idx - 1 / 2

view left child:
    2idx + 1

view right child:
    2idx + 2

*/

/**
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 */

import java.util.ArrayList;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap;

  /**
   * default constructor  ---  inits empty heap
   */
  public ALHeap()
  {
    _heap = new ArrayList<>();
  }



  /**
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   */
  public String toString()
  {
    return _heap.toString();
  }//O(n)


  /**
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   */
  public boolean isEmpty()
  {
    return _heap.isEmpty();
  }//O(1)


  /**
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   */
  public Integer peekMin()
  {
    // if heap is empty
    if (_heap.isEmpty()) {
      return null;
    }

    return _heap.get(0);
  }//O(1)


  /**
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   * ALGO:
   * <your clear && concise procedure here>
   * while parent is greater than addVal, swap the two
   */
  public void add( Integer addVal )
  {
    _heap.add(addVal);

    int addValIndex = _heap.size() - 1;
    int parentIndex = (addValIndex - 1) / 2;

    //reheapify!
    while(_heap.get(parentIndex) > addVal) {
      swap(parentIndex, addValIndex);

      addValIndex = parentIndex;
      parentIndex = (addValIndex - 1) / 2;

    }
  }//O(logn)


  /**
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   * ALGO:
   * while min child is less than current root, swap
   */
  public Integer removeMin()
  {
    // to return the value we are removing
    Integer retVal = peekMin();

    // see peekMin, if heap is empty returns null
    if (retVal == null) {
      return null;
    }

    // swap root with the last node
    swap(0, _heap.size()-1);
    _heap.remove(_heap.size()-1); // O(1) when removing the last element of an AL

    // index of the current node we are looking at (start at root)
    int parentIndex = 0;

    // while the node has children, and one of those children is less than the node
    while ((minChildPos(parentIndex) != -1) && (_heap.get(minChildPos(parentIndex)) < _heap.get(parentIndex))) {

      // swap the node with its smallest child
      int minpos = minChildPos(parentIndex);
      swap(parentIndex, minpos);

      // update the index of the node we are looking at to the new position (it was just swapped with minpos)
      parentIndex = minpos;
    }

    return retVal;
  }//O(logn)


  /**
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   */
  private int minChildPos( int pos )
  {
    int leftChildIndex = (2 * pos) + 1;
    int rightChildIndex = (2 * pos) + 2;

    if ((leftChildIndex >= _heap.size()) && (rightChildIndex >= _heap.size())) {
      return -1;
    } else if (leftChildIndex >= _heap.size()) {
      return rightChildIndex;
    } else if (rightChildIndex >= _heap.size()) {
      return leftChildIndex;
    } else {
      return _heap.indexOf(minOf(_heap.get(leftChildIndex), _heap.get(rightChildIndex)));
    }
  }//O(1)


  //~~~~~~~~~~~~~ aux helper fxns ~~~~~~~~~~~~~~
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
      return a;
    else
      return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  //main method for testing
  public static void main( String[] args )
  {
    ALHeap pile = new ALHeap();
    
    pile.add(2);
    System.out.println(pile);
    pile.add(4);
    System.out.println(pile);
    pile.add(6);
    System.out.println(pile);
    pile.add(8);
    System.out.println(pile);
    pile.add(10);
    System.out.println(pile);
    pile.add(1);
    System.out.println(pile);
    pile.add(3);
    System.out.println(pile);
    pile.add(5);
    System.out.println(pile);
    pile.add(7);
    System.out.println(pile);
    pile.add(9);
    System.out.println(pile);

    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
