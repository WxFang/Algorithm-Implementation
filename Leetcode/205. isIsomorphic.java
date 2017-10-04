class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;
        int[] arrs = new int[256];
        int[] arrt = new int[256];
        for(int i = 0; i < s.length(); i++){
            if(arrs[s.charAt(i)] != arrt[t.charAt(i)])
                return false;
            arrs[s.charAt(i)] = i + 1;
            arrt[t.charAt(i)] = i + 1;
        }
        return true;
    }
}