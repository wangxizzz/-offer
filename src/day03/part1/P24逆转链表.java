package day03.part1;

import util.ListNode;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/5/30 0030 10:52
 */
public class P24逆转链表 {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode reverseHead = null;
        while (curNode != null) {
            ListNode nextNode= curNode.next;
            if (nextNode == null) {
                reverseHead = curNode;
            }
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return reverseHead;
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6};
        ListNode head = ListNode.createList(num);
        head = reverseList(head);
        ListNode.display(head);
    }
}
