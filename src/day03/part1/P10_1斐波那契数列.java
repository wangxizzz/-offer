package day03.part1;

/**
 * @Author:王喜
 * @Description :斐波那契数列 ,求第n项的值
 * @Date: 2018/5/24 0024 13:39
 */
public class P10_1斐波那契数列 {
    /**
     * 自下而上的解法 O(n)
     * @param n
     * @return
     */
    public static int getN(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int temp1 = 0;
        int temp2 = 1;
        int tempN = 0;
        /**
         * 可以根据f(4)具体判断，i = 2是因为n需要从2开始
         */
        for (int i = 2; i <= n; i++) {
            tempN = temp1 + temp2;
            temp1 = temp2;
            temp2 = tempN;
        }
        return tempN;
    }

    /**
     * 递归，存在大量的重复计算
     * @param n
     * @return
     */
    public static int getByRecursive(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return getByRecursive(n - 1) + getByRecursive(n - 2);
    }
    public static void main(String[] args) {
        System.out.println(getByRecursive(10));
        System.out.println(getN(10));
    }
}
