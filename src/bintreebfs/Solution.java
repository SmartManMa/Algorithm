package bintreebfs;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
	
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		if ( root == null ) {
			return null;
		}
		ArrayList<Integer> list = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.addLast(root);
		while ( !queue.isEmpty() ) {
			TreeNode node = queue.pollFirst();
			list.add( node.val );
			if ( node.left != null ) {
				queue.addLast(node.left);
			}
			if ( node.right != null ) {
				queue.addLast(node.right);
			}
		}
		return list;
	}

}