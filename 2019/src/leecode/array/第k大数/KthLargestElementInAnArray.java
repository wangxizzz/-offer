package leecode.array.第k大数;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wangxi created on 2020/12/13 18:19
 * @version v1.0
 * <p>
 * top k问题
 * <p>
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        KthLargestElementInAnArray obj = new KthLargestElementInAnArray();
        System.out.println(obj.findKthLargestByHeap(nums, 2));
    }

    /**
     * java的 最小堆：堆顶元素最小，即queue[0]最小。每次poll，是把queue[0]元素弹出。
     * 最大堆，queue[0]元素最大，每次poll，把最大元素弹出，即queue[0]丢弃
     * <p>
     * 构建堆时，默认是小到大排序，因此queue[0]最小，即最小堆。
     * 更改排序的两个元素的位置，即可构建 大到小排序
     */

    public int findKthLargestByHeap(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k <= 0) {
            return -1;
        }
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));
        for (int i = 0; i < nums.length; i++) {
            if (queue.isEmpty() || queue.size() < k) {
                queue.offer(nums[i]);
            } else {
                if (queue.peek() < nums[i]) {
                    queue.offer(nums[i]);
                    queue.poll();
                }
            }
        }
        System.out.println(queue);
        return queue.peek();
    }


    /**
     * 借助快排的思想
     */
    int result = -1;

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k <= 0) {
            return -1;
        }
        /**
         * 假如纯粹使用快排会有一个问题：
         *  1.无法获取最后一个元素的索引。当k=1时  ，这个问题衍生的几种场景：
         *      a. 数组元素只有一个 k=1
         *      b. 数组元素全部都相等  k=1
         *      c. {-1, 0, 2}  k=1，也无法避免
         */

        if (nums.length == 1) {
            return nums[nums.length - 1];
        }
        findKthLargest(nums, 0, nums.length - 1, k);
        return result;
    }

    private void findKthLargest(int[] nums, int left, int right, int k) {
//        if (left >= right) {
//            return;
//        }
        int target = nums.length - k;
        int index = partition(nums, left, right);
        if (index == target) {
            result = nums[index];
            // 递归退出的条件，一定会在left<right范围内找到结果的。
            // 因此注释掉一般快排递归结束条件，否则还是无法取到k=1的值，即最后一个元素的索引值
            return;
        }
        // 缩小范围
        else if (index > target) {
            findKthLargest(nums, left, index - 1, k);
        } else {
            findKthLargest(nums, index + 1, right, k);
        }

    }

    private int partition(int[] nums, int left, int right) {
        int key = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= key) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= key) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[right] = key;
        return right;
    }
}
