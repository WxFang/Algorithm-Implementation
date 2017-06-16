public void moveZeroes(int[] nums) {
        int pos = 0;
        for(int pre=0; pre<nums.length; pre++){
            if(nums[pre]!=0){
                nums[pos] = nums[pre];
                pos++;
            }
        }
        for(; pos<nums.length; pos++){
            nums[pos] = 0;
        }
}