package review.day02;

import java.util.Arrays;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/25 0025 19:58
 */
public class 快排 {
    /*
        快速排序的时间复杂度在最坏情况下是O(N2)，平均的时间复杂度是O(N*lgN)。

        这句话很好理解：假设被排序的数列中有N个数。遍历一次的时间复杂度是O(N)，需要遍历多少次呢？
        至少lg(N+1)次，最多N次。

        (01) 为什么最少是lg(N+1)次？快速排序是采用的分治法进行遍历的，我们将它看作一棵二叉树，
        它需要遍历的次数就是二叉树的深度，而根据完全二叉树的定义，它的深度至少是lg(N+1)。
        因此，快速排序的遍历次数最少是lg(N+1)次。

        (02) 为什么最多是N次？这个应该非常简单，还是将快速排序看作一棵二叉树，它的深度最大是N。
        因此，快读排序的遍历次数最多是N次。
     */
    public static void sort(int[] nums, int start, int end){
        if (nums == null || nums.length <= 0) {
            return;
        }
        if (start >= end) {
            return;
        }
        int index = partition(nums, start, end);
        sort(nums, start, index);
        sort(nums, index + 1, end);
    }

    public static int partition(int[] nums, int start, int end){
        int key = nums[start];
        while (start < end) {  // 小到大排序
            while (start < end && nums[end] >= key){
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= key) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[end] = key;
        return end;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,1};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
