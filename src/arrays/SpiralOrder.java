package arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

	public static List<Integer> spiral(int[][] matrix){
		int rows = matrix.length;
		int columns = matrix[0].length;
		List<Integer> result = new ArrayList<>();
		int left = 0;
		int right = columns - 1;
		int up = 0;
		int down = rows - 1;
		
		while(result.size() < rows * columns) {
			for(int col = left; col <= right; col++) {
				result.add(matrix[up][col]);
			}
			
			for(int row = up + 1; row <= down; row++) {
				result.add(matrix[row][right]);
			}
			
			if(up != down) {
				for(int col = right - 1; col >= left; col--) {
					result.add(matrix[down][col]);
				}
			}
			
			for(int row = down - 1; row > up; row--) {
				result.add(matrix[row][left]);
			}
			left++;
			right--;
			up++;
			down--;
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[][] arr = new int[3][4];
		int val = 1;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = val;
				val++;
			}
		}

		List<Integer> spiral = spiral(arr);
		for (Integer i : spiral) {
			System.out.print(i + " ");
		}

		System.out.println();

        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
				System.out.print(ints[j] + "   ");
			}
            System.out.println();
        }

	}

}
