package review.day02;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/25 0025 20:51
 */
public class 最长不含重复字符的子串 {

    public static void getLength(String s){
        if (s == null || s.length() <= 0) {
            return;
        }
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        int curLength = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == -1) {
                curLength += 1;
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
            } else {
                if (i - map[s.charAt(i)] > curLength) {
                    curLength += 1;
                    if (curLength > maxLength) {
                        maxLength = curLength;
                    }
                } else {
                    curLength = i - map[s.charAt(i)];
                    if (curLength > maxLength) {
                        maxLength = curLength;
                    }
                }
            }
            // 更新数组内容
            map[s.charAt(i)] = i;
        }
        System.out.println(maxLength);
    }

    public static void main(String[] args) {
        getLength("babcda");
    }
}
