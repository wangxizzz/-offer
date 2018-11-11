package demos.算法文章;

/**
 * @Author: wangxi
 * @Description :输入字符串，转成char数组，转成int数组。采用分治思想，每一位的相乘;
 *              leetcode测评：https://leetcode-cn.com/problems/multiply-strings/description/
 *         参考网址：
 * @Date: 2018/5/26 0026 12:40
 */
public class 大数相乘 {
    /**
     * 时间O(n*n)
     * @param num1 数字1
     * @param num2 数字2
     * @return 返回相乘结果String类型
     */
    public static String multiply(String num1, String num2) {
        if (num1 == null || num1.length() <= 0 || num2 == null || num2.length() <= 0) {
            return null;
        }
        char[] temp1 = num1.toCharArray();
        char[] temp2 = num2.toCharArray();
        int[] result = new int[num1.length() + num2.length()];
        int[] array1 = new int[temp1.length];
        int[] array2 = new int[temp2.length];
        for (int i = 0; i < temp1.length; i++) {
            array1[i] = temp1[i] - '0';
        }
        for (int i = 0; i < temp2.length; i++) {
            array2[i] = temp2[i] - '0';
        }
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                result[i+j] += array1[i] * array2[j];
            }
        }
        //从后往前扫描进位（注意：是字符数组相乘）
        int carry = 0;
        int sum = 0;
        for (int i = result.length - 1; i >= 0; i--) {
            sum = result[i] + carry;
            result[i] = sum % 10;
            carry = sum / 10;
        }
        StringBuilder sb = new StringBuilder();
        if (carry > 0) {
            sb.append(carry);
        }
        // 规律
        for (int i = 0; i < result.length - 1; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }

}
