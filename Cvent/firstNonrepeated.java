// improvement
// dont traverse string again
// restore first meet index and counts together in map
// iterate map once instead of string
// O(256*n)
public class Solution {
    public char firstNonrepeated(String s) {

        Map<Character, int[]> map = new HashMap<>(256);
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c))
                map.put(c, new int[]{i, 1});
            else
                map.put(c, new int[]{map.get(c)[0], map.get(c)[1] + 1});
        }

        int res= s.length();
        for(int[] value: map.values())
            if(value[1] == 1 && value[0] < res)
                res = value[0];

        return s.charAt(res);
    }
}


// O(2*n) two pass
// doesnt apply to long string with limited unique letters
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