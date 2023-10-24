package strings;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstring {//distinct characters

	public static int lengthBruteForce(String s) {
		int n = s.length();
		int maxLen = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (checkUnique(s, i, j))
					maxLen = Math.max(maxLen, j - i + 1);
			}
		}

		return maxLen;
	}

	public static boolean checkUnique(String s, int i, int j) {
		HashSet<Character> set = new HashSet<>();

		for (int start = i; start <= j; start++) {
			if (set.contains(s.charAt(start)))
				return false;
			set.add(s.charAt(start));
		}
		return true;
	}

	public static int length(String s) {
		int left = 0;
		int right = 0;
		int maxLen = 0;
		HashMap<Character, Integer> map = new HashMap<>();

		while (right < s.length()) {
			char c = s.charAt(right);
			map.put(c, map.getOrDefault(c, 0) + 1);
			
			while (map.get(c) > 1) {
				char l = s.charAt(left);
				map.put(l, map.get(l) - 1);
				left++;
			}

			maxLen = Math.max(maxLen, right - left + 1);
			right++;
		}

		return maxLen;
	}

	public static void main(String[] args) {
		String s = "pwwkew";
		System.out.println(length(s));
	}

}
