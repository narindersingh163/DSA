package linkedlist;

public class ReverseBetween {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public ListNode head;
    public ListNode tail;

    public void addFirst(int val){
        ListNode newNode = new ListNode(val);
        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int val){
        ListNode newNode = new ListNode(val);
        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode leftPrev = dummy;
        ListNode curr = head;

        for(int i = 1; i < left; i++){
            leftPrev = leftPrev.next;
            curr = curr.next;
        }

        ListNode prev = null;
        ListNode next;
        for(int i = 0; i < (right - left + 1); i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        leftPrev.next.next = curr;
        leftPrev.next = prev;

        return dummy.next;
    }

    public void print(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ReverseBetween ll= new ReverseBetween();
        ll.head = ll.tail = new ListNode(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        ll.addLast(9);
        ll.addLast(10);
        ll.addLast(11);

        ll.print(ll.head);

        ListNode listNode = ll.reverseBetween(ll.head, 4, 9);

        ll.print(listNode);
    }
}
