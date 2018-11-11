package demos.demo01;

import util.ListNode;

/**
 * @Author:王喜
 * @Description :链表的逆转
 * @Date: 2018/4/16 0016 23:04
 */
public class ReverseList {

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preNode = null;
        ListNode nowNode = head;
        ListNode nextNode = null;
        while (nowNode != null) {
            nextNode = nowNode.next;  //保存下一个节点地址
            nowNode.next = preNode;   //当前节点下一个节点指向前一个节点
            preNode = nowNode;          //preNode后移
            nowNode = nextNode;     //当前节点后移
        }
        head = preNode;
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ListNode head = ListNode.createList(nums);
        head = reverseList(head);
        ListNode.display(head);
    }
}
