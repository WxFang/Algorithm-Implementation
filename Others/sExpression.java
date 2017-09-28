public class Solution{
	public String sExpression(TreeNode root){
		String res = "";
		if(root == null) return new String(res);
		res += "(";
		res += root.val;
		res += sExpression(root.left);
		res += sExpression(root.right);
		res += ")";
		return res;
	}
}