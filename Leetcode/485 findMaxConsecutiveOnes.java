public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int slow = 0, fast = 0;
        while(fast < nums.length){
            while(slow < nums.length && nums[slow] != 1) slow++;
            fast = slow;
            while(fast < nums.length && nums[fast] == 1) fast++;
            max = Math.max(max, fast - slow);
            slow = fast;
        }
        return max;
    }
}