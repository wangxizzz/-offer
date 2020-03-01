package leecode.array.坑的题;

/**
 * @Author wangxi
 * @Time 2020/2/29 20:37
 * https://leetcode.com/problems/missing-number/
 * 此题是一道easy题目。但是容易搞混
 * 但是容易和 nums[i] != nums[nums[i]] 的题目搞混。此题的数字是0到n，n为数组长度。如果采用数字交换，
 * 那么数组越界问题无法解决。 使用nums[i] != nums[nums[i]] 的前提是：数组中数字范围是：0~n-1 或者 1~n
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int n = nums.length;
        int total = n * (n - 1) / 2;
        return total - sum;
    }
}
