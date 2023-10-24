package Iterative;

import java.util.Arrays;
import java.util.HashMap;

public class IntersectionII {


	public int[] intersect(int[] nums1, int[] nums2) {
		if(nums1.length > nums2.length)
			return intersect(nums2, nums1);
		
		//if we are here nums1 length is short or equal to nums2
		HashMap<Integer, Integer> map = new HashMap<>();
		
		//add all the elements into the map
		for(int i : nums1)
			map.put(i, map.getOrDefault(i, 0) + 1);
		
		int[] arr = new int[nums1.length];
		int idx = 0;
		
		for(int i : nums2) {
			Integer count = map.getOrDefault(i, 0);
			if(count > 0) {
				arr[idx] = i;
				idx++;
				map.put(i, map.get(i) - 1);
			}
		}
		
		return Arrays.copyOf(arr, idx);

	}

	public static void main(String[] args) {
		int[] nums1 = { 4,9,5 };
		int[] nums2 = { 9,4,9,8,4 };
		
		IntersectionII intersection = new IntersectionII();
		int[] findIntersection = intersection.intersect(nums1, nums2);
		
		for(int i : findIntersection) {
			System.out.print(i + " ");
		}
		
	}

}
