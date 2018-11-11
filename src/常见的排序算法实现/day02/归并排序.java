package 常见的排序算法实现.day02;

import java.util.Arrays;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/31 0031 11:12
 */
public class 归并排序 {

    public static void sort(int[] nums, int start, int end) {
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

    public static void merge(int[] nums, int start, int mid, int end) {
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

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
