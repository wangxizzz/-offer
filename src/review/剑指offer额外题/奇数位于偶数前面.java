package review.剑指offer额外题;

import java.util.Arrays;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/10 0010 13:15
 */
public class 奇数位于偶数前面 {

    public static void function(int[] num){
        //检查鲁棒性
        if (num == null || num.length <= 0) {
            return;
        }
        int temp = num[0];
        int start = 0;
        int end = num.length - 1;
        while (start < end){
            while (start < end && (num[end] & 1) == 0) {
                end--;
            }
            num[start] = num[end];
            while (start < end && (num[start] & 1) == 1){
                start++;
            }
            num[end] = num[start];
        }
        num[end] = temp;
    }
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,56,23,21,44,46};
        function(num);
        System.out.println(Arrays.toString(num));
    }
}
