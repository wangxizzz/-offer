package review.day01;

import java.util.Arrays;

/**
 * @Author wangxi
 * @Time 2020/4/5 18:57
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {7,4,6,3,2,5};
        new MergeSort().sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start,mid,  end);
    }

    private void merge(int[] nums, int start,int mid,  int end) {
        int[] temp = new int[end - start + 1];
        int i = 0;
        int j = start;
        int k = mid + 1;
        while (j <= mid && k <= end) {
            if (nums[j] <= nums[k]) {
                temp[i++] = nums[j++];
            } else {
                temp[i++] = nums[k++];
            }
        }
        while (j <= mid) {
            temp[i++] = nums[j++];
        }
        while (k <= end) {
            temp[i++] = nums[k++];
        }
        for (int q = 0; q < temp.length; q++) {
            nums[q + start] = temp[q];
        }
    }
}
