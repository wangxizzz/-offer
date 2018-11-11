package day03.part2;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/10 0010 21:52
 */
public class P64 {

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        int sum = n;
        return n + sum(n - 1);
    }

    /**
     * 参考网址：https://blog.csdn.net/wangyang1354/article/details/73350720
     * @param n
     * @return
     */
    public static int getSum(int n) {
        int sum = n;
        //sum + getSum(n-1)是个表达式，因此需要加上>0变成boolean

        //利用&&运算符的短路性,如果n=0，则就不会执行(sum + getSum(n - 1) > 0)语句了
        boolean temp = (n > 0) && ((sum = sum + getSum(n - 1)) > 0);

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getSum(5));
    }
}
