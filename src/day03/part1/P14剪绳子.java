package day03.part1;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/5/26 0026 10:29
 */
public class P14剪绳子 {

    /**
     * 采用动态规划  O(n*n)
     * @param length 绳子长度
     * @return  乘积最大值
     */
    public static int max1(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        //定义存储最优子问题的数组
        int[] result = new int[length + 1];
        /**
         * 注意：子问题是为后面的大问题服务的（而不是真正的返回值）。
         *  例如求length = 5，就需要length = 1和length = 4的最优解。
         下面的写法是错误的
        result[0] = 0;
        result[1] = 0;
        result[2] = 1;
        result[3] = 2;
         */
        // 数组中第i个元素表示把长度为i的绳子剪成若干段之后的乘积的最大值
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        for (int i = 4; i <= length; i++) {
            int max = 0;
            //j代表切的绳子的长度。从1开始
            for (int j = 1; j <= i/2; j++) {
                int temp = result[j] * result[i - j];
                if (temp > max) {
                    max = temp;
                }
            }
            result[i] = max;  //把最优子问题存入数组
        }
        return result[length];
    }

    /**
     * 采用贪心算法
     * @param length
     * @return
     */
    public static int max2(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        // 当n>=5的时候，尽可能剪长度为3的绳子
        int timesOf3 = length / 3;
        // 当n=4的时候，剪成长度为2的两段
        if ((length - timesOf3 * 3) == 1) {
            timesOf3 -= 1;
        }
        // 剪成长度为2的两段
        int timesOf2 = (length - timesOf3 * 3) / 2;

        return (int)(Math.pow(3, timesOf3)) * (int)(Math.pow(2, timesOf2));
    }

    public static void main(String[] args) {
        System.out.println(max1(8)); //动态规划
        System.out.println(max2(8)); //贪心算法
    }
}
