package sDFS;

import java.util.ArrayList;

/**
 * 模仿LeetCode思路
 * 
 * @description Solution2.java
 * @author Administrator
 * @date 2018/03/11
 * @version
 */
public class Solution2 {
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (pRoot == null) {
			return res;
		}
		dfs(pRoot, res, 0);
		return res;
	}

	/**
	 * dfs TODO :
	 * 
	 * @param pRoot
	 * @param res
	 * @param i
	 * @author zhiman
	 * @date 2018/03/11 下午1:34:38
	 */
	private void dfs(TreeNode root, ArrayList<ArrayList<Integer>> res, int layer) {
		if (root == null) {
			return;
		}
		if (res.size() <= layer) {
			res.add(new ArrayList<>());
		}
		res.get(layer).add(root.val);
		dfs(root.left, res, layer + 1);
		dfs(root.right, res, layer + 1);
	}
}
