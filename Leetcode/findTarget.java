// binary search
// point is that two elements can be any two elements
// so binary search should start from root 
// also duplicates cannot exist
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }
    private boolean dfs(TreeNode root, TreeNode cur, int k){
        if(cur == null) return false;
        return search(root, cur, k - cur.val) || dfs(root, cur.left, k) || dfs(root, cur.right, k);
    }
    private boolean search(TreeNode root, TreeNode cur, int k){
        if(root == null) return false;
        if(root.val == k && root != cur) return true;
        else if(root.val < k) return search(root.right, cur, k);
        else return search(root.left, cur, k);
    }
}