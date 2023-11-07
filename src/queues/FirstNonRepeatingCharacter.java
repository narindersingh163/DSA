package queues;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacter {

    public static void printNonRepeating(String str){
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(char c : str.toCharArray()){
            freq[c - 'a']++;
            q.add(c);
            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            if(q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }
    public static void main(String[] args) {
        String str = "aabccxb";
        printNonRepeating(str);
    }
}
