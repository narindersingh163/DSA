package stack;

import java.util.Stack;

public class ReverseStack {
    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }

        int pop = stack.pop();
        reverse(stack);
        pushAtBottom(stack, pop);
    }

    public static void pushAtBottom(Stack<Integer> stack, int data){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }

        int curr = stack.pop();
        pushAtBottom(stack, data);
        stack.push(curr);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(7);
        stack.push(8);
        stack.push(9);

        reverse(stack);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
