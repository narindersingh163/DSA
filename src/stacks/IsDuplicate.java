package stacks;

import java.util.Stack;

public class IsDuplicate {

    public static boolean isDuplicate(String s){
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for(char c : arr){
            if(c == ')'){
                int count = 0;
                while (stack.pop() != '('){
                    count++;
                }
                if(count < 1) {
                    return true;
                }
            }else {
                stack.push(c);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "((a+b) + (c + d))";
        String str1 = "((a+b) + ((c + d)))";
        System.out.println(isDuplicate(str));
    }
}
