package 常见的排序算法实现.day01;

import java.util.Arrays;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/25 0025 21:16
 */
public class 堆排序 {
    // 不稳定排序，时间复杂度O(nlongn)
    public static void sort(int[] nums){
        if (nums == null || nums.length <= 0) {
            return;
        }
        // 首先对整个数组进行调整
        for (int i = (nums.length / 2) - 1; i >= 0; i--) {  // 找到第一个非叶子节点
            adjustHeap(nums, i, nums.length);
        }
        // 对未排好序的部分进行调整
        for (int j = nums.length - 1; j >= 0; j--) {
            swap(nums, 0, j);   // 每次第一个元素（也是二叉树的root节点）是最大的元素
            adjustHeap(nums, 0, j);  // j表示待调整数据的长度
        }
    }
    public static void adjustHeap(int[] nums, int start, int length){
        int temp = nums[start];   // 保存root节点，因为这个节点的值可能需要与其他值交换
        for (int k = 2*start + 1; k < length; k++) {   // 从根节点的左叶子节点开始比较
            if (k + 1 < length && nums[k + 1] > nums[k]) {
                k++;
            }
            if (nums[k] > temp) {
                nums[start] = nums[k];
                start = k;
            }else{
                break;
            }
        }
        nums[start] = temp;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int[] nums = {5,6,4,3,2,1,8};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
