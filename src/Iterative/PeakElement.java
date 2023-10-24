package Iterative;

//A peak element is an element that is strictly greater than its neighbors.
//
//Given a 0-indexed integer array nums,find a peak element,and return its index.
//If the array contains multiple peaks,return the index to any of the peaks.
//
//You may imagine that nums[-1]=nums[n]=-∞.In other words,an element is always
//considered to be strictly greater than a neighbor that is outside the array.
public class PeakElement {

	public static int peak(int[] nums) {// O(n)

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1])
				return i;
		}
		return nums.length - 1;
	}

	public static int peakII(int[] nums) {// O(log n)
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] > nums[mid + 1])
				right = mid;
			else
				left = mid + 1;
		}
		return left;
	}
	
	public static int peakRecursive(int[] nums) {
		return search(nums, 0 , nums.length - 1);
	}
	
	public static int search(int[] nums, int left, int right) {
		if(left == right) {
			return left;
		}
		
		int mid = left + (right - left)/2;
		
		if(nums[mid] > nums[mid + 1])
			return search(nums, left, mid);
		return search(nums, mid + 1, right);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 4, 3, 5 };
		System.out.println(peak(nums));

		System.out.println(peakII(nums));
		
		System.out.println(peakRecursive(nums));
	}

}
