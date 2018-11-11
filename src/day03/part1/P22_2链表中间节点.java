package day03.part1;

import util.ListNode;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/5/30 0030 10:21
 */
public class P22_2链表中间节点 {
    /**
     * 定义两个指针，fast一次走两步，走到最后，slow刚好到达中间节点
     * 时间O(n)，空间O(1)
     * @param head
     * @return
     */
    public static ListNode getMidNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next;  //fast一次走2步
            if (fast != null) {
                fast = fast.next;
            }
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
