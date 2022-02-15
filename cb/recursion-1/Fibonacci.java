// Team Erm: Ryan Lau and Paul Serbanescu
// APCS
// HW64 -- Revisitation
// 2022-02-15
// time spent: 0.5 hours

public class Fibonacci {
  public static int fibonacci(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fibonacci(n-1) + fibonacci(n-2);
  }
  public static void main(String[] args) {
    System.out.println(fibonacci(0));
    System.out.println(fibonacci(1));
    System.out.println(fibonacci(2));
    System.out.println(fibonacci(3));
    System.out.println(fibonacci(4));
    System.out.println(fibonacci(5));
  }
}
