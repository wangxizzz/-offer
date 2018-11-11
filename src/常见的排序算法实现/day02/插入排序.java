package 常见的排序算法实现.day02;

import java.util.Arrays;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/31 0031 11:00
 */
public class 插入排序 {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            for ( ;j > 0 && temp < nums[j - 1]; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }
}
