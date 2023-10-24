package Recursion;

public class StringReverse {
	public static void helper(char[] charArray, int idx) {
		if(idx == charArray.length) {
			return;
		}
		
		helper(charArray, idx + 1);
		System.out.print(charArray[idx]);
	}

	public static void reverse(String s) {
		if(s.length() == 1 || s.length() == 0) {
			System.out.println(s);
			return;
		}
		char[] charArray = s.toCharArray();
		
		helper(charArray, 0);
	}
	
	public static void main(String[] args) {
		String s = "narinderpal singh";
		
		reverse(s);
	}
}
