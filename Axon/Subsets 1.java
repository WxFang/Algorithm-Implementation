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