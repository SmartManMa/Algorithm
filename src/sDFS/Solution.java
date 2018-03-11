package sDFS;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		LinkedList<TreeNode> queue1 = new LinkedList<>();
		queue1.addLast(pRoot);
		LinkedList<TreeNode> queue2 = new LinkedList<>();
		while (!queue1.isEmpty() || !queue2.isEmpty()) {
			ArrayList<Integer> temp1 = new ArrayList<>();
			while (!queue1.isEmpty()) {
				TreeNode node = queue1.removeFirst();
				if (node != null) {
					temp1.add(node.val);
					queue2.addLast(node.left);
					queue2.addLast(node.right);
				}
			}
			if (!temp1.isEmpty()) {
				res.add(temp1);
			}
			ArrayList<Integer> temp2 = new ArrayList<>();
			while (!queue2.isEmpty()) {
				TreeNode node = queue2.removeFirst();
				if (node != null) {
					temp2.add(node.val);
					queue1.addLast(node.left);
					queue1.addLast(node.right);
				}
			}
			if (!temp2.isEmpty()) {
				res.add(temp2);
			}
		}
		return res;
	}
}