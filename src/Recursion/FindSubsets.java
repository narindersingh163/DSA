package Recursion;

public class FindSubsets {
    //total number of subsets are 2^n.

    public static void subsets(String s, String subset){
        if(s.isEmpty()){
            if(subset.isEmpty())
                System.out.print("empty");
            System.out.print(subset + " ");
            return;
        }
        char c = s.charAt(0);
        s = s.substring(1);
        subsets(s, subset + c);
        subsets(s, subset);
    }

    public static void main(String[] args) {
        String s = "abc";
        subsets(s, "");
    }
}
