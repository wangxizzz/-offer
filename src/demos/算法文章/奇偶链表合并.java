package demos.算法文章;

import util.ListNode;

/**
 * @Author: wangxi
 * @Description :  参考链接：https://www.cnblogs.com/DarrenChan/p/8764608.html
 *          题目描述：一个链表，奇数位升序偶数位降序，让链表变成升序的。
 *                  比如：1 8 3 6 5 4 7 2 9
 *                  最后输出1 2 3 4 5 6 7 8 9
 * @Date: 2018/9/1 0001 19:30
 */
public class 奇偶链表合并 {

    public static ListNode divide(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null || head.next.next == null) {
            return head;
        }
        ListNode head1 = head;  // 奇数
        ListNode head2 = head.next;  // 偶数
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int index = 3;
        head = head.next.next;
        while (head != null) {
            if (index % 2 == 1) {
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            index++;
            head = head.next;
        }
        // 调出循环需要两个链表的元素为null, 否则会有死循环
        cur1.next = null;
        cur2.next = null;
        // 逆转偶数位链表
        head2 = reverse(head2);
        // 然后再归并排序
        return merge(head1, head2);
    }
    private static ListNode reverse(ListNode head) {
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode reverseHead = null;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            if (nextNode == null) {
                reverseHead = curNode;
            }
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return reverseHead;
    }

    // 归并排序只能合并两个有序的链表或数组。比如[4,2],[1,3] 是无法采用下面方法合并的。
    private static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 != null && head2 == null) {
            return head1;
        }
        if (head1 == null && head2 != null) {
            return head2;
        }
        ListNode mergeHead = null;
        if (head1.val < head2.val) {
            mergeHead = head1;
            mergeHead.next = merge(head1.next, head2);
        } else {
            mergeHead = head2;
            mergeHead.next = merge(head1 ,head2.next);
        }
        return mergeHead;
    }


    public static void main(String[] args) {
        int[] nums = {1,8,3,6,5,4,7,2,9};
        ListNode head = ListNode.createList(nums);
        divide(head);
        ListNode.display(head);
    }
}
