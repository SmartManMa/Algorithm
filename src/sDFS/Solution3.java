package sDFS;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution3 {
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		// �����ڵ������
		queue.addLast(pRoot);
		// ����null��Ϊ��ָ���
		queue.addLast(null);
		// ��ȡ���еĿ�ʼԪ�أ��ж��Ƿ�Ϊ��
		while ( queue.getFirst() != null ) {
			ArrayList<Integer> list = new ArrayList<>();
			TreeNode node = queue.removeFirst();
			while ( node != null ) {
				list.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				// ������null,�Ƴ���Ϊ��ָ�����null,�������ѭ��
				node = queue.removeFirst();
			}
			// �µ�һ��������У�����null��Ϊ��ָ���
			queue.addLast(null);
			
			res.add(list);
		}
		return res;
	}
}