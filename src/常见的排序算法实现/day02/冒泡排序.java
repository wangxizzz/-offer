package 常见的排序算法实现.day02;

import java.util.Arrays;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/31 0031 10:32
 */
public class 冒泡排序 {

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= nums.length - i; j++) {
                if (nums[j] < nums[j - 1]) {   // 小到大进行排序
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
