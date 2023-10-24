package linkedlist;

public class LinkedListImp {
    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    private Node head;
    private Node tail;
    private int size;

    public void getHead() {
        System.out.println("Head is : " + head.val);
    }

    public void getTail() {
        System.out.println("Tail is : " + tail.val);
    }

    public void addFirst(int val){
        Node newNode = new Node(val);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int val){
        Node newNode = new Node(val);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void addAt(int val, int idx){
        if(size == 0 || idx == 0){
            addFirst(val);
            return;
        }
        if(size > 0 && size <= idx){
            addLast(val);
            return;
        }

        size++;
        Node newNode = new Node(val);
        int currIdx = 0;
        Node temp = head;
        while(currIdx < idx - 1) {
            temp = temp.next;
            currIdx++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void removeFirst(){
        if(head == null){
            return;
        }
        size--;
        head = head.next;
    }
    public void removeLast(){
        if(tail == null){
            return;
        }

        size--;
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
    }

    public int itrSearch(int key){
        if(head == null){
            return -1;
        }

        int idx = 0;
        Node temp = head;
        while(temp != null){
            if(temp.val == key){
                return idx;
            }
            temp = temp.next;
            idx++;
        }
        return -1;
    }

    public int helperSearch(Node temp, int key, int idx){
        if(temp.val == key){
            return idx;
        }

        return helperSearch(temp.next, key, idx+1);
    }
    public int recursiveSearch(int key){
        if(head == null){
            return -1;
        }

        Node temp = head;
        return helperSearch(temp, key, 0);
    }

    public void reverse(){
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public void size(){
        System.out.println("Size is : " + size);
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedListImp ll = new LinkedListImp();
        ll.addFirst(7);
        ll.addLast(6);
        ll.addFirst(9);
        ll.size();
        ll.addAt(5,2);
        ll.print();

        ll.reverse();
        ll.print();
    }
}
