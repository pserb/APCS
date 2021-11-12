public class Loopier {
  // 1. ARRAY OF RANDOM INTS
  public static int[] randArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      array[i] = (int)(Math.random()*5);
    }
    return array;
  }

  // 2. STRING VERSION OF INT ARRAY
  public static String arrayToString(int[] array) {
    String result = "";
    for (int num : array) {
      result += num + " ";
    }
    return result;
  }

  // 3. LINEAR SEARCH (FOR LOOP)
  public static int linSearch(int[] a, int target) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] == target) {
        return i;
      }
    }
    return -1;
  }

  // 3. LINEAR SEARCH (RECURSION)


  public static void main(String[] args) {
    int[] randArray = randArray(new int[5]);
    // System.out.println(randArray); // prints memory store
    System.out.println(arrayToString(randArray));

    int[] test = {1, 2, 3, 4, 5};
    System.out.println("\n" + linSearch(test, 2)); // print 1
    System.out.println(linSearch(test, 6)); // print -1
  }
}
