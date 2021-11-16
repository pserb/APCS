public class bigDiff {
  public int bigDiff(int[] nums) {
    int largest, smallest;
    largest = nums[0];
    smallest = nums[0];

    for (int num : nums) {
      largest = Math.max(largest, num);
      smallest = Math.min(smallest, num);
    }
    return largest-smallest;
  }
}
