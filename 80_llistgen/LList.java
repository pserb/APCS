// WON (Brian, Paul, Ethan)
//APCS
//HW 78 -- Insert Remove -- Linked Lists
//2020--03--15
//time spent: .2 hours

/*
QCC:Should the main method be using insert?
Disco:
*/

/***
 * class LList
 * Implements a linked list of DLLNodes, each containing String data
 **/

 /*
 ALGOS:
 add:add a new value to the end of the list, increase size by 1
 remove:walk to the index, set store value, make the element after the previous node the next node, decrease size by 1
  */

public class LList<T> implements List<T> //interface def must be in this dir
{

  //instance vars
  private DLLNode<T> _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( T newVal )
  {
    DLLNode<T> tmp = new DLLNode( newVal, _head );
    //System.out.println(_head + " " + tmp);
    if(_size > 1){
      _head.setPrev(tmp);
    }
    _head = tmp;
    _size++;
    return true;
  }


  public T get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    T retVal;
    DLLNode<T> tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }


  public T set( int index, T newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    DLLNode<T> tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //store target node's cargo
    T oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }


  //remove node from list, return its data
  public T remove( int index ) {
    DLLNode<T> tmp = _head;
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();
    System.out.println(tmp + " " + tmp.getPrev() + " " + tmp.getNext());
    if(_size == 1){
      _head = null;
    }
    else{
      if(index > 0)
      tmp.getPrev().setNext(tmp.getNext());
      else
      _head = _head.getNext();
      _head.setPrev(null);
      if(index < _size - 1)
      tmp.getNext().setPrev(tmp.getPrev());
      else
      tmp.getPrev().setNext(null);
    }
    _size--;
    return tmp.getCargo();
  }

  public void add( int index, T newVal ) {
    DLLNode<T> tmp = _head;
    for( int i=0; i < index-1; i++ )
      tmp = tmp.getNext();
    tmp.setNext(new DLLNode(newVal, tmp.getNext(), tmp));
    tmp.getNext().getNext().setPrev(tmp.getNext());
    //System.out.println(tmp.getNext().getPrev());
    _size++;
  }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    DLLNode<T> tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo().toString() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {
    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

    System.out.println( james );

    james.remove(2); //remove a
    System.out.println( james );

    //james.insert("JASDKASDA", 1);
    System.out.println( james );
  }

}//end class LList
