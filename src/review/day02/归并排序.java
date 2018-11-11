package review.day02;

import java.util.Arrays;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/25 0025 19:42
 */
public class 归并排序 {

    public static void sort(int[] nums, int start, int end){
        if (nums == null || nums.length <= 0) {
            return;
        }
        if (start >= end) {   // 只有一个元素,不用排序，直接返回
            return;
        }
        int mid = (start + end) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);   // 有两个数组，才是归并
    }

    public static void merge(int[] nums, int start, int mid, int end){
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {    // 小到大进行排序
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        for (int p = 0; p < temp.length; p++) {
            nums[p + start] = temp[p];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
