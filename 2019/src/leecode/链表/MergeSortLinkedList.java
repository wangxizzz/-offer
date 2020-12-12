package leecode.链表;

import util.ListNode;

/**
 * @author wangxi created on 2020/12/12 19:19
 * @version v1.0
 *
 * https://leetcode-cn.com/problems/sort-list/
 *
 * 利用归并排序：
 * （1）找到链表的中点，以中点为分界，将链表拆分成两个子链表。寻找链表的中点可以使用快慢指针的做法，
 *      快指针每次移动 22 步，慢指针每次移动 11 步，当快指针到达链表末尾时，慢指针指向的链表节点即为链表的中点。
 *
 * （2） 对两个子链表分别排序。
 *
 * （3）将两个排序后的子链表合并，得到完整的排序后的链表，将两个有序的子链表进行合并。
 *
 */
public class MergeSortLinkedList {
    public ListNode sortList(ListNode head) {
        // 递归退出的条件
        if (head == null || head.next == null) {
            // 注意，如果head == null，返回Head本身即可。这样可以防止此题的坑，如果返回null，就会有问题
            return head;
        }
        // 归并排序
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            if (fast.next == null || fast.next.next == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode temp = mid.next;
        // 断开链表
        mid.next = null;
        ListNode newHead1 = sortList(head);
        ListNode newHead2 = sortList(temp);
        return merge(newHead1, newHead2);

    }

    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null && head2 != null) {
            return head2;
        }
        if (head1 != null && head2 == null) {
            return head1;
        }
        ListNode head = null;
        if (head1.val >= head2.val) {
            head = head2;
            head.next = merge(head1, head2.next);
        } else {
            head = head1;
            head.next = merge(head1.next, head2);
        }
        return head;
    }
}
