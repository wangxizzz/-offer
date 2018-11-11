package day03.part2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/2 0002 19:45
 */
public class P41数据流的中位数 {

    private static PriorityQueue<Integer> minQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 > o2 ? 1 : -1;  //小到大排序
        }

    });
    private static PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>(){
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 > o2 ? -1 : 1;   //大到小排序
        }
    });
    private static int count = 0;
    public static void insert(int val) {  //偶数时，插入最小堆。否则，最大堆
        count++;
        if (count % 2 == 0) {
            maxQueue.offer(val);
            minQueue.offer(maxQueue.poll());
        }else {
            minQueue.offer(val);
            int temp = minQueue.poll();
            maxQueue.offer(temp);
        }

    }
    public static double getMiddle() {
        if (count % 2 == 0) {
            return (double)((maxQueue.peek() + minQueue.peek())/2.0);
        }else {
            return (double)(maxQueue.peek());
        }
    }

    public static void main(String[] args) {
        int[] num = {5,2,3,4,1,6,7,0,8};
        for (int val : num) {
            insert(val);
            System.out.println(getMiddle());
        }
    }
}
