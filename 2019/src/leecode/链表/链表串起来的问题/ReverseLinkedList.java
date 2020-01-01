package leecode.链表.链表串起来的问题;

import util.ListNode;

/**
 * @Author wangxi
 * @Time 2019/12/30 00:35
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode reverseHead = null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                reverseHead = cur;
                /**
                 * 如果加上break，相当于最后一个节点的next并没有指向pre节点，那么就会发生断链的情况。
                 */
                // break;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return reverseHead;
    }

    public static void main(String[] args) {
        ReverseLinkedList obj = new ReverseLinkedList();
        int[] nums = {1,2};
        ListNode head = ListNode.createList(nums);
        ListNode.display(obj.reverseList(head));
    }
}
