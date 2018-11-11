package day微机房;

import util.ListNode;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/4/11 0011 11:04
 */
public class 输出链表的倒数k个节点 {
    //注意鲁棒性
    public static ListNode findKthtotail(ListNode head,int k) {
        //判断head是否为空，并且不存在倒数第0个节点，根据题目的意思
        if (head == null || k == 0) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        int i = 0;
        for (i = 1; i <= k-1; i++) {
            //防止k的值超过节点的最大个数
            if (p != null) {
                p = p.next;
            } else {
                return null;
            }
        }
        while (p.next != null) {
            p = p.next;
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
        System.out.println(findKthtotail(head.next, 4).val);
    }
}
