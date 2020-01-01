package leecode.链表.链表串起来的问题;

import util.ListNode;

/**
 * @Author wangxi
 * @Time 2019/12/30 00:19
 * https://leetcode.com/problems/odd-even-linked-list/
 *
 * 解决疑惑：
 * 链表串起来的问题: easy.
 */
public class OddEvenLinkedList {


    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        if (evenHead == null) {
            return oddHead;
        }
        ListNode oddTemp = null;
        ListNode evenTemp = null;
        ListNode temp = head;
        int count = 1;
        while (temp != null) {
            if ((count & 1) == 1) {
                if (oddTemp == null) {
                    oddTemp = oddHead;
                } else {
                    oddTemp.next = temp;
                    oddTemp = temp;
                }
            } else {
                if (evenTemp == null) {
                    evenTemp = evenHead;
                } else {
                    evenTemp.next = temp;
                    evenTemp = temp;
                }
            }
            temp = temp.next;
            count++;
        }
        evenTemp.next = null;
        oddTemp.next = evenHead;
        return oddHead;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3,5,6,4,7};
        ListNode head = ListNode.createList(nums);
        OddEvenLinkedList obj = new OddEvenLinkedList();
        head = obj.oddEvenList(head);
        ListNode.display(head);
    }
}
