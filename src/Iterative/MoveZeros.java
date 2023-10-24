package Iterative;

public class MoveZeros {
	
	public static void move(int[] nums) {
		int idx = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) {
				nums[idx] = nums[i];
				idx++;
			}
		}
		
		for(int i = idx; i < nums.length; i++) {
			nums[i] = 0;
		}
		
		for(int i = 0; i < nums.length; i++) {
			System.out.print("[" + nums[i] + "]" + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] nums = { 0,1,0,3,12 };
		move(nums);
	}

}
