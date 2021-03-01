package leecode.array.二分查找问题.旋转排序数组问题;

/**
 * @author wangxi created on 2020/12/21 00:08
 * @version v1.0
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
 *
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 数组中无重复元素
 *
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            }

            // 注意考虑等号的情况，考虑 target == 边界的数字。
            if (nums[mid] >= nums[0]) {
                // 以index = 0 与 index = nums.length - 1 为参照，判断target所在的升序序列
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[nums.length - 1] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
