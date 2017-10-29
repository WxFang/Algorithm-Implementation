public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> res = new LinkedList<>();
    	if(nums == null || nums.length == 0)
    		return res;
    	dfs(res, nums, new LinkedList<>(), 0);
    	return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, List<Integer> list, int pos){
    	if(pos == nums.length){
            res.add(new LinkedList<>(list));
            return;
        }
        dfs(res, nums, list, pos + 1);
        list.add(nums[pos]);
        dfs(res, nums, list, pos + 1);
        list.remove(list.size() - 1);
    }
}

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length == 0) return res;
        helper(res, nums, new LinkedList<Integer>(), 0);
        return res;
    } 
    private void helper(List<List<Integer>> res, int[] nums, List<Integer> list, int pos){
        res.add(new LinkedList<>(list));
        for(int i = pos; i < nums.length; i++){
            list.add(nums[i]);
            helper(res, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}