package day02;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/5/13 0013 22:38
 */
public class Problem58_error {

    public static String reverseSentence(String s) {
        if (s == null || "".equals(s)) {
            return null;
        }
        //先翻转整个句子
        String s1 = reverse(0, s.length() - 1, s);
        System.out.println(s1);
        return null;
    }

    private static String reverse(int begin, int end, String s) {
        if (s == null || "".equals(s)) {
            return null;
        }
        /**
         * 错误示例，s是个常量，它的值是无法改变的。
         */
        while (begin < end) {
            char b = s.charAt(begin++);
            char e = s.charAt(end--);
            char temp = b;
            b = e;
            e = temp;
        }
        return s;  //最后返回的是依然是I am a student.
    }

    public static void main(String[] args) {
        reverseSentence("I am a student.");
    }
}
