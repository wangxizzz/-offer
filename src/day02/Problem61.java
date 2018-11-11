package day02;

import java.util.Arrays;

/**
 * @Author:王喜
 * @Description : 给你一个数组，判断是否连续。
 * @Date: 2018/5/17 0017 13:35
 */
public class Problem61 {

    public static boolean isContinuous(int[] array) {
        if (array == null || array.length <= 0) {
            return false;
        }
        //对数组进行排序。
        Arrays.sort(array);
        //统计0的个数
        int countZero = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                countZero++;
            }
        }
        //统计相邻数字之间的间隔数量
        int small = countZero; //定义前后两个指针，注意命名
        int big = countZero + 1;
        int countSpace = 0;
        while (big < array.length) {
            if (array[small] == array[big]) {
                return false;
            }
            countSpace = countSpace + (array[big] - array[small] - 1);
            small = big;
            big++;
        }
        if (countSpace > countZero) {
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args) {
        int[] num = {2,3,0,0,0,6,9};
        System.out.println(isContinuous(num));
    }
}
