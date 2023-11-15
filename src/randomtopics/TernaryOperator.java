package randomtopics;

import java.util.Scanner;

public class TernaryOperator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int next = sc.nextInt();

        String msg = next > 10 ? "Number is greater than 10" : "Number is less than 10";
        System.out.println(msg);
    }
}
