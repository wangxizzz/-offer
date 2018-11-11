package demos.demo01;

/**
 * @Author: wangxi
 * @Description :参考网址：https://blog.csdn.net/u012249528/article/details/47124771
 *            leetCode测试网址：https://leetcode-cn.com/problems/palindrome-linked-list/description/
 * @Date: 2018/7/17 0017 10:51
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class 回文链表 {
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        //得到长度，判断奇偶性
        ListNode slow = head;
        ListNode fast = head;
        if (head.next == null) {
            return true;
        }
        //找到中间节点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //只有使用头插入法来逆转链表，逆转指针指向是不行的
        ListNode midNode = slow;
        ListNode firstNode = midNode.next;  //该逆转部分的第一个节点
        ListNode curNode = firstNode.next;   //把当前节点头插入
        firstNode.next = null;  //第一个节点会变为尾节点
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = midNode.next;    //头插入法的核心
            midNode.next = curNode;
            curNode = nextNode;
        }
        //复用指针
        slow = head;
        fast = midNode.next;
        while (fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
