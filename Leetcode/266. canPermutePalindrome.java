// array
class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] arr = new int[256];
        for(char c: s.toCharArray())
            arr[c]++;
        int count = 0;
        for(int n: arr)
            if(n % 2 == 1)
                count++;
        if(count >= 2)
            return false;
        else
            return true;
    }
}

// hashmap
class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        int count = 0;
        for(int n: map.values())
            if(n % 2 == 1)
                count++;
        if(count >= 2)
            return false;
        else
            return true;
    }
}