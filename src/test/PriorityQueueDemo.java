package test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: wangxi
 * @Description :  jdk自带的堆测试
 * @Date: 2018/6/28 0028 20:18
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        //小到大排序，则为最小堆，因为每次取元素，会把顶元素取出来，也就是queue[0]
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : -1;   //小到大排序
            }
        });
        priorityQueue.add(3);
        priorityQueue.add(7);
        priorityQueue.add(1);
        priorityQueue.add(0);
        priorityQueue.add(8);

        while (priorityQueue.peek() != null) {
            System.out.println(priorityQueue.poll());
        }
    }
}
