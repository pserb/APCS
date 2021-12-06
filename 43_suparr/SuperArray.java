// Clyde "Thluffy" Sinclair
// APCS pd0
// HW43 -- encapsulation (basic SuperArray functionality)
// 2021-12-07t

/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

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

  //MY METHOD -- append input value to end of array
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
  }

  //MY METHOD -- pop value at index
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

      for( int i = 0; i < 3; i++ ) {
        curtis.expand();
        System.out.println("Printing expanded SuperArray curtis...");
        System.out.println(curtis);
      }

  }//end main()


}//end class
