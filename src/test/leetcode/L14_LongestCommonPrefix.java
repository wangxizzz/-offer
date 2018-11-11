package test.leetcode;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/14 0014 11:21
 */
public class L14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String s = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(s) != 0) {
                s = s.substring(0, s.length() - 1);
                if (s.isEmpty()) {
                    return "";
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {

    }
}
