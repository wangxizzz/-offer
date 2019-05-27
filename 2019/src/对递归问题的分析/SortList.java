package 对递归问题的分析;

import util.ListNode;

/**
 * <Description>
 * https://leetcode.com/problems/sort-list/submissions/
 * @author wangxi
 */
public class SortList {

    public static void main(String[] args) {
        int[] nums = {4,2,1,3};
        ListNode head = ListNode.createList(nums);
        new SortList().sortList(head);
    }

    public ListNode sortList(ListNode head) {
        // 如果不考虑空间复杂度，那么可以使用数组进行快排，然后重新写会链表数据
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(newHead);
        return merge(node1, node2);
    }
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode first = new ListNode(-1);
        ListNode cur = first;
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                cur.next = p2;
                p2 = p2.next;
            } else {
                cur.next = p1;
                p1 = p1.next;
            }
            cur = cur.next;
        }
        if (p2 != null) {
            cur.next = p2;
        } else {
            cur.next = p1;
        }
        return first.next;
    }
}

