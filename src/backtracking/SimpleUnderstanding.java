package backtracking;

public class SimpleUnderstanding {
	
	public static void assignValues(int[] nums, int idx, int val) {
		if(idx == 5) {
			return;
		}
		
		nums[idx] = val;
		assignValues(nums, idx + 1, val + 1);
		nums[idx] = val - 2;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[5];
		assignValues(nums, 0, 1);
		
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

}
