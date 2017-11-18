// to get number, we only need hashset
// to get index, we need hashmap

public class Solution {
    public int[] twoSum(int[] nums, int target) {
    	if(nums == null || nums.length == 0) return new int[]{0, 0};

    	Set<Integer> set = new HashSet<>();
    	for(int i = 0; i < nums.length; i++){
    		if(set.contains(target - nums[i]))
    			return new int[]{nums[i], target - nums[i]};
    		else
    			set.add(nums[i]);
    	}

    	return new int[]{0, 0};

    }
}