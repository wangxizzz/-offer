package day02;

/**
 * @Author:王喜
 * @Description : 时间O(n) ，空间O(1)
 * @Date: 2018/5/12 0012 21:48
 */
public class Problem57 {
    //本题是已经排好序的数组
    public static void findNumbersWithSum(int[] num, int sum) {
        if (num == null || num.length <= 0) {
            return;
        }
        int i = 0;
        int j = num.length - 1;
        int val1 = num[i];
        int val2 = num[j];
        while (i < j) {
            int result = val1 + val2;
            if (result < sum) {
                //往前移一位
                val1 = num[++i];
            } else if (result > sum) {
                val2 = num[--j];
            }else {
                System.out.println(val1);
                System.out.println(val2);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] num = {1,2,4,7,11,15};
        findNumbersWithSum(num, 152);
    }
}
