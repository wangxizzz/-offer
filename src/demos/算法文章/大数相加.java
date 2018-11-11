package demos.算法文章;

/**
 * @Author: wangxi
 * @Description :  大数相减
 *              参考网址：https://blog.csdn.net/lichong_87/article/details/6860329
 *                      大数相减里面对结果集的处理有点问题。
 *
 * @Date: 2018/5/26 0026 16:35
 */
public class 大数相加 {
    // 测评网址：https://leetcode-cn.com/problems/add-strings/description/
    public static String sum(String num1, String num2) {
        if (num1 == null || num1.length() <= 0 || num2 == null || num2.length() <= 0) {
            return null;
        }
        char[] temp1 = num1.toCharArray();
        char[] temp2 = num2.toCharArray();
        int[] array1 = new int[temp1.length];
        int[] array2 = new int[temp2.length];
        for (int i = 0; i < temp1.length; i++) {
            array1[i] = temp1[i] - '0';
        }
        for (int i = 0; i < temp2.length; i++) {
            array2[i] = temp2[i] - '0';
        }
        int length = array1.length > array2.length ? array1.length : array2.length;
        int[] result = new int[length + 1];
        //先按位相加
        int q = 0;
        int p = 0;
        for (int i = 0; i < length; i++) {
            if (i >= array1.length) {
                q = 0;
            }else {
                q = array1[i];
            }
            if (i >= array2.length) {
                p = 0;
            }else {
                p = array2[i];
            }
            result[i] = p + q;
        }
        //再对结果数组进行处理
        for (int i = result.length - 1; i > 0; i--) {
            result[i -1] = result[i - 1] + result[i] / 10;
            result[i] = result[i] % 10;
        }
        StringBuilder sb = new StringBuilder(result.length);
        for (int i = 0; i < result.length - 1; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "983";
        System.out.println(sum(num1, num2));
    }
}
