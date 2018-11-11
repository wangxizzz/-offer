package day03.part1;

import java.util.Arrays;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/5/28 0028 22:26
 */
public class P21奇数位于偶数前面 {

    /**
     * 时间O(n)
     * @param num 待处理数组
     */
    public static void changeNum(int[] num) {
        if (num == null || num.length <= 0) {
            return;
        }
        int start = 0;
        int end = num.length - 1;
        while (start < end) {
            while (start < end && ((num[start] & 1) == 1)) {  //判断为奇数
                start++;
            }
            while (start < end && (num[end] & 1) != 1) {
                end--;
            }
            if (start < end) {
                int temp = num[start];
                num[start] = num[end];
                num[end] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,7};
        changeNum(num);
        System.out.println(Arrays.toString(num));
    }
}
