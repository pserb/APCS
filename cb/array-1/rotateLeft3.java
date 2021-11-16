public class rotateLeft3 {
  public static int[] rotateLeft3(int[] nums) {
    int[] ans = new int[3];
    for (int i = 1; i < nums.length; i++) {
      ans[i-1] = nums[i];
    }
    ans[ans.length-1] = nums[0];
    return ans;
  }
}
