package Recursion;

public class SwapNodesInPairs {

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

	public static ListNode swap(ListNode head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode firstNode = head;
		ListNode secondNode = head.next;
		
		firstNode.next = swap(secondNode.next);
		secondNode.next = firstNode;
		
		
		return secondNode;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = null;
		
		ListNode swap = swap(head);
		System.out.println(swap.val);
		System.out.println(swap.next.val);
		System.out.println(swap.next.next.val);
		System.out.println(swap.next.next.next.val);
	}
}
