package linkedlist;

public class DetectCycle {
    public static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycle ll = new DetectCycle();
        head = new Node(9);
        head.next = new Node(8);
        head.next.next = new Node(7);
        head.next.next.next = head;

        System.out.println(ll.isCycle());
    }
}
