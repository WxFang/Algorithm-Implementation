// Leetcode 17

// dfs
public class Solution {
    private  static String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
    	List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
    	dfs(digits, res, new StringBuilder(), 0);
    	return res;
    }
    private void dfs(String digits, List<String> res, StringBuilder s, int pos){
    	if(pos > digits.length()) return;
    	if(pos == digits.length()){
    		res.add(s.toString());
    		return;
    	}
    	for(Character c: mapping[digits.charAt(pos) - '0'].toCharArray()){
    		s.append(c);
    		dfs(digits, res, s, pos + 1);
    		s.setLength(s.length() - 1);
    	}
    }
}

// followup question：
// to check valid words given a set of valid words.   
Map<String, List<String>> map = new HashMap<>();
