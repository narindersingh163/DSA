package stack;

import java.util.Stack;

public class ReverseString {

    public static String reverse(Stack<Character> stack, String s){
        int idx = 0;
        while(idx < s.length()){
            stack.push(s.charAt(idx++));
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String s = reverse(stack, "abc");
        System.out.println(s);
    }
}
