package leecode.面试题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wangxi created on 2020/12/20 12:03
 * @version v1.0
 *
 *  https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 *
 *  请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring obj = new LengthOfLongestSubstring();
        String s = "wkefyuiofw123455";
        System.out.println(
                obj.lengthOfLongestSubstring1(s));

        System.out.println(obj.lengthOfLongestSubstring2(s));
    }

    /**
     * 对方法1的优化，但是核心思想没变。
     *      窗口内遇到重复元素，直接跳到重复的下标下一个位置
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() <= 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        String result = "";
        int i = 0;
        int maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                // map里的元素并没有删除操作，因此可能会命中窗口之外的重复元素。因此需要比较i的大小
                i = Math.max(map.get(c), i);
            }
            int curLen = j - i + 1;
            if (curLen > maxLen) {
                maxLen = curLen;
                result = s.substring(i, j + 1);
            }
            map.put(c, j + 1);
        }
        System.out.println(result);
        return maxLen;
    }

    /**
     * 解法1：利用set判定窗口内是否存在重复字符，以及遇到窗口内重复字符i指针直接跳到重复字符+1的索引
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        // 注意：i初始值不能为 -1，要视情况而定
        int i = 0;
        int j = 0;
        String result = "";
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                int curLen = j - i;
                if (curLen > maxLength) {
                    maxLength = curLen;
                    result = s.substring(i, j);
                }

            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        System.out.println(result);
        return maxLength;
    }



}
