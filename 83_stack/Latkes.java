/*
Team WON: Paul Serbanescu, Ethan Lam, Brian Wang
APCS
HW83: Stacks on Stacks
2022-03-28
time spent: hrs

Wikipedia says...
In CS, an abstract data type (ADT) is a mathematical model for data types
where a data type is defined by its behavior (semantics) from the point of view of a user of the data,
specifically in terms of possible values,
possible operations on data of tihs type,
and the behavior of these operations.
*/



/***
 * class Latkes
 * v1
 * SKELETON
 * Implements a stack of Strings using an encapsulated array
 **/

/***
    DISCO

    QCC

 **/


public class Latkes
{
  private String [] _stack;
  private int _stackSize;


  //constructor
  public Latkes( int initCapacity )
  {
    _stack = new String[initCapacity];
    _stackSize = 0;
  }// O(?)


  //means of insertion
  public void push( String s )
  {
    if(isFull()){
        String[] old = _stack;
        _stack = new String[old.length * 2];
        for(int i = 0 ; i < _stackSize ; i++){
          _stack[i] = old[i];
        }
    }

    _stack[_stackSize] = s;
    _stackSize += 1;
  }// O(?)


  //means of removal
  public String pop( )
  {
    if(isEmpty()){
      return null;
    }
    else{
      String ret = _stack[_stackSize- 1];
      _stackSize -= 1;
      return ret;
    }
  }// O(?)


  //chk for emptiness
  public boolean isEmpty()
  {
    return _stackSize < 1;
  }// O(?)


  //chk for fullness
  public boolean isFull()
  {
    return _stackSize == _stack.length;
  }// O(?)


  //main method for testing
  public static void main( String[] args )
  {

    Latkes tastyStack = new Latkes(10);

    tastyStack.push("aoo");
    tastyStack.push("boo");
    tastyStack.push("coo");
    tastyStack.push("doo");
    tastyStack.push("eoo");
    tastyStack.push("foo");
    tastyStack.push("goo");
    tastyStack.push("hoo");
    tastyStack.push("ioo");
    tastyStack.push("joo");
    tastyStack.push("coocoo");
    tastyStack.push("cachoo");

    //cachoo
    System.out.println( tastyStack.pop() );
    //coocoo
    System.out.println( tastyStack.pop() );
    //joo
    System.out.println( tastyStack.pop() );
    //ioo
    System.out.println( tastyStack.pop() );
    //hoo
    System.out.println( tastyStack.pop() );
    //goo
    System.out.println( tastyStack.pop() );
    //foo
    System.out.println( tastyStack.pop() );
    //eoo
    System.out.println( tastyStack.pop() );
    //doo
    System.out.println( tastyStack.pop() );
    //coo
    System.out.println( tastyStack.pop() );
    //boo
    System.out.println( tastyStack.pop() );
    //aoo
    System.out.println( tastyStack.pop() );

    //stack empty by now; SOP(null)
    System.out.println( tastyStack.pop() );
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main()

}//end class Latkes
