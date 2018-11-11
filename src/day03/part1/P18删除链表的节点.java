package day03.part1;

import util.ListNode;

/**
 * @Author: wangxi
 * @Description : 需要在O(1)时间删除该节点
 * @Date: 2018/5/27 0027 15:16
 */
public class P18删除链表的节点 {

    /**  链表题举例子时，最好是举4个以上节点的例子，防止出错
     * 此方法是基于toBeDeletedNode已经存在于链表中
     * @param head
     * @param toBeDeletedNode
     * @return
     */
    public static ListNode deleteNode(ListNode head, ListNode toBeDeletedNode) {
        if (head == null || toBeDeletedNode == null) {
            System.out.println("参数错误");
            return null;
        }
        //链表中只有一个节点
        if (head.next == null && head == toBeDeletedNode) {
            return null;
        }else if (toBeDeletedNode.next == null) {   //删除节点时尾节点
            //从头遍历，找出toBeDeletedNode前一个节点
            ListNode temp = head;
            while (temp.next != toBeDeletedNode) {
                temp = temp.next;
            }
            temp.next = null;
            return head;
        }else {    //删除普通节点
            ListNode temp = toBeDeletedNode.next;
            toBeDeletedNode.val = temp.val;
            toBeDeletedNode.next = temp.next;
            temp = null;
            return head;
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        head = deleteNode(head, head);

        ListNode.display(head);
    }
}
