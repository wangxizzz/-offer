package book_note.day02.review;

import java.util.Arrays;

/**
 * @author wangxi created on 2021/1/4 23:47
 * @version v1.0
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    private void sort(int[] nums, int left, int right) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        if (left >= right) {
            return;
        }
        int mid = left + (right - left)/2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int start = left;
        int i = 0;
        int x = left;
        int y = mid + 1;
        while (x <= mid && y <= right) {
            if (nums[x] <= nums[y]) {
                temp[i++] = nums[x++];
            } else {
                temp[i++] = nums[y++];
            }
        }
        while (x <= mid) {
            temp[i++] = nums[x++];
        }
        while (y <= right) {
            temp[i++] = nums[y++];
        }

        for (int j = 0; j < temp.length; j++) {
            nums[j + start] = temp[j];
        }
    }
}
