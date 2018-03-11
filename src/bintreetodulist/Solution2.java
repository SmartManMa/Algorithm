package bintreetodulist;
public class Solution2 {
	//双向链表的头结点
	private TreeNode head = null;
	//双向链表的尾结点
	private TreeNode rear = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
    	if ( pRootOfTree!= null) {
    		// 不断递归，直到遇到最左叶子结点
    		Convert(pRootOfTree.left);
    		
    		// 找到双向链表头结点
    		if ( head == null ) {
    			head = pRootOfTree;
    			rear = head;
    		} else {
    			rear.right = pRootOfTree;
    			pRootOfTree.left = rear;
    			rear = rear.right;
    		}
    		Convert(pRootOfTree.right);
    	}
        return head;
    }
}