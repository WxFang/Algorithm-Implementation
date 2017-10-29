import java.io.*;
import java.util.*;

class GFG {
	// Time O(4^N)
    static String[] table = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
	public static void main (String[] args) {
		List<String> list = combination("01234");
		for(String s: list)
		    System.out.print(s + " ");
	}
	
	public static List<String> combination(String s){
    	List<String> res = new LinkedList<>();
	    if(s == null || s.length() == 0) 
	        return res;
	    // dfs(s, res, new StringBuilder(""), 0);
	    bfs(s, res);
	    return res;
	}
	
	private static void dfs(String s, List<String> res, StringBuilder temp, int pos){
	    if(pos == s.length()){
	        res.add(temp.toString());
	        return;
	    }
	    String dial = table[s.charAt(pos) - '0'];
	    // handle 0 or 1
	    if(dial.length() == 0)
	        dfs(s, res, temp, pos + 1);
	    for(int i = 0; i < dial.length(); i++){
	        temp.append(dial.charAt(i));
	        dfs(s, res, temp, pos + 1);
	        temp.setLength(temp.length() - 1);
	    }
	}

	private static void bfs(String s, List<String> res){

	}
}