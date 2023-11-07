package stacks;

public class UsingLL {
    public static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public Node top;

    public void push(int val){
        Node newNode = new Node(val);
        if(top == null){
            top = newNode;
            return;
        }

        newNode.next = top;
        top = newNode;
    }

    public int pop(){
        if(top == null){
            return -1;
        }
        int i = top.val;
        top = top.next;
        return i;
    }

    public void pushAtBottom(int val){
        if(top == null){
            push(val);
            return;
        }
        int i = pop();
        pushAtBottom(val);
        push(i);
    }

    public int peek(){
        return top.val;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void print(){
        while(!isEmpty()){
            System.out.print(peek() + " ");
            pop();
        }
    }

    public static void main(String[] args) {
        UsingLL stack = new UsingLL();
        stack.top = new Node(8);
        stack.push(7);
        stack.push(6);
        stack.push(5);
        stack.pushAtBottom(2);
        stack.pushAtBottom(1);
        stack.print();
    }
}
