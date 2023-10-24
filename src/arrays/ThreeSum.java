package arrays;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ThreeSum {//equal to 0, all the quadruplets
	
	public static List<List<Integer>> threeSum(int[] nums){
		Set<List<Integer>> set = new HashSet<>();
		Arrays.sort(nums);
		
		for(int i = 0; i < nums.length; i++) {
			
			int start = i + 1;
			int end = nums.length - 1;
			
			while(start < end) {
				int total = nums[i] + nums[start] + nums[end];
				if(total == 0)
					set.add(Arrays.asList(nums[i], nums[start], nums[end]));
				if(total > 0)
					end--;
				else
					start++;
			}
		}
		return new ArrayList<>(set);
	}
	
	public static void main(String[] args) {
		int[] nums = { -1,0,1,2,-1,-4 };
		List<List<Integer>> threeSum = threeSum(nums);
		System.out.println(threeSum);
	}

}
