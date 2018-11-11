package review.剑指offer额外题;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wangxi
 * @Description : P292
 * @Date: 2018/8/10 0010 13:38
 */
public class 队列最大值 {

    static Queue<Integer> data = new LinkedList<>();
    static Deque<Integer> max = new LinkedList<>();

    public static void push(int val){
        data.offer(val);
        if (max.isEmpty()) {
            max.offer(val);
        }else{
            while (!max.isEmpty() && val > max.getLast()) {
                max.pollLast();
            }
            max.offer(val);
        }
    }
    public static void pop(){
        if (!data.isEmpty() && !max.isEmpty()) {
            if (max.peek() == data.peek()) {
                data.poll();
                max.poll();
            }else{
                data.poll();
            }
        }
    }

    public static int max(){
        if (!max.isEmpty()) {
            return max.peek();
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
