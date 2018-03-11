package dfs;

import java.util.ArrayList;
/**
 * public class TreeNode { int val = 0; TreeNode left = null; TreeNode right =
 * null;
 * 
 * public TreeNode(int val) { this.val = val;
 * 
 * }
 * 
 * }
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<Integer> path = new ArrayList<>();
		ArrayList<ArrayList<Integer>> pathSet = new ArrayList<>();
		findPath(root, target, path, pathSet);
		return pathSet;
	}

	private void findPath(TreeNode root, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> pathSet) {
		if (root != null) {
			path.add(root.val);
			if (root.left == null && root.right == null) {
				int sum = 0;
				for (Integer val : path) {
					sum += val;
				}
				if (sum == target) {
					pathSet.add(new ArrayList<Integer>(path));
				}
			}
			findPath(root.left, target, path, pathSet);
			findPath(root.right, target, path, pathSet);
			path.remove(path.size() - 1);
		}
	}
}