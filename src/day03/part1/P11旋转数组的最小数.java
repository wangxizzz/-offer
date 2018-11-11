package day03.part1;

/**
 * @Author:王喜
 * @Description : 注意前提是：递增数组的旋转
 * @Date: 2018/5/24 0024 17:03
 */
public class P11旋转数组的最小数 {

    public static int getMin(int[] num) {
        if (num == null || num.length <= 0) {
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        /**
         * 注意：考虑旋转前面0个元素
         */
        int mid = 0;  //初始化为0
        while (num[start] >= num[end]) {  //返回值一定是两个子数组的交界元素，start指向前面递增数组，end指向后面递增数组，不能到一边去
            if (end - start == 1) {
                return num[end];
            }
            mid = (start + end) / 2;
            //考虑特殊情况
            if (num[start] == num[end] && num[end] == num[mid]) {
                return getMInByOrder(num, start, end);
            }
            if (num[mid] >= num[start]) {
                start = mid;
            }else if (num[mid] <= num[end]) {  //两边都需要考虑等于的情况
                end = mid;
            }
        }
        return num[mid];
    }

    private static int getMInByOrder(int[] num, int start, int end) {
        int min = num[start];
        for (int i = start + 1; i < num.length; i++) {
            if (num[i] < min) {
                min = num[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] num = {3,4,5,0,1,2};
        System.out.println(getMin(num));
    }
}
