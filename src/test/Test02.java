package test;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/20 0020 16:27
 */
public class Test02 {
    public static void main(String[] args) {
        String s = 'c' + "";
//        int a = Integer.parseInt(s);   //parseInt()参数只能是String类型

        //数组元素的直接复制
        String s1 = "abc";
        int[] a1 = new int[26];
        int[] b1;
        for (int i = 0; i < s1.length(); i++) {
            a1[s1.charAt(i) - 97]++;
        }
        b1 = a1;
        System.out.println(Arrays.toString(b1));

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(num));
    }
}
