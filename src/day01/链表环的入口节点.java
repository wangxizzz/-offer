package day01;

import util.ListNode;
/**
 * 面试23
 */
public class 链表环的入口节点 {
	//首先需要定位到环中的任意节点，为得出环的总结点数做准备
	public static ListNode meetingNode(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode p = head;
		ListNode q = head;
		while (p != null && p.next != null && q != null) {
			if (p.next.next == q) {
				return p;
			} else {
				p = p.next.next;
				q = q.next;
			}
		}
		return null;
	}
	
	public static ListNode entryOfLoop(ListNode head) {
		if (head == null) {
			return null;
		}
		//统计环中节点总数n
		ListNode temp = meetingNode(head);
		if (temp == null) {
			return null;
		}
		int count = 1;
		ListNode temp1 = temp;
		while (temp != temp1.next) {
			count++;
			temp1 = temp1.next;
		}
		//然后定义p,q  p走n步，p，q同时走
		ListNode p = head;
		ListNode q = head;
		for (int i = 1; i <= count; i++) {
			p = p.next;
		}
		while (p != q) {
			p = p.next;
			q = q.next;
		}
		return q;
	}
	
	public static void main(String[] args) {
		
	}
}
