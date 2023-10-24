package arrays;

public class RotateImage {


	public static void rotate(int[][] matrix) {
		//transpose
		transpose(matrix);
		//reflect
		reflect(matrix);
	}
	
	

	private static void transpose(int[][] matrix) {
		int n = matrix.length;
		
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		System.out.println("transpose: ");
		for(int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}



	private static void reflect(int[][] matrix) {
		int n = matrix.length;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n/2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - 1 - j];
				matrix[i][n - 1 - j] = temp;
			}
		}
		
		System.out.println("Reflect: ");
		for(int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}



	public static void main(String[] args) {
		int[][] matrix = new int[3][3];
		int val = 1;
		for(int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = val++;
			}
		}
		
		//printing
		for(int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		rotate(matrix);
		
	}
}
