public class countEvens {
  public static int countEvens(int[] nums) {
    int counter = 0;
    for (int num : nums) {
      if (num % 2 == 0) {
        counter++;
      }
    }
    return counter;
  }
}
