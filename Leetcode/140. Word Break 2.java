// formal DFS
// time complexity O(2 ^ len(s) * len(wordDict))
// doesnt need to iterate whole wordDict
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, List<String>>());
    }
    
    private List<String> dfs(String s, List<String> wordDict, HashMap<String, List<String>> map){
        List<String> res = new LinkedList<>();
        if(s == null || s.length() == 0){
            res.add("");
            return res;
        }
        if(map.containsKey(s))
            return map.get(s);
        for(int i = 0; i < s.length(); i++){
            if(!wordDict.contains(s.substring(i))) continue;
            List<String> tempList = dfs(s.substring(0, i), wordDict, map);
            for(String pre: tempList)
                res.add(pre + (pre.length() == 0 ? "" : " ") + s.substring(i));
        }
        map.put(s, res);
        return res;
    }
}


// DFS with hashmap
// time complexity O(len(wordDict) ^ len(s)
// doesnt apply for big wordDict
// cause it iterates whole wordDict
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, List<String>>());
    }
    
    private List<String> dfs(String s, List<String> wordDict, HashMap<String, List<String>> map){
        if(map.containsKey(s))
            return map.get(s);
        List<String> res = new LinkedList<>();
        if(s.length() == 0){
            res.add("");
            return res;
        }
        for(String word: wordDict)
            if(s.startsWith(word))
                for(String temp: dfs(s.substring(word.length()), wordDict, map))
                    res.add(word + (temp.length() == 0 ? "" : " ") + temp);
        map.put(s, res);
        return res;
    }
}