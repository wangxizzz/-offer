package leecode.dp问题;

/**
 * @author wangxi created on 2021/3/16 23:33
 * @version v1.0
 *
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 *  最长递增子序列
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        int[] nums = {10,9,2,5,3,7,101,18};

        obj.lengthOfLIS(nums);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            // 每个dp元素初始值都是1，因为每个元素自身就是1个递增序列
            dp[i] = 1;
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
