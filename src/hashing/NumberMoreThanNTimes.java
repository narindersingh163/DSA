package hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class NumberMoreThanNTimes {
    public static int[] elements(int[] nums, int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[nums.length];
        int idx = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Integer i : map.keySet()){
            if(map.get(i) >= 3){
                arr[idx++] = i;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,5,6,5,4,3,2,1,2,3,4,5,4,3,2};
        int[] elements = elements(nums, 3);
        for(int i : elements) {
            System.out.print("[" + i + "] ");
        }
    }
}
