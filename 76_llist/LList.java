// WON (Brian, Paul, Ethan)
//APCS
//HW 76 -- We Got a Little Ol' Convoy -- Ah, breaker one-nine, this here's the Rubber Duck
//2020--03--14
//time spent: .5 hours

/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = new LLNode(null, null);
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    if (size() == 0) {
      _head.setCargo(newVal);
      _size++;
      return true;
    }

    LLNode temp = _head;
    for (int i = 0; i < size()-1; i++) {
      temp = temp.getNext();
    }
    temp.setNext(new LLNode(newVal, null));
    _size++;
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    LLNode temp = _head;
    for (int i = 0; i < index; i++) {
      temp = temp.getNext();
    }
    return temp.getCargo();
  }


  public String set( int index, String newVal )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    LLNode temp = _head;
    for (int i = 0; i < index; i++) {
      temp = temp.getNext();
    }
    String oldVal = temp.getCargo();
    temp.setCargo(newVal);
    return oldVal;
  }


  //return number of nodes in list
  public int size()
  {
    return _size;
  }

  //--------------^  List interface methods  ^--------------



  // override inherited toString
  public String toString()
  {
    if (_head.getNext() != null) {
      return _head.getCargo() + ", " + _head.getNext().toString();
    } return _head.getCargo();
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
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class LList
