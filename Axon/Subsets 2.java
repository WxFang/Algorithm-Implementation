public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length == 0) return res;
        // 1# point
        Arrays.sort(nums);
        helper(res, nums, new LinkedList<Integer>(), 0);
        return res;
    } 
    private void helper(List<List<Integer>> res, int[] nums, List<Integer> list, int pos){
        res.add(new LinkedList<>(list));
        for(int i = pos; i < nums.length; i++){
            // 2# point
            if(i != pos && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            helper(res, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}