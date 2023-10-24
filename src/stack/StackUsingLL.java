package stack;

public class StackUsingLL {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    Node head = null;

    public boolean isEmpty(){
        return head == null;
    }

    public void push(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public int pop(){
        if(isEmpty())
            return -1;

        if(head.next == null){
            int top = head.val;
            head = null;
            return top;
        }

        int top = head.val;
        head = head.next;
        return top;
    }

    public int peek(){
        if(isEmpty())
            return  -1;

        return head.val;
    }

    public void pushAtBottom(int data){
        if(isEmpty()){
            push(data);
            return;
        }

        int curr = pop();
        pushAtBottom(data);
        push(curr);
    }

    public static void main(String[] args) {
        StackUsingLL st = new StackUsingLL();
        st.push(8);
        st.push(9);
        st.push(3);
        st.pushAtBottom(5);

        while (!st.isEmpty()){
            System.out.print(st.peek() + " ");
            st.pop();
        }
    }
}
