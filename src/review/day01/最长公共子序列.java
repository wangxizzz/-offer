package review.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/9 0009 11:43
 */
public class 最长公共子序列 {

    public static int[][] findLongestCommonSubString(String s1, String s2){
        if (s1 == null || s2 == null) {
            return null;
        }
        int length1 = s1.length() + 1;
        int length2 = s2.length() + 1;
        int[][] temp = new int[length1][length2];
        int[][] b = new int[length1][length2];
        for (int i = 1; i < length1; i++) {
            for (int j = 1; j < length2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                }
                // 如果字符不相等
                else if (temp[i - 1][j] >= temp[i][j - 1]) {
                    temp[i][j] = temp[i - 1][j];
                    b[i][j] = 0;
                }else{
                    temp[i][j] = temp[i][j - 1];
                    b[i][j] = -1;
                }
            }
        }
        System.out.println("最长子序列的长度是：" + temp[length1 - 1][length2 - 1]);
        return b;
    }

    static List<Character> list = new ArrayList<>();
    public static void display(int[][] b, int i, int j, String s){
        if (i < 1 || j < 1) {
            return;
        }
        if (b[i][j] == 1) {
            display(b, i - 1, j - 1, s);
            list.add(s.charAt(i - 1));
        }
        if (b[i][j] == 0) {
            display(b, i - 1, j, s);
        }
        if (b[i][j] == -1) {
            display(b, i, j - 1, s);
        }
    }


    public static void main(String[] args) {
        String s1 = "abccade";
        String s2 = "dgcadde";
        int[][] b = findLongestCommonSubString(s1, s2);
        if (b == null || b.length <= 0 || b[0].length <= 0) {
            return;
        }
        display(b, b.length - 1, b[0].length - 1, s1);
        System.out.println(list);
    }
}
