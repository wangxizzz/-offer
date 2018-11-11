package day03.part1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:王喜
 * @Description : 条件：在一个长度为n的数组里的所有数字都在0 ~ n-1的范围内
 * @Date: 2018/5/19 0019 12:25
 */
public class P3数组重复的数字 {
    /**
     * 最佳的解法：时间O(n)，空间O(1)，可以找出所有重复的数
     * @param num
     */
    public static void getDuplicatedNum1(int[] num) {
        if (num == null || num.length <= 0) {
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] < 0 || num[i] > num.length - 1) {
                System.out.println("输入数据不合法！");
                return;
            }
        }
        for (int i = 0; i < num.length; i++) {
            while (num[i] != i) {
                if (num[i] == num[num[i]]) {
                    System.out.print(num[i] + "  ");
                    break;  //这里有两层循环
                }
                int temp = num[i];
                //num[i] = num[num[i]];  这里是一个坑
                //num[num[i]] = temp;

                num[i] = num[num[i]];
                num[temp] = temp;

            }
        }
        //如果没有
        return;
    }

    /**
     * 方法2 时间O(n)， 空间O(n)的hash表
     * @param num
     */
    public static void getDuplicatedNum2(int[] num) {
        //首先数据的鲁棒性

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            if (map.containsKey(num[i])) {    //利用O(1)的时间判断是否存在
                System.out.print(num[i] + "  ");
                continue;
            }
            map.put(num[i], null);
        }
    }

    /**
     * 利用快排，时间O(nlogn),空间O(1)
     * @param num
     */
    public static void getDuplicatedNum3(int[] num) {
        //验证鲁棒性

        Arrays.sort(num);
        int i = 0;
        int j = 1;
        while (j < num.length) {
            if (num[j] == num[i]) {
                System.out.print(num[j] + "  ");
            }
            i = j;
            j++;
        }
    }

    public static void main(String[] args) {
//        int[] num = {2,3,1,0,2,5,3};
        int[] num = {2,4,3,1,4};
        getDuplicatedNum1(num);
        System.out.println();
        getDuplicatedNum2(num);
        System.out.println();
        getDuplicatedNum3(num);
    }
}
