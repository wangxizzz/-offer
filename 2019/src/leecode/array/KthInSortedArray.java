package leecode.array;

/**
 * @Author wangxi
 * @Time 2019/10/27 18:20
 * 在两个排序数组寻找中位数
 * https://www.cnblogs.com/grandyang/p/4465932.html
 */
public class KthInSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
            int len2 = nums2.length;
            /**
             * 利用小技巧，不用区分len1+len2的奇偶
             */
            int left = (len1 + len2 + 1) / 2;
            int right = (len1 + len2 + 2) / 2;
            // 找到合并后的第left个元素
            int leftValue = findKthSortedArrays(nums1, 0, nums2, 0, left);
            int rightValue = findKthSortedArrays(nums1, 0, nums2, 0, right);
            return (leftValue + rightValue) / 2.0;
        }
        // 避免数组的拷贝，所以利用两个初始指针
    public int findKthSortedArrays(int[] nums1, int i, int[] nums2, int j, int k) {
        // 处理边界条件
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        // 寻找合并后第一个数
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        // 分别在两个数组找是否有k/2的元素。递归的参数一定要带上
        int midVal1 = (i + k / 2 - 1 >= nums1.length) ? Integer.MAX_VALUE : nums1[i + k / 2 - 1];
        int midVal2 = (j + k / 2 - 1 >= nums2.length) ? Integer.MAX_VALUE : nums2[j + k / 2 - 1];
        if (midVal1 > midVal2) {
            return findKthSortedArrays(nums1, i, nums2, j + k/2, k - k/2);
        } else {
            return findKthSortedArrays(nums1, i + k / 2, nums2, j, k - k/2);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {-1,3};
        System.out.println(new KthInSortedArray().findMedianSortedArrays(nums1, nums2));
    }
}
