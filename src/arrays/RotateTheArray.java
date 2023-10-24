package arrays;

public class RotateTheArray {

	public static void rotate(int[] nums, int k) {
		if(nums.length == 1) {
			System.out.println(nums[0]);
			return;
		}
		
		if(k == 0 ||  k % nums.length == 0) {
			for(int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
			}
			return;
		}
		
		k = k % nums.length;
		int[] arr = new int[nums.length];
		int idx = 0;
		
		for(int i = nums.length - k; i < nums.length; i++) {
			arr[idx] = nums[i];
			idx++;
		}
		
		for(int i = 0 ; i < nums.length - k; i++) {
			arr[idx] = nums[i];
			idx++;
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		
		rotate(nums, 1);
		
	}
}
