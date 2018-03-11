package kthNode;

public class Solution {
	private int kth;

	TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null || k <= 0 ) {
			return null;
		}
		kth = k;
		TreeNode[] result = new TreeNode[1];
		try {
			inOrder(pRoot, result);
		} catch (Exception e) {
			
		}
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
	 * @date 2018/03/11 ÏÂÎç4:20:42
	 */
	private void inOrder(TreeNode pRoot, TreeNode[] result) throws Exception {

		if (pRoot == null) {
			return;
		}
		inOrder(pRoot.left, result);
		if ( kth == 1) {
			result[0] = pRoot;
			throw new Exception();
		}
		kth--;
		inOrder(pRoot.right, result);
	}

}