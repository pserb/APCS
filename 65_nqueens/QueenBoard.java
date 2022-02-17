/*
IDK (Paul Serbanescu, May Qiu, Jeffery Tang)
APCS
HW65 -- QueenBoard
2022-02-16
time spent: .5 hrs
*/

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Transcribe your KtS verbiage into block comments preceding each method where necessary.
 * 2. Implement solver method.
 */

public class QueenBoard
{

  private int[][] _board;

  public QueenBoard( int size )
  {
    _board = new int[size][size];
  }


  /***
   * precondition: board is filled with 0's only.
   * postcondition:
   * If a solution is found, board shows position of N queens,
   * returns true.
   * If no solution, board is filled with 0's,
   * returns false.
   */
  public boolean solve()
  {
    if (solveH(0)) {
      // show the board
      printSolution();
      return true;
    }
    return false;
  }


  /**
   *Helper method for solve.
   */
  private boolean solveH( int col )
  {
    // System.out.println(toString());
    // base case
    if (col >= _board.length) {
      return true;
    }

    for (int row = 0; row < _board.length; row++) {
      if (addQueen(row, col)) {
        // recurse
        if (solveH(col + 1) == true)
          return true;
      }
      removeQueen(row, col);
    }
    return false;
  }


  public void printSolution()
  {
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */

    String ans = "";
    String toAdd = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        if (_board[r][c] == 1) toAdd = "Q";
        if (_board[r][c] <= 0) toAdd = "_";
        ans += toAdd + "\t";
      }
      ans += "\n";
    }
    System.out.println(ans);
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * addQueen adds a queen to the inputted space, making its value 1, and sets the values of spaces to its right,
   diagonally up right, and diagonally down right to 1 less
   * precondition: space is equal to 0
   * postcondition: queen is placed (set value to 1), proper adjacent spaces decremented by one
   */
  private boolean addQueen(int row, int col)
  {
    if(_board[row][col] != 0){
      return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
      _board[row][col+offset]--;
      if(row - offset >= 0){
        _board[row-offset][col+offset]--;
      }
      if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
      }
      offset++;
    }
    return true;
  }


  /***
   * removeQueen removes a queen from the inputted space, making its value 0, and sets the values of spaces to its right,
   diagonally up right, and diagonally down right to 1 more
   * precondition: space is equal to 1
   * postcondition: sets space to 0, increments proper adjacent spaces by 1
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
      return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
      _board[row][col+offset]++;
      if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
      }
      if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
      }
      offset++;
    }
    return true;
  }


  /***
   * <General description>
   * precondition:
   * postcondition:
   */
  public String  toString()
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
      }
      ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard a = new QueenBoard(2);
    System.out.println(a.solve());
    QueenBoard c = new QueenBoard(4);
    System.out.println(c.solve());
    QueenBoard d = new QueenBoard(8);
    System.out.println(d.solve());
    QueenBoard b = new QueenBoard(5);
    System.out.println(b.solve());


    // System.out.println(b);
    // /** should be...
    //    0	0	0	0	0
    //    0	0	0	0	0
    //    0	0	0	0	0
    //    0	0	0	0	0
    //    0	0	0	0	0
    // */
    //
    // b.addQueen(3,0);
    // b.addQueen(0,1);
    // System.out.println(b);
    // /** should be...
    //    0	1	-1	-2	-1
    //    0	0	-2	0	0
    //    0	-1	0	-1	0
    //    1	-1	-1	-1	-2
    //    0	-1	0	0	0
    // */
    //
    // b.removeQueen(3,0);
    // System.out.println(b);
    // /** should be...
    //    0	1	-1	-1	-1
    //    0	0	-1	0	0
    //    0	0	0	-1	0
    //    0	0	0	0	-1
    //    0	0	0	0	0
    // */

  }

}//end class
