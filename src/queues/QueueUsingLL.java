package queues;

public class QueueUsingLL {

    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public void add(int val){
        Node temp = new Node(val);
        if(head == null){
            head = tail = temp;
            return;
        }

        tail.next = temp;
        tail = temp;
    }

    public int remove(){
        if(head == null){
            System.out.println("Queue is Empty");
            return -1;
        }

        int remove = head.val;
        if(tail == head){
            head = tail = null;
        }
        head = head.next;
        return remove;
    }

    public int peek(){
        if(head == null){
            System.out.println("Queue is empty");
            return -1;
        }

        return head.val;
    }

    public void print(){
        if(head == null){
            return;
        }

        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
            if(head == tail){
                System.out.println(head.val);
                head = tail = null;
            }
        }
    }

    public static void main(String[] args) {
        QueueUsingLL q = new QueueUsingLL();
        q.add(8);
        q.add(7);
        q.add(6);
        q.print();
        System.out.println(q.peek());
    }
}
