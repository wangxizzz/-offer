package demos.算法文章;

/**
 * @Author: wangxi
 * @Description : 问题描述：
 *             假设有一种货币，它有面值为1分、2分、5分和1角的硬币，最少需要多少个硬币来找出K分钱的零钱。
 *
 *             按照贪婪法的思想，需要不断地使用面值最大的硬币。如果找零的值小于最大的硬币值，
 *              则尝试第二大的硬币，依次类推。
 * @Date: 2018/5/26 0026 18:55
 */
public class 硬币找零_贪心算法 {

    public static void function(double money) {
        int onefen = 0; //一分
        int twofen = 0;
        int fivefen = 0;
        int onejiao = 0;
        while (money >= 0.1) {
            onejiao++;
            money -= 0.1;
        }
        while (money >= 0.05) {
            fivefen++;
            money -= 0.05;
        }
        while (money >= 0.02) {
            twofen++;
            money -= 0.02;
        }
        while (money >= 0.01) {
            onefen++;
            money -= 0.01;
        }
        System.out.println("一分的数量：" + onefen);
        System.out.println("二分的数量：" + twofen);
        System.out.println("五分的数量：" + fivefen);
        System.out.println("一角的数量：" + onejiao);
    }

    public static void main(String[] args) {
        function( 1.16);
    }
}
