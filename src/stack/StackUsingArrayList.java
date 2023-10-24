package stack;

import java.util.ArrayList;

public class StackUsingArrayList {
    ArrayList<Integer> stack = new ArrayList<>();

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void push(int data){
        stack.add(data);
    }

    public int pop(){
        return stack.remove(stack.size()-1);
    }

    public int peek(){
        return stack.get(stack.size()-1);
    }

    public static void main(String[] args) {
        StackUsingArrayList stack = new StackUsingArrayList();
        stack.push(8);
        stack.push(7);
        stack.push(5);

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
