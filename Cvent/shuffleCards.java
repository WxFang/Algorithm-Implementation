class Solution {

    private int[] arr;
    private Random random;
    
    public Solution(int[] nums) {
        this.arr = nums;
        this.random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return arr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] temp = arr.clone();
        for(int i = 0; i < temp.length; i++){
            int j = random.nextInt(i + 1);
            int b = temp[i];
            temp[i] = temp[j];
            temp[j] = b;
        }
        return temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */