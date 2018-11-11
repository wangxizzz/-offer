package 随笔测试;

import java.util.*;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/10 0010 22:10
 */
public class A {

    public static boolean isPowerOfFour(int num) {
        int zero = 0;
        int one = 0;
        while (num != 0) {
            int a = num & 1;
            if (a == 0) {
                zero++;
            } else if (a == 1) {
                one++;
            }
            num = num >>> 1;
        }
        if (one == 1 && (zero & 1) == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(Integer.MIN_VALUE));
    }
}
