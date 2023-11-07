package stacks;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for (char c : arr) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (c == ')' && stack.peek() == '(')
                    stack.pop();
                if (c == ']' && stack.peek() == '[')
                    stack.pop();
                if (c == '}' && stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "((()))[]]";
        System.out.println(isValid(s));
    }
}
