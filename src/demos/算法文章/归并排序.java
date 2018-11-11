package demos.算法文章;

import java.util.Arrays;

/**
 * @Author: wangxi
 * @Description : 时间复杂度O(nlongn),空间复杂度是O(n),是一种稳定的排序
 *              更多注释：参考网址：https://www.cnblogs.com/of-fanruice/p/7678801.html
 * @Date: 2018/7/24 0024 22:27
 */
public class 归并排序 {
    public static void sort(int[] num, int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {   // 分治法划分若干小数组的条件
            sort(num, start, mid);
            sort(num, mid + 1, end);
            merge(num, start, mid, end);
        }
    }
    public static void merge(int[] num, int start, int mid, int end){
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int count = 0;
        while (i <= mid && j <= end) {    // 小到大进行排序
            if (num[i] >= num[j]) {
                temp[count++] = num[j];
                j++;
            }else {
                temp[count++] = num[i];
                i++;
            }
        }
        while (i <= mid) {
            temp[count++] = num[i++];
        }
        while (j <= end){
            temp[count++] = num[j++];
        }
        for (int x = 0; x < temp.length; x++) {
            num[x + start] = temp[x];
        }
    }

    public static void main(String[] args) {
        int[] nums = {6,5,4,3,2,1,10,0};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
