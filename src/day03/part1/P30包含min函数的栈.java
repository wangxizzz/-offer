package day03.part1;

import java.util.Stack;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/5/31 0031 13:34
 */
public class P30包含min函数的栈 {

    private static Stack<Integer> dataStack = new Stack<>();
    private static Stack<Integer> minStack = new Stack<>();

    public static void push(int val) {
        dataStack.push(val);
        if (minStack.isEmpty() || val < minStack.peek()) {
            minStack.push(val);
        }else {
            minStack.push(minStack.peek());
        }
    }

    public static int pop() {
        if (dataStack.isEmpty() || minStack.isEmpty()) {
            return -1;
        }
        minStack.pop();
        return dataStack.pop();
    }

    public static int getMin() {
        if (minStack.isEmpty() || minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }
    public static void main(String[] args) {

    }
}
