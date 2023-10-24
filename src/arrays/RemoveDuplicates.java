package arrays;


//for sorted increasing array
public class RemoveDuplicates {

	public static void remove(int[] nums) {
		int curr = Integer.MIN_VALUE;
		int idx = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(curr != nums[i]) {
				curr = nums[i];
				nums[idx] = nums[i];
				idx++;
			}
		}
		
		for(int i = 0; i < nums.length; i++) {
			System.out.print("[" + nums[i] + "]" + " ");
		}
		
		System.out.println("\n" + "Count of uniques elements is : " + idx);
	}

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

		remove(nums);
	}
}
