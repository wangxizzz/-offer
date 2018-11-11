package day02;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/5/17 0017 10:36
 */
public class Problem59 {
    /**
     * 时间复杂度O(n)
     * 参考网址：
     *          2.https://www.cnblogs.com/rosending/p/5722541.html
     *          3.https://blog.csdn.net/tongdanping/article/details/79475294
     *           4.采用双端队列的原因：因为在队列的两端同时需要删除元素，所以需要队列两端同时开口。
     *  但是怎么判断在队列头的最大值是否过期呢，那么这就需要在双向队列中保存的是元素的下标，
     *  当发现队列头部的元素下标和当前下标的差值大于滑动窗口的大小的时候，说明该最大值过期，
     *  应该把他从队列头部删除掉。
     */
    public static void getMaxByWindow(int[] num, int size) {
        if (num == null || num.length <= 0 || size == 0) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            if (!deque.isEmpty() && (i - deque.getFirst()) == size) {
                deque.pollFirst();
            }
            //注意：存的是索引
            while (!deque.isEmpty() && num[i] >= num[deque.getLast()]) {
                deque.pollLast();
            }
            //添加到尾部
            deque.offer(i);
            if (i >= (size - 1)) {
                //注意：存的是索引
                list.add(num[deque.getFirst()]);
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        getMaxByWindow(num, 3);
    }
}
