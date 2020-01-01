package leecode.链表.链表串起来的问题;

import util.ListNode;

/**
 * @Author wangxi
 * @Time 2019/12/29 23:20
 * https://leetcode.com/problems/reverse-linked-list-ii/
 *
 * 解决疑惑：
 * （1）头插入法：
 * （2）p1->p2->p3   =>  p1->p3->p2
 * 那么：
 * Node temp = p2.next;
 * p2.next = null;
 * temp.next = p2  还是  temp.next = p1.next 呢?
 * p1.next = temp;
 *
 * ========
 * 经过分析：其实都可以。只是temp.next = p2情况，需要额外处理，每次需要移动p2的引用，否则会发生节点覆盖。
 */
public class ReverseLinkedListII {
    public ListNode reverseBetweenError(ListNode head, int m, int n) {
        if (head == null || m < 1 || m > n) {
            return null;
        }
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode p = first;
        for (int i = 1; i < m; i++) {
            p = p.next;
        }
        ListNode q = p.next;
        for (int i = 0; i < n - m; i++) {
            ListNode temp = q.next;
            q.next = q.next.next;
            /**
             * 这种情况，第一个temp节点会被顺利添加，但是后面新new出来的节点会把上一个temp节点
             * 覆盖掉。最终会导致最终只有一个节点。
             */
            temp.next = q;
            p.next = temp;

        }
        return first.next;
    }

    public ListNode reverseBetweenCorrect01(ListNode head, int m, int n) {
        if (head == null || m < 1 || m > n) {
            return null;
        }
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode p = first;
        for (int i = 1; i < m; i++) {
            p = p.next;
        }
        ListNode q = p.next;
        ListNode flag = q;
        for (int i = 0; i < n - m; i++) {
            ListNode temp = q.next;
            q.next = q.next.next;
            // 这种情况是，增加一个引用指针。可以让每个temp节点串起来
            temp.next = flag;
            p.next = temp;
            flag = temp;

        }
        return first.next;
    }

    public ListNode reverseBetweenCorrect02(ListNode head, int m, int n) {
        if (head == null || m < 1 || m > n) {
            return null;
        }
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode p = first;
        for (int i = 1; i < m; i++) {
            p = p.next;
        }
        ListNode q = p.next;
        for (int i = 0; i < n - m; i++) {
            ListNode temp = q.next;
            q.next = q.next.next;
            // 这种情况是，平滑的把所有temp节点串起来
            temp.next = p.next;
            p.next = temp;

        }
        return first.next;
    }

    public static void main(String[] args) {
        ReverseLinkedListII object = new ReverseLinkedListII();
        int[] nums = {1,2,3,4,5};
        ListNode head = util.ListNode.createList(nums);
        // 上面2中正确的做法，都经过了leetcode的OJ.
        head = object.reverseBetweenCorrect01(head, 1, 4);
        ListNode.display(head);
    }
}
