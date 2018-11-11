package day02;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:王喜
 * @Description : 面试50 时间复杂度是O(n)，空间复杂度为固定的长度，故为O(1)
 * @Date: 2018/4/17 0017 21:14
 */
public class 第一次只出现一次的字符 {

    public static Character getFirstNotRepeating(String s) {
        if (s == null || "".equals(s)) {
            return null;
        }
        Map<Character,Integer> map = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character,Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                return e.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getFirstNotRepeating("abaccdeff"));
    }
}
