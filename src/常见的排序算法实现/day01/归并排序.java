package 常见的排序算法实现.day01;

import java.util.Arrays;

/**
 * @Author:王喜
 * @Description :  注意可能会遇到合并两个有序链表
 * @Date: 2018/5/6 0006 14:02
 */
public class 归并排序 {

    public static void sort(int[] a,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            sort(a,low,mid);
            sort(a,mid+1,high);
            //左右归并
            merge(a,low,mid,high);
        }
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];  //创建一个临时数组
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        k = 0;
        while (low <= high) {
            a[low++] = temp[k++];
        }
    }
    public static void main(String[] args) {
        int[] num = {9,8,7,6,5,4,3,2,1};
        sort(num, 0, num.length - 1);
        System.out.println(Arrays.toString(num));
    }
}
