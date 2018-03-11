package kthNode;

public class Solution2 {
	private int kth;

	TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null || k <= 0) {
			return null;
		}
		kth = k;
		TreeNode[] result = new TreeNode[1];
		inOrder(pRoot, result);
		return result[0];
	}

	/**
	 * inOrder TODO :
	 * 
	 * @param pRoot
	 * @param k
	 * @return
	 * @author zhiman
	 * @throws Exception
	 * @date 2018/03/11 下午4:20:42
	 */
	private void inOrder(TreeNode pRoot, TreeNode[] result){

		if (pRoot == null) {
			return;
		}
		inOrder(pRoot.left, result);
		if (kth == 1) {
			result[0] = pRoot;
			// 找到目标节点后,kth =Integer.MIN_VALUE恒成立，不会再遍历上一层的右子树
			kth = Integer.MIN_VALUE;
			return;
		} 
		if (kth == Integer.MIN_VALUE) {
			return;
		}
		kth--;
		inOrder(pRoot.right, result);
	}

}