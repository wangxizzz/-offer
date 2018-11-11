package day03.part2;

import util.ListNode;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/7/6 0006 20:01
 */
public class P52两个链表的第一个公共节点 {
    /**
     * 让长链表先走K步，然后一起走，第一个公共节点就是所求的
     *          时间复杂度O(m+n)
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode getFirstCommonNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode longHead = head1;
        ListNode shortHead = head2;
        int length1 = getLength(head1);
        int length2 = getLength(head2);
        int k = length1 - length2;
        if (length1 < length2) {
            longHead = head2;
            shortHead = head1;
            k = length2 - length1;
        }
        for (int i = 0; i < k; i++) {
            longHead = longHead.next;
        }
        ListNode result = null;
        while (longHead != null && shortHead != null) {
            if (longHead == shortHead) {
                result = longHead;
                break;
            }
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return result;
    }
    private static int getLength(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
