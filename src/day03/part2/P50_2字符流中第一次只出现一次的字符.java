package day03.part2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/4 0004 21:53
 */
public class P50_2字符流中第一次只出现一次的字符 {
    public static int[] temp = new int[128];   //不仅仅只有数字和字母字符
    public static List<Character> result = new ArrayList<>();
    public static void insert(char c) {
        temp[c]++;
        if (temp[c] == 1) {
            result.add(c);
        }else {
            result.remove(0);
        }
    }

    public static char getFirstCharacter() {
        if (!result.isEmpty()) {
            return result.get(0);
        }
        return '#';
    }
}
