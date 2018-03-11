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
	 * @date 2018/03/11 ����9:42:39
	 */
	private boolean isSymTree(TreeNode left, TreeNode right) {
		if (left == null) {
			// ������Ϊ�գ��ж��������Ƿ�Ϊ��
			return right == null;
		}else if (right == null) {
			// ��������Ϊ�գ�������Ϊ�գ�����false
			return false;
		}
		if (left.val != right.val) {
			return false;
		}
		return isSymTree(left.left, right.right) && isSymTree(left.right, right.left);
	}

}