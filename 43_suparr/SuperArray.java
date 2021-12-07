/*
TNPG: Pseb & Co (Andrew Piatesky, Paul Serbanescu, Joseph Othman) and Burnt Peanut
APCS
HW43 - Array of Steel
2021-12-06
time spent: 25min

DISCOVERIES:
One way to modify arrays is by using a temporary storage array and to "dump" all
of the info from our previously existing array into it, then to make a new array
with the same name as the initial array (in our case, _data) and to make the
necessary changes when we initialize _data.

QUESTIONS:
What would be the best implementations of append and remove? Should we remove at
any given index? Should we append any value, and where?
Is there any built in functionality that will allow us to have these array
functions?
*/

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    this._data = new int[10];
    this._size = this._data.length;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String s = "[";
    for (int i = 0; i < this._size; i++) {
        if (i != this._size - 1) {
            s += this._data[i] + ",";
        } else {
            s += this._data[i];
        }
    }
    return s + "]";
  }


  //double capacity of SuperArray
  private void expand()
  {
    int[] oldData = new int[this._size];
    for (int i = 0; i < this._size; i++) {
        oldData[i] = this._data[i];
    }

    _data = new int[this._size * 2];
    for (int i = 0; i < this._size; i++) {
        this._data[i] = oldData[i];
    }
    this._size = this._data.length;

  }


  //accessor -- return value at specified index
  public int get( int index )
  {
    return this._data[index];
  }

  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    int oldVal = this._data[index];
    this._data[index] = newVal;
    return oldVal;
  }
  
  //=== Following are added methods not included in the homework guidelines ===

  //EXTRA METHOD -- append input value to end of array
  public void append( int val ) {
      int[] oldData = new int[this._size];
      for (int i = 0; i < this._size; i++) {
        oldData[i] = this._data[i];
      }

      this._data = new int[this._size + 1];
      for (int i = 0; i < this._size; i++) {
          this._data[i] = oldData[i];
      }
      this._data[_size] = val;
      this._size = this._data.length;
  }//end append()

  //EXTRA METHOD -- pop value at index
  public void pop( int index ) {
    int[] oldData = new int[this._size];
    for (int i = 0; i < this._size; i++) {
      oldData[i] = this._data[i];
    }

    _data = new int[this._size - 1];
    int shift = 0;
    for (int i = 0; i < this._size - 1; i++) {
        this._data[i] = oldData[i+shift];
        if (i == index) {
            shift = 1;
            this._data[i] = oldData[i+shift];
        }
    }
    this._size = _data.length;
  }//end pop()


  //main method for testing
  public static void main( String[] args )
  {
    
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );
      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }

      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);

      System.out.println("Printing appended value of 69 to curtis...");
      curtis.append(69);
      System.out.println(curtis);

      System.out.println("Printing resultant array from popped index of 4 in curtis...");
      curtis.pop(4);
      System.out.println(curtis);

      System.out.println("Printing resultant array when popping LAST index in curtis...");
      curtis.pop(10);
      System.out.println(curtis);

      for( int i = 0; i < 3; i++ ) {
        curtis.expand();
        System.out.println("Printing expanded SuperArray curtis...");
        System.out.println(curtis);
      }

  }//end main()


}//end class
