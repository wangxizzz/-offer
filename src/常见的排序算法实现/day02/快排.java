package 常见的排序算法实现.day02;

import java.util.Arrays;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/31 0031 11:04
 */
public class 快排 {

    public static void sort(int[] nums, int start, int end) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        if (start >= end) {
            return;
        }
        int index = partition(nums, start, end);
        sort(nums, start, index);
        sort(nums, index + 1, end);
    }

    public static int partition(int[] nums, int start, int end) {
        int key = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= key) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= key) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = key;
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1,2};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
