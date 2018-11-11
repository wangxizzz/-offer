package day02;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/5/12 0012 22:08
 */
public class Problem57_2 {

    //此题是建立在连续的正数序列
    public static void findSequenceWithSum(int sum) {
        if (sum < 3) {
            return;
        }
        int small = 1;
        int big = 2;
        /**
         * 序列至少需要2个数.所以small必须小于中间的数，那么就一定存在一个大于middle的数构成序列
         */
        int middle = (1 + sum)/2;
        int result = big + small;
        while (small < middle) {
            if (result == sum) {
                printSequence(small, big);
            }
            //当和小于sum时
            while (result < sum && small < middle) {
                big++;
                result += big;
                if (result == sum) {
                    printSequence(small, big);
                }
            }
            result -= small;
            small++;
        }
    }

    private static void printSequence(int small, int big) {
        System.out.println("输出序列是：");
        for (int i = small; i <= big; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        findSequenceWithSum(15);
    }
}
