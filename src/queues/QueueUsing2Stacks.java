package queues;

import java.util.Stack;

public class QueueUsing2Stacks {

    static Stack<Integer> q1 = new Stack<>();
    static Stack<Integer> q2 = new Stack<>();

    public static boolean isEmpty(){
        return q1.isEmpty();
    }

    public static void add(int val){
        if(isEmpty()){
            q1.push(val);
            return;
        }

        //first empty the q1 stack and add all to the q2.
        while (!q1.isEmpty()){
            q2.push(q1.pop());
        }

        q1.push(val);

        //now add elements back to the q1 stack.
        while (!q2.isEmpty()){
            q1.push(q2.pop());
        }
    }

    public static int remove(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }

        return q1.pop();
    }

    public static int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }

        return q1.peek();
    }
    public static void main(String[] args) {
        add(6);
        add(7);
        add(8);
        System.out.println(remove());
    }
}
