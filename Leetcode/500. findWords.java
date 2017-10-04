// array
class Solution {
    public String[] findWords(String[] words) {
        if(words == null || words.length == 0) return new String[]{};
        int[] arr = {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};        
        List<String> list = new LinkedList<>();
        for(String s: words){
            int level = arr[s.toLowerCase().charAt(0) - 'a'];
            boolean flag = false;
            for(char c: s.toLowerCase().toCharArray()){
                if(arr[c - 'a'] != level){
                    flag = true;
                    break;
                }
            }
            if(flag == false)
                list.add(s);
        }
        return list.toArray(new String[list.size()]);
    }
}

// hashmap
class Solution {
    public String[] findWords(String[] words) {
        if(words == null || words.length == 0) return new String[]{};
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('q', 1);
        map.put('w', 1);
        map.put('e', 1);
        map.put('r', 1);
        map.put('t', 1);
        map.put('y', 1);
        map.put('u', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('p', 1);
        map.put('a', 2);
        map.put('s', 2);
        map.put('d', 2);
        map.put('f', 2);
        map.put('g', 2);
        map.put('h', 2);
        map.put('j', 2);
        map.put('k', 2);
        map.put('l', 2);
        map.put('z', 3);
        map.put('x', 3);
        map.put('c', 3);
        map.put('v', 3);
        map.put('b', 3);
        map.put('n', 3);
        map.put('m', 3);
        
        List<String> list = new LinkedList<>();
        for(String s: words){
            int level = map.get(s.toLowerCase().charAt(0));
            boolean flag = false;
            for(char c: s.toLowerCase().toCharArray()){
                if(map.get(c) != level){
                    flag = true;
                    break;
                }
            }
            if(flag == false)
                list.add(s);
        }
        return list.toArray(new String[list.size()]);
    }
}