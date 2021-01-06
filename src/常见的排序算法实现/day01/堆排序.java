package 常见的排序算法实现.day01;

import java.util.Arrays;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/25 0025 21:16
 * https://www.javazhiyin.com/57579.html
 * 堆排序是一种选择排序，堆排序由两部分构成：
 * 1.构建初始堆
 * 2.交换堆顶元素和末尾元素并重建堆。
 *
 * 堆是具有以下性质的完全二叉树：每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆；
 * 或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆
 *
 * 要使用堆排序，必须先要满足堆的性质，因此会有先构建堆的步骤。
 */
public class 堆排序 {
    // 不稳定排序，时间复杂度O(nlongn)
    public static void sort(int[] arr) {
        //1.构建大顶堆 (从下往上构建大根堆)
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素 (从上往下 进行堆调整)
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);//重新对堆进行调整
        }

    }

    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {   // 注意for循环：递归把最大节点提上来(最小堆)
            //从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                //如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (arr[k] > temp) {
                //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终合适的位置
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 4, 3, 2, 1, 8};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
