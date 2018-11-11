package day03.part2;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/10 0010 21:35
 */
public class P63股票的最大利润 {

    public static int getMaxMoney(int[] array) {
        if (array == null || array.length < 2) {
            return -1;
        }
        int min = array[0];
        int maxDiff = array[1] - array[0];
        for (int i = 2; i < array.length; i++) {
            //找出前面的最小值
            if (array[i - 1] < min) {
                min = array[i - 1];
            }
            int curDiff = array[i] - min;
            if (curDiff > maxDiff) {
                maxDiff = curDiff;
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] array = {9,11,8,5,7,12,16,14};
        System.out.println(getMaxMoney(array));
    }
}
