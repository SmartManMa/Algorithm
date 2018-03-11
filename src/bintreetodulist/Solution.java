package bintreetodulist;
public class Solution {
	//˫�������ͷ���
	private TreeNode head = null;
	//˫�������β���
	private TreeNode rear = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
    	coreConvert(pRootOfTree);
        return head;
    }
	/** 
	  * coreConvert TODO :
	  * @param pRootOfTree
	  * @author zhiman
	  * @date 2018/02/25 ����3:25:20 
	  */
	private void coreConvert(TreeNode pRootOfTree) {
		if ( pRootOfTree == null ) { 
			return;
		}
		// ���ϵݹ飬ֱ����������Ҷ�ӽ��
		coreConvert(pRootOfTree.left);
		// �ҵ�˫������ͷ���
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