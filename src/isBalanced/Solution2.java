package isBalanced;


public class Solution2 {
	private boolean flag = true;
    public boolean IsBalanced_Solution(TreeNode root) {
    	try {
			TreeDepth(root);
		} catch (Exception e) {
		}
		return flag;
    }
	public int TreeDepth(TreeNode root) throws Exception {
		if (root == null) {
			return 0;
		}
		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);
		if ( Math.abs(left - right) > 1) {
			flag = false;
			throw new Exception();
		}
		return Math.max(left, right)+1;

	}
   
}