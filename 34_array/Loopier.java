/*
Paul Serbanescu
HW34 - A Pirate's Life for Me
2021-11-15
0.5

DISCO:
iterative approach is still easier than recursive
like how we used .length() for Strings, we can use .length on arrays - they are classes and length is a var they have

QCC:
is there a cleaner way to do recursion, what we have is a big mess
is there a toString() method for arrays? one that will print out a nice string representation separated by commmas
*/


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
  public static int linSearchR(int[] a, int target) {
    if (a.length == 1) {
      if (a[0] == target) {
        return 0;
      }
      else {
	return -1;
      }
    }
    else {
      if (a[0] == target) {
	return 0;
      }
      else {
	int[] b = new int[a.length-1];
        for(int i = 0; i < a.length -1; i++) {
	  b[i] = a[i+1];
	}
	if (linSearchR(b, target) >=0) {
	  return 1 + linSearchR(b,target);
	}
      }
    }
    return -1;
  }

  // 4. FREQUENCY COUNTER
  public static int freq(int[] a, int target) {
    int counter = 0;
    for (int i = 0; i<a.length; i++) {
      if (a[i] == target) {
	counter = counter + 1;
      }
    }
    return counter;
  }

  // 4. FREQUENCY COUNTER (RECURSION)
  public static int freqRec(int[] a, int target) {
    int counter = 0;
    if (a.length == 1) {
	if (a[0] == target) {
	  counter = counter + 1;
	}
    }
    else {
	int[] b = new int[a.length-1];
        for(int i = 0; i < a.length -1; i++) {
          b[i] = a[i+1];
        }
	if (a[0] == target) {
	  counter = 1 + freqRec(b, target);
	}
	else {
	  counter = freqRec(b, target);
	}
    } return counter;
  }

  public static void main(String[] args) {
    int[] randArray = randArray(new int[5]);
    // System.out.println(randArray); // prints memory store
    System.out.println(arrayToString(randArray));

    int[] test = {1, 2, 3, 4, 5};
    int[] freqTest = {1,1,1,2,2,3,4,8,1,2};
    System.out.println("\n" + linSearch(test, 2)); // print 1
    System.out.println(linSearch(test, 6)); // print -1
    System.out.println("\n" + linSearchR(test, 1)); // print 0
    System.out.println("\n" + linSearchR(test, 6)); // print -1
    System.out.println("\n" + freq(freqTest, 1)); // print 4
    System.out.println("\n" + freq(freqTest, 6)); // print 0
    System.out.println("\n" + freqRec(freqTest, 1)); // print 4
    System.out.println("\n" + freqRec(freqTest, 6)); // print 0

  }
}
