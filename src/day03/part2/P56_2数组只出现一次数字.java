package day03.part2;

import java.util.Arrays;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/7 0007 22:37
 */
public class P56_2数组只出现一次数字 {
    /**
     * 每个数字都出现3次，只有一个数字出现一次。把所有数字的二进制位相加，模3。
     *      为0，说明该数字那位为0，否则为1
     * @param array
     * @return
     */
    public static int findNumAppearOnce(int[] array) {
        if (array == null || array.length < 1) {
            return -1;
        }
        //先求出所有数字二进制位数相加的和
        int[] bitSum = new int[32];
        for (int i = 0; i < array.length; i++) {
            int temp = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = array[i] & temp;
                if (bit != 0) {
                    bitSum[j] += 1;   // 对应位置加1，并不是加bit.bit并不等于1，只在对应位置+1
                }
                temp = temp << 1;
            }
        }
//        System.out.println(Arrays.toString(bitSum));

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result = result + bitSum[i] % 3;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] num = {3,3,3,1,-6,-6,-6};   注意：不适用于负数
        int[] num = {3,3,3,2};
        System.out.println(findNumAppearOnce(num));
    }
}
