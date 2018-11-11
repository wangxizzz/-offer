package day03.part1;

import java.util.Stack;

/**
 * @Author:王喜
 * @Description :自己设计函数时，不要自己为难自己，尽量简单、不要返回值
 * @Date: 2018/5/24 0024 11:08
 */
public class P9_1两栈实现队列 {
    //bug已修复
    public static Stack<Integer> s1 = new Stack<>();
    public static Stack<Integer> s2 = new Stack<>();

    public static void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public static int pop() {
        if (!s2.isEmpty()) {
            int temp = s2.pop();
            return temp;
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    /** Get the front element. */
    public static int peek() {
        if (!s2.isEmpty()) {
            int temp = s2.pop();
            s2.push(temp);
            return temp;
        }
        int top = 0;
        while (s1.size() > 1) {
            s2.push(s1.pop());
        }
        top = s1.pop();
        s2.push(top);
        return top;
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        System.out.println(peek());
        System.out.println(pop());
        System.out.println(peek());
        System.out.println(pop());
    }

}
