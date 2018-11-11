package review.day02;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/25 0025 20:22
 */
public class 大数相乘 {

    public static void multiple(String s1, String s2){
        if (s1 == null || s1.length() <= 0 || s2 == null || s2.length() <= 0) {
            return;
        }
        int[] res = new int[s1.length() + s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                int a = s1.charAt(i) - '0';
                int b = s2.charAt(j) - '0';
                res[i + j] = res[i + j] + a * b;
            }
        }
        int carry = 0;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = res[i] + carry;
            carry = res[i] / 10;
            res[i] = res[i] % 10;
        }
        StringBuilder sb = new StringBuilder();
        if (carry >= 1) {
            sb.append(carry);
        }
        for (int i = 0; i < res.length - 1; i++) {
            sb.append(res[i]);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        String s1 = "14";
        String s2 = "13";
        multiple(s1, s2);

    }
}
