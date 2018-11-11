package day03.part1;

import util.ListNode;

/**
 * @Author:王喜
 * @Description : 递归很好的例子 p59
 * @Date: 2018/5/24 0024 10:56
 */
public class P6_2倒序输出链表 {

    public static void printWithRecursive(ListNode head) {
        if (head != null) {
            if (head.next != null) {
                printWithRecursive(head.next);
            }
            System.out.print(head.val + "  ");
        }
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        ListNode head = ListNode.createList(num);
        printWithRecursive(head);
    }
}
