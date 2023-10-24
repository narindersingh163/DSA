package arrays;

import java.util.HashMap;

public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int required = target - nums[i];
			if (map.containsKey(required))
				return new int[] { map.get(required), i };
			map.put(nums[i], i);
		}
		return null;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;

		int[] twoSum = twoSum(nums, target);

		if (twoSum.length == 2) {
			System.out.println(twoSum[0] + " " + twoSum[1]);
		} else {
			Throwable tr = new Throwable();
			tr.printStackTrace();
		}
	}

}
