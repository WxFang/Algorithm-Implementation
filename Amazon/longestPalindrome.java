package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class longestPalindrome {

	private static int lo, maxLen;
	
	public static String _longestPalindrome(String s){
		if(s.length() < 2) return s;
		for(int i = 0; i < s.length() - 1; i++){
			helper(i, i + 1, s);
			helper(i, i + 2, s);
		}
		return s.substring(lo, lo + maxLen);
	}
	
	private static void helper(int left, int right, String s){
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
			left--;
			right++;
		}
		if(right - left - 1 > maxLen){
			lo = left + 1;
			maxLen = right - left - 1;
		}
	}
	
	public static void main(String[] args){
		List<String> input = new ArrayList<>();
		input.addAll(Arrays.asList("abbasce","","a","abbaabb","abbwccccwbba"));
		for(String s: input)
			System.out.println(_longestPalindrome(s));
	}
}

