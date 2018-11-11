package review.剑指offer额外题;

/**
 * @Author: wangxi
 * @Description : P278数组中只要一个元素出现了一次，其他都出现三次
 * @Date: 2018/8/10 0010 13:37
 */
public class 数组唯一出现的数字 {
    public static int findNum(int[] num){
        if (num == null || num.length <= 0) {
            return -1;
        }
        int[] bits = new int[32];
        for (int i = 0; i < num.length; i++) {
            int temp = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = num[i] & temp;
                if (bit != 0) {
                    bits[j] += 1;   // 对应位置加1，并不是加bit.bit并不等于1，只在对应位置+1
                }
                temp = temp << 1;   // 不改变数组元素
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result = result + bits[i] % 3;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {2,3,3,3};
        System.out.println(findNum(num));
    }
}
