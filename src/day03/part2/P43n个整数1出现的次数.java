package day03.part2;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/2 0002 20:15
 */
public class P43n个整数1出现的次数 {
    /**
     * 时间复杂度O(nlongn)有优化的算法
     * @param n
     * @return
     */
    public static int getNumOf1ToN(int n) {
        if (n <= 0) {
            return -1;
        }
        int number = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp != 0) {
                if (temp % 10 == 1) {
                    number++;
                }
                temp = temp / 10;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(getNumOf1ToN(10));
    }
}
