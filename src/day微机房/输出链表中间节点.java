package day微机房;

import util.ListNode;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/4/11 0011 11:04
 */
public class 输出链表中间节点 {
    //定义两个指针，一个走两步，一个走一步，当第一个到达尾，第二个在中间
    public static ListNode getMidNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        while (p != null && p.next != null) {
            p = p.next.next;
            q = q.next;
        }
        return q;
    }

    public static void main(String[] args) {
        int[] num = { 2, 3, 3, 5, 7, 8, 8 };
        ListNode head = new ListNode();
        ListNode pre = head;
        for (int i = 0; i < num.length; i++) {
            ListNode node = new ListNode(num[i]);
            pre.next = node;
            pre = node;
        }
        System.out.println(getMidNode(head.next).val);
    }
}
