package treeDepth;

import java.util.TreeSet;

public class Solution {
    public int TreeDepth(TreeNode root) {
    	int depth = 0;
    	if (root == null) {
    		return depth;
    	}
    	TreeSet<Integer> set = new TreeSet<>();
    	//int max = Integer.MIN_VALUE;
    	dfs(root, depth, set);
    	return set.last();
    }

	/** 
	  * dfs TODO :
	  * @param root
	  * @param depth
	  * @return
	  * @author zhiman
	 * @param path 
	 * @param set 
	  * @date 2018/03/07 ÏÂÎç4:43:24 
	  */
	private void dfs(TreeNode root, int depth, TreeSet<Integer> set) {
		if ( root != null ) {
			depth++;
		} else {
			set.add(depth);
			return;
		}
		dfs(root.left,depth,set);
		dfs(root.right,depth,set);
		depth--;
	}
}