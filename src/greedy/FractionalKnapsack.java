package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static void fractionalKnSc(int[] val, int[] weight, int capacity){
        double[][] ratio = new double[val.length][2];

        for(int i = 0; i < val.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int totalPrice = 0;
        int totalCapacity = capacity;
        for(int i = ratio.length - 1; i >= 0; i--){
            int idx = (int) ratio[i][0];
            if(totalCapacity > weight[idx]){
                totalCapacity -= weight[idx];
                totalPrice += val[idx];
            }else{
                totalPrice += (int) (totalCapacity * ratio[i][1]);
                totalCapacity = 0;
                break;
            }
        }

        System.out.println(totalPrice);

    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int capacity = 50;
        fractionalKnSc(val, weight, capacity);
    }
}
