// WON (Brian, Paul, Ethan)
//APCS
//HW 76 -- We Got a Little Ol' Convoy -- Ah, breaker one-nine, this here's the Rubber Duck
//2020--pi
//time spent: .5 hours

/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class LLNode
{
  //instance vars
  private String _cargo;
  private LLNode _nextNode;


  // constructor
  public LLNode( String value, LLNode next )
  {
    _cargo = value;
    _nextNode = next;
  }


  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return _cargo;
  }

  public LLNode getNext()
  {
    return _nextNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo )
  {
    String oldCargo = _cargo;
    _cargo = newCargo;
    return oldCargo;
  }

  public LLNode setNext( LLNode newNext )
  {
    LLNode oldNext = _nextNode;
    _nextNode = newNext;
    return oldNext;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    if (_nextNode != null) {
      return _cargo + ", " + _nextNode.toString();
    } return _cargo;
  }


  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    LLNode first = new LLNode( "cat", null );

    //Create a new node after the first
    first.setNext( new LLNode( "dog", null ) );

    //Create a third node after the second
    first.getNext().setNext( new LLNode( "cow", null ) );


    // traverses while preserving pointer to first, JVM won't eat it up
    LLNode temp = first;

    while( temp != null ) {
      System.out.println( temp );
      temp = temp.getNext();
    }

  }//end main

}//end class LLNode

