/***
 * class RQueue
 * SKELETON
 * A node-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 **/


public class RQueue<T> implements Queue<T>
{
  //instance variables
  private LLNode<T> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue()
  {
    _front = _end = null;
    _size = 0;
  }


  public void enqueue( T enQVal )
  {
    //special case: when enqueuing to an empty list,
    //make _front && _end point to same node
    if ( isEmpty() ) {
      _front = _end = new LLNode<T>( enQVal, null );
    }
    else {
      _end.setNext( new LLNode<T>( enQVal, null ) );
      _end = _end.getNext();
    }
    _size++;
    System.out.println("enqueued " + enQVal);
  }//O(?)


  // remove and return thing at front of queue
  // assume _queue ! empty
  public T dequeue()
  {
    T retVal = peekFront();
    _front = _front.getNext();

    if (_front == null) _end = null;

    _size--;

    return retVal;
  }//O(?)


  public T peekFront()
  {
    sample();
    return _front.getCargo();
  }//O(?)


  /***
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   *   < YOUR SUCCINCT SUMMARY HERE >
   **/
  public void sample ()
  {
    LLNode<T> _temp = _front;
    int random = (int) (Math.random() * _size);
    for (int i = 0; i < random; i++) {
      _temp = _temp.getNext();
    }
    //TODO: SWAP _temp and _front
    T tmpCargo = _front.getCargo();
    _front.setCargo(_temp.getCargo());
    _temp.setCargo(tmpCargo);
  }//O(?)


  public boolean isEmpty()
  {
    return _front == null;
  } //O(?)


  // print each node, separated by spaces
  public String toString()
  {
    String foo = "";
    LLNode<T> tmp = _front;
    while ( tmp != null ) {
      foo += tmp.getCargo() + " ";
      tmp = tmp.getNext();
    }
    return foo;
  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {


    Queue<String> PirateQueue = new RQueue<String>();

    System.out.println("\nnow enqueuing...");
    PirateQueue.enqueue("Dread");
    PirateQueue.enqueue("Pirate");
    PirateQueue.enqueue("Roberts");
    PirateQueue.enqueue("Blackbeard");
    PirateQueue.enqueue("Peter");
    PirateQueue.enqueue("Stuyvesant");

    System.out.println("\nnow testing toString()...");
    System.out.println( PirateQueue ); //for testing toString()...

    System.out.println("\nnow dequeuing...");
    System.out.println( PirateQueue.dequeue() );
    // System.out.println("\nQueue is now: \n" + PirateQueue );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    
    System.out.println("\nnow dequeuing fr empty queue...\n" +
    "(expect NPE)\n");
    System.out.println( PirateQueue.dequeue() );
    
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
