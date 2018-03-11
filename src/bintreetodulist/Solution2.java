package bintreetodulist;
public class Solution2 {
	//˫�������ͷ���
	private TreeNode head = null;
	//˫�������β���
	private TreeNode rear = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
    	if ( pRootOfTree!= null) {
    		// ���ϵݹ飬ֱ����������Ҷ�ӽ��
    		Convert(pRootOfTree.left);
    		
    		// �ҵ�˫������ͷ���
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