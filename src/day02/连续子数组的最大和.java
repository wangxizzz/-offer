package day02;

/**
 * @Author:王喜
 * @Description :面试42
 * @Date: 2018/4/16 0016 22:18
 */
public class 连续子数组的最大和 {

    public static Integer findMaxSumOfSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int currentSum = 0;
        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum = currentSum + nums[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            else if (currentSum < 0) {
                //从当前值开始算起
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {1,-2,3,10,-4,7,2,-5};
        System.out.println(findMaxSumOfSubArray(nums));
    }
}
