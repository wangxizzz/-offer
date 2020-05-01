package leecode.array.子串与子序列问题;

/**
 * @Author wangxi
 * @Time 2020/5/1 00:20
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int p = 0;
        int q = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || curSum <= 0) {
                curSum = nums[i];
                p = i;
            } else {
                curSum += nums[i];
            }
            if (curSum > maxSum) {
                maxSum = curSum;
                q = i;
            }
        }
        System.out.println("起始下标: " + p + " 结束下标: " + q);
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-50,4, 100};
        System.out.println(new MaxSubArray().maxSubArray(nums));
    }
}
