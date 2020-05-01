package review.day01;

import java.util.Arrays;

/**
 * @Author wangxi
 * @Time 2020/4/5 18:57
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {7,4,6,3,2,5};
        new QuickSort().sort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = partition(nums, start, end);
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int key = nums[start];
        while (start < end) {
            while (nums[end] >= key && start < end) {
                end--;
            }
            nums[start] = nums[end];
            while (nums[start] <= key && start < end) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = key;
        return start;
    }
}
