package leecode.链表;

import util.ListNode;

/**
 * @author wangxi created on 2021/1/21 18:20
 * @version v1.0
 */
public class ReverseKGroup {

    // 计算出哪些组需要翻转，然后利用头插法进行翻转链表即可。

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        int len = 0;
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode tempNode = head;
        while (tempNode != null) {
            len++;
            tempNode = tempNode.next;
        }
        int group = len / k;
        ListNode pre = first;
        ListNode cur = head;
        for (int i = 0; i < group; i++) {
            for (int j = 0; j < k - 1; j++) {
                ListNode nextNode = cur.next;
                cur.next = nextNode.next;
                nextNode.next = pre.next;
                pre.next = nextNode;
            }
            pre = cur;
            cur = cur.next;
        }
        return first.next;
    }
}
