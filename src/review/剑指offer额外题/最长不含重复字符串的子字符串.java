package review.剑指offer额外题;

/**
 * @Author: wangxi
 * @Description : Problem48  P236
 * @Date: 2018/8/10 0010 13:33
 */
public class 最长不含重复字符串的子字符串 {

    public static int findSubString(String s){
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        int maxLength = 0;
        int curLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == -1) {
                curLength = curLength + 1;
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
            }else{
                int lastIndex = map[s.charAt(i)];
                if (i - lastIndex > maxLength) {
                    curLength += 1;
                    if (curLength > maxLength) {
                        maxLength = curLength;
                    }
                }else{
                    curLength = i - lastIndex;
                    if (curLength > maxLength) {
                        maxLength = curLength;
                    }
                }
            }
            // 更新字符最后出现的位置
            map[s.charAt(i)] = i;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findSubString("arabcacfr"));
    }
}
