package day03.part1;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/5/26 0026 19:19
 */
public class P15_1二进制1的个数 {
    /**
     * 统计整数n的二进制1的个数 (考虑n为负数的情况)
     *  最佳解法：时间复杂度与1的个数相同
     * @param n
     * @return
     */
    public static int getNum1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    /**
     * 常规解法：时间复杂度为32次
     * @param n
     * @return
     */
    public static int getNum2(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getNum1(5));
        System.out.println(getNum2(5));
    }
}
