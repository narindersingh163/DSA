package Iterative;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);
        
        for(int row = 1; row < numRows; row++) {
        	List<Integer> currRow = new ArrayList<>();
        	List<Integer> prevRow = triangle.get(row - 1);
        	currRow.add(1);
        	
        	for(int col = 1; col < prevRow.size(); col++) {
        		currRow.add(prevRow.get(col - 1) + prevRow.get(col));
        	}
        	
        	currRow.add(1);
        	triangle.add(currRow);
        }
        
        
        return triangle;
    }

	public static void main(String[] args) {
		List<List<Integer>> generate = generate(5);
		for(List<Integer> l : generate) {
			System.out.println(l);
		}
	}

}
