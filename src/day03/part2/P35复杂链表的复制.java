package day03.part2;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/6/22 0022 15:13
 */
public class P35复杂链表的复制 {

    public static ComplexListNode copy(ComplexListNode head) {
        if (head != null) {
            copyNodes(head);
            connectSiblingNodes(head);
            return divide(head);
        }
        return null;
    }
    //第一步，复制节点
    private static void copyNodes(ComplexListNode head) {
        ComplexListNode temp = head;
        while (temp != null) {   //插入节点的方法 ，有待验证
            ComplexListNode nextNode = temp.next;
            ComplexListNode c = new ComplexListNode();
            c.val = temp.val;
            temp.next = c;
            c.next = nextNode;
            temp = c.next;
        }
    }
    private static void connectSiblingNodes(ComplexListNode head) {
        ComplexListNode temp = head;
        while (temp != null) {
            ComplexListNode nextNode = temp.next;
            if (temp.sibling != null) {
                nextNode.sibling = temp.sibling.next;
            }
            temp = nextNode.next;
        }
    }
    private static ComplexListNode divide(ComplexListNode head) {
        ComplexListNode temp = head;
        ComplexListNode copyHead = null;  //复制后链表的头结点
        ComplexListNode copyTemp = null;  //复制后链表的temp节点，用来找到其他节点
        //确定复制链表的头结点
        if (temp != null) {
            copyHead = copyTemp = temp.next;
            temp.next = copyTemp.next;
            temp = temp.next;
        }
        //再找其他节点
        while (temp != null) {
            copyTemp.next = temp.next;
            copyTemp = copyTemp.next;
            temp.next = copyTemp.next;
            temp = temp.next;
        }
        return copyHead;
    }

    static class ComplexListNode {
        int val;
        ComplexListNode next;
        ComplexListNode sibling;
    }

}
