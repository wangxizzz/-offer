package day02;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/5/18 0018 10:46
 */
public class Problem65 {

    public static int sum(int num1, int num2) {
        int sum = 0;
        int carry = 0;
        while (num2 != 0) {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;  //循环相加
            num2 = carry;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(sum(2, 322));
    }
}
