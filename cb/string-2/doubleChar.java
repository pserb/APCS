public class doubleChar {
  // create my charAt method to prove I know what built in string method charAt does
  // from what I know, there is no way to typecast a string to a char without using charAt, so this method returns a String instead of ideally being a char.
  public static String myCharAt(String str, int n) {
    return str.substring(n, n+1);
  }

  public static String doubleChar(String str) {
    String ans = "";
    for (int i = 0; i < str.length(); ++i) {
      for (int j = 0; j < 2; ++j) {
        ans += str.charAt(i);
      }
    }
    return ans;
  }
  public static void main(String[] args) {
    System.out.println(doubleChar("The"));
    System.out.println(doubleChar("AAbb"));
    System.out.println(doubleChar("Hi-There"));

    // test my charAt method
    // /*
    System.out.println(myCharAt("hello", 0));
    System.out.println(myCharAt("hello", 1));
    System.out.println(myCharAt("hello", 2));
    System.out.println(myCharAt("hello", 3));
    System.out.println(myCharAt("hello", 4));
    // */
  }
}
