package util;

public class ListNode {
	public int val;
	public ListNode next;
	
	public ListNode() {
		// TODO Auto-generated constructor stub
	}
	
	public ListNode(int x) { val = x; }


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

}

