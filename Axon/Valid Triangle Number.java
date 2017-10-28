// faster
// check if addition of two smaller numbers is bigger than biggest one 
public class Solution {
    public int triangleNumber(int[] nums) {
        if(nums.length < 3) return 0;
        Arrays.sort(nums);
        int res = 0;

        for(int i = nums.length - 1; i >= 2; i--){
        	int left = 0;
        	int right = i - 1; 
        	while(left < right){
        		if(nums[left] + nums[right] <= nums[i])
        			left++;
        		else{
        			res += right - left;
        			right--;
        		}
        	}
        }

        return res;
    }
}


// slower
public class Solution {
    public int triangleNumber(int[] nums) {
        if(nums.length < 3) return 0;
        Arrays.sort(nums);
        int res = 0;

        for(int i = 0; i < nums.length - 2; i++){
        	for(int j = i + 1; j < nums.length - 1; j++){
        		int k = j + 1;
        		while(k < nums.length && nums[i] + nums[j] > nums[k]){
        			res++;
        			k++;
        		}
        	}
        }

        return res;
    }
}