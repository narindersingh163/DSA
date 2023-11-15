package dynamicprogramming;

public class O1Knapsack {

    public static int knapsack(int[] val, int[] wt, int W, int n){
        if(n == 0 || W == 0) return 0;

        if(wt[n - 1] <= W){//valid
            //include
            int val1 = val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1);
            //don't include
            int val2 = knapsack(val, wt, W, n - 1);

            return Math.max(val1, val2);
        }else {//invalid
            return knapsack(val,wt, W, n - 1);
        }

    }

    public static void main(String[] args) {
        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4};
        int W = 7;

        System.out.println(knapsack(val, wt, W, val.length));
    }
}
