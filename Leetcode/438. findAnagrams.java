class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<>();
        if(s == null || p == null || s.length() < p.length()) return list;
        
        int[] arr = new int[26];
        for(char c: p.toCharArray())
            arr[c - 'a']++;
        
        char[] sArr = s.toCharArray();
        
        for(int i = 0; i <= sArr.length - p.length(); i++){
            if(p.indexOf(sArr[i]) < 0 || p.indexOf(sArr[i + p.length() - 1]) < 0) continue;
            int[] temp = Arrays.copyOf(arr, 26);
            boolean isAnagram = true;
            for(int j = i; j < i + p.length(); j++)
                temp[sArr[j] - 'a']--;
            for(int n: temp)
                if(n != 0)
                    isAnagram = false;
                    
            if(isAnagram == true)
                list.add(i);
        }
        return list;
    }
}