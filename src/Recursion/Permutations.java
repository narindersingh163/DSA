package Recursion;

public class Permutations {

    public static void permutations(String s, String perm){
        if(s.isEmpty()){
            System.out.println(perm);
            return;
        }

        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            permutations(s.substring(0,i) + s.substring(i + 1), perm + curr);
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        permutations(s, "");
    }
}
