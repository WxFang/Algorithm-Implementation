class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) return 0;
        return helper(nestedList, 1);
    }
    
    private int helper(List<NestedInteger> list, int level){
        if(list.size() == 0) return 0;
        int res = 0;
        for(NestedInteger n: list){
            if(n.isInteger())
                res += n.getInteger() * level;
            else
                res += helper(n.getList(), level + 1);
        }
        return res;
    }
}