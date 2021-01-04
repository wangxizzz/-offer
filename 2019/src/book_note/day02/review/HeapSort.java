package book_note.day02.review;

import java.util.Arrays;

/**
 * @author wangxi created on 2021/1/3 20:39
 * @version v1.0
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(nums);

        System.out.println(Arrays.toString(nums));
    }

    private void sort(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        for (int i = (nums.length - 1)/2; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void adjustHeap(int[] nums, int index, int len) {
        int key = nums[index];
        int i = index * 2 + 1;
        for (; i < len; i++) {
            if (i + 1 < len && nums[i + 1] > nums[i]) {
                i = i + 1;
            }
            if (key >= nums[i]) {
                break;
            } else {
                nums[index] = nums[i];
                index = i;
            }
        }
        nums[index] = key;
    }
}
