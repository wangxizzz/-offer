package review.day01;

import java.util.Arrays;

/**
 * @Author wangxi
 * @Time 2020/4/11 19:21
 */
public class HeapSort01 {
    public static void main(String[] args) {
        int[] nums = {7,4,6,3,2,5};
        new HeapSort01().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        // 建堆
        for (int i = nums.length/2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }

        // 堆调整
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
    }

    private void adjustHeap(int[] nums, int index, int len) {
        int key = nums[index];
        for (int i = 2 * index + 1; i < len; i++) {
            if (i + 1 < len && nums[i] < nums[i + 1]) {
                i = i + 1;
            }
            if (key < nums[i]) {
                nums[index] = nums[i];
                index = i;
            } else {
                break;
            }
        }
        nums[index] = key;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
