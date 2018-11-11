package day02;

import util.ListNode;

import java.util.Stack;

/**
 * @Author:王喜
 * @Description :面试52
 * @Date: 2018/4/17 0017 21:32
 */
public class 两个链表的第一公共节点 {

    /**
     * 借用两个辅助栈 时间O(m+n) , 空间 O(m+n)
     * @param head1 头结点1
     * @param head2
     * @return
     */
    public static ListNode findFirstCommonNode1(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        for (ListNode temp = head1; temp != null; temp = temp.next) {
            stack1.push(temp);
        }
        for (ListNode temp = head2; temp != null; temp = temp.next) {
            stack2.push(temp);
        }
        ListNode result = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            ListNode tempNode = stack1.peek();
            if (stack1.pop() == stack2.pop()) {
                result = tempNode;
            } else {
                return result;
            }
        }
        return null;
    }

    /**
     * 比较两个链表的长度，让长链表先走，然后两个一起走
     * 时间O(m+n)
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode findFirstCommonNode2(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int length1 = getListLength(head1);
        int length2 = getListLength(head2);
        int tempLength = length1 - length2;
        ListNode longHeadNode = head1;
        ListNode shortListNode = head2;
        if (tempLength < 0) {
            longHeadNode = head2;
            shortListNode = head1;
        }
        for (int i = 0; i < tempLength; i++) {
            longHeadNode = longHeadNode.next;
        }
        while (longHeadNode != null && shortListNode != null) {
            if (longHeadNode == shortListNode) {
                return longHeadNode;
            }
            longHeadNode = longHeadNode.next;
            shortListNode = shortListNode.next;
        }
        return null;
    }
    private static int getListLength(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = null;
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        b1.next = b2;
        b2.next = a3;

        System.out.println(findFirstCommonNode1(a1, b1).val);
        System.out.println(findFirstCommonNode2(a1, b1).val);
    }
}
