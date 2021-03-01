package leecode.面试题;

import java.util.ArrayList;
import java.util.List;

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
        List<String> list = new ArrayList<>();
        String ss = "";
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || curSum <= 0) {
                curSum = nums[i];
                // start指针在哪里切换的
                p = i;
            } else {
                curSum += nums[i];
            }
            if (curSum > maxSum) {
                maxSum = curSum;
                // end指针在哪里切换的
                q = i;

                list.add(p + "_" + q);
                // 利用其它容器保存 窗口的两个边界，不让后续数字破坏窗口边界值
                ss = p + "_" + q;
            }
        }
        System.out.println("起始下标: " + p + " 结束下标: " + q);
        System.out.println(list);
        System.out.println(ss);
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,10000,4,-100000,2,1,-50,4, 100};
        System.out.println(new MaxSubArray().maxSubArray(nums));
    }
}
