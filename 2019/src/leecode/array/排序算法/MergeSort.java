package leecode.array.排序算法;

/**
 * @author wangxi created on 2021/3/3 00:07
 * @version v1.0
 *
 * https://leetcode-cn.com/problems/sort-an-array/
 */
public class MergeSort {

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return nums;
        }
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int start, int end) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] > nums[j]) {
                temp[k++] = nums[j++];
            } else {
                temp[k++] = nums[i++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        for (int p = 0; p < temp.length; p++) {
            nums[start + p] = temp[p];
        }
    }
}
