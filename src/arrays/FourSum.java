package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Set<List<Integer>> set = new HashSet<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> threeSum = threeSum(nums, target - nums[i], i + 1, nums.length);
			if (!threeSum.isEmpty()) {
				for (List<Integer> list : threeSum) {
					List<Integer> l = new ArrayList<>();
					l.addAll(list);
					l.add(nums[i]);
					set.add(l);
				}
			}
		}
		return new ArrayList<>(set);
	}

	public static List<List<Integer>> threeSum(int[] nums, int target, int start, int end) {
		Set<List<Integer>> set = new HashSet<>();

		for (int i = start; i < end; i++) {
			int begin = i + 1;
			int finish = end - 1;

			while (begin < finish) {
				long sum = (long) nums[i] + nums[begin] + nums[finish];
				if (sum == target)
					set.add(Arrays.asList(nums[i], nums[begin], nums[finish]));
				if (sum > target)
					finish--;
				else
					begin++;
			}
		}

		return new ArrayList<>(set);
	}

	public static void main(String[] args) {
		int[] nums = { 1000000000, 1000000000, 1000000000, 1000000000 };
		int target = -294967296;

		List<List<Integer>> fourSum = fourSum(nums, target);
		System.out.println(fourSum);
	}

}
