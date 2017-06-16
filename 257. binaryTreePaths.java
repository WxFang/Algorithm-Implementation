/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root!=null) SBT(root, "", res);
        return res;
    }
    
    private void SBT(TreeNode root, String path, List<String> res){
        if(root.left==null && root.right==null) res.add(path+root.val);
        if(root.left!=null) SBT(root.left, path+root.val+"->", res);
        if(root.right!=null) SBT(root.right, path+root.val+"->", res);
    }
}
