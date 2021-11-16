public class reverse3 {
  public static int[] reverse3(int[] nums) {
    int[] ans = new int[3];
    ans[0] = nums[2];
    ans[2] = nums[0];
    ans[1] = nums[1];
    return ans;
  }
}
