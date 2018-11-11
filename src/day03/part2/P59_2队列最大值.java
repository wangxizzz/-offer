package day03.part2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/9 0009 23:45
 */
public class P59_2队列最大值 {
    //定义两个双端队列
    static Deque<Integer> dataDeque = new LinkedList<>();
    static Deque<Integer> maxDeque = new LinkedList<>();

    public static void push(int val) {
        dataDeque.offer(val);
        if (maxDeque.isEmpty()) {
            maxDeque.offer(val);
        }else {
            //利用滑动窗口思想
            while (!maxDeque.isEmpty() && val > maxDeque.getLast()) {  //是否可以带等号?
                maxDeque.pollLast();
            }
            maxDeque.offer(val);
        }
    }
    public static int pop() {
        if (dataDeque.isEmpty()) {
            return -1;
        }
        if (dataDeque.peekFirst() == maxDeque.peekFirst()) {
            maxDeque.pollFirst();
        }
        return dataDeque.pollFirst();
    }
    public static int max() {
        if (!maxDeque.isEmpty()) {
            return maxDeque.getFirst();
        }
        return -1;
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
