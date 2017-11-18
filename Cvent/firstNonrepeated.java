public class Solution {
	public char firstNonrepeated(String s) {
    	if(s == null || s.length() == 0) return ' ';
    	char[] arr = new char[256];
    	for(char c: s.toCharArray())
    		arr[c]++;
    	for(char c: s.toCharArray())
    		if(arr[c] == 1)
    			return c;
    	return ' ';
    }
}