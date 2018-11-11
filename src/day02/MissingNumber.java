package day02;

/**
 * @Author:王喜
 * @Description :  面试53 题目二
 * @Date: 2018/4/25 0025 22:32
 */
public class MissingNumber {

    /**
     * 在一个递增排序的数组中，找到0~n-1中缺失的唯一一个数字
     * 排序数组：二分查找  参照书上的解题思路
     * @param nums
     * @return
     */
    public static int getMissingNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == mid) {
                left = mid + 1;
            }else if (mid == 0 || (nums[mid] != mid && nums[mid - 1] == mid - 1)) {
                return mid;
            } else if (nums[mid] != mid && nums[mid - 1] != mid - 1) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        System.out.println(getMissingNumber(nums));
    }
}
