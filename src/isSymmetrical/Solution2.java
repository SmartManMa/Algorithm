package isSymmetrical;

public class Solution2 {
	boolean isSymmetrical(TreeNode pRoot) {
		if (pRoot == null) {
			return true;
		}
		return isSymTree(pRoot.left, pRoot.right);
	}

	/**
	 * isSymTree TODO :
	 * 
	 * @param left
	 * @param right
	 * @return
	 * @author zhiman
	 * @date 2018/03/11 上午9:42:39
	 */
	private boolean isSymTree(TreeNode left, TreeNode right) {
		if (left == null) {
			// 左子树为空，判断右子树是否为空
			return right == null;
		}else if (right == null) {
			// 左子树不为空，右子树为空，返回false
			return false;
		}
		if (left.val != right.val) {
			return false;
		}
		return isSymTree(left.left, right.right) && isSymTree(left.right, right.left);
	}

}