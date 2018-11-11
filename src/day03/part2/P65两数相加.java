package day03.part2;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/10 0010 21:52
 */
public class P65两数相加 {

    public static int sum(int num1, int num2) {
        int sum = 0;
        int carry = 0;
        while (num2 != 0) {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(sum(1, 2));
    }
}
