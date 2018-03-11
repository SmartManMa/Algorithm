package getNextTreeNode;

//����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
//ע�⣬
public class Solution {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null) {
			return pNode;
		}
		// ���pNode���ҽڵ㣬��Ӹ��ҽڵ����Ѱ��������Ľڵ�
		if (pNode.right != null) {
			TreeLinkNode p = pNode.right;
			while (p.left != null) {
				p = p.left;
			}
			return p;
		} else if (pNode.next != null && pNode.next.left == pNode) {
			return pNode.next;
			// ���pNodeû���ҽڵ㣬����pNode���丸�ڵ����ڵ㣬���丸�ڵ���PNode��һ���ڵ�
		} else {
			// ���pNodeû���ҽڵ㣬����pNode���丸�ڵ���ҽڵ㣬��������Ѱ��
			TreeLinkNode p = pNode.next;
			while (p != null) {
				if (p.next != null && p.next.left == p) {
					return p.next;
				} else {
					p = p.next;
				}
			}
			return null;
		}
	}
}