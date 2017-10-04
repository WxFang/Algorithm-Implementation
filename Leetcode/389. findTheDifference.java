// array
class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length() != t.length() - 1)
            return ' ';
        int[] arr = new int[26];
        for(char c: s.toCharArray())
            arr[c - 'a']++;
        for(char c: t.toCharArray()){
            if(arr[c - 'a'] <= 0)
                return c;
            arr[c - 'a']--;
        }
        return ' ';
    }
}

// hashmap
class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length() != t.length() - 1)
            return ' ';
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        for(char c: t.toCharArray()){
            if(!map.containsKey(c) || map.get(c) <= 0)
                return c;
            map.put(c, map.get(c) - 1);
        }
        return ' ';
    }
}