package day03.part2;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/8 0008 21:45
 */
public class P58_2左旋转字符串 {

    public static String reverseLeft(String str, int n) {
        if (str == null || "".equals(str) || n <= 0 || n > str.length()) {
            return "";
        }
        char[] temp = str.toCharArray();
        reverseString(temp, 0, n - 1);
        reverseString(temp, n, str.length() - 1);
        reverseString(temp, 0, str.length() - 1);
        return String.valueOf(temp);
    }

    private static void reverseString(char[] num, int start, int end) {
        while (start < end) {
            char temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseLeft("abcdefg", 2));
    }
}
