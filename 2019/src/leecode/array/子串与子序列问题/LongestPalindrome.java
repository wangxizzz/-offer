package leecode.array.子串与子序列问题;

/**
 * @Author wangxi
 * @Time 2020/5/1 13:33
 * 最长回文子串, 利用中心扩散法，时间复杂度O(n*n)
 * https://leetcode-cn.com/problems/longest-palindromic-substring
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = extendFromCenter(s, i, i);
            // 偶数情况
            int len2 = extendFromCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                // 偶数，需要(len - 1)
                start = i - (len - 1)/2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int extendFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 当条件不满足时，会走到这里来
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
    }
}
