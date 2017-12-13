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

// bfs
public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> res = new LinkedList<String>();
        if(digits.length()==0) return res;
        res.add("");
        for(int i=0; i<digits.length(); i++){
            int x = digits.charAt(i)-'0';
            while(res.peek().length()==i){
                String tmp = res.remove();
                for(char s: mapping[x].toCharArray())
                    res.add(tmp+s);
            }
        }
        return res;
    }
}


// followup question：
// to check valid words given a set of valid words.   
Map<String, List<String>> map = new HashMap<>();
