package day01;

import util.ListNode;

public class 删除链表重复节点 {
	//递增链表
	public static ListNode createList(int[] nums) {
		ListNode head = new ListNode(0);
		ListNode temp = head;
		for (int i = 0; i < nums.length; i++) {
			ListNode node = new ListNode(nums[i]);
			temp.next = node;
			temp = node;
		}
		temp.next = null;
		return head.next;
	}
	//输出链表
	public static void display(ListNode first) {
		while (first != null) {
			System.out.print(first.val + "  ");
			first = first.next;
		}
	}
		
	public static ListNode deleteDuplication(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode p = head;
		while (p != null && p.next != null) {
			if (p.val == p.next.val) {
				p.next = p.next.next;
			}else {
				p = p.next;
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,2,3,3,4,4,5,5,5,6};
		ListNode head = createList(nums);
		display(head);
		System.out.println();
		deleteDuplication(head);
		display(head);
	}
}
