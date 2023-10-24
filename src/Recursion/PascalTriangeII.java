package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangeII {
	
	public static int getNumber(int rowIndex, int colIndex) {
		if(rowIndex == 0 || colIndex == 0 || rowIndex == colIndex) {
			return 1;
		}
		
		return getNumber(rowIndex - 1, colIndex - 1) + getNumber(rowIndex - 1, colIndex);
	}
	
	
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> ans = new ArrayList<>();
		
		for(int i = 0; i <= rowIndex; i++) {
			ans.add(getNumber(rowIndex, i));
		}
		
		return ans;
	}

	public static void main(String[] args) {
		List<Integer> row = getRow(31);
		System.out.println(row);
	}

}












