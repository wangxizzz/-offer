package day03.part1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/5/31 0031 10:30
 */
public class P29顺时针打印矩阵 {

    private static List<Integer> result = new ArrayList<>();

    public static void print(int[][] num) {
        //获取矩阵的列数 num[0].length
        if (num == null || num.length <= 0 || num[0].length <= 0) {
            return;
        }
        int len = Math.min(num.length, num[0].length);
        for (int i = 0; 2 * i < len; i++) {
            printCycle(num, i);
        }
    }
    private static void printCycle(int[][] num, int start) {
        int endRows = num.length - start - 1;
        int endCols = num[0].length - start - 1;
        //从左到右打印
        for (int i = start; i <= endCols; i++) {
            int number = num[start][i];
            result.add(number);
        }
        //上到下打印
        if (endRows > start) {
            for (int i = start + 1; i <= endRows; i++) {
                int number = num[i][endCols];
                result.add(number);
            }
        }
        //右到左打印
        if (endRows > start && endCols > start) {
            for (int i = endCols - 1; i >= start; i--) {
                int number = num[endRows][i];
                result.add(number);
            }
        }
        //从下到上
        if (endRows - 1 > start && endCols > start) {
            for (int i = endRows - 1; i > start; i--) {
                int number = num[i][start];
                result.add(number);
            }
        }
    }

    public static void main(String[] args) {
        int[][] num = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        print(num);
        System.out.println(result);
    }
}
