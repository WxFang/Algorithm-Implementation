package amazon;

import java.util.ArrayList;


public class maxSub{
	
	private class Temp{
		int count;
		int sum;
		public Temp(int count, int sum){
			this.count = count;
			this.sum = sum;
		}
	}
	
	private class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int val){
			this.val = val;
		}
	}
	
	private TreeNode subtree = null;
	private Temp subtreetemp = null;	
		
	public TreeNode _maxSub(TreeNode root){
		helper(root);
		return subtree;
	}
	
	private Temp helper(TreeNode root){
		if(root == null) return new Temp(0, 0);
		Temp left = helper(root.left);
		Temp right = helper(root.right);
		Temp res = new Temp(left.sum + right.sum + root.val, left.count + right.count + 1);
		if(subtree == null || subtreetemp.sum * res.count < res.sum * subtreetemp.count){
			subtree = root;
			subtreetemp = res;
		}
		return res;
	}

}
