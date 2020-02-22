package leecode.array;

/**
 * @Author wangxi
 * @Time 2020/2/19 17:07
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int curSum = 0;
        int curLen = 0;
        int minLen = Integer.MAX_VALUE;
        for (; j < nums.length; j++) {
            curSum += nums[j];
            if (curSum < s) {
                continue;
            }
            while (curSum >= s && i <= j) {
                curLen = j - i + 1;
                if (curLen < minLen) {
                    minLen = curLen;
                }
                curSum -= nums[i];
                i++;
            }

        }
        return minLen;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
    }
}
