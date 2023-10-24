package Recursion;

public class ReverseALinkedList {
	
	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	//recursive
	public static ListNode reverse(ListNode head) {
		if(head == null) {
			return null;
		}
		if(head.next == null) {
			return head;
		}
	
		ListNode newHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		
		return newHead;
	}
	
	//iterative
	public static ListNode reverseII(ListNode head) {
		if(head == null) {
			return null;
		}
		if(head.next == null) {
			return head;
		}
		
		ListNode prev = null;
		ListNode curr = head;
		
		while(curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			
		}
		head = prev;
		return head;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = null;
		
		System.out.println(reverseII(head).val);
	}

}
