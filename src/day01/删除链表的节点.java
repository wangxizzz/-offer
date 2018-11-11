package day01;

import util.ListNode;

/**
 * 面试18 注意：这个题是有前提条件的
 */
public class 删除链表的节点 {
	
	/**
	 * 1.删除中间节点
	 * 2.删除尾节点
	 * 3.删除头结点
	 */
	public static ListNode deleteNode(ListNode head, ListNode toBeDeletedNode) {
		if (head == null || toBeDeletedNode == null) {
			return null;
		}
		//删除的中间节点
		if (toBeDeletedNode.next != null) {
			ListNode p =  toBeDeletedNode.next;
			toBeDeletedNode.val = p.val;
			toBeDeletedNode.next = p.next;
			return head;
		} 
		//如果只有一个头节点，删除头结点
		else if (head == toBeDeletedNode) {
			head = null;
			return head;
		}
		//删除尾节点，还是需要遍历
		else {
			ListNode q = head;
			//找到最后一个节点的前一个节点
			for (; q.next.next != null; q = q.next) {
				
			}
			//找到最后一个节点的前一个节点，然后.next = null，才可以删掉最后一个节点
			q.next = null;
			return head;
		}
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(2);
		head.next = second;
		second.next = third;
		third.next = null;
		System.out.println(deleteNode(head, third).next.next.val);
//		head.next = null;
//		System.out.println(deleteNode(head, head));
	}
}
