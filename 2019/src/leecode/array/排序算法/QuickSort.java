package leecode.array.排序算法;

/**
 * @author wangxi created on 2021/3/2 23:56
 * @version v1.0
 *
 * 算法思想：
 *   基于分治的思想，是冒泡排序的改进型。
 *   首先在数组中选择一个基准点（该基准点的选取可能影响快速排序的效率，后面讲解选取的方法），
 *   然后分别从数组的两端扫描数组，设两个指示标志（lo指向起始位置，hi指向末尾)，
 *   首先从后半部分开始，如果发现有元素比该基准点的值小，
 *   就交换lo和hi位置的值，然后从前半部分开始扫秒，发现有元素大于基准点的值，
 *   就交换lo和hi位置的值，如此往复循环，直到lo>=hi,然后把基准点的值放到hi这个位置。
 *   一次排序就完成了。以后采用递归的方式分别对前半部分和后半部分排序，
 *   当前半部分和后半部分均有序时该数组就自然有序了。
 *
 * https://leetcode-cn.com/problems/sort-an-array/
 *
 */
public class QuickSort {
    public int[] MySort (int[] arr) {
        // write code here
        if (arr == null || arr.length <= 0) {
            return arr;
        }
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    private void sort(int[] arr, int left, int right) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        if (left >= right) {
            return;
        }
        int index = partition(arr, left, right);
        sort(arr, left, index);
        sort(arr, index + 1, right);
    }
    // 严格按照快排的思想进行编码,并不是数组元素简单对调
    private int partition(int[] arr, int left, int right) {
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[right] = key;
        return right;
    }
}
