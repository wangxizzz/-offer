package day03.part1;

import util.ListNode;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/5/30 0030 10:09
 */
public class P22_1倒数第K个节点 {
    /**
     * 时间O(n)，空间O(1)
     * @param head
     * @param k
     * @return
     */
    public static ListNode getNodeOfKTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k - 1; i++) {
            if (fast.next != null) {
                fast = fast.next;
            }else {    //判断是否有k个节点
                return null;
            }
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
