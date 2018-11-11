package test;

import java.util.Stack;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/6/22 0022 14:44
 */
public class PrintStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        for (int i : stack) {
            System.out.println(i); //输出为1,2,3,4
        }

    }
}
