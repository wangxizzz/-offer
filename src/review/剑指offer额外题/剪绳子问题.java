package review.剑指offer额外题;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/10 0010 12:02
 */
public class 剪绳子问题 {

    public static int maxSum(int length){
        // 一下只有一种切法的直接返回
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= length; i++) {
            for (int j = 0; j <= i/2; j++) {
                int temp = dp[j] * dp[i - j];
                if (temp > dp[i]) {
                    dp[i] = temp;
                }
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        System.out.println(maxSum(8));
    }
}
