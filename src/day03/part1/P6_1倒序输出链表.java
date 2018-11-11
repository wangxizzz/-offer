package day03.part1;

import util.ListNode;

import java.util.Stack;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/5/22 0022 10:41
 */
public class P6_1倒序输出链表 {
    /**
     * 借用辅助栈，时间O(n)，空间O(n)
     * @param head
     */
    public static void print(ListNode head) {
        if (head == null) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        for (ListNode temp = head; temp != null; temp = temp.next) {
            stack.push(temp.val);
        }
        //注意：遍历栈、队列是判断是否为空
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,7,3};
        ListNode head = ListNode.createList(num);
        print(head);
    }
}
