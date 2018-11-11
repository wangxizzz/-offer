package demos.算法文章;

import java.util.Arrays;

/**
 * @Author: wangxi
 * @Description :不稳定排序，它的最坏，最好，平均时间复杂度均为O(nlogn)
 *     时间复杂度分析：构建堆的的过程的时间复杂度为n，调堆时间复杂度为logn
 *
 *      堆是具有以下性质的完全二叉树：
 *          每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆；
 *          或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆
 * @Date: 2018/5/25 0025 21:07
 */
public class 堆排序 {
    /*
    注意，书上描述的是最大堆，我们代码实现的是最小堆
    1、将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;

    2、将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;

    3、重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
     */
    public static void sort(int[] array) {
        if (array == null || array.length <= 0) {
            return;
        }
        for (int i = array.length/2 - 1; i >= 0; i--) {
            //从最后一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(array, i, array.length);
        }
        //开始交换堆顶元素与尾节点
        for (int j = array.length - 1; j >= 0; j--) {
            swap(array, 0, j);  //堆顶元素始终是0号元素
            adjustHeap(array, 0, j);  //j 代表还需要排序的元素长度
        }
    }

    /**
     * 对堆进行调整，使满足堆的性质
     * @param array 待排序的数组
     * @param i  待调整子树的根节点
     * @param length  需要排序数组的长度（除去已经排好序部分的长度）
     */
    private static void adjustHeap(int[] array, int i, int length) {
        int temp = array[i];
        for (int k = 2*i + 1; k < length; k = k*2+1) {
            if ((k + 1) < length && array[k] < array[k+1]) {  //维持最大堆
                k = k + 1;
            }
            if (array[k] > temp) {
                array[i] = array[k];
                i = k;
            }else {   // 一旦叶子节点小于等于根节点，说明此时根节点是最大的。
                break;
            }
        }
        array[i] = temp;
    }

    /**
     *
     * @param array 原数组
     * @param a 堆顶元素
     * @param b  末尾元素
     */
    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        int[] num = {9,8,7,6,5,4,3,2,1};
        sort(num);
        System.out.println(Arrays.toString(num));
    }
}
