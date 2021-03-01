package leecode.array.子串与子序列问题;

/**
 * @author wangxi created on 2021/2/27 21:32
 * @version v1.0
 *
 * https://www.nowcoder.com/practice/f33f5adc55f444baa0e0ca87ad8a6aac?tpId=188&tqId=37540&rp=1&ru=%2Fta%2Fjob-code-high-week&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 *
 * 本题要求是求【最长公共子串】，
 * 区别在于前者的子序列指的是【原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）
 * 后组成的新字符串】，本题的【最长公共子串】中的子串指的是连续子序列。
 */
public class LongestCommonSubstring {

    /**
     * 区别在于leetcode 1143这道题是求【最长公共子序列】的数目，本题要求是求【最长公共子串】，
     * 区别在于前者的子序列指的是【原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）
     * 后组成的新字符串】，本题的【最长公共子串】中的子串指的是连续子序列。
     *
     * 本题区别在于如果 str1[i-1] != str2[j-1]说明不是连续的子串，那么不做处理，
     * 只处理str1[i-1] == str2[j-1]的情况，使用maxlen记录最长的连续子串的长度，index记录最长连续子串末尾的序号:
     */

    public String LCS (String str1, String str2) {
        // write code here
        if (str1 == null || str1.length() <= 0 || str2 == null || str2.length() <= 0) {
            return "";
        }
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int maxLen = 0;
        int index = 0;
        // 注意带上等号，语义表示 i,j之前的最长子串的长度
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    char c1 = str1.charAt(i - 1);
                    char c2 = str2.charAt(j - 1);
                    if (c1 == c2) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        if (dp[i][j] > maxLen) {
                            maxLen = dp[i][j];
                            index = i;
                        }
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }
        return str1.substring(index - maxLen, index);
    }
}
