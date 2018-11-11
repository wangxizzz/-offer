package day03.part2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wangxi
 * @Description :参考网址：https://www.cnblogs.com/rosending/p/5722541.html
 *                          有详细的注释
 * @Date: 2018/7/9 0009 22:59
 */
public class P59_1滑动窗口最大值 {

    public static List<Integer> getMaxWithWindow(int[] array, int size) {
        List<Integer> list = new ArrayList<>();
        if (array == null || array.length <= 0 || size <= 0 || size > array.length) {
            return list;
        }
        Deque<Integer> indexDequeue = new LinkedList<>();  //存的是数组元素的索引
        for (int i = 0; i < array.length; i++) {
            while (!indexDequeue.isEmpty() && (i - indexDequeue.peek()) == size) {
                indexDequeue.pollFirst();
            }
            while (!indexDequeue.isEmpty() && (array[i] >= array[indexDequeue.getLast()])) {
                indexDequeue.pollLast();
            }
            indexDequeue.offer(i);   //注意：队列存的是元素的索引值
            if (i >= (size - 1)) {
                list.add(array[indexDequeue.peekFirst()]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        System.out.println(getMaxWithWindow(num, 3));
    }
}
