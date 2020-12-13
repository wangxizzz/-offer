package leecode.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wangxi created on 2020/12/13 18:19
 * @version v1.0
 *
 * top k问题
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k <= 0) {
            return -1;
        }
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        for (int num : nums) {
            if (minQueue.size() >= k) {
                int peek = minQueue.peek();
                if (num > peek) {
                    minQueue.offer(num);
                    minQueue.poll();
                }
            } else {
                minQueue.offer(num);
            }
        }
        return minQueue.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        KthLargestElementInAnArray obj = new KthLargestElementInAnArray();
        System.out.println(obj.findKthLargest(nums, 2));
    }
}
