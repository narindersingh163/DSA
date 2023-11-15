package dynamicprogramming;

public class ClimbingStairs {

    /**
     * 1 or 2 steps at a time
     * @param n is the step we want to reach
     * @return the number of ways we can reach the step number n
     */
    public static int climbingRecursive(int n){
        if(n == 0 || n == 1) return 1;

        return climbingRecursive(n - 1) + climbingRecursive(n - 2);
    }

    public static int climbingDp(int n, int[] f){
        if(n == 0 || n == 1) return f[n] = 1;

        f[n] = f[n] != 0 ? f[n] : climbingDp(n - 1, f) + climbingDp(n - 2, f);

        return f[n];
    }
    public static void main(String[] args) {
        int n = 77;
        int[] f = new int[n + 1];
        System.out.println(climbingDp(n, f));
        System.out.println(climbingRecursive(n));
    }
}
