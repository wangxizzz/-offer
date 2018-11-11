package day03.part1;

/**
 * @Author: wangxi
 * @Description : p103
 * @Date: 2018/5/27 0027 13:26
 */
public class P15_2位运算 {

    public static boolean ispow(int n) {
        return ((n & (n - 1)) == 0 ? true : false);
    }

    public static void main(String[] args) {
        System.out.println(ispow(42));
    }
}
