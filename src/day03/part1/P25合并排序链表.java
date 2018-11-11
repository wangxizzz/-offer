package day03.part1;

import util.ListNode;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/5/30 0030 11:05
 */
public class P25合并排序链表 {

    public static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode mergeHead = null;
        if (head1.val < head2.val) {
            mergeHead = head1;
            mergeHead.next = merge(head1.next, head2);
        }else {
            mergeHead = head2;
            mergeHead.next = merge(head1, head2.next);
        }
        return mergeHead;
    }

    public static void main(String[] args) {
        int[] num1 = {1,3,5,7};
        int[] num2 = {2,4,6,8};
        ListNode head1 = ListNode.createList(num1);
        ListNode head2 = ListNode.createList(num2);
        ListNode head3 = merge(head1, head2);
        ListNode.display(head3);
    }
}
