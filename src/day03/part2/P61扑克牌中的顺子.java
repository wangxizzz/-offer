package day03.part2;

import java.util.Arrays;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/10 0010 20:10
 */
public class P61扑克牌中的顺子 {
    /**
     * 时间O(nlongn)
     * @param array
     * @return
     */
    public static boolean isContinuous(int[] array) {
        if (array == null || array.length <= 0) {
            return false;
        }
        int countZero = 0;
        int countSpace = 0;
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                break;
            }
            countZero++;
        }
        int small = countZero;
        int big = small + 1;
        while (big < array.length) {
            //如果有相同的元素，则一定不为顺子
            if (array[small] == array[big]) {
                return false;
            }
            countSpace += array[big] - array[small] - 1;
            small = big;
            big++;
        }
        System.out.println(Arrays.toString(array));
        System.out.println(countSpace);
        System.out.println(countZero);
        return (countSpace <= countZero);
    }

    public static void main(String[] args) {
        int[] array = {3,5,2,7,0,6,8,0,10};
        System.out.println(isContinuous(array));
    }
}
