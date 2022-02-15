// Team Erm: Ryan Lau and Paul Serbanescu
// APCS
// HW64 -- Revisitation
// 2022-02-15
// time spent: 0.5 hours

public class Count8 {
  public static int count8(int n) {
    if (n == 0) return 0;

    if (n % 10 == 8) {
      if (n % 100 == 8) {
        return count8(n / 10) + 2;
      }
      return count8(n / 10) + 1;
    }

    return count8(n / 10);
  }
}
