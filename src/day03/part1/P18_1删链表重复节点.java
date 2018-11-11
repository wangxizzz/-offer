package day03.part1;

import util.ListNode;

/**
 * @Author: wangxi
 * @Description : 彻底删除，不留源节点（递增链表）
 *                  如：1 —> 2 —> 2 —> 2 —> 2 —> 3 —> 3 —> 4
 *                  删除后：1 —> 4  头指针会被删掉
 * @Date: 2018/5/27 0027 15:58
 */
public class P18_1删链表重复节点 {

    public static ListNode deleteDuplicated(ListNode pHead) {
        if(pHead == null)
            return pHead;
        ListNode first = new ListNode(-1);   //考虑把头结点删掉了
        first.next = pHead;
        ListNode p = pHead;   //当前节点
        ListNode preNode = first;

        while(p != null && p.next != null) {
            if(p.val == p.next.val) {
                int val = p.val;

                while(p != null && p.val == val) {
                    p = p.next;
                }
                preNode.next = p;
            } else {
                preNode = p;
                p = p.next;
            }
        }

        return first.next;
    }

    public static void main(String[] args) {
        int[] num = {1,1,2,3,3,4,4,5};
        ListNode head = ListNode.createList(num);
        head = deleteDuplicated(head);
        ListNode.display(head);
    }
}
