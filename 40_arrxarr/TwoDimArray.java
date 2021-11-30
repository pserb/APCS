/*
PSerb & co - Paul Serbanescu, Andrew Piatetsky, Joseph Othman
APCS pd 7
HW40 - Demand A Raise (2D arrays)
2021-11-30
0.4

DISCO:
You can use foreach loops on 2D arrays, getting each array element in order with type int[],
and then further by nesting another foreach loop to get each element inside that array with type int

QCC:
Are there dictionaries in Java?
What is the difference between a matrix and a 2D array?
Are there 3D arrays? can you do int[][][]?
*/

public class TwoDimArray
{
  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOR loop
  public static void print1( int[][] a )
  {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
  }


  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOREACH loop
  public static void print2( int[][] a )
  {
    for (int[] row : a) {
      for (int item : row) {
        System.out.print(item + " ");
      }
      System.out.println();
    }
  }


  //postcond: returns sum of all items in 2D int array a
  public static int sum1( int[][] a )
  {
    int sum = 0;
    for (int[] row : a) {
      for (int item : row) {
        sum += item;
      }
    }
    return sum;
  }


  //postcond: returns sum of all items in 2D int array a
  //          * uses helper fxn sumRow
  public static int sum2( int [][] m )
  {
    int sum = 0;
    for (int i = 0; i < m.length; i++) {
      sum += sumRow(i, m);
    }
    return sum;
  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOR loop
  public static int sumRow( int r, int[][] a )
  {
    int sum = 0;
    for (int i = 0; i < a[r].length; i++) {
      sum += a[r][i];
    }
    return sum;
  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOREACH loop
  public static int sumRow2(int r, int[][] m)
  {
    // *** YOUR IMPLEMENTATION HERE ***
    int summer = 0;
    for (int item : m[r]) {
      summer += item;
    }
    return summer;
  }
/*
*/
  public static void main( String [] args )
  {
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
      int [][] m1 = new int[4][2];
      int [][] m2 = { {2,4,6}, {3,5,7} };
      int [][] m3 = { {2}, {4,6}, {1,3,5} };
      print1(m1);
      print1(m2);
      print1(m3);
      print2(m1);
      print2(m2);
      print2(m3);

      System.out.print("testing sum1...\n");
      System.out.println("sum m1 : " + sum1(m1));
      System.out.println("sum m2 : " + sum1(m2));
      System.out.println("sum m3 : " + sum1(m3));
      System.out.print("testing sum2...\n");
      System.out.println("sum m1 : " + sum2(m1));
      System.out.println("sum m2 : " + sum2(m2));
      System.out.println("sum m3 : " + sum2(m3));
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

      System.out.print("testing sumRow... \n");
      System.out.println("sumRow of m2 row 0 : " + sumRow(0, m2)); // expected 12

      System.out.print("testing sumRow2... \n");
      System.out.println("sumRow2 of m2 row 0 : " + sumRow2(0, m2)); // expected 12

  }

}//end class TwoDimArray
