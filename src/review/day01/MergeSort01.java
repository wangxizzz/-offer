package review.day01;

import java.util.Arrays;

/**
 * @Author wangxi
 * @Time 2020/4/11 19:41
 */
public class MergeSort01 {
    public static void main(String[] args) {
        int[] nums = {7,4,6,3,2,5};
        new MergeSort01().sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start)/2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = 0;
        int p = start;
        int q = mid + 1;
        while (p <= mid && q <= end) {
            if (nums[p] >= nums[q]) {
                temp[i++] = nums[q++];
            } else {
                temp[i++] = nums[p++];
            }
        }
        while (p <= mid) {
            temp[i++] = nums[p++];
        }
        while (q <= end) {
            temp[i++] = nums[q++];
        }
        for (int j = 0; j < temp.length; j++) {
            nums[j + start] = temp[j];
        }
    }
}
