package day03.part1;

import util.ListNode;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/5/30 0030 10:26
 */
public class P23链表环的入口节点 {
    /**
     * 时间O(n)
     * @param head
     * @return
     */
    public static ListNode getEnterNodeOfCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        //得到环节点的个数
        ListNode meetingNode = getMeetingNode(head);
        if (meetingNode == null) {
            return null;
        }
        int count = 1;
        ListNode temp = meetingNode;
        while (temp.next != meetingNode) {
            temp = temp.next;
            count++;
        }
        ListNode front = head;
        for (int i = 0; i < count; i++) {
            front = front.next;
        }
        ListNode behind = head;
        while (front != behind) {
            front = front.next;
            behind = behind.next;
        }
        return front;
    }

    //得到环里面任何一个节点
    private static ListNode getMeetingNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }
}
