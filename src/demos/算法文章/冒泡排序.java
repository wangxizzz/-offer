package demos.算法文章;

import java.util.Arrays;

/**
 * @Author:王喜
 * @Description :冒泡排序稳定性
冒泡排序是稳定的算法，它满足稳定算法的定义。

算法稳定性 -- 假设在数列中存在a[i]=a[j]，若在排序之前，a[i]在a[j]前面；
并且排序之后，a[i]仍然在a[j]前面。则这个排序算法是稳定的！
 * @Date: 2018/5/25 0025 19:26
 */
public class 冒泡排序 {

    /**
     * 它是一种较简单的排序算法。它会遍历若干次要排序的数列，
     * 每次遍历时，它都会从前往后依次的比较相邻两个数的大小；如果前者比后者大，则交换它们的位置。
     * 这样，一次遍历之后，最大的元素就在数列的末尾！ 采用相同的方法再次遍历时，
     * 第二大的元素就被排列在最大元素之前。重复此操作，直到整个数列都有序为止！
     */

    //优化的冒泡排序
    public static void sort(int[] array) {
        if (array == null || array.length <= 0) {
            return;
        }
        boolean flag = false;  //定义需要冒泡标志
        int n = array.length;
        for (int i = 1; i < n; i++) {
            flag = true;
            for (int j = 1; j <= n - i; j++) {   //j需要比较n-i次
                if (array[j] < array[j - 1]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    flag = false;
                }
            }
            if(flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] num = {9,8,7,6,5,4,3,2,1};
        sort(num);
        System.out.println(Arrays.toString(num));
    }
}
