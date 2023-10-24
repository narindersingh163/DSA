package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRange {

	public static List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
		List<List<Integer>> result = new ArrayList<>();

		if (nums.length == 0) {
			result.add(Arrays.asList(lower, upper));
			return result;
		}

		if (nums[0] > lower) {
			result.add(Arrays.asList(lower, nums[0] - 1));
		}

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i + 1] - nums[i] == 1) {
				continue;
			}
			result.add(Arrays.asList(nums[i] + 1, nums[i + 1] - 1));
		}

		if (nums[nums.length - 1] < upper) {
			result.add(Arrays.asList(nums[nums.length - 1] + 1, upper));
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 3, 50, 75 };

		System.out.println(findMissingRanges(nums, 0, 99));
	}

}
