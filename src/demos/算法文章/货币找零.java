package demos.算法文章;

/**
 * @Author: wangxi
 * @Description : 动态规划解法  此方法是得到该money找零所需的最少硬币的数量
 *  测评网址：https://leetcode-cn.com/problems/coin-change/description/
 *
 *                  参考网址：https://blog.csdn.net/m0_37561165/article/details/81061425
 *                           https://blog.csdn.net/you12345678901234567/article/details/8130804
 * @Date: 2018/6/26 0026 14:58
 */
public class 货币找零 {

    //递推式为：dp[i] = dp[i - coins[j]] + 1

    public static void makeChange(int money, int[] kindValues) {
        int[] res = new int[money + 1];    //存的是没分钱的最优解。（硬币的最少数）
        for (int i = 0; i < res.length; i++) {
            res[i] = money + 1;
        }
        int[] track = new int[money + 1];  //保存每个硬币最优解的路径
        res[0] = 0;  //填表  ，为数组第一个元素初始化,可以代入dp[2],dp[3]就可以知道为什么dp[0]=0,此时的面值可以设置为{1,2,5}进行代入实验
        for (int i = 1; i <= money; i++) {
            int last = 0;
            for (int j = 0; j < kindValues.length; j++) {
                if (i >= kindValues[j]) {
                    /**
                     * 下面代码解释：
                     * 如果有1,2,5分的硬币，此时money=8,找零?
                     * => dp[7] + 1, 加一的目的是dp[7]的最优解 + 1分就可以为8分了，其他类推
                     */
                    int temp = res[i - kindValues[j]] + 1;  //利用子问题求解
                    if (temp < res[i]) {
                        res[i] = temp;
                        last = j;
                    }
                }
            }
            track[i] = kindValues[last];

        }
        if (res[money] >= money + 1) {    // 没钱找散时
            return;
        }
        System.out.println("所需硬币最少是：" + res[money]);
        printTrack(money, track);
    }
    //输出硬币的具体值路径（也是子问题）
    private static void printTrack(int money, int[] track) {
        if (money == 0) {
           return;
        }else {
            System.out.print(track[money] + " ");
            printTrack(money - track[money], track);
        }
    }

    // AC解法
    public static int coinChange1(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        for(int i=1;i<amount+1;i++)
            dp[i]=1000;
        dp[0]=0;
        for(int i=0;i<=amount;i++)
        {
            for(int j=0;j<coins.length;j++)
            {
                if(i-coins[j]>=0)
                    if(dp[i]>dp[i-coins[j]]+1)
                        //如果想输出相应的硬币金额，可以在这个if下面存储相应的值
                        dp[i]=dp[i-coins[j]]+1;
            }
        }
        if(dp[amount]>=1000)
            return -1;
        else
            return dp[amount];
    }

    public static void main(String[] args) {
        int[] kindValues = {1,2,5,25};
        int money = 20;
        makeChange(money, kindValues);


    }
}
