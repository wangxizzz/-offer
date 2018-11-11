package day03.part2;
/**
 * @Author: wangxi
 * @Description :
 * 主要思路：可以选一个数字或两个连续的数字（10~25）翻译成一个字符。
        定义f(i)f(i)：从第i位数字开始的不同翻译数目
1）若第i个数字和第i+1个数字拼接成的数字在10~25范围内，则递归式子为：
        f(i)=f(i+1)+f(i+2)
2）否则
        f(i)=f(i+1)
为了防止重复计算，按i从大到小计算。

 参考网址：https://blog.csdn.net/m0_37862405/article/details/80354994
 */
public class P46把数字翻译成字符串 {

    //从后往前翻译，否则会有很多的子问题
    public static int convertNumToString(int val) {
        if (val < 0) {
            return 0;
        }
        String temp = String.valueOf(val);
        int[] result = new int[temp.length()];
        result[temp.length() - 1] = 1;
        int count = 0;   //保存f(i+1)的值
        for (int i = temp.length() - 2; i >= 0; i++) {
            count = result[i + 1];  //保存f(i+1)的值
            int a = temp.charAt(i) - '0';
            int b = temp.charAt(i + 1) - '0';
            int temp1 = a * 10 + b;
            if (temp1 >= 10 && temp1 <= 25) {
                if (i == temp.length() - 2) {
                    count += 1;
                }else if (i < temp.length() - 2) {
                    count += result[i + 2];
                }
            }
            result[i] = count;
        }
        return result[0];
    }

    public static void main(String[] args) {

    }
}
