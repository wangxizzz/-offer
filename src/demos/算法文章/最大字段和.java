package demos.算法文章;

/**
 * @Author: wangxi
 * @Description : 时间O(n) ，动态规划求解
 *              求解递推公式如下：f(i) = pData[i]  当i = 0 或者f(i - 1) <= 0
 *                               f(i) = f(i - 1) + pData[i]  当i != 0 并且 f(i-1) > 0
 * @Date: 2018/5/26 0026 19:13
 */
public class 最大字段和 {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int sum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curSum <= 0) {
                curSum = nums[i];
            }else {
                curSum = curSum + nums[i];
            }
            if (curSum > sum) {
                sum = curSum;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] num = {-5,4,-3,5,8,-3};
        int[] num1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(num));
        System.out.println(maxSubArray(num1));
    }
}
