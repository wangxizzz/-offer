package day03.part1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author:王喜
 * @Description :两个队列实现栈-->参照书上的思想
 * @Date: 2018/5/24 0024 12:49
 */
public class P9_2两个队列实现栈 {

    public static Deque<Integer> queue1 = new LinkedList<>();

    public static void push(int val) {
        queue1.offer(val);
    }

    public static int pop() {
        if (queue1.isEmpty()) {
            return -1;
        }else {
            return queue1.pollLast();
        }
    }

    public static void main(String[] args) {

    }
}
