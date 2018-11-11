package day03.part2;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/4 0004 19:33
 */
public class P48不含重复字符的最长子串 {
    /**
     * //注意：此题的前提条件是字符串中只包含a - z字符,空间O(1)
     *  时间O(n)
     * @param str
     * @return
     */
    public static Integer getMaxSubString(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int[] temp = new int[26];  //保存每个字母上次出现在字符串的位置
        for (int i = 0; i < 26; i++) {
            temp[i] = -1;
        }
        int maxLength = 0;
        int curLength = 0;
        for (int i = 0; i < str.length(); i++) {  //i表示每个字符的位置
            int prePosition = temp[str.charAt(i) - 'a']; //每次来一个字符先判断是否在字符前面的字符出现过
            //如果字符在这之前没有出现过(表示为prePosition=-1,或者出现了，但是距离大于curLength)
            if (prePosition < 0 || (i - prePosition) > curLength) {
                curLength++;
            }else {

                if (curLength > maxLength) {
                    maxLength = curLength;
                }
                curLength = i - prePosition;  //当前长度在变化之前，如果大需要保存
            }
            temp[str.charAt(i) - 'a'] = i;
        }
        if (curLength < maxLength) {
            maxLength = curLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(getMaxSubString("arabcacfr"));
    }
}
