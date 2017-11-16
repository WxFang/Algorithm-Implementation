// pass the current found integer sum into the next level of recursion, and return it back again
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) return 0;
        return helper(nestedList, 0);
    }
    
    private int helper(List<NestedInteger> list, int prev){
        int curr = prev;
        List<NestedInteger> temp = new ArrayList<>();
        for(NestedInteger n: list){
            if(n.isInteger())
                curr += n.getInteger();
            else
                temp.addAll(n.getList());
        }
        if(!temp.isEmpty())
            return curr + helper(temp, curr);
        else
            return curr;
    }
}

class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int prev = 0, curr = 0;
        while(!nestedList.isEmpty()){
            List<NestedInteger> temp = new ArrayList<>();
            for(NestedInteger n: nestedList){
                if(n.isInteger())
                    curr += n.getInteger();
                else
                    temp.addAll(n.getList());
            }
            nestedList = temp;
            prev += curr;
        }
        return prev;
    }
}