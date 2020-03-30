package leecode.链表.链表节点引用问题;

import util.ListNode;

/**
 * @Author wangxi
 * @Time 2020/3/28 22:27
 */
public class Main01 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ListNode head = ListNode.createList(nums);

        System.out.println(head.next);
        // 起初 temp与node指向的同一片内存区域，后来temp移动了指向了其他的内存区域，
        // 因此temp移动后，改变其值，对temp没影响。
        ListNode node = new ListNode(-1);
        ListNode temp = node;
        temp.next = head.next;
        temp = temp.next;
        temp.next = head.next.next;
        temp = temp.next;

        System.out.println(temp);

        System.out.println(node.next);
    }
}
