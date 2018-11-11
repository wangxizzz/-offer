package day微机房;

import util.ListNode;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/4/11 0011 11:01
 */
public class 删除链表中重复的节点二 {
    public static ListNode deleteDuplication(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preNode = null; //前节点
        ListNode node = head; //当前节点
        while (node != null && node.next != null) {
            ListNode nextNode = node.next;
            if (node.val == nextNode.val) {
                //需要删除 (把流程走一遍就知道代码的意思)
                int val = node.val;
                ListNode toBeDeNode = node;
                //把所有重复的节点都删掉
                while (toBeDeNode != null && toBeDeNode.val == val) {
                    //注意，变量过多时，toBeDeNode.next写成node.next会陷于死循环
                    nextNode = toBeDeNode.next;
                    toBeDeNode = nextNode;
                }
                if (preNode == null) {	//头结点删除时
                    head = nextNode;
                }else {
                    preNode.next = nextNode;
                }

            } else {
                //如果不相等,pre就有值
                preNode = node;
                node = node.next;
            }
            //执行if时，在这里需要更新node值
            node = nextNode;
        }
        return head;
    }


    /**
     * 打印输出链表的结点值
     * @param head 链表头结点的下一个结点
     */
    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
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
        pre.next = null;
        print(head.next);
        head = deleteDuplication(head.next);
        print(head);
    }
}
