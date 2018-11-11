package demos.算法文章;

/**
 * @Author: wangxi
 * @Description : 得到钱数的组合
 *  测评网址：https://leetcode-cn.com/problems/coin-change-2/description/
 * @Date: 2018/6/26 0026 16:50
 */
public class 货币找零01 {
    /**
     * 算法解释：用每种硬币去初始化dp数组
     *  先用面值为1去初始化时，dp中每个元素的组合都只有一种，如：dp[3]的组合是3个1
     *
     *  然后再用面值2的去初始化，如：dp[4] = dp[4](用面值1初始化就有结果了) + dp[4 - 2];
     *
     * @param money 输入的钱
     * @return 硬币的组合数
     */
    public static Integer getTimes(int money) {
        int[] kindValues = {1,2,5,10};   //硬币的种类
        int[] dp = new int[money + 1];  //存储的是钱数，比如dp[1]代表是1分钱，dp[5]代表5分钱，即money=5
        dp[0] = 1;    //初始化为1,表示当求dp[1]时，转化为子问题为dp[0]，因为存在1面值币，所以dp[1]等于1，所以dp[0]需要设置为0
        for (int i = 0; i < kindValues.length; i++) {
            for (int j = kindValues[i]; j <= money; j++) {
                dp[j] = dp[j] + dp[j - kindValues[i]];
            }
        }
        return dp[money];
    }

    public static void main(String[] args) {

    }
}
