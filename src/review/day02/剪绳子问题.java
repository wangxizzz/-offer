package review.day02;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/25 0025 21:08
 */
public class 剪绳子问题 {

    // 绳子可以剪成很多段，得到很多段的乘积最大值。
    public static int getLength(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;  // 需要验证数组的长度。
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i/2; j++) {
                int temp = dp[j] * dp[i - j];
                if (temp > max){
                    max = temp;
                }
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(getLength(8));
    }
}
