package slidingwindow;

import java.util.Collections;
import java.util.HashMap;

public class TwoDIstinctCharLongestLengthOfSubString {
	
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		int left = 0;
		int right = 0;
		int maxLen = 0;
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		while(right < s.length()) {
			map.put(s.charAt(right), right);
			
			if(map.size() == 3) {
				Integer charToDelete = Collections.min(map.values());
				map.remove(s.charAt(charToDelete));
				left = charToDelete + 1;
			}
			maxLen = Math.max(maxLen, right - left + 1);
			right++;
		}
		
		return maxLen;
	}
	
	public static void main(String[] args) {
		String s = "ecebf";
		System.out.println(lengthOfLongestSubstringTwoDistinct(s));
	}
}








