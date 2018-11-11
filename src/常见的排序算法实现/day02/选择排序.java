package 常见的排序算法实现.day02;

import java.util.Arrays;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/31 0031 10:42
 */
public class 选择排序 {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int temp = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    temp = j;
                }
            }
            nums[temp] = nums[i];
            nums[i] = min;
        }
        System.out.println(Arrays.toString(nums));
    }
}
