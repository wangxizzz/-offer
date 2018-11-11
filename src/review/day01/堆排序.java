package review.day01;

import java.util.Arrays;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/9 0009 22:02
 */
public class 堆排序 {

    public static void sort(int[] num){
        if (num == null) {
            return;
        }
        int length = num.length;
        for (int i = length/2 - 1; i >= 0; i--) {
            adjust(num, i, length);
        }
        // 堆顶元素与最后一个元素交换
        for (int i = length - 1; i >= 0; i--) {
            swap(num, 0, i);
            adjust(num, 0, i);
        }
    }

    private static void adjust(int[] num, int i, int length){
        int temp = num[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if ((k + 1) < length && num[k + 1] > num[k]) {
                k = k + 1;
            }
            if (num[k] > temp) {
                num[i] = num[k];
                i = k;
            }else{
                break;
            }
        }
        num[i] = temp;
    }

    private static void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {
        int[] num = {9,8,7,6,5,4,3,2,1};
        sort(num);
        System.out.println(Arrays.toString(num));
    }
}
