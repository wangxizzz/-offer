package day01;

import util.ListNode;

/**
 * @Author:王喜
 * @Description :面试25
 * @Date: 2018/4/11 0011 13:12
 */
public class 合并两个递增的链表 {
    public static ListNode Merge(ListNode head1, ListNode head2) {
        //边界条件
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        //创建链表合并之后的头指针
        ListNode mergeHead = null;
        if (head1.val < head2.val) {
            mergeHead = head1;
            mergeHead.next = Merge(head1.next, head2);
        }else {
            mergeHead = head2;
            mergeHead.next = Merge(head1, head2.next);
        }
        return mergeHead;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,7,9};
        int[] nums2 = {2,3,4,7,8,10};
        ListNode head1 = ListNode.createList(nums1);
        ListNode head2 = ListNode.createList(nums2);
        ListNode mergeHead = Merge(head1, head2);
        ListNode.display(mergeHead);
    }
}
