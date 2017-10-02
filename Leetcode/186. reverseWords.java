public class Solution {
    public void reverseWords(char[] s) {
        if(s == null || s.length == 0) return;
        helper(s, 0, s.length - 1);
        int fast = 0, slow = 0;
        while(fast < s.length){
            while(fast < s.length && s[fast] != ' ')
                fast++;
            helper(s, slow, fast - 1);
            slow = fast + 1;
            fast = slow;
        }
    }
    private void helper(char[] s, int left, int right){
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}