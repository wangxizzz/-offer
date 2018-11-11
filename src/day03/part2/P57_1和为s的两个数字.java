package day03.part2;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/8 0008 19:42
 */
public class P57_1和为s的两个数字 {
    /**
     * 时间复杂O(n)
     * @param array
     * @param sum
     */
    public static void findNum(int[] array, int sum) {
        if (array == null ||array.length < 2) {
            return;
        }
        int length = array.length;
        int small = 0;
        int big = length - 1;
        int result1 = 0;
        int result2 = 0;
        while (small < big) {
            int curSum = array[small] + array[big];
            if (curSum == sum) {
                result1 = array[small];
                result2 = array[big];
                break;
            }else if (curSum > sum) {
                big--;
            }else {
                small++;
            }
        }
        System.out.println(result1);
        System.out.println(result2);
    }

    public static void main(String[] args) {
        int[] num = {1,2,4,7,11,15};
        findNum(num, 15);
    }
}
