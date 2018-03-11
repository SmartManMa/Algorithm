package binarytree;

public class Solution {
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if ( pre == null || in == null || pre.length != in.length ) {
			throw new RuntimeException("reConstructBinaryTree输入错误");
		}
		int rootValue = pre[0];
		TreeNode root = new TreeNode( rootValue );
		
		if ( pre.length == 1 ) {
			if ( in.length == 1 && rootValue == in[0] ) {
				return root;
			} else {
				throw new RuntimeException("reConstructBinaryTree输入错误");
			}
		} 
		// rootIndex int[] in中rootValue对应的下标
		int  rootIndex = 0;
		while ( rootIndex <= in.length -1 && rootValue != in[rootIndex] ) {
			 rootIndex++ ;
		}
		if ( rootIndex >= in.length || rootValue != in[rootIndex]) {
			throw new RuntimeException("reConstructBinaryTree输入错误");
		}
		// 递归生成左子树
		if ( rootIndex > 0 ) {
			int[] subPre = getSubTree(pre,1,rootIndex);
			int[] subIn = getSubTree(in,0,rootIndex);
			root.left = reConstructBinaryTree( subPre, subIn );
		}
		// 递归生成右子树
		int count = in.length - rootIndex - 1;
		if ( count > 0 ) {
			int[] subPre = getSubTree(pre,rootIndex+1,count);
			int[] subIn = getSubTree(in,rootIndex+1,count);
			root.right = reConstructBinaryTree( subPre, subIn );
		}
		return root;
	}


	/** 
	  * getSubTree TODO :
	  * @param srcArr
	  * @param begin
	  * @param count
	  * @return
	  * @author zhiman
	  * @date 2018/01/25 上午10:21:22 
	  */
	private int[] getSubTree(int[] srcArr, int begin, int count) {
		int[] dstArr = new int[count];
		System.arraycopy(srcArr, begin, dstArr, 0, count);
		return dstArr;
	}
	public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		TreeNode root = new Solution().reConstructBinaryTree(pre, in);
		viewBinTree(root);
	}
	public static void viewBinTree( TreeNode root ) {
		if ( root != null) {
			//System.out.println(root.val);
			viewBinTree(root.left);
			System.out.println(root.val);
			viewBinTree(root.right);
		}
	}
}








