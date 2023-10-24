package arrays;

public class MinRotatedArrayII {

	public int min(int[] nums) {
		if(nums.length == 1) {
			return nums[0];
		}
		
		if(nums[0] <= nums[nums.length - 1]) {
			return nums[0];
		}
		
		int left = 0;
		int right = nums.length - 1;
		
		while(left <= right) {
			int mid = left + (right - left)/2;
			
			if(nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];
			}
			
			if(nums[mid - 1] > nums[mid]) {
				return nums[mid - 1];
			}
			
			if(nums[mid] > nums[0]) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		
		return left;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,2,2,0,1};
		
		System.out.println(new MinRotatedArrayII().min(nums));
		
	}
}
