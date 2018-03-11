package bintreetodulist;
public class Solution {
	//双向链表的头结点
	private TreeNode head = null;
	//双向链表的尾结点
	private TreeNode rear = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
    	coreConvert(pRootOfTree);
        return head;
    }
	/** 
	  * coreConvert TODO :
	  * @param pRootOfTree
	  * @author zhiman
	  * @date 2018/02/25 下午3:25:20 
	  */
	private void coreConvert(TreeNode pRootOfTree) {
		if ( pRootOfTree == null ) { 
			return;
		}
		// 不断递归，直到遇到最左叶子结点
		coreConvert(pRootOfTree.left);
		// 找到双向链表头结点
		if ( head == null ) {
			head = pRootOfTree;
			rear = head;
		} else {
			rear.right = pRootOfTree;
			pRootOfTree.left = rear;
			rear = rear.right;
		}
		coreConvert(pRootOfTree.right);
	}
}