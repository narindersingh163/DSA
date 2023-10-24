package Iterative;

import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

public class Intersection {
	
	public int[] result(Set<Integer> largerSet, Set<Integer> smallerSet) {
		int[] arr = new int[smallerSet.size()];
		int idx = 0;
		
		for(Integer i : smallerSet) {
			if(largerSet.contains(i)) {
				arr[idx] = i;
				idx++;
			}
		}
		return Arrays.copyOf(arr, idx);
	}
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        
        for(int i : nums1) 
        	set1.add(i);
        
        Set<Integer> set2 = new HashSet<>();
        
        for(int i : nums2) 
        	set2.add(i);
        
        if(set1.size() > set2.size())
        	return result(set1, set2);
		return result(set2, set1);
    }
    
    public static void main(String[] args) {
		int[] nums1 = {9,4,9,8,4};
		int[] nums2 = {4,9,5};
		
		Intersection intersection = new Intersection();
		int[] intersection2 = intersection.intersection(nums1, nums2);
		
		for(int i : intersection2) {
			System.out.print(i + " ");
		}
	}
}
