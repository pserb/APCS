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

  //ADDED OVERLOADED CONSTRUCTOR
  public SuperArray( int size ) {
    this();
    this._data = new int[size];
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

  //EXTRA METHOD -- return max value of array
  public int max() {
    int max = this._data[0];
    for (int i = 0; i < this._size; i++) {
      if (this._data[i] > max) {
        max = this._data[i];
      }
    }
    return max;
  }

  //EXTRA METHOD -- return min value of array
  public int min() {
    int min = this._data[0];
    for (int i = 0; i < this._size; i++) {
      if (this._data[i] < min) {
        min = this._data[i];
      }
    }
    return min;
  }

  //EXTRA METHOD -- return the index of given value in array
  //if value appears multiple times, this returns the index of its first occurrence
  public int indexOf( int val ) {
    for (int i = 0; i < this._size; i++) {
      if (this._data[i] == val) {
        return i;
      }
    }
    //if val not in array, return -1
    return -1;
  }

  //EXTRA METHOD -- splicing, returns a SuperArray
  //given a = [0,4,8,12], a[1:3] = [4,8]
  //precond: start > end, start != end
  public SuperArray splice( int start, int end ) {
    //create new SuperArray of length 0
    SuperArray spliced = new SuperArray(0);
    for (int i = start; i < end; i++) {
      spliced.append(this._data[i]);
    }
    return spliced;
  }


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

      System.out.println("Printing max value of curtis...");
      System.out.println(curtis.max());

      System.out.println("Printing min value of curtis...");
      System.out.println(curtis.min());

      System.out.println("Printing index of 10 in curtis...");
      System.out.println(curtis.indexOf(10));
      System.out.println("Printing index of 99 in curtis...");
      System.out.println(curtis.indexOf(99));

      System.out.println("Printing splice [1:3] of curtis...");
      System.out.println(curtis.splice(1, 3));

      for( int i = 0; i < 3; i++ ) {
        curtis.expand();
        System.out.println("Printing expanded SuperArray curtis...");
        System.out.println(curtis);
      }

  }//end main()


}//end class
