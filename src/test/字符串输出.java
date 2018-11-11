package test;

/**
 * @Author: wangxi
 * @Description : 0002 --> 2
 * @Date: 2018/5/27 0027 15:00
 */
public class 字符串输出 {

    public static void print(String s) {
        if (s == null || s.length() <= 0) {
            return;
        }
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                flag = true;
            }
            if (flag) {
                System.out.print(s.charAt(i) + "  ");
            }
        }
    }

    public static void main(String[] args) {
        print("00002333");
    }
}
