package review.day01;

import java.util.Arrays;

/**
 * @Author wangxi
 * @Time 2020/4/5 18:57
 *
 * 如果是小到大排序，本质是构造大根堆的过程
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] num = {3,4,2,6,9,1,0,4,10};
        new HeapSort().sort(num);
        System.out.println(Arrays.toString(num));
    }

    public void sort(int[] nums) {
        for (int i = nums.length / 2 -1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }


        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
    }

    private void adjustHeap(int[] nums, int index, int len) {
        int key = nums[index];
        for (int i = 2 * index + 1; i < len; i = 2 * i + 1) {
            if (i + 1 < len && nums[i] <= nums[i + 1]) {
                i = i + 1;
            }
            if (nums[i] > key) {
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
