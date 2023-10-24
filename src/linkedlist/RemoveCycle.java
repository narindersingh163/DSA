package linkedlist;

public class RemoveCycle {
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

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
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

    public void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle = true;
                break;
            }
        }

        if(!cycle) {
            return;
        }

        slow = head;
        Node prev = null;

        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }



    public static void main(String[] args) {
        RemoveCycle ll = new RemoveCycle();
        head = new Node(8);
        Node temp = new Node(7);
        head.next = temp;
        temp.next = new Node(5);
        temp.next.next = new Node(4);
        temp.next.next.next = temp;

        System.out.println(ll.isCycle());
        ll.removeCycle();
        ll.print();
        System.out.println(ll.isCycle());
    }
}
