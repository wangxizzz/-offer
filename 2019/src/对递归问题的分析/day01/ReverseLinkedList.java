package 对递归问题的分析.day01;

import util.ListNode;

/**
 * <Description>
 *
 * @author wangxi
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = ListNode.createList(nums);
        new ReverseLinkedList().reverseList(head);
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

