package leecode.array.子串与子序列问题;

/**
 * @Author wangxi
 * @Time 2020/4/30 21:37
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * 这道题 其实是采用的滑动窗口的思想
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return -1;
        }
        int[] num = new int[128];
        for (int i = 0; i < num.length; i++) {
            num[i] = -1;
        }
        int i = 0;
        int temp = 0;
        int curLen = 0;
        int maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            if (num[s.charAt(j)] == -1 || j - num[s.charAt(j)] > curLen) {
                curLen++;
                if (curLen > maxLen) {
                    maxLen = curLen;
                    // 这里是确认最终的滑动窗口的初始索引，只有curLen > maxLen，初始索引才变化
                    i = temp;
                }
            } else {
                // 从当前窗口截断一部分
                curLen = j - num[s.charAt(j)];
                // 这里是最终的滑动窗口的初始索引可能发生变化的地方
                temp = j;
            }
            num[s.charAt(j)] = j;
        }
        System.out.println(s.substring(i, i + maxLen));
        return maxLen;
    }


    public static void main(String[] args) {
        LongestSubstring l = new LongestSubstring();
        System.out.println(l.lengthOfLongestSubstring("wkeffw123455"));
    }
}
