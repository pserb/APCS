//Won (Brian Wang, NAMES HERE)
//APCS pd6
//HW72 So So Fast // Fast Select
//2022--03--08
//time spent: 0.5 hours

/*
DISCO:
Linear runtime, interesting
The contributinos of randomness to runtime

QCC:
Could optimizations be made from where exactly partions are ran? 

BIG-OH:
O(n)
Best Case:
The first element in the array is the yth smallest element.

Worst Case:
You are searching for the largest element, and the array is sorted.

ALGO:
1. Run partition on the first element (order doesn't really matter since the array is randomized)
2. Find the final resting position of the partition
  a. If the final position is the yth position from the end, return the partition's value
  b. If not, determine the index of the partition, and run another partition method on the "half" of the array that the yth element is in
3. Repeat step 2
*/

public class QuickSelect {

  //partition helper
  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  /**
   * int partition(int[],int,int,int)
   * partitions!
   *
   * @param arr
   * @param start
   * @param end
   * @param partition
   * @return int
   *
   */
  public static int partition( int arr[], int a, int b, int c)
  {
    int v = arr[c];

    swap( c, b, arr);
    int s = a;

    for( int i = a; i < b; i++ ) {
      if ( arr[i] <= v) {
        swap( i, s, arr );
        s++;}
    }
    swap(s,b,arr);

    return s;
  }//end mysterion

  /**
   * fastSelect(int[], int)
   * O(n) selects yth smallest element of array
   * 
   * @param arr
   * @param ySmall
   * @return yth smallest element
   */
  public static int fastSelect(int[] arr, int ySmall){
    int part = partition(arr, 0, arr.length - 1, 0);
    ySmall --; //the nth smallest element has index n - 1
    while(ySmall != part){
      //partition before target
      if (ySmall > part){
        part = partition(arr, part, arr.length - 1, part + 1); //would setting the a value to 0 work?
      }
      //partition after target
      else{
        part = partition(arr, 0, part, 1);
      }
    }
    return arr[part];

  }

  public static void main(String[] args) {
    //TESTS HERE?!?!?!
    //sorted would be {1, 2, 3, 4, 5, 6}
    int[] testArr = {2, 5, 3, 4, 1, 6};
    //should return 4
    System.out.println(fastSelect(testArr, 4));
    //should return 1
    System.out.println(fastSelect(testArr, 1));
    //should return 6
    System.out.println(fastSelect(testArr, 6));
    //should return 2
    System.out.println(fastSelect(testArr, 2));
  }
}
