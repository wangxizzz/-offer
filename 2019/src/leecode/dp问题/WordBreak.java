package leecode.dp问题;

import java.util.List;

/**
 * @author wangxi created on 2021/1/18 00:13
 * @version v1.0
 * https://leetcode-cn.com/problems/word-break/
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"
 *
 */
public class WordBreak {
    public static void main(String[] args) {

    }


    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() <= 0 || wordDict.size() <= 0) {
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
