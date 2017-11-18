class Solution {
    public String reverseString(String s) {
        if(s == null || s.length() == 0) return "";
        char[] arr = s.toCharArray();
        for(int i = 0; i < s.length() / 2; i++){
            char c = arr[i];
            arr[i] = arr[s.length() - 1 - i];
            arr[s.length() - 1 - i] = c;
        }
        return new String(arr);
    }
}