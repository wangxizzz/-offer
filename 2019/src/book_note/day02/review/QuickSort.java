package book_note.day02.review;

import java.util.Arrays;

/**
 * @author wangxi created on 2021/1/3 20:10
 * @version v1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        int[] nums = {5,4,3,2,1};

        quickSort.sort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    private void sort(int[] nums, int left, int right) {
        // 递归退出的条件1
        if (nums == null || nums.length <= 0) {
            return;
        }
        // 递归退出的条件2
        if (left >= right) {
            return;
        }
        int mid = partition(nums, left, right);
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int key = nums[left];
        while (left < right) {
            while (left < right && nums[left] <= key) {
                left++;
            }
            while (left < right && nums[right] >= key) {
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        nums[left] = key;

        return left;
    }
}
