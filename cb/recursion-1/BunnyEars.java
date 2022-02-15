// Team Erm: Ryan Lau and Paul Serbanescu
// APCS
// HW64 -- Revisitation
// 2022-02-15
// time spent: 0.5 hours

public class BunnyEars {
  public static int bunnyEars(int bunnies) {
    if (bunnies == 0) return 0;
    return 2 + bunnyEars(bunnies-1);
  }
  public static void main(String[] args) {
    System.out.println(bunnyEars(2));
  }
}
