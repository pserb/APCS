// Won (Brian Wang, Ethan Lam, Paul Serbanescu)
// APCS pd6
// HW80 -- implement a node for a linked list
// 2022-03-14m
// time spent:  hrs

/***
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class DLLNode <T>
{
  //instance vars
  private T _cargo;
  private DLLNode _nextNode;
  private DLLNode _prevNode;


  // constructor
  public DLLNode( T value, DLLNode next )
  {
    _cargo = value;
    _nextNode = next;
  }

  public DLLNode( T value, DLLNode next, DLLNode prev )
  {
    _cargo = value;
    _nextNode = next;
    _prevNode = prev;
  }


  //--------------v  ACCESSORS  v--------------
  public T getCargo()
  {
    return _cargo;
  }

  public DLLNode getNext()
  {
    return _nextNode;
  }

  public DLLNode getPrev()
  {
    return _prevNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public T setCargo( T newCargo )
  {
    T foo = getCargo();
    _cargo = newCargo;
    return foo;
  }

  public DLLNode setNext( DLLNode newNext )
  {
    DLLNode foo = getNext();
    _nextNode = newNext;
    //newNext.setPrev(this);
    return foo;
  }

  public DLLNode setPrev( DLLNode newPrev )
  {
    DLLNode foo = getPrev();
    _prevNode = newPrev;
    return foo;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    return _cargo.toString();
  }


  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    DLLNode first = new DLLNode( "cat", null );

    //Create a new node after the first
    first.setNext( new DLLNode( "dog", null ) );

    //Create a third node after the second
    first.getNext().setNext( new DLLNode( "cow", null ) );
    //first.getNext().setPrev(first);
    System.out.println(first.getNext());
    System.out.println(first.getNext().getNext());
    System.out.println(first.getNext().getPrev());
    /* A naive list traversal, has side effects.... ??
       while( first != null ) {
       System.out.println( first );
       first = first.getNext();
       }
    */

    //Q: when head ptr moves to next node in list, what happens to the node it just left?
    //A: garbage collector reclaims that memory

    //  so, better: (w/o moving first)
    /*
    DLLNode temp = first;
    while( temp != null ) {
      System.out.println( temp );
      temp = temp.getNext();
    }
    */

  }//end main

}//end class DLLNode
