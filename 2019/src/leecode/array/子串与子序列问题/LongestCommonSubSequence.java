package leecode.array.子串与子序列问题;

/**
 * @author wangxi created on 2021/2/27 20:26
 * @version v1.0
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 *
 * https://leetcode-cn.com/problems/longest-common-subsequence/solution/1143-zui-chang-gong-gong-zi-xu-lie-dong-zde2v/
 *
 *  最长公共子序列
 */
public class LongestCommonSubSequence {
    public static void main(String[] args) {
        LongestCommonSubSequence obj = new LongestCommonSubSequence();
        int res = obj.longestCommonSubsequence("abcde", "ace");

        System.out.println(res);
    }


    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() <= 0 || text2 == null || text2.length() <= 0) {
            return 0;
        }
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i <= text1.length(); i++) {
            // i, j 之前的最长子序列
            for (int j = 0; j <= text2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    // i, j 之前的最长子序列
                    char c1 = text1.charAt(i - 1);
                    char c2 = text2.charAt(j - 1);
                    if (c1 == c2) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
