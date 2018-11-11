package day02;

import java.util.Stack;

/**
 * @Author:王喜
 * @Description :面试30 基本思想：利用一个最小辅助栈
 * @Date: 2018/4/14 0014 20:42
 */
public class 包含min函数的栈 {

    public static Stack<Integer> minStack  = new Stack<>();
    public static Stack<Integer> dataStack = new Stack<>();

    public static void push (int data) {
        dataStack.push(data);
        //当最小栈中初始化没有元素时
        if (minStack.size() == 0 || data < minStack.peek()) {
            minStack.push(data);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public static Integer pop() {
        if (dataStack.size() < 1) {
            return null;
        }
        //及时更新需要的最小值
        minStack.pop();

        return dataStack.pop();
    }

    public static Integer min() {
        if (minStack.size() < 1) {
            return null;
        }
        return minStack.peek();
    }
    public static void main(String[] args) {
        push(3);
        System.out.println(min());
        push(4);
        System.out.println(min());
        push(2);
        System.out.println(min());
        push(1);
        System.out.println(min());
        pop();
        System.out.println(min());
        pop();
        System.out.println(min());
        push(0);
        System.out.println(min());

    }
}
