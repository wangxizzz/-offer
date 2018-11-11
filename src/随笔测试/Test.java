package 随笔测试;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/9/7 0007 16:14
 */
public class Test {
    public static void main(String[] args) {
        String s = new String("aa");
        s = s.intern();
        String s1 = "aa";
        System.out.println(s == s1);
    }
}
