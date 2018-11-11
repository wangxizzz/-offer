package day02;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/5/18 0018 10:27
 */
public class Problem64 {
    //普通递归
    public static int getSumWithCommon(int n) {
        //确定边界条件
        if (n  == 1) {
            return 1;
        }
        int sum = n;
        return sum + getSum(n-1);
    }

    /**
     * 参考网址：https://blog.csdn.net/wangyang1354/article/details/73350720
     * @param n
     * @return
     */
    public static int getSum(int n) {
        int sum = n;
        //sum + getSum(n-1)是个表达式，因此需要加上>0变成boolean
        boolean b = (n > 0) && (sum = sum +  getSum(n-1)) > 0;

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getSum(5));
    }
}
