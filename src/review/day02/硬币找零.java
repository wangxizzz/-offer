package review.day02;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/26 0026 13:43
 */
public class 硬币找零 {

    public static void exchange(int money) {
        int[] values = {1,2,5};
        int[] dp = new int[money + 1];
        for (int i = 0; i < money + 1; i++) {
            dp[i] = money + 1;  // 最大值为money + 1
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= money; i++) {
            for (int j = 0; j < values.length; j++) {
                if (i >= values[j]) {
                    int temp = dp[i - values[j]] + 1;
                    if (temp < dp[i]) {
                        dp[i] = temp;
                    }
                }
            }
        }
        System.out.println(dp[money]);
    }

    public static void main(String[] args) {

    }
}
