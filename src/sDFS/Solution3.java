package sDFS;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution3 {
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		// 树根节点入队列
		queue.addLast(pRoot);
		// 插入null作为层分隔符
		queue.addLast(null);
		// 获取队列的开始元素，判断是否为空
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
				// 若遇到null,移除作为层分隔符的null,否则继续循环
				node = queue.removeFirst();
			}
			// 新的一层已入队列，插入null作为层分隔符
			queue.addLast(null);
			
			res.add(list);
		}
		return res;
	}
}