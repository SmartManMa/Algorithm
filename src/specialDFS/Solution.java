package specialDFS;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ��ʵ��һ����������֮���δ�ӡ�������� 
 * ����һ�а��մ����ҵ�˳���ӡ��
 *  �ڶ��㰴�մ��������˳���ӡ�� 
 *  �����а��մ����ҵ�˳���ӡ�� 
 *  �������Դ����ơ�
 *  {8,6,10,5,7,9,11}
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		// �Ƿ���ż����
		boolean isEven = false;
		// ���
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		// ��Linkedlistģ��ջoddStackΪ������ڵ�ջ��evenStackΪż����ڵ�ջ
		LinkedList<TreeNode> oddStack = new LinkedList<>();
		oddStack.addLast(pRoot);
		LinkedList<TreeNode> evenStack = new LinkedList<>();
		while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
			if (!isEven) {
				ArrayList<Integer> temp = new ArrayList<>();
				while (!oddStack.isEmpty()) {
					TreeNode node = oddStack.removeLast();
					if (node != null) {
						temp.add(node.val);
						evenStack.addLast(node.left);
						evenStack.addLast(node.right);
					}
				}
				if (!temp.isEmpty()) {
					res.add(temp);
					// �����������нڵ��ջ,���Ŵ���ż����
					isEven = true;
				}
			} else {
				ArrayList<Integer> temp = new ArrayList<>();
				while (!evenStack.isEmpty()) {
					TreeNode node = evenStack.removeLast();
					if (node != null) {
						temp.add(node.val);
						oddStack.addLast(node.right);
						oddStack.addLast(node.left);
					}
				}
				if (!temp.isEmpty()) {
					res.add(temp);
					// ż���������нڵ��ջ,���Ŵ���������
					isEven = false;
				}
			}
		}
		return res;
	}

}