package day03.part2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/6/28 0028 19:43
 */
public class P40最小K个数 {
    /**
     * 时间复杂O(n)
     * @param num 数组
     * @param k
     */
    public static void getMinKNum(int[] num, int k){
        if (num == null || k == 0 || k >= num.length) {
            return;  //输入参数有误
        }
        int start = 0;
        int end = num.length - 1;
        int index = partition(num, start, end);
        while (index != k) {
            if (index > k) {
                end = index - 1;   //相当于二分查找位置k，因此需要-1，可以纸上画下二分查找的原理
                index = partition(num, start, end);
            }else {
                start = index + 1;
                index = partition(num, start, end);
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.print(num[i] + "  ");
        }
    }
    private static int partition(int[] array, int start, int end) {
        int temp = array[start];
        while (start < end) {
            while (start < end && array[end] >= temp) {
                end--;
            }
            array[start] = array[end];  //注意：只交换小于的，等于不交换
            while (start < end && array[start] <= temp) {
                start++;
            }
            array[end] = array[start];
        }
        array[end] = temp;
        return end;
    }

    /**
     * 维持一个k个元素的最大堆。时间O(nlogk)
     * 参考网址：
     * @param num
     * @param k
     */
    public static void getKNumWithMaxHeap(int[] num, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? -1 : 1;   //维持一个最大堆
            }
        });
        for (int i = 0 ; i < num.length; i++) {
            if (queue.size() != k) {
                queue.offer(num[i]);
            }else if (num[i] > queue.peek()) {
                continue;
            }else {
                queue.poll();
                queue.offer(num[i]);
            }
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + "  ");
        }
    }

    public static void main(String[] args) {
        int[] num = {4,5,1,6,2,7,3,8};
        getMinKNum(num, 4);
        System.out.println();
        getKNumWithMaxHeap(num, 4);
    }
}
