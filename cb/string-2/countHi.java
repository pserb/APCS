public class countHi {
  public static int countHi(String str) {
    int count = 0;
    for (int i = 0; i < str.length()-1; ++i) {
      if (str.substring(i, i+2).equals("hi")) {
        ++count;
      }
    }
    return count;
  }
  public static void main(String[] args) {
    System.out.println(countHi("abc hi ho"));
    System.out.println(countHi("ABChi hi"));
    System.out.println(countHi("hihi"));
  }
}
