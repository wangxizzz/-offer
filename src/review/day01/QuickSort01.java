package review.day01;

import java.util.Arrays;

/**
 * @Author wangxi
 * @Time 2020/4/11 18:56
 */
public class QuickSort01 {
    public static void main(String[] args) {
        int[] nums = {7,4,6,3,2,5};
        new QuickSort01().sort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] nums, int start, int end) {
        if (nums == null || nums.length <= 0) {
            return;
        }
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
            while (start < end && nums[end] > key) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] < key) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = key;
        return start;
    }
}
