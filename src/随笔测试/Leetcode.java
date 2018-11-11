package 随笔测试;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/9 0009 20:23
 */
public class Leetcode {

    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length <= 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];   // 存的是没分钱的最优解。（硬币的最少数）
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;
        }
        int min = 0;
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            min = i;   // 肯定要被替换的，否则题目没有意义
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    int temp = dp[i - coins[j]] + 1;
                    if (temp < min) {
                        min = temp;
                    }
                }
            }
            dp[i] = min;
        }
        if (dp[amount] >= amount) {
            return -1;
        }
        return dp[amount];
    }

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
        int[] coins ={2};
        System.out.println(coinChange1(coins, 3));
    }
}
