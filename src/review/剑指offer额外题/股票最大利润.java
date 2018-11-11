package review.剑指offer额外题;

/**
 * @Author: wangxi
 * @Description :  p304
 * @Date: 2018/8/10 0010 13:40
 */
public class 股票最大利润 {

    public static int max(int[] num){
        if (num == null || num.length < 2) {
            return 0;
        }
        // 找出前面的最小值
        int min = num[0];
        int maxDiff = num[1] - min;
        for (int i = 2; i < num.length; i++) {
            if (num[i - 1] < min) {
                min = num[i - 1];
            }
            int curDiff = num[i] - min;
            if (curDiff > maxDiff) {
                maxDiff = curDiff;
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] num = {9,11,8,5,7,12,16,14};
        System.out.println(max(num));
    }
}
