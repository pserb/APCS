public class doubleChar {
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
  }
}
