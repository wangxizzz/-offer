package review.day02;

import java.util.Arrays;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/25 0025 16:15
 */
public class 堆排序 {

    public static void sort(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        int length = nums.length;
        // 找到最后一个非叶子节点
        for (int i = length / 2 - 2; i >= 0; i--) {
            adjustHeap(nums, i, length);
        }
        for (int i = length - 1; i >= 0; i--) {
            swap(nums, 0, i);  // 每次都是交换堆顶元素和末尾元素
            adjustHeap(nums, 0, i);
        }
    }

    public static void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];
        for (int k = 2 * i + 1; k < length; k = 2*k + 1) {
            if (k + 1 < length && nums[k + 1] > nums[k]) {
                k = k + 1;
            }
            if (nums[k] > temp) {
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
        }
        nums[i] = temp;
    }

    public static void swap(int[] nums, int i, int j) {
        int val = nums[i];
        nums[i] = nums[j];
        nums[j] = val;
    }
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
