package review.剑指offer额外题;

import util.ListNode;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/10 0010 11:25
 */
public class 尾到头打印链表 {

    public static void print(ListNode head){
        if (head == null) {
            return;
        }
        print(head.next);
        System.out.print(head.val + "  ");
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        ListNode head = ListNode.createList(num);
        print(head);
    }
}
