package getNextTreeNode;

//给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
//注意，
public class Solution {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null) {
			return pNode;
		}
		// 如果pNode有右节点，则从该右节点出发寻找其最左的节点
		if (pNode.right != null) {
			TreeLinkNode p = pNode.right;
			while (p.left != null) {
				p = p.left;
			}
			return p;
		} else if (pNode.next != null && pNode.next.left == pNode) {
			return pNode.next;
			// 如果pNode没有右节点，并且pNode是其父节点的左节点，则其父节点是PNode下一个节点
		} else {
			// 如果pNode没有右节点，并且pNode是其父节点的右节点，则其向上寻找
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