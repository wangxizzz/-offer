package day02;

/**
 * @Author:王喜
 * @Description :数组中的数对，得到最大差值
 * @Date: 2018/5/18 0018 10:11
 */
public class Problem63 {

    /**
     * 得到最大的差值 ，时间O(n)，空间O(1)
     * 注意：差值可以是负数，不是绝对值。如果是绝对值最大，那么不能用此题的解法
     * @param num 数组
     * @return
     */
    public static int getMaxDiff(int[] num) {
        //注意：此题的条件
        if (num == null || num.length < 2) {
            return -1;
        }
        int min = num[0];
        int maxDiff = num[1] - min;
        for (int i = 2; i < num.length; i++) {
            //得到i-1前面的最小值
            if (num[i-1] < min) {
                min = num[i-1];
            }
            int currentDiff = num[i] - min;
            if (maxDiff < currentDiff) {
                maxDiff = currentDiff;
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] num = {9,11,8,500,7,12,16,14,1};
        System.out.println(getMaxDiff(num));
    }
}
