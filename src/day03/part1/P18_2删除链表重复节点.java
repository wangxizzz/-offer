package day03.part1;

import util.ListNode;

/**
 * @Author: wangxi
 * @Description :  保留重复源节点(递增链表)
 *                 如： 1 —> 2 —> 2 —> 2 —> 2 —> 3 —> 3 —> 4
 *                 删除后：1 —> 2 —> 3 —> 4   //头指针是不会被删掉的
 * @Date: 2018/5/27 0027 17:10
 */
public class P18_2删除链表重复节点 {

    public static ListNode delete(ListNode head) {
        if (head == null) {
            return null;
        }
        /**
         * 头指针是不会被删掉的,因此不需要preNode，只需要一个节点即可
         */
        ListNode curNode = head;
        while (curNode != null && curNode.next != null) {
            ListNode nextNode = curNode.next;
            if (curNode.val == nextNode.val) {
                curNode.next = nextNode.next;
                nextNode = null;
            }else {
                curNode = curNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] num = {2,2,2,3,3,4,5,5};
        ListNode head = ListNode.createList(num);
        head = delete(head);
        ListNode.display(head);
    }
}
