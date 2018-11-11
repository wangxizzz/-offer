package day03.part2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/4 0004 20:28
 */
public class P50_1第一次只出现一次的字符 {
    /**
     * 时间O(n)，空间O(1),因为字符char占两个字节
     * @param str
     * @return
     */
    public static char getFirstCharacter(String str) {
        if (str == null || "".equals(str)) {
            return '0';  //输入错误提示。可以更换
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) +1);
            }else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            if (map.get(key) == 1) {
                return key;
            }
        }
        return '0';
    }

    public static void main(String[] args) {
        System.out.println(getFirstCharacter("abaccdeff"));
    }
}
