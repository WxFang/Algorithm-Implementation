public class Solution {
    public boolean isValid(String s) {
    	if(s == null || s.length() == 0) return false;
    	Stack<Character> st = new Stack<>();
    	for(Character c: s.toCharArray()){
    		if(c == '(')
    			st.push(')');
    		else if(c == '[')
    			st.push(']');
    		else if(c == '{')
    			st.push('}');
    		else
    			if(st.isEmpty() || st.pop() != c)
    				return false;
    	}	
    	return st.isEmpty();
    }
}

// followup:
// what if there are lots of parenthese?
// then use hashmap to restore mapping from left to right
// each time meet a left parennthsis, push a right one to the stack