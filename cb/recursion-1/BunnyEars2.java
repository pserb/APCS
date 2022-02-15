// Team Erm: Ryan Lau and Paul Serbanescu
// APCS
// HW64 -- Revisitation
// 2022-02-15
// time spent: 0.5 hours

public class BunnyEars2 {
  public static int bunnyEars2(int bunnies) {
    if (bunnies == 0) return 0;
    if (bunnies % 2 == 0) return 3+bunnyEars2(bunnies-1);
    return 2 + bunnyEars2(bunnies-1);
  }
  public static void main(String[] args) {
    System.out.println(bunnyEars2(0));
    System.out.println(bunnyEars2(1));
    System.out.println(bunnyEars2(2));
  }
}
