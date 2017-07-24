public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, n, k, 1, new ArrayList<Integer>());
        return res;
    }
    private void helper(List<List<Integer>> res, int target, int count, int pos, ArrayList<Integer> list){
        if(list.size() > count || target < 0) return;
        if(list.size() == count && target == 0){
            // NOTICE: list is reference!!!
            // if without doing so, the whole time, you will use just one Arraylist object, 
            // so it can be change by "comb.remove(comb.size() - 1);" 
            // after it is added to the "ans", it can be changed too.
            List<Integer> temp = new ArrayList<Integer>(list);
            res.add(temp);
            return;
        }
        for(int i = pos; i <= 9; i++){
            list.add(i);
            helper(res, target - i, count, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}