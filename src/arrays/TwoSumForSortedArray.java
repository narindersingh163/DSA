package arrays;

public class TwoSumForSortedArray {

	public int[] twoSum(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length - 1;

		while (left < right) {
			if (numbers[left] + numbers[right] == target)
				return new int[] {left + 1, right + 1};
			
			if (numbers[left] + numbers[right] > target) 
				right--;
			else 
				left++;
		}
		
		return null;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0 };
		int target = -1;

		TwoSumForSortedArray ts = new TwoSumForSortedArray();
		int[] twoSum = ts.twoSum(nums, target);

		System.out.println(twoSum[0] + " " + twoSum[1]);
	}

}
