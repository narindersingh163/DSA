package arrays;

public class MinInRotatedArray {

	//based on the inflection point. It is the point where the array starts decreasing.
	public static int min(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		
		//edge case
		if(nums.length == 1)
			return nums[0];
		
		//no rotation. If there is no rotation then that means the last element will be greater than the first element.
		if(nums[0] < nums[right])
			return nums[0];

		while (left <= right) {
			int mid = left + (right - left) / 2;
			
			//case 1. If mid is greater than mid + 1 then mid + 1 is the inflection point.
			if(nums[mid] > nums[mid + 1])
				return nums[mid + 1];
			
			//case 2. If the mid - 1 is greater than mid then mid is the inflection point. 
			if(nums[mid - 1] > nums[mid])
				return nums[mid];
			
			//case 3. If mid is greater than index 0 then search right. left = mid + 1.
			if(nums[mid] > nums[0])
				left = mid + 1;
			
			//case 4. if mid is less than index 0 then the array's inflection point was on the left hand side so we search in the left. right = mid - 1.
			else
				right = mid - 1;
		}
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		int[] nums = { 2,1};
		System.out.println(min(nums));
	}
}
