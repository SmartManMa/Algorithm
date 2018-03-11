package specialDFS;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 请实现一个函数按照之字形打印二叉树， 
 * 即第一行按照从左到右的顺序打印，
 *  第二层按照从右至左的顺序打印， 
 *  第三行按照从左到右的顺序打印， 
 *  其他行以此类推。
 *  {8,6,10,5,7,9,11}
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		// 是否是偶数层
		boolean isEven = false;
		// 结果
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		// 用Linkedlist模仿栈oddStack为奇数层节点栈，evenStack为偶数层节点栈
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
					// 奇数数层所有节点出栈,接着处理偶数层
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
					// 偶数数层所有节点出栈,接着处理奇数层
					isEven = false;
				}
			}
		}
		return res;
	}

}