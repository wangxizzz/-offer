package day03.part2;

import java.util.Stack;

/**
 * @Author: wangxi
 * @Description : 参考网址：https://blog.csdn.net/abc7845129630/article/details/52734148
 * @Date: 2018/6/26 0026 22:54
 */
public class P38_1字符串的组合 {

    public static void combine(char[] c) {
        if (c == null || c.length <= 0) {
            return;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 1; i <= c.length; i++) {
            combine(c, 0, i, stack);
        }
    }
    //从字符数组中第begin个字符开始挑选number个字符加入stack中
    private static void combine(char[] c, int begin, int number, Stack<Character> stack) {
        if (number == 0) {
            System.out.println(stack.toString());
            return;
        }
        if (begin == c.length) {  //作用这句话combine(c, begin + 1, number, stack);
            return;
        }
        stack.push(c[begin]);
        combine(c, begin + 1, number - 1, stack);
        stack.pop();
        combine(c, begin + 1, number, stack);
    }

    public static void main(String[] args) {
        char[] c = {'a', 'b', 'c'};
        combine(c);
    }
}
