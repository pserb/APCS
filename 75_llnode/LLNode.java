/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class LLNode
{
  //instance vars
  private String _car;
  private LLNode _cdr;


  // constructor
  public LLNode( String value, LLNode next )
  {
    _car = value;
    _cdr = next;
  }


  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return _car;
  }

  public LLNode getNext()
  {
    return _cdr;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo )
  {
    String oldCargo = _car;
    _car = newCargo;
    return oldCargo;
  }

  public LLNode setNext( LLNode newNext )
  {
    LLNode oldNext = _cdr;
    _cdr = newNext;
    return oldNext;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    if (_cdr != null) {
      return _car + ", " + _cdr.toString();
    } return _car;
  }


  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    LLNode first = new LLNode( "cat", null );
    System.out.println(first); // see what's happening

    //Create a new node after the first
    first.setNext( new LLNode( "dog", null ) );
    System.out.println(first); // see what's happening

    //Create a third node after the second
    first.getNext().setNext( new LLNode( "cow", null ) );
    System.out.println(first); // see what's happening

    System.out.println();

    while( first != null ) {
      System.out.println( first );
      first = first.getNext();
    }
    /* A naive list traversal, has side effects.... ??
    */

    //Q: when head ptr moves to next node in list, what happens to the node it just left?

    //...so better: ?
    //
    //
    //

  }//end main

}//end class LLNode

