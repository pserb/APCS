public class SuperArray implements ListInt  {

  //INSTANCE VARIABLES
  private int[] _data;
  private int _size;

  public SuperArray() {
    _data = new int[10];
    _size = 0;
  }

  public String toString() {
    String foo = "[";
    for( int i = 0; i < _size; i++ ) {
      foo += _data[i] + ",";
    }
    if ( foo.length() > 1 )
      //shave off trailing comma
      foo = foo.substring( 0, foo.length()-1 );
    foo += "]";
    return foo;
  }

  public boolean add(int x) {
    _data[_size] = x;
    _size++;
    return true;
  }
  public boolean add(int index, int x) {
    if (index >= _size) {
      return false;
    } else {
      //increment size
      _size++;
      //go right to left, starting at end (_size), shifting over each element, until you reach index
      for (int i = _size; i > index; i--) {
        _data[i] = _data[i-1];
      }
      //now safe to overwrite index with new value (x)
      _data[index] = x;
    }
    return true;
  }
  public int get(int index) {
    if ((index < _size) && !(index < 0)) {
      return _data[index];
    } else {
      System.out.println("Index is out of bounds.");
    }
    return -1;
  }
  public int set(int index, int o) {
    //init var to store old value at index
    int oldVal = -1;

    //if the index is valid within the SuperArray and is not less than zero
    if ((index < _size) && !(index < 0)) {
      oldVal = _data[index];
      _data[index] = o;
    } else {
      //if index is not valid within SuperArray
      System.out.println("Index is out of bounds.");
      return oldVal;
    }
    return oldVal;
  }
  public int size() {
    return _size;
  }
  public static void main(String[] args) {
    /// === error: ListInt is abstract; cannot be instantiated === ///
    // ListInt a = new ListInt();
    // System.out.println(a);

    //test methods
    SuperArray sup = new SuperArray();
    System.out.println("Initalizing new SuperArray...");
    System.out.println(sup);

    System.out.println("Adding 10...");
    sup.add(10);
    System.out.println(sup);

    System.out.println("Adding 4...");
    sup.add(4);
    System.out.println(sup);

    System.out.println("Adding 5 at index of zero...");
    sup.add(0, 5);
    System.out.println(sup);

    System.out.println("Printing value at index of 1...");
    System.out.println(sup.get(1));

    System.out.println("Setting index 2 to value of 15...");
    sup.set(2, 15);
    System.out.println(sup);

    System.out.println("Printing size...");
    System.out.println(sup.size());

    System.out.println("Trying to get value at index that does not exist (10) ...");
    System.out.println(sup.get(10));
  }
}