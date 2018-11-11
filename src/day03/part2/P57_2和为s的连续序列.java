package day03.part2;

/**
 * @Author: wangxi
 * @Description :   和为s的连续正序序列
 * @Date: 2018/7/8 0008 19:43
 */
public class P57_2和为s的连续序列 {

    public static void findContinuousSequence(int sum) {
        if (sum < 3) {
            return;
        }
        int small = 1;
        int big = 2;
        int curSum = small + big;
        int mid = (1 + sum) / 2;   //限制small增大到sum的一半，保证序列至少两个数
        while (small < mid) {
            if (curSum == sum) {
                printContinuousSequence(small, big);
            }
            while (curSum > sum && small < mid) {
                curSum -= small;
                small++;
                if (curSum == sum) {
                    printContinuousSequence(small, big);
                }
            }
            big++;
            curSum += big;
        }
    }

    private static void printContinuousSequence(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        findContinuousSequence(15);
    }
}
