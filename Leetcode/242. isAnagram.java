// array
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) return false;
        int[] arr = new int[26];
        for(char c: s.toCharArray()){
            arr[c - 'a']++;
        }
        for(char c: t.toCharArray()){
            arr[c - 'a']--;
        }
        for(int n: arr){
            if(n != 0)
                return false;
        }
        return true;
    }
}

// hash table
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c: t.toCharArray()){
            if(!map.containsKey(c))
                return false;
            map.put(c, map.get(c) - 1);
            if(map.get(c) == 0) 
                map.remove(c);
        }
        if(map.isEmpty() == true) 
            return true;
        else
            return false;
    }
}