import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangxi created on 2021/3/16 22:28
 * @version v1.0
 */
public class Solution {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
