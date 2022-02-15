// Team Erm: Ryan Lau and Paul Serbanescu
// APCS
// HW64 -- Revisitation
// 2022-02-15
// time spent: 0.5 hours

public class Count7 {
  public static int count7(int n) {
    if (n == 0) return 0;

    if (n % 10 == 7) {
      return count7(n / 10) + 1;
    }

    return count7(n / 10);

  }

  public static void main(String[] args) {
    System.out.println(count7(717));
    System.out.println(count7(7));
    System.out.println(count7(123));
  }
}
