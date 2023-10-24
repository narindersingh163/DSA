package arrays;

public class MaxSubArraySum {
	
	public static int max(int[] nums, int k) {
		int cSum = 0;
		int mSum = Integer.MIN_VALUE;
		
		for(int i = 0; i < k; i++) {
			cSum += nums[i];
		}
		
		mSum = Math.max(cSum, mSum);
		
		for(int i = k; i < nums.length; i++) {
			cSum = cSum - nums[i - k] + nums[i];
			mSum = Math.max(cSum, mSum);
		}
		
		return mSum;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,9,31,-4,21,7};
		int k = 3;
		
		System.out.println(max(nums, k));
	}

}
