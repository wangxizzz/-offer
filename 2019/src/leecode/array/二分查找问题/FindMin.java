package leecode.array.二分查找问题;

/**
 * @Author wangxi
 * @Time 2020/2/18 21:09
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
 *
 * 利用二分查找 找到 旋转数组的最小值
 */
public class FindMin {

    /**
     * 关于二分查找：
     *
     * 首先需要是有序的序列。
     *
     * 1.退出while循环的条件：带等号的 意味着当right==left时，mid代表的元素是否可以标志while循环结束，
     * 而不会陷入死循环。比如排序的二分查找，需要带上等号，因为mid代表的元素如果和被查找的元素相等，那么即可返回。
     * 但是就此题而言，带上等号就会陷入死循环，因为mid标志的元素并不会结束while循环。
     * 所以，可以朝着此方向来判断是否带等号。
     *
     * 2.left=mid + 1 还是 left = mid ?
     * 这要看 mid代表的元素是不是可以根据题目条件排除掉。比如排序的二分查找，nums[mid]如果不等于target，那么
     * left = mid + 1，因为mid这个元素已经可以排除了，没必要left=mid导致后面在判断一次mid!=target。
     * 再比如这个题，无法排除nums[mid]是否满足题目要求，因此无法排除，因此需要left=mid,再做后续的判断。
     */

    public static int findMin(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
