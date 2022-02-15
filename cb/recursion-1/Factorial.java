// Team Erm: Ryan Lau and Paul Serbanescu
// APCS
// HW64 -- Revisitation
// 2022-02-15
// time spent: 0.5 hours

public class Factorial {
  public static int factorial(int n) {
    if (n == 1) return n;
    return n * factorial(n-1);
  }
  public static void main(String[] args) {
    System.out.println(factorial(5));
  }
}
