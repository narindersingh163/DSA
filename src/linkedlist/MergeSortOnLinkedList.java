package linkedlist;

public class MergeSortOnLinkedList {
    public static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;
    public int size;

    public void addFirst(int val){
        size++;
        Node newNode = new Node(val);
        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int val){
        size++;
        Node newNode = new Node(val);
        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void print(Node currHead){
        Node temp = currHead;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node mid(Node currHead){
        Node slow = currHead;
        Node fast = currHead.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public Node mergeSort(Node currHead){
        if(currHead == null || currHead.next == null){
            return currHead;
        }

        Node mid = mid(currHead);
        Node right = mid.next;
        mid.next = null;

        Node leftSide = mergeSort(currHead);
        Node rightSide = mergeSort(right);

        return merge(leftSide, rightSide);
    }

    public Node merge(Node left, Node right){
        Node mergedLL = new Node(-1);
        Node tempListHead = mergedLL;
        Node leftPointer = left;
        Node rightPointer = right;

        while(leftPointer != null && rightPointer != null){
            if(leftPointer.val < rightPointer.val){
                tempListHead.next = leftPointer;
                leftPointer = leftPointer.next;
            }else{
                tempListHead.next = rightPointer;
                rightPointer = rightPointer.next;
            }
            tempListHead = tempListHead.next;
        }

        while(leftPointer != null){
            tempListHead.next = leftPointer;
            tempListHead = tempListHead.next;
            leftPointer = leftPointer.next;
        }

        while(rightPointer != null){
            tempListHead.next = rightPointer;
            tempListHead = tempListHead.next;
            rightPointer = rightPointer.next;
        }

        return mergedLL.next;
    }
    public static void main(String[] args) {
        MergeSortOnLinkedList ll = new MergeSortOnLinkedList();
        ll.head = ll.tail = new Node(4);
        ll.addFirst(8);
        ll.addFirst(9);
        ll.addLast(5);
        ll.print(ll.head);
        Node newHead = ll.mergeSort(ll.head);
        ll.print(newHead);
    }
}
