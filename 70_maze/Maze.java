// full of soup - Paul Serbanescu, Andrew Piatetsky
// APCS pd6
// HW69 -- maze solving (blind, depth-first)
// 2022-03-03r
// time spent:  hrs

/***
 * SKEELTON for
 * class MazeSolver
 * Implements a blind depth-first exit-finding algorithm.
 * Displays probing in terminal.
 *
 * USAGE:
 * $ java Maze [path/to/mazefile]
 * (mazefile is ASCII representation of a maze, using symbols below)
 *
 * ALGORITHM for finding exit from starting position:
 *  |-----------|
 *  | _ | b | _ |
 *  | c | x | a |
 *  | _ | d | _ |
 *  |-----------|
 *  First the hero sees if the right is a possible next move (a), if it is then it moves to the right, if not it checks up (b)
 *  Next it checks if it can go up (b), if that's possible it goes up and recurses, if not checks left (c)
 *  Next it checks if it can go to the left (C), if that's possible it moves to the left, if not it checks the bottom (d)
 *  Finally, the hero checks if it can go down (d), if it can it goes down, 
 *    - if not it realizes that there are no more moves left and then recursively backtracks to the last point of intersection (a point where there is another possible place to turn)
 *    - on its way back it leaves a "crumb  trail" of zeros so that it knows where it has checked for a path before.
 *
 * DISCO
 *
 * QCC
 *
 ***/

//enable file I/O
import java.io.*;
import java.util.*;


class MazeSolver
{
  final private int FRAME_DELAY = 50;

  private char[][] _maze;
  private int h, w; // height, width of maze
  private boolean _solved;

  int startX, startY;

  //~~~~~~~~~~~~~  L E G E N D  ~~~~~~~~~~~~~
  final private char HERO =           '@';
  final private char PATH =           '#';
  final private char WALL =           ' ';
  final private char EXIT =           '$';
  final private char VISITED_PATH =   '.';
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  public MazeSolver( String inputFile )
  {
    // init 2D array to represent maze
    // (80x25 is default terminal window size)
    _maze = new char[80][25];
    h = 0;
    w = 0;

    //transcribe maze from file into memory
    try {
      Scanner sc = new Scanner( new File(inputFile) );

      System.out.println( "reading in file..." );

      int row = 0;

      while( sc.hasNext() ) {

        String line = sc.nextLine();

        if ( w < line.length() )
          w = line.length();

        for( int i=0; i<line.length(); i++ )
          _maze[i][row] = line.charAt( i );

        h++;
        row++;
      }

      for( int i=0; i<w; i++ )
        _maze[i][row] = WALL;
      h++;
      row++;

    } catch( Exception e ) { System.out.println( "Error reading file" ); }

    //at init time, maze has not been solved:
    _solved = false;
  }//end constructor


  /**
   * "stringify" the board
   **/
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, ESC
    //emacs shortcut: M-x quoted-insert, ESC

    int i, j;
    for( i=0; i<h; i++ ) {
      for( j=0; j<w; j++ )
        retStr = retStr + _maze[j][i];
      retStr = retStr + "\n";
    }
    return retStr;
  }


  /**
   * helper method to keep try/catch clutter out of main flow
   * @param n      delay in ms
   **/
  private void delay( int n )
  {
    try {
      Thread.sleep(n);
    } catch( InterruptedException e ) {
      System.exit(0);
    }
  }


  /**
   * void solve(int x,int y) -- recursively finds maze exit (depth-first)
   * @param x starting x-coord, measured from left
   * @param y starting y-coord, measured from top
   **/
  public void solve( int x, int y)
  {
    delay( FRAME_DELAY ); //slow it down enough to be followable

    //primary base case
    if ( _solved ) {
      cleanup();
      System.out.println( this );
      System.out.println("start pos: " + startX + ", " + startY);
      System.out.println("exit: " + findExit()[0] + ", " + findExit()[1]);
      System.exit(0);
    }
    //other base cases
    else if ( _maze[x][y] == EXIT ) {
      _solved = true;
      System.out.println( this );
      return;
    }
    // moveable spots
    else if ( _maze[x][y] != PATH) {
      return;
    }
    //otherwise, recursively solve maze from next pos over,
    //after marking current location
    else{
      _maze[x][y] = HERO;
      System.out.println( this ); //refresh screen

      solve(x + 1, y); // right
      solve(x, y - 1); // up
      solve(x - 1, y); // left
      solve(x, y + 1); // down

      _maze[x][y] = VISITED_PATH;
      System.out.println( this ); //refresh screen
    }
  }

  //accessor method to help with randomized drop-in location
  public boolean onPath( int x, int y) {
    return _maze[x][y] == PATH;
  }

  //method to loop thru maze and remove all @ when maze is solved
  public void cleanup() {
    for (int r = 0; r < _maze.length-1; r++) {
      for (int c = 0; c < _maze[0].length-1; c++) {
        if (_maze[r][c] == HERO) {
          _maze[r][c] = VISITED_PATH;
        }
      }
    }
  }

  public int[] findExit() {
    int[] ans = new int[2];
    for (int r = 0; r < _maze.length-1; r++) {
      for (int c = 0; c < _maze[0].length-1; c++) {
        if (_maze[r][c] == EXIT) {
          ans[0] = r;
          ans[1] = c;
        }
      }
    }
    return ans;
  }

  public void quickestPath( int x, int y ) {

  }

}//end class MazeSolver


public class Maze
{
  public static void main( String[] args )
  {
    String mazeInputFile = null;

    try {
      mazeInputFile = args[0];
    } catch( Exception e ) {
      System.out.println( "Error reading input file." );
      System.out.println( "USAGE:\n $ java Maze path/to/filename" );
    }

    if (mazeInputFile==null) { System.exit(0); }

    MazeSolver ms = new MazeSolver( mazeInputFile );

    //clear screen
    System.out.println( "[2J" );

    //display maze
    System.out.println( ms );

    //drop hero into the maze (coords must be on path)
    // ThinkerTODO: comment next line out when ready to randomize startpos
    // ms.solve( 4, 3 );

    //drop our hero into maze at random location on path
    // YOUR RANDOM-POSITION-GENERATOR CODE HERE
    Random random = new Random();

    ms.startX = random.nextInt(80);
    ms.startY = random.nextInt(25);
    while ( !ms.onPath(ms.startX, ms.startY) ) {
      ms.startX = random.nextInt(80);
      ms.startY = random.nextInt(25);
    }

    System.out.println(ms.startX + ", " + ms.startY);
    ms.solve( ms.startX, ms.startY );
    ms.quickestPath( ms.startX, ms.startY );
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class Maze
