// one hashmap
// one corner case
class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern.length() == 0 || str.length() == 0) return false;
        String[] words = str.split(" ");
        // corner case: length doesnt equal
        if(words.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(words[i]))
                    return false;
            }
            else{
                if(map.containsValue(words[i]))
                    return false;
                map.put(c, words[i]);
            }
        }
        return true;
    }
}

// two hashmaps
// two corner cases
class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern.length() == 0 || str.length() == 0) return false;
        String[] strs = str.split(" ");
        // corner case: length doesnt equal
        if(strs.length != pattern.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        Map<String, Integer> mapString = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++){
            if(map.containsKey(pattern.charAt(i)))
                if(!strs[i].equals(strs[map.get(pattern.charAt(i))]))
                    return false;
            map.put(pattern.charAt(i), i);
            mapString.put(strs[i], i);
        }
        // corner case: same words in str
        if(mapString.size() != map.size())
            return false;
        else
            return true;
    }
}