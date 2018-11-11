package day03.part2;

/**
 * @Author: wangxi
 * @Description :  如果两个字符串，组成的字符相同，并且字符出现的个数相同，则互为变位词
 * @Date: 2018/7/4 0004 22:07
 */
public class P50_5单词互为变位词 {

    public static boolean isProper(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        if ("".equals(str1) && "".equals(str2)) {
            return true;
        }
        int[] temp = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            temp[str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            temp[str2.charAt(i)]--;
        }
        for (int i : temp) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isProper("silent", "listen"));
    }
}
