package day03.part2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/5/17 0017 10:57
 */
public class Problem59_2 {

    public static Deque<Integer> dataDeque = new LinkedList<>();
    public static Deque<Integer> maxDeque = new LinkedList<>();

    public static void push (int val) {
        dataDeque.offer(val);
        if (maxDeque.isEmpty()) {
            maxDeque.offer(val);
        }else {
            //主要是这里的思想。注意：在弹出元素时，随时判断!maxDeque.isEmpty()
            while (!maxDeque.isEmpty() && val >= maxDeque.getLast()) {
                maxDeque.pollLast();
            }
            maxDeque.offer(val);
        }
    }

    public static int pop() {
        if (dataDeque.isEmpty()) {
            return -1;
        }
        //如果正好弹出了最大值，那么同时更新maxDeque中的值
        if (dataDeque.getFirst() == maxDeque.getFirst()) {
            maxDeque.pollFirst();
        }
        return dataDeque.pollFirst();
    }

    public static int max() {
        if (maxDeque.isEmpty()) {
            return -1;
        }
        return maxDeque.getFirst();
    }

    public static void main(String[] args) {
        push(7);
        push(5);
        push(2);
        push(6);
        System.out.println(pop());   //注意：这是队列
        System.out.println(max());
    }
}
