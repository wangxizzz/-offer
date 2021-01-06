package leecode.array.二分查找问题.旋转排序数组问题;

/**
 * @author wangxi created on 2020/12/26 17:24
 * @version v1.0
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 *
 * 请找出其中最小的元素。
 *https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        // 列出如下特殊情况
        if (nums.length == 1) {
            return nums[0];
        }
        // 数组没有旋转
        if (nums[right] > nums[left]) {
            return nums[0];
        }
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (mid < nums.length -1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
