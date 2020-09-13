package util;

import java.util.Scanner;

/**
 * @Author wangxi
 * @Time 2020/5/11 00:09
 */
public class 生成类名01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入字符串：");
        String s = scanner.nextLine();
        String[] parts = s.split("-");
        StringBuilder buffer = new StringBuilder();
        for (String item : parts) {
            char[] chars = item.toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            buffer.append(chars);
        }
        System.out.println(buffer.toString());
    }
}
