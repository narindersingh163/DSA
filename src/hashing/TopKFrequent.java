package hashing;

import java.util.*;

public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();

        if(nums.length==1)
            return nums;

        if(nums.length>=2) {
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());

        int[] n = new int[k];
        int x = 0;
        while(x < k){
            n[x++] = pq.remove();
        }

        return n;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 1;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}